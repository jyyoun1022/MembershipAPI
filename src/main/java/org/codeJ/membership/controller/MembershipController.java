package org.codeJ.membership.controller;

import org.codeJ.dto.MembershipRequest;
import org.codeJ.dto.MembershipResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static org.codeJ.dto.MembershipConstants.USER_ID_HEADER;

@RestController
public class MembershipController {

    @PostMapping("/api/vi/memberships")
    public ResponseEntity<MembershipResponse>addMembership(
            @RequestHeader(USER_ID_HEADER) final String userId,
            @RequestBody @Validated final MembershipRequest membershipRequest){

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
