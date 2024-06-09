# Application JavaFx

## À propos
Bienvenue sur le projet **Application de vente de films**, une plateforme de vente de films développée en JavaFX.
Cette application permet aux utilisateurs de parcourir, évaluer et acheter des films, ainsi que de gérer leur panier et leur compte. De plus, le projet inclut des rôles distincts pour les utilisateurs et les administrateurs, chacun ayant des fonctionnalités spécifiques.

## Fonctionnalités
### côté client
- **Recherche de films** : Permet aux utilisateurs de trier des films par titre, genre, etc.
- **Évaluations** : Les utilisateurs peuvent évaluer et commenter les films.
- **Gestion du panier** : Ajouter, supprimer et gérer les films dans le panier.
- **Compte utilisateur** : Création et gestion de comptes utilisateur.
 
### côté administrateur
- **Ajouter, modfier et supprimer les films** : permet la gestion des films côté admin

## Prérequis

- [Java JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) ou supérieur
- [JavaFX 11](https://openjfx.io/) ou supérieur
- Un IDE compatible Java (Eclipse, IntelliJ IDEA, etc.)

## Installation

1. Clonez le dépôt :
    ```sh
    git clone https://github.com/yourusername/VenteProjetFilms.git
    ```

2. Importez le projet dans votre IDE favori.

3. Ajoutez les bibliothèques JavaFX à votre projet :
    - Pour IntelliJ IDEA : [IntelliJ IDEA avec JavaFX](https://openjfx.io/openjfx-docs/#IDE-IntelliJ)
    - Pour Eclipse : [Eclipse avec JavaFX](https://openjfx.io/openjfx-docs/#IDE-Eclipse)

## Exécution

1. Configurez votre IDE pour inclure les modules JavaFX lors de l'exécution. Par exemple, pour IntelliJ IDEA, ajoutez les VM options suivantes :
    ```sh
    --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
    ```

2. Exécutez la classe principale `MainApp` :
    ```java
    package com.cytech.main;

    public class MainApp {
        public static void main(String[] args) {
            launch(args);
        }
    }
    ```

## Structure du projet

Voici un aperçu de la structure du projet :

```sh
VenteProjetFilms/
├── src/
│   ├── com/
│   │   ├── cytech/
│   │   │   ├── data/
│   │   │   │   ├── Achat.java
│   │   │   │   ├── Acteur.java
│   │   │   │   ├── Client.java
│   │   │   │   ├── Evaluation.java
│   │   │   │   ├── Film.java
│   │   │   │   ├── Producteur.java
│   │   │   │   ├── Role.java
│   │   │   │   ├── Theme.java
│   │   │   │   ├── Vitrine.java
│   │   │   │   ├── GestionEvaluation.java
│   │   │   ├── address/
│   │   │   │   ├── view/
│   │   │   │   │   ├── AccueilController.java
│   │   │   │   │   ├── CreateAccountController.java
│   │   │   │   ├── model/
│   │   │   │   ├── MainApp.java
│   │   │   ├── main/
│   │   │   │   ├── MainApp.java
├── resources/
│   ├── com/
│   │   ├── cytech/
│   │   │   ├── view/
│   │   │   │   ├── accueil.fxml
│   │   │   │   ├── createaccount.fxml
├── README.md
