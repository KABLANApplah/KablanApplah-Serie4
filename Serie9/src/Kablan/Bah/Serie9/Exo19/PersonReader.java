package Kablan.Bah.Serie9.Exo19;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class PersonReader {
	
	AnalyzeBean analyzeBean = new AnalyzeBean();
			
		public List<Object> read()
			{
				
				List<  Object> list = new ArrayList<>(); 
				
				
				try(FileReader reader = new FileReader("files/fichier.txt");
						BufferedReader br = new BufferedReader(reader))
				{
					String getNbrLine = br.readLine(); 
					int index = -1; 
					while(getNbrLine != null)
					{
						if(getNbrLine.startsWith("#"))
						{
							getNbrLine = br.readLine(); 
							continue; 
						}
						
						
						String property = getNbrLine.substring(getNbrLine.indexOf(".")+1, getNbrLine.indexOf("=")); 
						String value = getNbrLine.substring(getNbrLine.indexOf("=")+1); 
							
						
						if(property.equals("class"))
						{
								 Object intance = analyzeBean.getInstance(value); 
								 list.add(intance); 
								 index++; 
						}
						if(property.equals("lastName"))
						{
								analyzeBean.set(list.get(index), property, value);
						}
						if(property.equals("firstName"))
						{
								analyzeBean.set(list.get(index), property, value);
						}
						if(property.equals("age"))
						{
								
								analyzeBean.set1(list.get(index), property, Integer.parseInt(value));
						}
						if(property.equals("salary"))
						{
								analyzeBean.set1(list.get(index), property, Integer.parseInt(value));
						}
						getNbrLine = br.readLine();
					}
					return list; 
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				return null;  
			}


	}

