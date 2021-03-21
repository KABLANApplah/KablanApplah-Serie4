package Kablan.Bah.Serie9.Exo19;

import java.util.ArrayList;
import java.util.List;


public class Exo19 {
		
		public static void main(String[] args) 
		{
			Person person = new Person();
			AnalyzeBean analyzeBean = new AnalyzeBean(); 
			Employee employee = new Employee(); 
			PersonReader reader = new PersonReader(); 
			PersonWriter writer = new PersonWriter(); 
			
			Person p1 = new Person("Tabarly","Eric",32);
			Person p2 = new Person("Auguin","Christophe",45);
		
			List<Person> list = List.of(p1,p2);
			
			
			System.out.println();
			System.out.println("\t Question1");
			System.out.println("Classe   : "+analyzeBean.getClassName(person));
			System.out.println("\n Classe  : "+analyzeBean.getClassName(employee));
			System.out.println();
			
			System.out.println("\t Question2");
			Object instancePerson = analyzeBean.getInstance("Kablan.Bah.Serie9.Exo19.Person"); 
			Object instanceEmplyee = analyzeBean.getInstance("Kablan.Bah.Serie9.Exo19.Employee"); 
			System.out.println("instance de Person : "+instancePerson);
			System.out.println("\ninstance de Employee"+instanceEmplyee);
			System.out.println();
			
			System.out.println("\t Question3");
			List<String> mypropertiesPerson = analyzeBean.getProperties(person); 
			List<String> mypropertiesEmployee = analyzeBean.getProperties(employee); 
			System.out.println("les proprietes de la classe Person sont : " + " " + mypropertiesPerson);
			System.out.println("\nles proprietes de la classe Employee sont : " + " " + mypropertiesEmployee);
			System.out.println();
			
			System.out.println("\t Question4");
			for(Person p : list)
			{
				Object value = analyzeBean.get(p, "firstName");
				System.out.println("Le Prenom est :" + " -> "+value);
			}
			System.out.println();
			
			System.out.println("\t Question5");
			analyzeBean.set(p1,"lastName", "Tabarly");
			analyzeBean.set1(p2,"age", 45);
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			System.out.println();
			
			System.out.println("\t Question6");
			List<Object> toRead = new ArrayList<>(); 
			toRead = reader.read() ; 
			toRead.forEach(chaine -> System.out.println(chaine));
			
			System.out.println();
			
			System.out.println("\t Question7");
			@SuppressWarnings("unused")
			List<Object> toWrite = writer.write(toRead); 
			System.out.println("Allez-y voir le fichier2");
			
		}
	}




