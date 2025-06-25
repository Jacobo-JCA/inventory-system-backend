package com.softwarelabs.InventorySystem.modules.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user_roles", uniqueConstraints = { @UniqueConstraint(columnNames = {"id_user", "id_role"})})
public class UserRole {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserRole;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;
}
