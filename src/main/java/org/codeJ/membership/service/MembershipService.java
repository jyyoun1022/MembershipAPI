package org.codeJ.membership.service;

import lombok.RequiredArgsConstructor;
import org.codeJ.dto.MembershipResponse;
import org.codeJ.membership.entity.Membership;
import org.codeJ.membership.entity.MembershipType;
import org.codeJ.membership.repository.MembershipRepository;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipResponse addMembership(final String userId, final MembershipType membershipType, final Integer point){

        final Membership result = membershipRepository.findByUserIdAndMembershipType(userId, membershipType);
        if( result != null ){
            throw new MembershipException(MembershipErrorResult.DUPLICATED_MEMBERSHIP_REGISTER);
        }
        final Membership membership = Membership.builder()
                .userId(userId)
                .point(point)
                .membershipType(membershipType)
                .build();

        final Membership savedMembership = membershipRepository.save(membership);

        return MembershipResponse.builder()
                .id(savedMembership.getId())
                .membershipType(savedMembership.getMembershipType())
                .build();
    }
}
