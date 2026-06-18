# NexTeam - Documentation

NexTeam est une plateforme d’intranet nouvelle génération visant à centraliser la communication, la gestion de tâches et les outils collaboratifs au sein des équipes.

Cette documentation technique est construite avec **Docusaurus**.

---

## 🚀 Installation

```bash
yarn install
```
## 💻 Lancer le projet en local

```bash
yarn start
```

Le site sera accessible sur :
http://localhost:3000

Les modifications sont appliquées automatiquement (hot reload).

## 🏗️ Build de production

```bash
yarn build
```

Génère un site statique dans le dossier /build.

## 🌐 Déploiement


Avec SSH
```bash
USE_SSH=true yarn deploy
```

Sans SSH

```bash
GIT_USER=<votre-username-github> 
```

```bash
yarn deploy
```

## 🧱 Stack technique

Docusaurus 3
React
TypeScript
Markdown / MDX
Prism (highlight code)

## 📁 Structure du projet

```bash
/docs        → Documentation technique
/src         → Composants UI custom
/static      → Images, assets
/sidebars.ts → Navigation des docs
```

## ✨ Objectif du projet

Ce projet a pour but de documenter et structurer l’architecture et les fonctionnalités de NexTeam, une application d’intranet moderne destinée à améliorer la productivité des équipes.

## 📌 Auteur

Projet réalisé par Jonatan Ns
GitHub : https://github.com/JonatanNs/appNexTeam