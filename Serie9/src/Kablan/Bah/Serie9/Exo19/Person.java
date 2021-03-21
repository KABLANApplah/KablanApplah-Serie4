package Kablan.Bah.Serie9.Exo19;

public class Person 
{
		private String lastName; 
		private String firstName; 
		private int age ;
		
		public Person() 
		{
 
		}
		public Person(String newlastName, String newfirstName, int newAge) 
		{
			this.lastName = newlastName; 
			this.firstName = newfirstName;  
			this.age = newAge; 
		}
	
		public String getLastName() 
		{
			return lastName;
		}
		public void setLastName(String lastName) 
		{
			this.lastName = lastName;
		}
		public String getFirstName() 
		{
			return firstName;
		}
		public void setFirstName(String firstName) 
		{
			this.firstName = firstName;
		}
		public int getAge() 
		{
			return age;
		}
		public void setAge(int age)
		{
			this.age = age;
		}
		@Override
		public String toString() {
			return "Person [lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + "]";
		}
				
}
