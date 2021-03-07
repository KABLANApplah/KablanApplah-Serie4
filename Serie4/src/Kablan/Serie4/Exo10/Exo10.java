package Kablan.Serie4.Exo10;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Exo10 {
	

		public static void main(String[] args) 
		{
			
			Function<String,String> Maj = s->s.toUpperCase(); 
			System.out.println("chaine convertit en majuscule : "+Maj.apply("hamadi")); 
			
			Function<String,String> Mchaine = s->
			{
				if(s.isEmpty())
					return "";
				else 
					return s; 
				 		
			}; 
			System.out.println("retourne la chaine reçu si elle est vide retourne une chaine vide : "+Mchaine.apply("Hamadi"));
			
			Function<String,Integer> longueur = s->
			{
				if(s.isEmpty())
					return 0; 
				else 
					return s.length();   		
			};
			System.out.println("retourne la longueur de la chaine: "+longueur.apply("Hamadi"));
			
			Function<String,String> returnChaine = s ->
			{
				if(s.isEmpty())
					return "()"; 
				else 
					return "(" + s + ")"; 
				
			}; 
			System.out.println("chaine entre parenthèses de la chaine: "+returnChaine.apply("Hamadi"));
			
			BiFunction<String,String,Integer> indexOf = (s1, s2)->s1.indexOf(s2);  
			System.out.println("tester si s2 est dans s1: "+indexOf.apply("Hamadi","ama"));
			
			Function<String,Integer> indexOf1 = s->indexOf.apply("abcdef",s);
			System.out.println("tester si s2 est dans s1: "+indexOf1.apply("bcd"));
		}

	}

	// andthen faire deux taches à la fois 



	


