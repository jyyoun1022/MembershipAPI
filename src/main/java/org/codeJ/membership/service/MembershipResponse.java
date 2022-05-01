package org.codeJ.membership.service;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.codeJ.membership.entity.MembershipType;

@Getter
@Builder
@RequiredArgsConstructor
public class MembershipResponse {

    private final Long id;
    private final MembershipType membershipType;
}
