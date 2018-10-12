
public class cPerson {

	private String name;
	private String lastName;
	private String address;
	

	public cPerson(String name, String lastName, String address) 
	{
		this.name =name;
		this.lastName = lastName;
		this.address = address;
	}
	// function responsible for setting name
	public String getName()
	{
		return name;
	}

	// function responsible for setting name
	public void setName(String name)
	{
		this.name = name;
	}

	// function responsible for getting last name
	public String getLastName()
	{
		return lastName;
	}

	// function responsible for setting last address
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getAddress()
	{
		return address;
	}

	// function responsible for setting address
	public void setAddress(String address)
	{
		this.address = address;
	}

}
