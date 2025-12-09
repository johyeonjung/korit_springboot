package com.korit.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity {
    private int userRoleId;
    private int userId;
    private int roleId;

    private RoleEntity roleEntity;
}
