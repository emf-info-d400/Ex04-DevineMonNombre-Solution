package ihmsimple.ctrl;

import ihmsimple.views.View;
import java.awt.Color;
import ihmsimple.services.ServiceDevine;

/**
 * Classe représentant le contrôleur de l'application MVC "IhmSimple".
 * 
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 29.10.2023
 * @version 1.0.0
 */
public class Controller {
    public int nombre;
    public View refView;
    public ServiceDevine refServiceDevine;

    /**
     * Constructeur du contrôleur. Comme toujours, le travail N°1 consiste à
     * initialiser TOUS nos attributs :-).
     * Pour les références aux serviceDevine et view, vous devez à présent savoir
     * qu’elles valeurs initiales donner. Pour la valeur initiale de l’attribut
     * nombre, utilisez NOMBRE_INVALIDE.
     */
    public Controller() {
        this.refView = null;
        this.refServiceDevine = null;
    }

    /**
     * Méthode permettant de démarrer un nouveau jeu.
     * Voir le diagramme de séquence pour l'implémentation de cette méthode.
     */
    public void actionDemarrerNouveauJeu() {
        this.nombre = this.refServiceDevine.penserAUnNombre();
        this.refView.afficherStatus("Devinez !", Color.YELLOW);
    }

    /**
     * Méthode permettant de deviner le nombre pensé par l'utilisateur.
     * Voir le diagramme de séquence pour l'implémentation de cette méthode.
     */
    public void actionDeviner() {
        if (nombre != ServiceDevine.NOMBRE_INVALIDE) {
            int valeurProposee = this.refView.lireValeurProposee();
            if (valeurProposee != ServiceDevine.NOMBRE_INVALIDE) {
                if (valeurProposee < nombre) {
                    this.refView.afficherStatus("Trop petit !", Color.RED);
                } else if (valeurProposee > nombre) {
                    this.refView.afficherStatus("Trop grand !", Color.RED);
                } else {
                    this.refView.afficherStatus("Trouvé !!!", Color.GREEN);
                }
            } else {
                this.refView.afficherStatus("Entrez un nombre !", Color.YELLOW);
            }
        }

    }

    /**
     * Méthode permettant de démarrer l'application.
     * Voir le diagramme de séquence pour l'implémentation de cette méthode.
     */
    public void start() {
        this.refView.ihmStart();
        this.refView.afficherStatus("Jeu teriminé !", Color.LIGHT_GRAY);
    }

    /**
     * Setter de la référence à la vue de l'application.
     * @param refView la nouvelle référence à la vue de l'application
     */
    public void setRefView(View refView) {
        this.refView = refView;
    }

    /**
     * Setter de la référence au serviceDevine de l'application.
     * @param refServiceDevine la nouvelle référence au serviceDevine de l'application
     */
    public void setRefServiceDevine(ServiceDevine refServiceDevine) {
        this.refServiceDevine = refServiceDevine;
    }

    /**
     * Getter de la référence à la vue de l'application.
     * @return la référence à la vue de l'application
     */
    public View getRefView() {
        return refView;
    }

    /**
     * Getter de la référence au serviceDevine de l'application.
     * @return la référence au serviceDevine de l'application
     */
    public ServiceDevine getRefServiceDevine() {
        return refServiceDevine;
    }

}
