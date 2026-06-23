package com.nexteam.user;

import com.nexteam.role.Role;
import com.nexteam.address.Address;
import com.nexteam.common.AuditableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * La classe User représente un utilisateur de l’application.
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
public class User extends AuditableEntity {

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Ce champ ne peut pas être vide.")
    private String firstname;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Ce champ ne peut pas être vide.")
    private String lastname;

    @Email
    @Column(unique = true, nullable = false, length = 150)
    @NotBlank(message = "Le champ email ne peut pas être vide.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Ce champ ne peut pas être vide.")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "Le mot de passe doit contenir majuscule, minuscule et chiffre."
    )
    // TODO : mettre un mot de passe fort
    private String password;

    @Column(nullable = false)
    private boolean active = true;

    /**
     * Relation ManyToMany entre User et Role.
     * Un utilisateur peut avoir plusieurs rôles et un rôle peut être attribué à plusieurs utilisateurs
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    /**
     * Relation ManyToOne entre User et Address.
     * Un utilisateur peut avoir une seule adresse et une adresse peut être attribuée à plusieurs utilisateurs.
     */
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}



