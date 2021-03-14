package Kablan.Serie5.Exo13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exo13 {
	
	

		public static void main(String[] args) 
		{
			List <String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve");
			
			//Question 1 
			
			words.forEach(mot -> System.out.println(mot));
			System.out.println("\n");
			
			//Question 2
			
			List <String> words3 = new ArrayList<>(words);  
			words3.removeIf(s->s.length()!=3); 
			words3.forEach(mot -> System.out.println(mot));
			System.out.println("\n");
			
			//Question 3
			
			Comparator <String> comparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());  
			words3.sort(comparator);
			words3.forEach(mot -> System.out.println(mot));
			System.out.println("\n");
			
			//Question 4 
			
			Comparator <String> cmp = (String s1, String s2)->
			{
				if(s1.length() == s2.length())
				{
					return s1.compareTo(s2); 
				}
				else 
				{
					return comparator.compare(s1, s2); 
				}
			}; 
			words.sort(cmp);
			words.forEach(mot -> System.out.println(mot));
			System.out.println("\n");
			
			//Question 5
			
			IntStream result = words.stream().mapToInt(s -> s.length()); 
			System.out.println("la moyenne est : "+result.average().getAsDouble());
			System.out.println("\n");
			
			//Question 6 
			
			System.out.println("les lettre utilisées dans ce stream");
			Stream<Character> nbrElemUse = words.stream().flatMap(s -> s.chars().mapToObj(letter ->(char)letter)); 
			nbrElemUse.forEach(s -> System.out.print("\t"+s));
			System.out.println("\n le nombre de lettre utilisées dans ce stream");
			
			Stream<Character> nbrElemStream1 =  words.stream().flatMap(s->s.chars().mapToObj(letter ->(char)letter));

			double nbrLetters = nbrElemStream1.count(); 
			System.out.println("le total des lettres utilisé :"+nbrLetters);
			
			System.out.println("le nombre d'element diffenrente:");
			Stream<Character> nbrElemStream2 =  words.stream().flatMap(s->s.chars().mapToObj(letter ->(char)letter)).distinct();

			double nbrLettersD = nbrElemStream2.count();
			System.out.println("le total des lettres utilisé :"+nbrLettersD);
			
			Stream<Character> nbrElemStream3 =  words.stream().flatMap(s->s.chars().mapToObj(letter ->(char)letter)).distinct();
			
			Character lettreMax = nbrElemStream3.max(Comparator.comparing(Integer::valueOf)).get();  
			System.out.println("\nLettres maximale : "+lettreMax);
			
			Stream<Character> nbrElemStream4 =  words.stream().flatMap(s->s.chars().mapToObj(letter ->(char)letter)).distinct();
			
			Character lettreMin = nbrElemStream4.min(Comparator.comparing(Integer::valueOf)).get();  
			System.out.println("\nLettres maximale : "+lettreMin);
					
		}

	}

	


