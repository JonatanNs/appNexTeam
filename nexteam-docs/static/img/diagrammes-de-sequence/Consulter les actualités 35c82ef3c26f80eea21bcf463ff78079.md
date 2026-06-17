# Consulter les actualités

Propriétaire: Jonatan Ns
Étiquettes: Conception théorique
État: Terminé

```
@startuml
!theme bluegray
title "Diagramme de séquence - Consulter les actualités"
actor Utilisateur
participant "Frontend" as Front
participant "API" as API
participant "NewsService" as Service
participant "Base de données" as DB

Utilisateur -> Front : Ouvrir actualités
Front -> API : GET /actualites
API -> Service : Récupérer actualités
Service -> DB : Lire actualités
DB --> Service : Liste actualités
Service --> API : Retour données
API --> Front : Liste actualités
Front --> Utilisateur : Affichage actualités
@enduml
```