package ihmsimple.app;

import ihmsimple.ctrl.Controller;
import ihmsimple.services.ServiceDevine;
import ihmsimple.views.View;

/**
 * Classe principale de l'application MVC "IhmSimple".
 * 
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 29.10.2023
 * @version 1.0.0
 */
public class IhmSimple {

    /**
     * Méthode principale de l'application qui instancie les objets MVC et les relie entre eux.
     * Voir le diagramme de séquence pour l'implémentation e cette méthode.
     * 
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        Controller refCtrl = new Controller();
        ServiceDevine refServiceDevine = new ServiceDevine();
        refCtrl.setRefServiceDevine(refServiceDevine);
        View refView = new View();
        refCtrl.setRefView(refView);
        refView.setRefCtrl(refCtrl);
        refServiceDevine.setRefCtrl(refCtrl);
        refCtrl.start();
    }

}
