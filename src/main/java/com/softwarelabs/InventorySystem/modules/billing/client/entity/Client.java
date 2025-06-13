package com.softwarelabs.InventorySystem.modules.billing.client.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Client {
    private Long idClient;
    private String firstName;
    private String lastName;
    private String address;
    private String dni;
    private String phoneNumber;
    private String email;
}
