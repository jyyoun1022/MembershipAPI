package org.codeJ.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.codeJ.membership.entity.MembershipType;

@Getter
@Builder
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class MembershipRequest {

    @NotNull
    @Min(0)
    private final Integer point;
    @NotNull
    private final MembershipType membershipType;
}
