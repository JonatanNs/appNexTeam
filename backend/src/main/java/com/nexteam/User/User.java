package com.nexteam.User;

import com.nexteam.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

/**
 * La classe User représente un utilisateur de l’application.
 *
 * @author JonatanNs
 * @version 1.0
 * @since 26/05/2026 23:41
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class User extends BaseEntity {

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
            message = "Le mot de passe doit contenir majuscule, minuscule et chiffre"
    )
    // TODO : mettre un mot de passe fort
    private String password;

    private boolean active = true;
}



