package TPPROBSOLV;

import java.util.*;


public class SUBSETGAME extends Thread{
	
	static int subsetCount = 0;
	
	// Generates a random int
	static int genint(int borneInf, int borneSup){
		   Random random = new Random();
		   int nmb;
		   nmb = borneInf+random.nextInt(borneSup-borneInf);
		   return nmb;
	}
	//removes repeat
	static boolean repeat (int[] tab , int entier) {
		boolean test = true;
		for (int j : tab)
			if (j == entier) {
				test = false;
				break;
			}
		
		return test;
	}

// calculates sum of entered int
	static int addsum(int [] tab) {
		int sum = 0;
		int [] listeIndice = new int[3] ;
		int alea;
		for (int i = 0 ; i < 3 ; i++) {
			do { alea = genint(0,6); } while (!repeat(listeIndice , alea)) ;
			listeIndice[i] = alea;
			sum += tab[alea];
		}
		return sum;
	}

    static void subsetSum(int[] list, int sum, int startingIndex, int targetSum) {
    	
        if( targetSum == sum ) {
            subsetCount++;
            if(startingIndex < list.length) {
                subsetSum(list, sum - list[startingIndex-1], startingIndex, targetSum);
            }
            	
        }
        else
        { 
            for( int i = startingIndex; i < list.length; i++ ) 
                subsetSum(list, sum + list[i], i + 1, targetSum);
        }
    }
    
    
    // User tries
    static void playertest(int[] tab , int somme , int nbrCombinaison) {
    	
    	int combGagne = 0;
    	int entier;
    	int j = 1;
    	int nb;
    	Scanner S = new Scanner(System.in);
    	do{
    		int testSomme = 0;
	    	System.out.println(j + " Insert the number of combination integers to create the sum : ");
	    	nb = S.nextInt();
	    	
	    	while(nb > 6) {
	    		System.out.println(" Combination number cannot be over 6 \n" + j + "Insert the number of combination integers to create the sum :");
		    	nb = S.nextInt();
		    	
	    	}
	    	for (int i = 0 ; i < nb ; i++) {
	    		
	    		int k = i+1;
	    		System.out.println("Integers " + k + " is ");
    			entier = S.nextInt();
	    		
    			while (!includedin(tab, entier)) {
    				System.out.println("Please insert a number in the list \n Integer " + k + " is ");
        			entier = S.nextInt();
	    		}
	    		testSomme += entier;
	    	}
	    	
	    	if (testSomme == somme) {System.out.println("Good, Continue ?  ");combGagne++; j++;}
	    	else {System.out.println("Bad try ");}
	    	
    	}while(combGagne < nbrCombinaison);
    	if (combGagne == nbrCombinaison) {System.out.println("CONGRATS! , You won th stage ");}
    	else {System.out.println("DIED !");}
    }
    
   // Test if included
    static boolean includedin (int[] tab , int entier) {
    	boolean test = false;
		for (int j : tab) {
			if (j == entier) {
				test = true;
				break;
			}
		}
    	return test;
    }
	// Fill an int table with random non repeated random numbers
	public static void  tabfill(int[] tabEntier) {
		int i = 0;
		int entier ;

		do{
			entier = genint(1,9);
			while(repeat(tabEntier, entier)) {

				tabEntier[i] = entier;
				if (i == 6) {break;}
				else 	{i++;}
			}
		}while(i < 6);

	}
    //have fun
	public static void play () {

		System.out.println("jeu1");
		int [] tabEntier = new int[7];
		tabfill(tabEntier);
		
		int somme = addsum(tabEntier);
		System.out.println("All number: ");
		for (int j = 0 ; j < 6 ; j++)
			System.out.println(tabEntier[j]);
		subsetSum(tabEntier, 0, 0, somme);
		System.out.println("" + subsetCount +"combinations for " + somme );
		playertest(tabEntier, somme, subsetCount);
	}
	
	public void run()
	{
		play();
	}
}
