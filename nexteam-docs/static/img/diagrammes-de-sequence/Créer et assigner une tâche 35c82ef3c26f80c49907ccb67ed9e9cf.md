# Créer et assigner une tâche

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Créer et assigner une tâche"
actor Manager
participant "Frontend" as Front
participant "API" as API
participant "TaskService" as Service
participant "Base de données" as DB

Manager -> Front : Créer tâche
Front -> API : POST /taches
API -> Service : Créer tâche
Service -> DB : Sauvegarder tâche
DB --> Service : Tâche enregistrée

Manager -> Front : Assigner employé
Front -> API : PUT /taches/{id}/assigne
API -> Service : Affecter tâche
Service -> DB : Mise à jour tâche
DB --> Service : Confirmation

Service --> API : Succès opération
API --> Front : Tâche assignée
Front --> Manager : Afficher confirmation
@enduml
```