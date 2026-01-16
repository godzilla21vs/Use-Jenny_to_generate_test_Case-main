#  Vérification et Validation - Résolution des Équations du Second Degré

Ce projet est une implémentation complète de Vérification et Validation, axé sur la résolution des équations du second degré. Le but principal est de mettre en pratique les concepts de tests logiciels, notamment les tests manuels et automatisés, tout en gérant les cas spécifiques à travers des exceptions personnalisées.

## Fonctionnalités

### 1. Résolution des Équations du Second Degré
- Méthode principale : `resolve(double a, double b, double c)` pour résoudre \( ax^2 + bx + c = 0 \).
- Gestion des cas spéciaux :
  - **Équations non quadratiques** : Exception `NotAQuadraticEquationException` levée si \( a = 0 \).
  - **Pas de solutions réelles** : Exception `NoRealSolutionException` levée si le discriminant \( \Delta < 0 \).

### 2. Tests Manuels
- Génération des cas de test avec l'outil **Jenny**.
- Vérification des solutions et gestion des exceptions personnalisées.
- Génération d'un rapport détaillé dans `TestReport.txt` avec :
  - Les valeurs des coefficients \( a, b, c \).
  - Les résultats des tests (solutions ou exceptions).
  - Le statut du test (succès ou échec).

### 3. Tests Unitaires Automatisés
- Conversion des tests manuels en tests unitaires avec **JUnit**.
- Automatisation de la vérification des cas de test à l'aide de :
  - `assertEquals` pour les solutions valides avec une tolérance définie (\( 10^{-6} \)).
  - `assertThrows` pour valider les exceptions levées dans les cas invalides.

## Classes et Interfaces Implémentées

| Classe / Interface                 | Description                                                                     |
|------------------------------------|---------------------------------------------------------------------------------|
| **`Equation`**                     | Résolution des équations et levée des exceptions personnalisées.                |
| **`CaseAdapter`**                  | Lecture d'un fichier de cas de test et transformation en structure exploitable. |
| **`EquationManualTest`**           | Exécution des tests manuels et génération des rapports.                         |
| **`NotAQuadraticEquationException`** | Exception pour les équations non quadratiques.                                  |
| **`NoRealSolutionException`**      | Exception pour discriminant négatif.                                            |
| **`EquationTest`**                 | Automatisation des tests avec JUnit.                                            |

## Installation et Exécution

### Prérequis
- **Java JDK**
- **JUnit**
- Outil de génération de cas de test : [Jenny](http://bennycheung.github.io/Jenny/)

### Étapes

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/godzilla21vs/Use-Jenny_to_generate_test_Case
   ```

2. **Compiler les classes** :
   ```bash
   javac -cp .:/path/to/junit.jar *.java
   ```

3. **Exécuter les tests manuels** :
   ```bash
   java EquationManualTest
   ```

4. **Exécuter les tests unitaires avec JUnit** :
   ```bash
   java -cp .:/path/to/junit.jar org.junit.runner.JUnitCore EquationTest
   ```

5. **Consulter le rapport** : Vérifiez le fichier `TestReport.txt` pour les résultats des tests.

## Résultats et Accomplissements
- Mise en pratique des concepts de tests logiciels, incluant :
  - **Tolérance numérique** pour valider les résultats.
  - **Gestion des exceptions** pour les cas d'erreur.
  - **Automatisation des tests** pour une efficacité accrue.
- Production d'un rapport clair et détaillé des tests exécutés.

## Auteur
**FranckJudes**

---
N'hésitez pas à me contacter pour toute question ou suggestion concernant ce projet. 🚀
