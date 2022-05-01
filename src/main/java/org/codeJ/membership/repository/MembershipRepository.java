package org.codeJ.membership.repository;

import org.codeJ.membership.entity.Membership;
import org.codeJ.membership.entity.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership,Long> {

    Membership findByUserIdAndMembershipType(final String userId, final MembershipType membershipType);
}
