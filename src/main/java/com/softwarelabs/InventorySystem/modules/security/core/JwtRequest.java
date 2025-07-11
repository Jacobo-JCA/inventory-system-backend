package com.softwarelabs.InventorySystem.modules.security.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtRequest implements Serializable {
    private String email;
    private String password;
}
