package com.softwarelabs.InventorySystem.modules.user.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user_roles", uniqueConstraints = { @UniqueConstraint(columnNames = {"id_user", "id_role"})})
public class UserRole {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserRole;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;
}
