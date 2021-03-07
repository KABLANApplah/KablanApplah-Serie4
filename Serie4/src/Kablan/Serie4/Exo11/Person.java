package Kablan.Serie4.Exo11;

public class Person {
	
		private String firstName;  
		private String lastName ;  
		private int age ;  
		
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {

			this.age = age;
		}

		public Person(String newFirstName, String newLastName, int newAge) 
		{
			this.firstName = newFirstName;  
			this.lastName = newLastName ; 
			this.age = newAge ;  
			
		}

		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
		}
			
	}



