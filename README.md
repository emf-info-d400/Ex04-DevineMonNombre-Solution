# Exercice 04 : Devine mon nombre
## durée : 240'
## Objectifs visés :
Maitriser les diagrammes de séquence ; Maitriser les diagrammes de classes ; Savoir se référer à la Javadoc ; Maîtrise de MVC avec Ihm simple fournie

## Travail à réaliser
Lisez avec attention les informations fournies ci-après sous diverses formes (diagramme de classe, javadoc, diagrammes de séquence, …) car vous y trouverez toutes les informations utiles afin de finaliser le projet Java « DevineMonNombre ».

## Résultat à obtenir
Si votre code est correctement implémenté selon les directives reçues, vous devriez obtenir une application fonctionnelle ressemblant à cela à son démarrage :
![Aperçu de l'application](images/interface.png)
## Description des fonctionnalités de l’application
Les deux seuls boutons de l’application permettent de :
-	démarrer une nouvelle partie (bouton « Ordinateur – Pense à un nouveau nombre »)
-	tenter de deviner le nombre (bouton « Vérifier »).

| Pression du bouton | Résultats possibles| Aperçu |
| :--------------- |:---------------| :----------------|
| Ordinateur - Pense à un nouveau nombre  | L’ihm affichera ceci afin d’indiquer qu’un nouveau jeu a démarré :        |  ![Démarrage jeu](images/interface_1.png) |
| Vérifier  | Si le jeu n’avait pas encore été démarré, l’ihm affichera ceci pour indiquer cela : | ![Jeu par démarré !](images/interface_2.png) |
| Vérifier | Si le jeu a été démarré et que la proposition de nombre saisie ne constitue pas un nombre valable, l’ihm affichera ceci pour l’indiquer : |    ![pas nombre valable !](images/interface_3.png) ![pas nombre valable !](images/interface_4.png)
| Vérifier | Si le jeu a été démarré, l’ihm affichera ceci pour indiquer que la proposition du joueur est trop petite : |    ![pas nombre valable !](images/interface_5.png) 
| Vérifier | Si le jeu a été démarré, l’ihm affichera ceci pour indiquer que la proposition du joueur est trop grande : |    ![pas nombre valable !](images/interface_6.png) 
| Vérifier | Si le jeu a été démarré, l’ihm affichera ceci pour indiquer que la proposition du joueur est correcte : |    ![pas nombre valable !](images/interface_7.png) 

## Diagramme de classes
```mermaid
classDiagram

class IhmSimple {
    main(String[] args)$ void
}

class View {
    -javax.swing.JButton jButtonDeviner
    -javax.swing.JButton jButtonNouveauJeu
    -javax.swing.JLabel jLabelEtat
    -javax.swing.JLabel jLabelLogo
    -javax.swing.JLabel jLabelProposition
    -javax.swing.JTextField jTextFieldProposition
    -Controller refCtrl
    +View()
    +afficherStatus(String text, Color backgroundColor) void
    +ihmStart() void
    +lireValeurProposee() int
    +setRefCtrl(Controller refCtrl) void
    +getRefCtrl(Controller refCtrl) Controller
    -initComponents() void
    -jButtonDevinerActionPerformed(java.awt.event.ActionEvent evt) void
    -jButtonNouveauJeuActionPerformed(java.awt.event.ActionEvent evt) void
}

class Controller {
    -int nombre
    -View refView
    -ServiceDevine refServiceDevine
    +Controller()
    +actionDemarrerNouveauJeu() void
    +actionDevinerJeu() void
    +start() void
    +setRefView(View view) void
    +setRefServiceDevine(ServiceDevine service) void
    +getRefView() View
    +getRefServiceDevine() ServiceDevine
}

class ServiceDevine {
    +int MAX_NOMBRE$
    +int MIN_NOMBRE$
    +int NOMBRE_INVALIDE$
    -Controller refCtrl
    +ServiceDevine()
    +penserAUnNombre() int
    +setRefCtrl(Controller ctrl)
    +getRefCtrl() Controller
}
note for ServiceDevine "MAX_NOMBRE = 100\nMIN_NOMBRE = 1\nNOMBRE_INVALIDE = -1"
Controller "1" o--> ServiceDevine : refServiceDevine
ServiceDevine "1" o--> Controller : refController
View "1" o--> Controller : refCtrl
Controller "1" o--> View : refView
```

## Structure des packages Java
Voici la structure des packages pour chaque classe du projet
```mermaid
classDiagram
namespace ihmsimple {
    class app
    class views
    class ctrl
    class services
}
namespace app {
    class IhmSimple
}
namespace views {
    class View
}
namespace ctrl {
    class Controller 
}
namespace services {
    class ServiceDevine 
}

```

## Diagramme de séquence
### ihmsimple.app.IhmSimple.main()
Voici le diagramme de séquence de la méthode de la méthode `main()` de la classe `IhmSimple` du package `app` :
```mermaid
sequenceDiagram
    participant main
    main->>Controller: new Controller()
    Controller-->>main: refCtrl
    main->>ServiceDevine: new ServiceDevine()
    ServiceDevine-->>main: refServiceDevine
    main->>Controller: setRefServiceDevine(refServiceDevine)
    main->>View: new View()
    View-->>main: refView
    main->>Controller: setRefView(refView)
    main->>View: setRefCtrl(refCtrl)
    main->>ServiceDevine: setRefCtrl(refctrl)
    main->>Controller: start()
```
### ihmsimple.ctrl.Controller.start()
Voici le diagramme de séquence de la méthode de la méthode `start()` de la classe `Controller` du package `ctrl` :
```mermaid
sequenceDiagram
    participant Controller.start()
    Controller.start()->>View refView: ihmStart()
    Controller.start()->>View refView: afficherStatus("Jeu teriminé !", Color.LIGHT_GRAY)
```
### ihmsimple.ctrl.Controller.actionDemarrerNouveauJeu()
Voici le diagramme de séquence de la méthode de la méthode `actionDemarrerNouveauJeu()` de la classe `Controller` du package `ctrl` :
```mermaid
sequenceDiagram
    participant Controller.actionDemarrerNouveauJeu()
    Controller.actionDemarrerNouveauJeu()->>ServiceDevine refServiceDevine: penserAUnNombre()
    ServiceDevine refServiceDevine-->>Controller.actionDemarrerNouveauJeu(): nombre=
    Controller.actionDemarrerNouveauJeu()->>View refView: afficherStatus("Devinez !", Color.YELLOW)
```
### ihmsimple.ctrl.Controller.actionDeviner()
Voici le diagramme de séquence de la méthode de la méthode `actionDeviner()` de la classe `Controller` du package `ctrl` :
```mermaid
sequenceDiagram
    participant Controller.actionDeviner()
    alt nombre IS NOT NOMBRE_INVALIDE
        Controller.actionDeviner()->>View refView: lireValeurProposee()
        View refView-->>Controller.actionDeviner(): valeurProposee=
        alt ValeurProposee IS NOT NOMBRE_INVALIDE
            alt ValeurProposee < nombre
               Controller.actionDeviner()->>View refView: afficherStatus("Trop petit !", Color.RED)
            else ValeurProposee > nombre
                Controller.actionDeviner()->>View refView: afficherStatus("Trop grand !", Color.RED)
            else
                Controller.actionDeviner()->>View refView: afficherStatus("Trouvé !!!", Color.GREEN)            
            end 
        else
            Controller.actionDeviner()->>View refView: afficherStatus("Entrez un nombre !", Color.YELLOW)
        end

    end
```
## Javadoc
Vous pouvez cliquer sur [ce lien pour obtenir la JavaDoc en HTML](javadoc/index.html) de l'application IhmSimple.

