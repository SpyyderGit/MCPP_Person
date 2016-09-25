package person;

public class Person
{
	private int id = 0;
	private String fName = null;
	private String lName = null;
	private int age = 0;

	public  Person(int id, String fName, String lName, int age)
	{
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getfName()
	{
		return fName;
	}

	public void setfName(String fName)
	{
		this.fName = fName;
	}

	public String getlName()
	{
		return lName;
	}

	public void setlName(String lName)
	{
		this.lName = lName;
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
	public String toString()
	{
		return "Person [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + "]\n";
	}

}
