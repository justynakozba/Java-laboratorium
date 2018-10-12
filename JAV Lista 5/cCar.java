
public class cCar implements Identification {

	private String registrationNumber;
	private String brand;
	private String model;
	private Integer year;
	
	public cCar(String brand, String model, Integer year, String registrationNumber) throws ParkingException {
		
		this.brand = brand;
		this.model = model;
		this.year = year;

		if( registrationNumber.length() != 7)
		{
			throw new ParkingException("Numer rejestracji samochodu powinien miec 7 znakow");
		}
		else
		{
			this.registrationNumber = registrationNumber;
		}
	}

	public cCar(String registrationNumber) throws ParkingException {

		if( registrationNumber.length() != 7)
		{
			throw new ParkingException("Numer rejestracji samochodu powinien miec 7 znakow");
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

	@Override
	public String registrationNumber() {

		return registrationNumber;
	}
	
}
