import java.util.ArrayList;
import java.util.List;

public class cParking {

	class cCarEntry
	{
	    private String number; 
	    private boolean parked;

	    public cCarEntry(String number)
	    {
	    	this.number = number;
	    	this.parked = false;
	    }
	    
	    public String getRegNum()
	    {
	    	return this.number;
	    }
	    public void parkCar()
	    {
	    	parked = true;
	    }
	    
	    public void getCar()
	    {
	    	parked = false;
	    }
	 };

	private List<cCarEntry> register;
	public cParking() {
		register = new ArrayList<cCarEntry>();
	}

	public void addToRegisrer(String regNum) throws ParkingException
	{
		if(!register.isEmpty())
		{
			for(cCarEntry iter: register)
			{
				if(iter.number.equals(regNum))
				{
					throw new ParkingException("Pojazd jest juz w rejestrze");
				}
			}
		}

		cCarEntry entry = new cCarEntry(regNum);
		register.add(entry);
	}

	public void removeFromRegister(String regNum) throws ParkingException
	{
		if(!register.isEmpty())
		{
			for(cCarEntry iter: register)
			{
				if(iter.number.equals(regNum))
				{
					register.remove(iter);
				}
			}
		}
		else
		{
			throw new ParkingException("Rejest jest pusty");
		}
	}
	
	public void registerIn(String regNum) throws ParkingException
	{
		if(register.isEmpty())
		{
			throw new ParkingException("Pojazdu nie ma w rejestrze - Rejest jest pust");
		}

		for(cCarEntry iter: register)
		{
			if(iter.number.equals(regNum))
			{
				if(iter.parked == false)
				{
					iter.parkCar();
				}
				else
				{
					throw new ParkingException("Pojazd znajduje sie juz na parkingu");
				}
			}
		}
	}

	public void registerOut(String regNum) throws ParkingException
	{
		if(register.isEmpty())
		{
			throw new ParkingException("Parking jest pusty nie mozna wyrejstorwac");
		}

		for(cCarEntry iter: register)
		{
			if(iter.number.equals(regNum))
			{
				if(iter.parked == true)
				{
					iter.getCar();
				}
				else
				{
					throw new ParkingException("Samochód nie jest zaparkowany");
				}
			}
		}
	}
	
	void display()
	{
		for(cCarEntry iter: register)
		{
			System.out.println(" Pojazd o rejestracji " + iter.getRegNum() + ((iter.parked) ? "  Zaparkowany" :  "  Niezaparkowany"));
		}
	}
}
