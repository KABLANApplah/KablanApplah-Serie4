package Kablan.Serie6.Exo14;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exo_14 {

	public static void main(String[] args) {
		
		
				List <String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve");
				
				Stream<String> strings = words.stream(); 
				
				//Question1
		
				strings.forEach(System.out::println);
				System.out.println(" \n");
		
				//Question2
		
				Stream<String> maj = words.stream().map(mot ->mot.toUpperCase());
				maj.forEach(System.out::println);
				System.out.println(" \n");
				
				//Question3
				
				Stream<String> firstMaj = words.stream().
						map(mot -> mot.substring(0,1).
								toUpperCase()).
						distinct(); 
				firstMaj.forEach(System.out::println);
				System.out.println(" \n");

			        //Question4 
		
				Stream<Integer> longueur = words.stream().
						map(mot -> mot.length()).
						distinct(); 
				longueur.forEach(System.out::println);
				System.out.println(" \n");
				
				//Question5
		
				long nbrElem = words.stream().count(); 
				System.out.println("Le nombre d'élément est : " +nbrElem);
				System.out.println(" \n");
				
				//Question6
		
				Stream<String> ElemPair = words.stream().filter(mot -> mot.length()%2==0); 
				ElemPair.forEach(System.out::println);
				long nbrElemPair = words.stream().filter(mot -> mot.length()%2==0).count(); 
				System.out.println("le nombre d'élément de ce stream qui ont une longueur paire :"+ nbrElemPair);
				System.out.println(" \n");
				
				 //Question7 
				Comparator <String> comparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length()); 
				Optional<String> motPlusLong = words.stream().collect(Collectors.maxBy(comparator)); 	
				OptionalInt tailleLong=	words.stream().mapToInt(mot -> mot.length()).max(); 		
				System.out.println("l'élément le plus long de taille :"+ motPlusLong);
				
				System.out.println("Taille du mot le plus long :"+tailleLong);
				System.out.println(" \n");
				
				//Question8 
				
				List <String> chaineLongImpaire = words.stream().map(mot ->mot.toUpperCase()).filter(taille -> taille.length()%2!=0).collect(Collectors.toList()); 
				chaineLongImpaire.forEach(System.out::println);
				System.out.println(" \n");
				
				//Question9 
		
				String chaine = words.stream().filter(taille -> taille.length()<=5).sorted().collect(Collectors.joining(",","{","}")); 
				System.out.println("la nouvelle chaine : "+ chaine);
				System.out.println(" \n");
				
				//Question10
		
				 Function<String, Integer> recoverLength = s -> s.length(); 
				 Map<Integer,List<String>> map = words.stream().collect(Collectors.groupingBy(recoverLength));
											   
				System.out.print("map : \n"+map);
				System.out.println(" \n");
				
				System.out.println("  Question11 ");
				Function<String, String> started = s -> s.substring(0,1); 
				
				Map<String, List<String>> map1 = words.stream().collect(Collectors.groupingBy(started)); 
				
				System.out.print("map1 : \n"+map1);

			}
}

		
	


