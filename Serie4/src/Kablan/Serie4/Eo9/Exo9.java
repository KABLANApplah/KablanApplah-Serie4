package Kablan.Serie4.Eo9;

import java.util.function.Predicate;

/*une interface fonctionelle c'est une interface qui n'a qu'une seule methode abstrait*/

/*List<String> strings = Arrays.asList("one","two"); 

Iterable<String> iterable = ()-> strings.iterator(); 

iterable.forEach((String s) -> { System.out.println(s.toUpperCase());});*/




public class Exo9 {
	
		public  static void main(String[] args)
		{
			
			/*return true si la chaine fait plus de 4 chaines */
			
			Predicate <String> p = (String s) -> s.length()>4 ;  
			System.out.println("P sur KabLanAppLah : "+ p.test("KabLanAppLah"));
			
			// return true si la chaine de caractere est vide
			Predicate <String> m = s -> s.isEmpty(); 
			System.out.println("test si la chaine est vide : "+ m.test("Applah"));
			
			// return true si la chaine commence par J 
			Predicate <String> j =  s->s.startsWith("J") ;  
			System.out.println("test si la chaine commence par J : "+ j.test("Jose"));
			
			// return true si la chaine fait 5 caractere 
			Predicate <String> taille = s ->s.length() == 5; 
			System.out.println("test si la chaine est de taille 5 : "+taille.test("Pere"));
			
			// return true si la chaine commence par J et fait exactement 5 caractere 
			
			Predicate<String> J5 = s->(s.startsWith("J") && s.length() == 5);  
			System.out.println("test si la chaine commence par J et  est de taille 5 : "+J5.test("Jonas"));
		
		}

	}


	