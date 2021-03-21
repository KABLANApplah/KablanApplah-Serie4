package Kablan.Bah.Serie9.Exo19;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class AnalyzeBean {
	
              //Question 1
	
		public   String getClassName(Object o)
		{
			String nameClass = o.getClass().getSimpleName(); 
			return nameClass; 
		}
		
		//Question 2
		
		public  Object getInstance(String className) 
		{	
			try
			{
				Class<?> classInstance = Class.forName(className); 
				@SuppressWarnings("deprecation")
				Object instance = classInstance.newInstance(); 
				return instance ; 
			}
			catch( ClassNotFoundException | InstantiationException  | IllegalAccessException e)
			{
				e.printStackTrace();
			}
			return null; 	
		}
		
		
		BiFunction<String,String,String> property = (strings, begining) ->
		{
			if(strings.startsWith("beginging"))
			{
				strings = strings.substring(begining.length(), strings.length()); 
				strings = strings.substring(0, 1).toUpperCase()+strings.substring(1,strings.length()); 
			}
			return strings; 
		}; 
		
		//Question3
		
		public  List<String> getProperties(Object o)
		{
			Class<? extends Object> gClass = o.getClass(); 

			List<String> properties = Arrays.stream(gClass.getMethods())
			 								.map(strings ->strings.getName())
			 								.filter(strings ->strings.startsWith("get")||strings.startsWith("set"))
			 								.map(strings ->property.apply(strings, "get"))
			 								.map(strings ->property.apply(strings, "set"))
			 								.distinct()
			 								.collect(Collectors.toList()); 			
			return properties ; 
		
		}
		//*****************************************************
		private static String buildGetterName(String property) 
		{
			return "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
		}
		
		//Question4
		
		public Object get(Object bean, String property) 
		{
			
			try 
			{
				Class<? extends Object> gClass = bean.getClass(); 
				String getterName = buildGetterName(property); 
				Method getter = gClass.getMethod(getterName);
				Object value = getter.invoke(bean); 
				return value ; 
				
			} 
			catch (NoSuchMethodException 
					| SecurityException 
					| IllegalAccessException 
					|  InvocationTargetException 
					| IllegalArgumentException e) {
				 	e.printStackTrace();
			} 
			
			return null; 
		}
		//*****************************************************
	 
		private static String buildSetterName(String property)
		{
			return "set"+property.substring(0, 1).toUpperCase()+property.substring(1); 
		}
		
		//Question5

		public void set(Object bean, String property, Object value)
		{
			try
			{
				Class<? extends Object> gClass = bean.getClass(); 
				
				String setterName = buildSetterName(property); 
				Method setter = gClass.getMethod(setterName, value.getClass()); 	
			    setter.invoke(bean, value); 
			 
			}
			catch (NoSuchMethodException 
					| SecurityException 
					| IllegalAccessException 
					|  InvocationTargetException 
					| IllegalArgumentException e) {
				 	e.printStackTrace();
			} 
			
		}
		
		public void set1(Object bean, String property, Object value)
		{
			try
			{
				Class<? extends Object> gClass = bean.getClass(); 
				
				String setterName = buildSetterName(property); 
				Method setter = gClass.getMethod(setterName, int.class); 
			    setter.invoke(bean, value); 
			 
			}
			catch (NoSuchMethodException 
					| SecurityException 
					| IllegalAccessException 
					|  InvocationTargetException 
					| IllegalArgumentException e) {
				 	e.printStackTrace();
			} 
			
		}
		
	}















































