package TPPROBSOLV;

import java.util.*;

public class JeuxNum3 extends Thread{

	public static boolean test(int n, Pieceor[] urne) {
		boolean test = true;
		if (urne[0] == null)
			return true;
		else {
			for (int i = 0; i <= urne.length; i++) {
				if (urne[i] == null) {
					break;
				} else if (n == urne[i].getNum()) {
					test = false;
					break;
				}
			}
		}
		return test;
	}

	public static void retour(Pieceor[] pieces, Pieceor[] urne, int t_urn, double v, int end, double som) {
		if (t_urn == 1 && urne[1] == null) {
			t_urn = 0;
			v = 0d;
			urne[0] = null;
		} else {
			v = (v - urne[t_urn - 1].getPoids()) - 3;
			t_urn = t_urn - 1;
		}
		if (urne[0] == null)
			System.out.println("Urne vide");
		else {
			for (int i = 0; i < t_urn; i++) {
				System.out.print(urne[i].toString());
			}
			System.out.println("Totale de poids : " + v);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		jeucomplet(pieces, urne, t_urn, v, end, som);
	}
//Calculer le nombre de tentative , les urnes collectes et retourner le poids
	public static void jeucomplet(Pieceor[] pieces, Pieceor[] urne, int t_urn, double v, int end, double som) {

		Scanner sc = new Scanner(System.in);
		int n;
		end++;
		if (end <= 10) {
			System.out.println("Il vous reste  " + (10 - end + 1) + "  TENTATIVES");
			do {
				System.out.println("Choisissez un nombre entre 1..20 non utilise");
				for (int i = 0; i < 20; i++) {
					System.out.print(pieces[i].getNum() + "  ");
				}
				n = sc.nextInt();
			} while (!test(n, urne));

			if (n != 0) {
				for (int i = 0; i < 20; i++) {
					if (pieces[i].getNum() == n) {
						v += pieces[i].getPoids() + 3;
						urne[t_urn] = pieces[i];
						t_urn++;
						break;
					}
				}

				for (int i = 0; i < t_urn; i++) {
					System.out.print(urne[i].toString());
				}
				System.out.println(" Totale de poids  est " + v);
				System.out.println();
				System.out.println();
				System.out.println();
				jeucomplet(pieces, urne, t_urn, v, end, som);
			} else if (t_urn != 0)
				retour(pieces, urne, t_urn, v, end, som);
			else {
				System.out.println("vide");
				jeucomplet(pieces, urne, t_urn, v, end, som);
			}
		} else if (Math.round(((v * 100) / som)) >= 80) {
			System.out.print("BRAVOOO! , Totale est :");
			String x = Math.round(((v * 100) / som)) + " % du totale";
			System.out.println(x);
		} else {
			System.out.print("Vous avez Perdu , Totale est : ");
			System.out.println(Math.round(((v * 100) / som)) + " % du totale");
		}
	}

	public static void execute() {
		// TODO Auto-generated method stub
		double v = 0d;
		int end = 0;
		Pieceor[] pieces = new Pieceor[20];
		Pieceor[] urne = new Pieceor[10];
		int t_urn = 0;
		double som = 0d;

		for (int i = 0; i < 20; i++) {
			double x = Math.round(Math.random() * 10);
			pieces[i] = new Pieceor(x, i + 1);
			som += pieces[i].getPoids();
		}
		jeucomplet(pieces, urne, t_urn, v, end, som);

	}
	
	public void run()
	{
		execute();
	}
}