# Gérer les actualités

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Gérer les actualités"
actor "RH / Admin" as Admin
participant "Frontend" as Front
participant "API" as API
participant "NewsService" as Service
participant "Base de données" as DB

Admin -> Front : Créer / Modifier actualité
Front -> API : POST ou PUT /actualites
API -> Service : Vérifier permissions
Service -> DB : Sauvegarder actualité
DB --> Service : Confirmation
Service --> API : Succès opération
API --> Front : Actualité mise à jour
Front --> Admin : Affichage confirmation
@enduml
```