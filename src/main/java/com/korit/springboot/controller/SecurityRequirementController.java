package com.korit.springboot.controller;

import com.korit.springboot.security.PrincipalUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRequirementController {

    @Operation(security = @SecurityRequirement(name = "Bearer Authentication"))
    @GetMapping("/api/security")
    public ResponseEntity<?> get(@AuthenticationPrincipal PrincipalUser principalUser) {
        System.out.println(principalUser.getUserId());
        PrincipalUser principalUser2 = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principalUser2.getUserId());
        return ResponseEntity.ok("응답");
    }
}
