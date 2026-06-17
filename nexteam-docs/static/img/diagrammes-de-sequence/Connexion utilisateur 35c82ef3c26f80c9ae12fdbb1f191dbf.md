# Connexion utilisateur

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Connexion utilisateur"
actor Utilisateur
participant "Frontend" as Front
participant "API" as API
participant "AuthService" as Auth
participant "Base de données" as DB

Utilisateur -> Front : Saisir email + mot de passe
Front -> API : POST /connexion
API -> Auth : Vérifier identifiants
Auth -> DB : Rechercher utilisateur
DB --> Auth : Données utilisateur

alt Utilisateur valide
    Auth --> API : Génération Token
    API --> Front : Token + rôle utilisateur
    Front --> Utilisateur : Connexion réussie
else Erreur authentification
    Auth --> API : Erreur login
    API --> Front : Message d’erreur
    Front --> Utilisateur : Afficher erreur
end
@enduml
```