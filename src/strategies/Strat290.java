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
        for (int i = 0; i < 3; i++) {
            if (j.getBonzes()[i][0] > 1) {
                if (j.getBonzes()[i][1] == j.getMaximum()[j.getBonzes()[i][0] - 2] && j.getBonzesRestants() == 0) {
                    return true;
                }
            }
        }
        if (j.getNbCoup() < 4) {
            return false;
        }

        else {
            return true;
        }

    }

    /**
     * @return vos noms
     */
    public String getName() {
        return "BERNARD_VIALA";
    }
}
