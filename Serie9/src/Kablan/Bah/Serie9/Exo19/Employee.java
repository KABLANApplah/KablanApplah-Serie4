package Kablan.Bah.Serie9.Exo19;

public class Employee extends Person  {
	
		private int salary ;
		
		
		public Employee() 
		{	
			
		}
		
		public Employee(int salary) 
		{
			
			this.salary = salary;
		}

		public int getSalary() 
		{
			return salary;
		}

		public void setSalary(int salary)
		{
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [Salary=" + salary + ", LastName()=" + getLastName() + ", FirstName()=" + getFirstName()
					+ ", Age()=" + getAge() + "]";
		}

	}



