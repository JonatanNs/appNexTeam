package com.nexteam.core;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

/**
 * La classe BaseEntity est une classe commune utilisée par toutes les entités du projet.
 *
 * @author jnsualu2026
 * @version 1.0
 * @since 18/06/2026 15:57
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID public_id;

    @Column(updatable = false, nullable = false)
    private Instant created_at;

    private Instant updated_at;

    /**
     * Initialise les données de l'entité avant sa première persistance en base.
     * Génère un identifiant public unique et définit la date de création.
     */
    @PrePersist
    public void prePersist() {
        if (public_id == null) {
            public_id = UUID.randomUUID();
        }
        created_at = Instant.now();
    }

    /**
     * Met à jour automatiquement la date de modification avant chaque update en base.
     */
    @PreUpdate
    public void preUpdate() {
        updated_at = Instant.now();
    }

}
