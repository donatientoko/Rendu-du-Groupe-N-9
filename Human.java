package Explain;

import java.util.Scanner;

public class Human {
	private static char[][] grille = {
	        {' ', ' ', ' '},
	        {' ', ' ', ' '},
	        {' ', ' ', ' '}
	    };
	    private static char joueurActuel = 'X';

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean jeuEnCours = true;

	        System.out.println("Bienvenue dans le jeu de Morpion !");
	        afficherGrille();

	        while (jeuEnCours) {
	            System.out.println("Joueur " + joueurActuel + ", entrez votre coup (ligne et colonne, de 1 à 3) : ");
	            int ligne = scanner.nextInt() - 1;
	            int colonne = scanner.nextInt() - 1;

	            if (ligne >= 0 && ligne < 3 && colonne >= 0 && colonne < 3 && grille[ligne][colonne] == ' ') {
	                grille[ligne][colonne] = joueurActuel;
	                afficherGrille();

	                if (verifierVictoire()) {
	                    System.out.println("Félicitations ! Le joueur " + joueurActuel + " a gagné !");
	                    jeuEnCours = false;
	                } else if (estMatchNul()) {
	                    System.out.println("Match nul !");
	                    jeuEnCours = false;
	                } else {
	                    changerJoueur();
	                }
	            } else {
	                System.out.println("Coup invalide, réessayez !");
	            }
	        }
	        scanner.close();
	    }

	    private static void afficherGrille() {
	        System.out.println("  1 2 3");
	        for (int i = 0; i < 3; i++) {
	            System.out.print((i + 1) + " ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(grille[i][j]);
	                if (j < 2) System.out.print("|");
	            }
	            System.out.println();
	            if (i < 2) System.out.println("  -----");
	        }
	    }

	    private static boolean verifierVictoire() {
	        for (int i = 0; i < 3; i++) {
	            if (grille[i][0] == joueurActuel && grille[i][1] == joueurActuel && grille[i][2] == joueurActuel) return true;
	            if (grille[0][i] == joueurActuel && grille[1][i] == joueurActuel && grille[2][i] == joueurActuel) return true;
	        }
	        if (grille[0][0] == joueurActuel && grille[1][1] == joueurActuel && grille[2][2] == joueurActuel) return true;
	        if (grille[0][2] == joueurActuel && grille[1][1] == joueurActuel && grille[2][0] == joueurActuel) return true;

	        return false;
	    }

	    private static boolean estMatchNul() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (grille[i][j] == ' ') return false;
	            }
	        }
	        return true;
	    }

	    private static void changerJoueur() {
	        joueurActuel = (joueurActuel == 'X') ? 'O' : 'X';
	    }

}
