package fr.iutvalence.java.morpion;

import java.security.SecureRandom;
import java.util.Scanner;

/** Modélisation d'une vue.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0 */
public class VueMorpion
{
	/** Noms par défaut des différents joueurs. */
    private static final String[] JOUEURS_PAR_DEFAUT = {"Joueur 1", "Joueur 2"};
	
	/** Demander aux utilisateurs si ils veulent changer le nom des joueurs.
	 *  
	 * @return Un tableau contenant les noms des joueurs. */
	public String[] demanderNomsJoueurs()
	{
		final Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = scanner.nextLine();

			if ("N".equals(choix))
				return JOUEURS_PAR_DEFAUT;

			if ("O".equals(choix))
			{
				while (true)
				{
					System.out.println("Veuillez entrer le nom du joueur 1 : ");
					String namePlayer1 = scanner.nextLine();
					System.out.println("Veuillez entrer le nom du joueur 2 : ");
					String namePlayer2 = scanner.nextLine();

					if (namePlayer1.equals(namePlayer2))
						System.out.println("Veuillez saisir des noms différents.\n");
					else
						return new String[]{namePlayer1, namePlayer2};
				}
			}
			System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
	
	/** On affiche quel joueur doit jouer son coup.
	 * 
	 * @param unJoueur Un joueur. */
	public void estAJoueurDeJouer(Joueurs unJoueur)
	{
		String symbole = (unJoueur.obtenirSignatureCourante() == PlateauJeu.SIGNATURE_JOUEUR1) ? "X" : "O";
		System.out.printf("\nC'est à %s de jouer (pion : %s)%n", unJoueur.obtenirNomCourant(), symbole);
	}
	
	/** Permet de demander la première coordonnée au joueur courant. */
	public void demandePremiereCoordonnee()
	{
		System.out.print("Veuillez saisir la première coordonnée (entre 1 et 3 compris) : ");
	}
	
	/** Permet de demander la deuxième coordonnée au joueur courant. */
	public void demandeDeuxiemeCoordonnee()
	{
		System.out.print("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) : ");
	}
	
	/** Message à afficher lorsqu'il y a un vainqueur.
	 * 
	 * @param vainqueur Contient le nom du vainqueur.*/
	public void afficherVainqueur(final String vainqueur)
	{
		System.out.printf("La partie est remportée par %s%n", vainqueur);
	}
	
	/** Permet d'afficher une partie nulle. */
	public void afficherPartieNulle()
	{
		System.out.println("\nPartie nulle. Il n'y a pas de vainqueur.");
	}
	
	/** Permet de demander aux joueurs si ils veulent rejouer une partie.
	 * 
	 * @return true si le joueur veut rejouer une partie, false sinon. */
	public boolean choixRejouer()
	{
		while (true)
		{		
			Scanner choixDePoursuite = new Scanner(System.in);
			System.out.println("\nVoulez-vous rejouer une partie ? (O/N)");
			String reponse = choixDePoursuite.nextLine();

			if ("O".equals(reponse))
				return true;
			else
				if ("N".equals(reponse))
				{
					quitter();
					return false;
				}
				else
					System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
	
	/** Message à afficher lorsqu'on quitte l'application. */
	public void quitter()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-- Développé par Delorme Loïc et Basson Julien --");
		System.out.println("--- Merci à Anthony Gelibert pour son aide ! ----");
		System.out.println("-------------------------------------------------");
	}
}
