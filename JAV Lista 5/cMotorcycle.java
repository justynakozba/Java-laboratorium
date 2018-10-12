
public class cMotorcycle implements Identification {

	private String registrationNumber;
	private String brand;
	private String model;
	private Integer year;
	
	public cMotorcycle(String brand, String model, Integer year, String registrationNumber) throws ParkingException {
		
		this.brand = brand;
		this.model = model;
		this.year = year;

		if( registrationNumber.length() != 6)
		{
			//TODO: own exception
			throw new ParkingException("Numer rejestracyjny motocykla powinien miec 6 znakow");
		}
		else
		{
			this.registrationNumber = registrationNumber;
		}
	}

	public cMotorcycle(String registrationNumber) throws ParkingException {

		if( registrationNumber.length() != 6)
		{
			throw new ParkingException("Numer rejestracyjny motocykla powinien miec 6 znakow");
		}
		else
		{
			this.registrationNumber = registrationNumber;
		}
	}


	public Integer getYear() {
		return this.year;
	}

	public String getModel() {
		return this.model;
	}

	public String getBrand(){
		return this.brand;
	}

	public String RegistrationNumer()
	{
		return this.registrationNumber;
	}

	@Override
	public String registrationNumber()
	{
		return registrationNumber;
	}
}
