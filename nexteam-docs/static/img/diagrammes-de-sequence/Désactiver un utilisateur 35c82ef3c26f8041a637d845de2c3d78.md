# Désactiver un utilisateur

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Désactiver un utilisateur"
actor "RH / Admin" as Admin
participant "Frontend" as Front
participant "API" as API
participant "PersonService" as Service
participant "Base de données" as DB

Admin -> Front : Désactiver utilisateur
Front -> API : PUT /person/{id}/desactiver
API -> Service : Vérifier permissions
Service -> DB : Modifier statut utilisateur
DB --> Service : Confirmation modification
Service --> API : Utilisateur désactivé
API --> Front : Succès opération
Front --> Admin : Afficher confirmation
@enduml
```