package Kablan.Serie5.Exo12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exo12 {
	
		public static void main(String[] args) 
		{
			//question 1
			
			List <String> words = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve");
			
			Map<Integer, List<String>> map1 = new HashMap<>();  
			
			for(String s : words) 
			{
				
				int length = s.length(); 
				/*if(map.containsKey(length))
				{List<String> value = map.get(length); value.add(s); }
				else{List<String> list = new ArrayList<>();  list.add(s); map.put(length, list); }*/
				
				map1.computeIfAbsent(length,key -> new ArrayList<>()).add(s); 
				
			}
			map1.forEach((Integer key,List<String>list)->System.out.println(key + "->" + list));
			System.out.println("\n");
			
			// question 2
			
			List<String> chaine = Arrays.asList("Hensha","Marie-louis","Vanessa","frere", "Applah","Viviane","Henri","Gausse","Raven","Abiba","Mariam");
			Map<String, List<String>> map2 = new HashMap<>(); 
			
			for(String chaines : chaine)
			{
				String started = chaines.substring(0,1); 
				map2.computeIfAbsent(started, key -> new ArrayList<>()).add(chaines); 
				
			}
			map2.forEach(( String key, List<String> list) -> System.out.println(key + "->" + list) ) ;
			System.out.println("\n");
			
			// question 3 
			
			Map<String, Map<Integer, List<String> > > map3 = new HashMap<>();  
			for(String chaines : chaine)
			{
				String started = chaines.substring(0,1); 
				int length = chaines.length(); 
				map3.computeIfAbsent(started, key -> new HashMap<>()).computeIfAbsent(length, key -> new ArrayList<>()).add(chaines);  
				
			}
			map3.forEach((key, list) -> System.out.println(key + "->" + list));
			System.out.println("\n");
			
			// question 4
			
			Map<Integer, String> map4 = new HashMap<>(); 
			
			for(String s : words)
			{
				int length = s.length();  
				map4.merge(length, s, (s1 , s2) -> s1 + "," +s2); 
				
			}
			map4.forEach((key, list) -> System.out.println(key + "->" + list));
			
		}
	}


	// s-> s.lenght === String :: length 


