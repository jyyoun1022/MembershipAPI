package org.codeJ.membership.service;

import org.codeJ.dto.MembershipResponse;
import org.codeJ.membership.entity.Membership;
import org.codeJ.membership.entity.MembershipType;
import org.codeJ.membership.repository.MembershipRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MembershipServiceTest {

    @InjectMocks
    private MembershipService target;

    @Mock
    private MembershipRepository membershipRepository;

    private final String userId = "userId";
    private final MembershipType membershipType = MembershipType.NAVER;
    private final Integer point =10000;

//    doReturn(): Mock 객체가 특정한 값을 반환해야 하는 경우
//    doNothing(): Mock 객체가 아무 것도 반환하지 않는 경우(void)
//    doThrow(): Mock 객체가 예외를 발생시키는 경우


    @Test
    @DisplayName("멤버십등록실패_이미존재합니다.")
    void failRegister(){
        //given
        doReturn(null).when(membershipRepository).findByUserIdAndMembershipType(userId,membershipType);
        doReturn(membership()).when(membershipRepository).save(any(Membership.class));


        //when
        final MembershipResponse result =target.addMembership(userId,membershipType,point);


        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);

        //verify
        verify(membershipRepository,times(1)).findByUserIdAndMembershipType(userId,membershipType);
        verify(membershipRepository,times(1)).save(any(Membership.class));
    }

    private Membership membership(){
        return Membership.builder()
                .id(-1L)
                .userId(userId)
                .point(point)
                .membershipType(MembershipType.NAVER)
                .build();
    }

    @Test
    @DisplayName("멤버십등록성공")
    public void successRegister(){
        //given
        doReturn(null).when(membershipRepository).findByUserIdAndMembershipType(userId, membershipType);
        doReturn(membership()).when(membershipRepository).save(any(Membership.class));

        //when
        final MembershipResponse result = target.addMembership(userId, membershipType, point);

        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);

        //verify
        verify(membershipRepository, times(1)).findByUserIdAndMembershipType(userId, membershipType);
        verify(membershipRepository, times(1)).save(any(Membership.class));

    }

}
