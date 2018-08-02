package tp2;

import javax.swing.JOptionPane;

public class Tp2 {

	public static void main(String[] args) {
		// Message
		JOptionPane.showMessageDialog(null, "***** BIENVENUE AU MASTERMIND *****");
		// Déclaration de variables
		final int NBR_COULEUR = 6;
		final String COULEURS = "BJMNVR";
		int niveau, nbrEssaisMax = 0, nbrGagne = 0;
		String rejouer = "";
		boolean erreurSaisie = true;

		String refer = "";// JOptionPane.showInputDialog("Entrer le code couleur
							// : (4 couleurs max)");
		String propo = "BJBJ";

		// Verifer le nbr de couleurs proposées et esq c les bonnes couleurs
		boolean victoire = true;

		// Compter le nombre de couleurs placées

		/*
		 * String joueur = JOptionPane.
		 * showInputDialog("Jouer contre 1 - machine\t2 - multijoueur"); int
		 * adversaire = Integer.parseInt(joueur); switch (adversaire) { case 1:
		 * adversaire = 1; // machine break; case 2: adversaire = 2; // joueur
		 * break;
		 * 
		 * default: nbrEssaisMax = 1;
		 */
		do {

			String maxEssais = JOptionPane.showInputDialog("Niveau 1-Facile 2-Moyen 3-difficile");
			niveau = Integer.parseInt(maxEssais);

			switch (niveau) {
			case 1:
				nbrEssaisMax = 15;
				break;
			case 2:
				nbrEssaisMax = 10;
				break;
			case 3:
				nbrEssaisMax = 5;
				break;

			default:
				nbrEssaisMax = 1;
			}

			String referMachine = "";

			for (int i = 0; i < 4; i++) {
				int rnd = (int) (Math.random() * 6);
				referMachine += COULEURS.charAt(rnd);
			}
			refer = referMachine;

			// conbinaison de couleurs machine

			do {
				int nbrTouvee = 0, nbrPlacee = 0;
				propo = JOptionPane.showInputDialog("Entrer la proposition  ");
				refer = refer.toUpperCase();
				propo = propo.toUpperCase();
				StringBuffer crefer = new StringBuffer(refer);
				StringBuffer cpropo = new StringBuffer(propo);

				for (int i = 0; i < 4; i++) {
					if (crefer.charAt(i) == cpropo.charAt(i)) {
						nbrPlacee++;
						cpropo.setCharAt(i, '*');
						crefer.setCharAt(i, '-');
					}
				}

				System.out.println(crefer + " " + cpropo);

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (crefer.charAt(i) == cpropo.charAt(j)) {
							nbrTouvee++;
							cpropo.setCharAt(j, '*');
							crefer.setCharAt(i, '-');
						}
					}
				}
				System.out.println(crefer + " " + cpropo);
				/*			---M		P = 0
				 * 			**M*		T = 4
				 */				
				System.out.println(propo + " -> " + nbrPlacee + " Placés\t" + nbrTouvee + " Trouvés");
				nbrEssaisMax--;
				nbrGagne = nbrPlacee;

			} while (nbrGagne != 4 && nbrEssaisMax != 0);

			if (nbrGagne == 4) {
				JOptionPane.showMessageDialog(null, "Gagné!");
			} else if (victoire == false && nbrEssaisMax == 0) {
				JOptionPane.showMessageDialog(null, "Perdu!");
			}

			do {
				erreurSaisie = false;
				rejouer = JOptionPane.showInputDialog("voulez-vous rejouer? (O/N)");
				if (rejouer.length() == 1 && rejouer.toUpperCase().charAt(0) != 'O') {
					erreurSaisie = true;
					System.out.println(erreurSaisie);
				}
				System.out.println(erreurSaisie);
			} while (erreurSaisie);
			rejouer = "o";
		} while (rejouer.equals("O"));
	}
}
