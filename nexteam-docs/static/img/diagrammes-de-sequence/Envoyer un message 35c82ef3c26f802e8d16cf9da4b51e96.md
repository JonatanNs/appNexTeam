# Envoyer un message

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique, feature
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Envoyer un message"
actor Utilisateur
participant "Frontend" as Front
participant "API" as API
participant "MessageService" as Service
participant "Base de données" as DB

Utilisateur -> Front : Écrire message
Front -> API : POST /messages
API -> Service : Créer message
Service -> DB : Sauvegarder message
DB --> Service : Confirmation
Service --> API : Message enregistré
API --> Front : Succès envoi
Front --> Utilisateur : Afficher message
@enduml
```