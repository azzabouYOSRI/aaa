package TPPROBSOLV;

import java.util.Scanner;

public class stage2 extends Thread{

    public static void execute() {
        Scanner sc = new Scanner(System.in);

        int x = 5;
        // nom Stage
        System.out.println("felicitation de rejoindre stage Numero 2 !");

        // Description Stage
        System.out.println("Dans ce stage du jeux, \n" +
                " veuiller gramper une montagne du\n"
                + "point de depart de couleur  par example blanc a un point d’arriver de couleur comme bleu de afin que que vous optimzer la distance pour otenir le plus court chemin"
                + "parcourue.\n" + "sur cette montagne en va fixé un ensemble de piquet de diffrent couleur\n"
                + "la somme des ditances entre les pqiquet choisis represent les piquets choisis");
        System.out.println("cette matrice nous indique les distance entre chaque couple des piquets");
        Prob.generateGraph(x);
        Prob.showGraph();
        System.out.println("veuillez saisir la couleur du piquet que vous voulez visiter ");
        System.out.println("pour vister le piquet prefrer svp enter la couleur ");
        String R = "blanc";
        int a = 0, b = 0, c = 0;
        while (!(R.equalsIgnoreCase("noir"))) {
            R = sc.nextLine();
            while ((!(R.equalsIgnoreCase("jaune"))) && (!(R.equalsIgnoreCase("rouge")))
                    && (!(R.equalsIgnoreCase("mauve")))
                    && (!(R.equalsIgnoreCase("noire")) && (!(R.equalsIgnoreCase("gris"))))) {
                System.out.println("choix invalide ! veuillez saisie un coulour valid");
                R = sc.nextLine();
            }
            R = R.toLowerCase();
            switch (R) {
                case "jaune":
                    a = 1;
                    break;
                case "rouge":
                    a = 2;
                    break;
                case "mauve":
                    a = 3;
                    break;
                case "noire":
                    a = 4;
                    break;
                default:
                    a = 0;
            }
            c = Prob.graph[a][b] + c;
            b = a;

        }

        System.out.println("La distance a éte parcourue =  " + c);
        Prob.resolveTSP(1);
        long Z;

        System.out.print("le plus court chemin pour atteindre la sommet (Gris , ");
        int j = 1, min = 0, k = 0;
        for (int i = 1; i < Prob.finalCycle.size(); i++) {
            if (Prob.finalCycle.get(i) == 1) {
                System.out.print("(Gris ,");
            }
            if (Prob.finalCycle.get(i) == 2) {
                System.out.print("jaune ,");
            }
            if (Prob.finalCycle.get(i) == 3) {
                System.out.print("rouge ,");
            }
            if (Prob.finalCycle.get(i) == 4) {
                System.out.print("mauve ,");
            }
            if (Prob.finalCycle.get(i) == 5) {
                System.out.println("noire )");
            }
            min = min + Prob.graph[i][k];
            k = i;
        }
        System.out.println("La distance optimal = " + min);
        if (c == min) {
            System.out.println("felicitation! vous avez gagné avec score = 100 pt");
        } else {
            Z = c - min;
            long score = 100 - Math.abs(Z);
            System.out.println("Vous avez malheureusement pas parcourue le chemin minimal ! Votre score =" + score);
        }

    }

    public void run()
    {
        execute();
    }
}
