import java.util.Scanner;

/**
 * Classe Application
 * @author Loic
 */
public class Application {

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

    /**
     * Permet de lancer le jeu
     * @param args
     */
    public static void main(String[] args) {
        Scanner recuperationInformation = new Scanner(System.in);

        boolean choiceOfPlayer = false;
        
		do {
            System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
            String choix = recuperationInformation.nextLine();
            
            if ("N".equals(choix)) {
                /* TODO Est-ce que ces variables ne devraient pas avoir une portée plus grande ? Elles seront utiles dans les deux cas… */
            	Joueurs player1 = new Joueurs(PLAYER1, SIGNATURE1);
            	Joueurs player2 = new Joueurs(PLAYER2, SIGNATURE2);
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
                        	Joueurs player1 = new Joueurs(namePlayer1, SIGNATURE1);
                        	Joueurs player2 = new Joueurs(namePlayer2, SIGNATURE2);
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
