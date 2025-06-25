package com.softwarelabs.InventorySystem.modules.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(nullable = false, length = 50, unique = true)
    private String username;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false, length = 10)
    private String phoneNumber;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> authorities;
    private final LocalDateTime createdAt = LocalDateTime.now();

    public void addAuthority(UserRole authority) {
        if (this.authorities == null) {
            this.authorities = new HashSet<>();
        }
        this.authorities.add(authority);
        authority.setUser(this);
    }
}