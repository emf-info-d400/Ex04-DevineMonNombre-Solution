package ihmsimple.services;

import ihmsimple.ctrl.Controller;

/**
 * Classe représentant le service de l'application MVC "IhmSimple".
 * 
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 29.10.2023
 * @version 1.0.0
 */
public class ServiceDevine {
    public static final int MAX_NOMBRE = 100;
    public static final int MIN_NOMBRE = 1;
    public static final int NOMBRE_INVALIDE = -1;

    private Controller refCtrl;

    /**
     * Constructeur du service.
     * Comme toujours, le travail N°1 consiste à initialiser TOUS nos attributs :-).
     * Pour la référence au contrôleur, vous devez à présent savoir quelle valeur
     * initiale donner.
     */
    public ServiceDevine() {
        this.refCtrl = null;
    }

    /**
     * Invente et retourne un nouveau nombre à deviner aléatoirement choisi entre les limites tolérées pour ce jeu.
     * @return le nombre à deviner aléatoirement choisi
     */
    public int penserAUnNombre() {
        return (int) (Math.random() * MAX_NOMBRE) + MIN_NOMBRE;
    }

    /**
     * Retourne la référence au contrôleur de l'application.
     * @param refCtrl la référence au contrôleur de l'application
     */
    public void setRefCtrl(Controller refCtrl) {
        this.refCtrl = refCtrl;
    }

    /**
     * Retourne la référence au contrôleur de l'application.
     * @return la référence au contrôleur de l'application
     */
    public Controller getRefCtrl() {
        return refCtrl;
    }

}
