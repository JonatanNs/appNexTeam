# Créer un utilisateur

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Créer un utilisateur"
actor "RH / Admin" as Admin
participant "Frontend" as Front
participant "API" as API
participant "PersonService" as Service
participant "Base de données" as DB

Admin -> Front : Saisir nouvel utilisateur
Front -> API : POST /person
API -> Service : Vérifier permissions
Service -> DB : Enregistrer utilisateur
DB --> Service : Confirmation création
Service --> API : Utilisateur créé
API --> Front : Succès création
Front --> Admin : Afficher confirmation
@enduml
```