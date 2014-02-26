package fr.iutvalence.java.morpion;

import java.util.Scanner;

/* TODO JavaDoc : Même commentaire que pour la classe PlateauJeu. */
/* TODO Pourquoi faire une classe dédiée à cela ? Cette classe s'apparante à ce que nous avions appelé "Partie" ou "Jeux" en TP. */
/**
 * La classe Menu permet de lancer un "dialogue" avec l'utilisateur en mode console afin
 * d'établir les paramètres souhaités
 * @author Loic
 *
 */
public class Menu
{
	/**
	 * Le nom par défaut du joueur 1
	 */
	private static final String PLAYER1 = "Joueur 1";
	
	/**
	 * Le nom par défaut du joueur 2
	 */
	private static final String PLAYER2 = "Joueur 2";
	
	/**
	 * La signature par défaut du joueur 1
	 */
	private static final int SIGNATURE1 = 5;
	
	/**
	 * La signature par défaut du joueur 2
	 */
	private static final int SIGNATURE2 = - SIGNATURE1;

    /* TODO Pourquoi un attribut ? */
	/**
	 * Permettra de créer le joueur player1 avec des composantes définies
	 */
	private static Joueurs player1;

    /* TODO Pourquoi un attribut ? */
	/**
	 * Permettra de créer le joueur player1 avec des composantes définies
	 */
	private static Joueurs player2;
	
	/**
	 * Lance le menu qui permet de demander le choix de l'utilisateur concencernant le choix des joueurs
	 */
	public void StartMenu()
	{
		Scanner recuperationInformation = new Scanner(System.in);

        /* TODO Pourquoi passer par cette variable ? */
        boolean choiceOfPlayer = false;

		do {
            System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
            String choix = recuperationInformation.nextLine();

            /* TODO Avez-vous compris pourquoi je vous indiqué comme une bonne pratique ce formalisme-ci ? */
            if ("N".equals(choix)) {
            	player1 = new Joueurs(PLAYER1, SIGNATURE1);
            	player2 = new Joueurs(PLAYER2, SIGNATURE2);
                choiceOfPlayer = true;
            }

            else {
                if ("O".equals(choix)) {
                    do {

                        System.out.println("Veuillez entrer le nom du joueur 1 : ");
                        String namePlayer1 = recuperationInformation.nextLine();
                        System.out.println("Veuillez entrer le nom du joueur 2 : ");
                        String namePlayer2 = recuperationInformation.nextLine();

                        if (namePlayer1.equals(namePlayer2)) System.out.println("Veuillez saisir des noms différents");
                        else {
                        	player1 = new Joueurs(namePlayer1, SIGNATURE1);
                        	player2 = new Joueurs(namePlayer2, SIGNATURE2);
							choiceOfPlayer = true;
						}
                    }
                    while (!choiceOfPlayer);
				}
				else
					System.out.println("Veuillez saisir une lettre valide");
			}
		}
        while (!choiceOfPlayer);
	}

}