# Backend de la formation sur mesure pour l'APEC

---
## Description

Ce projet a été généré avec l'outil [Spring Initializr](https://start.spring.io/).  
Il a pour vocation de démontrer l'utilisation de Java et de Spring à des profils "chef de projet" 
souhaitant apprendre les concepts du développement pour interagir avec leurs équipes.

## Quick start

### Installation

#### JDK 8
Télécharger l'archive contenant le JDK [ici](https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot).  
Puis suivre la procédure comme indiqué [ici](https://adoptopenjdk.net/installation.html?variant=openjdk8&jvmVariant=hotspot#x64_win-jdk) pour finaliser l'installation.  

Pour vérifier l'installation, il suffit d'ouvrir un nouveau terminal et de taper :
```shell
java -version
```
La réponse devrait indiquer la version du JDK qui vient d'être installée.

#### IntelliJ
Télécharger IntelliJ [ici](https://www.jetbrains.com/fr-fr/idea/download/#section=linux).  
La version "Community" est suffisante pour ce projet.

### Démarrage

Ouvrir le projet avec IntelliJ : `File > New > Project from existing Sources...`  
Choisir le dossier correspondant au Back. Puis selectionner : `Import project from external model > Maven`

Ouvrir le fichier `src/main/java/com/zenika/formation/apec/Application`.  

Si IntelliJ demande d'indiquer le JDK, indiquer l'emplacement d'installation de votre JDK.  
Sur windows, regarder ici et ajuster en fonction de votre environnement :  
```shell
C:\Programmes\AdoptOpenJDK\1.8
```

Ensuite click sur la flèche verte "Play" qui se trouve à gauche de la ligne `public static void main`. 