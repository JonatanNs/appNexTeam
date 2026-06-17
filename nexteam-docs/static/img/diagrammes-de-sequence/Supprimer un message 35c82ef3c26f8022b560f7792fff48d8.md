# Supprimer un message

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Supprimer un message"
actor Utilisateur
participant "Frontend" as Front
participant "API" as API
participant "MessageService" as Service
participant "Base de données" as DB

Utilisateur -> Front : Supprimer message
Front -> API : DELETE /messages/{id}
API -> Service : Vérifier autorisation
Service -> DB : Supprimer message
DB --> Service : Confirmation suppression
Service --> API : Message supprimé
API --> Front : Succès suppression
Front --> Utilisateur : Message supprimé
@enduml
```