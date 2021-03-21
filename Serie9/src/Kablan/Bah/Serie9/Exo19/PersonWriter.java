package Kablan.Bah.Serie9.Exo19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {
	
		 AnalyzeBean analyzeBean = new AnalyzeBean();
		 
		 Function<String,String> getPerson = string ->
		 {
			 String person1 = "p1"; 
			 String person2 = "p2"; 
			 
			 if(string.equals("Person"))
				 return person1;
			 else
				 return person2; 
		 };
		 
		 public  List<Object> write(List<Object> beans)
		 {
			 try(FileWriter writer = new FileWriter("files/fichier2.txt") ;
					 BufferedWriter bw = new BufferedWriter(writer) )
			 {
				 bw.write("# Ceci est une ligne de commentaires");
				 bw.write("\n");
				 
				 for(int i=0;i<beans.size();i++)
				 {
					 bw.write("bean"+"."+"name"+"="+getPerson.apply(analyzeBean.getClassName(beans.get(i))));
					 bw.write("\n");
					 bw.write(getPerson.apply(analyzeBean.getClassName(beans.get(i))) + "."+"class"+"="+ beans.get(i).getClass().getName());
					 bw.write("\n");
					 bw.write(getPerson.apply(analyzeBean.getClassName(beans.get(i))) + "."+"lastName"+"="+ analyzeBean.get(beans.get(i), "lastName"));
					 bw.write("\n");
					 bw.write(getPerson.apply(analyzeBean.getClassName(beans.get(i))) + "."+"firstName"+"="+analyzeBean.get(beans.get(i),"firstName"));
					 bw.write("\n");
					 bw.write(getPerson.apply(analyzeBean.getClassName(beans.get(i))) + "."+"age"+"="+analyzeBean.get(beans.get(i),"age"));
					 bw.write("\n");
					 if(analyzeBean.getClassName(beans.get(i)).equals("Employee"))
					 {
						 bw.write(getPerson.apply(analyzeBean.getClassName(beans.get(i))) + "."+"salary"+"="+analyzeBean.get(beans.get(i),"salary"));
						 bw.write("\n");
					 }
				 }
				 
				 
			 }
			 catch(IOException e)
			 {
				 e.printStackTrace();
			 }
			return beans;
		 }

	}

