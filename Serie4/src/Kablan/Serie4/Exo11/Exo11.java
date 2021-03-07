package Kablan.Serie4.Exo11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exo11 {
	

		public static void main(String[] args) 
		{
			Person p1 = new Person("Kablan","Applah", 23);  
			Person p2 = new Person("Kablan", "Ashley", 13);
			Person p3 = new Person("Ngala", "Stephane", 27);
			Person p4 = new Person("Kablan", "shella", 20);
			Person p5 = new Person("Djifli", "Hela", 22);
			
			
			String chaine1 = "Stephane"; 
			String chaine2 = "Steph"; 
			
			// question 1 
			Comparator <String> comparator= (String s1, String s2)-> Integer.compare(s1.length(), s2.length());
			System.out.println("Comparer au sens des longueurs: "+ comparator.compare(chaine1, chaine2));
			
			System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			//question 2  
			Comparator <Person> comparatorLastName= (Person s1, Person s2)->p1.getLastName().compareTo(p2.getLastName());		
			System.out.println(" Comparaison de personne suivant leur nom de famille : " + comparatorLastName.compare(p1, p2));
			System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			//question 3 
			Comparator <Person> comparatorDeep= (Person s1, Person s2)-> p1.getLastName().compareTo(p2.getLastName()) ==0 ?  p1.getFirstName().compareTo(p2.getFirstName()) : p1.getLastName().compareTo(p2.getLastName());
			System.out.println("Test comparateur de noms et prenom: "+ comparatorDeep.compare(p1, p2));
			//question 4 
			
			Comparator <Person> comparatorDeepReverse=comparatorDeep.reversed(); 
			System.out.println("Test comparateur de noms et prenom: "+ comparatorDeepReverse.compare(p4, p5));
			
			System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			// question 5 
			List<Person> person_list = Arrays.asList(p1, null, p2, null , p3); 	
			Comparator<Person> comparatorSorted = Comparator.nullsLast(comparatorLastName);  
			person_list.sort(comparatorSorted);
			System.out.println(person_list);
		}
	}

	


