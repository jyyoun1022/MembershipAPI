package org.codeJ.membership.repository;

import org.assertj.core.api.Assertions;
import org.codeJ.membership.entity.Membership;
import org.codeJ.membership.entity.MembershipType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberShipRepositoryTest {

    @Autowired
    private MembershipRepository membershipRepository;

    @Test
    @DisplayName("memberRepository가 null이 아님 ")
    void repositoryIsNull(){

        assertThat(membershipRepository).isNotNull();
    }

    @Test
    @DisplayName("멤버십 등록")
    public void registerMembership(){
        //given

        final Membership membership= Membership.builder()
                .userId("userId")
                .membershipType(MembershipType.NAVER)
                .point(10000)
                .build();

        //when
        final  Membership result = membershipRepository.save(membership);

        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getUserId()).isEqualTo("userId");
        assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);
        assertThat(result.getPoint()).isEqualTo(10000);

    }

    @Test
    @DisplayName("멤버십이 존재하는지에 대한 테스트")
    void alreadyMembership(){
        //given
        final Membership membership = Membership.builder()
                .userId("userId")
                .membershipType(MembershipType.NAVER)
                .point(10000)
                .build();

        //when
        membershipRepository.save(membership);
        Membership findResult = membershipRepository.findByUserIdAndMembershipType("userId", MembershipType.NAVER);


        //then
        assertThat(findResult).isNotNull();
        assertThat(findResult.getId()).isNotNull();
        assertThat(findResult.getUserId()).isEqualTo("userId");
        assertThat(findResult.getMembershipType()).isEqualTo(MembershipType.NAVER);
        assertThat(findResult.getPoint()).isEqualTo(10000);

    }


}
