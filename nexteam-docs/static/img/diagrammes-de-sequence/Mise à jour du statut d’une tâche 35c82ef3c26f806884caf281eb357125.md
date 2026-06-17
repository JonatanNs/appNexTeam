# Mise à jour du statut d’une tâche

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Mise à jour du statut d’une tâche"
actor Utilisateur
participant "Frontend" as Front
participant "API" as API
participant "TaskService" as Service
participant "Base de données" as DB

Utilisateur -> Front : Modifier statut tâche
Front -> API : PUT /taches/{id}
API -> Service : Vérifier droits
Service -> DB : Mise à jour statut
DB --> Service : Confirmation
Service --> API : Succès modification
API --> Front : Nouveau statut
Front --> Utilisateur : Affichage mise à jour
@enduml
```