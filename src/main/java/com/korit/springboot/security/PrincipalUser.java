package com.korit.springboot.security;

import com.korit.springboot.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@RequiredArgsConstructor
public class PrincipalUser implements UserDetails {
    private final UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userEntity.getUserRoleEntities().stream().map(userRoleEntity ->
                        new SimpleGrantedAuthority(userRoleEntity.getRoleEntity().getRoleName()))
                .toList();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }
    public int getUserId() {
        return userEntity.getUserId();
    }
}
