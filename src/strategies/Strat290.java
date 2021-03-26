package strategies;

import org.graalvm.compiler.nodes.GetObjectAddressNode;

import cantstop.Jeu;

/**
 * Votre Stratégie (copie de la Strat0 pour l'instant)
 *
 * Expliquez votre stratégie en une 20aine de lignes maximum.
 *
 * RENDU: Ce fichier, correctement nommé et rempli avec le numéro de la
 * stratégie choisie.ptit test
 *
 * @author VOS NOMS (en binome maximum)
 */
public class Strat290 implements Strategie {

    /**
     * @param j le jeu
     * @return toujours le 1er choix
     */
    public int choix(Jeu j) {
        int[][] lesChoix = j.getLesChoix();
        int choix = 0;
        int k = 0;
        boolean stop = false; // true = le choix est trouvé

        while (stop == false) {
            for (int i = 0; i < j.getNbChoix(); i++) {
                if ((lesChoix[i][0] == 7 - k || lesChoix[i][0] == 7 + k)
                        || (lesChoix[i][1] == 7 - k || lesChoix[i][1] == 7 + k)) {
                    stop = true;
                    choix = i;
                    break;
                }
            }
            k++;

        }

        return choix;
    }

    /**
     * @param j le jeu
     * @return toujours vrai (pour s'arrêter)
     */
    public boolean stop(Jeu j) {
        boolean colonne7 = false;
        boolean colonne6ou8 = false;
        for (int i = 0; i < 3; i++) {
            if (j.getBonzes()[i][0] > 1) {
                if (j.getBonzes()[i][1] == j.getMaximum()[j.getBonzes()[i][0] - 2] && j.getBonzesRestants() == 0) {
                    return true;
                }
                if (j.getBonzes()[i][0] == 7) {
                    colonne7 = true;
                }
                if (j.getBonzes()[i][0] == 6 || j.getBonzes()[i][0] == 8) {
                    colonne6ou8 = true;
                }

            }
        }
        if (colonne7 == true && j.getNbCoup() >= 10) {
            return true;
        }

        else if (colonne6ou8 == true && j.getNbCoup() >= 8) {
            return true;
        }

        else if (j.getNbCoup() >= 6) {
            return true;
        }

        else {
            return false;
        }

    }

    /**
     * @return vos noms
     */
    public String getName() {
        return "BERNARD_VIALA";
    }
}
