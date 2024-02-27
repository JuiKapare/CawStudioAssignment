package test;


import org.openqa.selenium.WebDriver;

//Test data class 
class TestData {
	WebDriver driver;

	String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, "
			+ "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, "
			+ "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, "
			+ "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, "
			+ "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";

	Record[] records = { new Record("Bob", "20", "male"), new Record("George", "42", "male"),
			new Record("Sara", "42", "female"), new Record("Conor", "40", "male"),
			new Record("Jennifer", "42", "female") };

	class Record 
	{
		String name;
		String age;
		String gender;

		public Record(String name, String age, String gender) 
		{
			this.name = name;
			this.age = age;
			this.gender = gender;

		}
	}
}
