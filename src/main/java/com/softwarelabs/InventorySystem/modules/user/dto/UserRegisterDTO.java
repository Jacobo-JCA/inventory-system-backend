package com.softwarelabs.InventorySystem.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegisterDTO {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
}
