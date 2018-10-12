import java.util.Scanner;

public class cParkingTest {

	private cParking parking;
	public Scanner menu;

	public cParkingTest() {
		// TODO Auto-generated constructor stub
	}

	private void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Menu tekstowe testów klasy Parking");
		System.out.println("==============================================");
		System.out.println(" Aby wybraæ zadanie wpisz odpowiedni¹ liczbê");
		System.out.println(" 0  -Wyœwietl menu");
		System.out.println(" 1  -Stwórz nowy parking");
		System.out.println(" 2  -Dodaj pojazd do rejestru");
		System.out.println(" 3  -Usuñ pojazd z rejestru");
		System.out.println(" 4  -Zarejestruj wjazd pojazdu na praking");
		System.out.println(" 5  -Zarejestruj wyjazd pojazdu z parkingu");
		System.out.println(" 6  -Usuñ parking");
		System.out.println(" 7  -Wyswietl stan parkingu (rejest i zaparkowane pojazdy)");
		System.out.println(" 8  -Wyjœcie");
		System.out.println("==============================================");
	}
	
	public void test() throws ParkingException
	{
		menu = new Scanner(System.in);
		printMenu();
				
		while(true)
		{
			int choice = menu.nextInt();
		
			switch (choice)
			{
				case 0:
					printMenu();
					break;

				case 1:
					parking = new cParking();
					System.out.println("Parking utworzony");
					break;

				case 2:
					System.out.println("Dodaj pojazd do rejestru");
					System.out.println("Wpisz s dla samochodu lub m dla motocykla");
					String type = menu.next();
					
					if(type.equals("s"))
					{
						cCar c = null;
						try
						{
							System.out.println("Podaj numer rejestracyjny samochodu");
							String regNum =  menu.next();

							c =  new cCar(regNum);
						}
						catch (ParkingException e)
						{
							System.out.println(e);
						}

						try
						{
							parking.addToRegisrer(c.registrationNumber());
						}
						catch (ParkingException e)
						{
							System.out.println(e);
						}					
						catch(NullPointerException e)
						{
							System.out.println("Najpierw utwórz parking " + e);
						}
					}
					else if(type.equals("m"))
					{
						cMotorcycle m = null;
						try
						{
							System.out.println("Podaj numer rejestracyjny motocykla");
							String regNum =  menu.next();

							m =  new cMotorcycle(regNum);
						}
						catch (ParkingException e)
						{
							System.out.println(e);
						}

						try
						{
							parking.addToRegisrer(m.registrationNumber());
						}
						catch (ParkingException e)
						{
							System.out.println(e);
						}					
						catch(NullPointerException e)
						{
							System.out.println("Najpierw utwórz parking " + e);
						}
					}
					else
					{
						System.out.println("Nie ma takiej opcji");
					}

					break;

				case 3:
					System.out.println("Podaj numer rejestracyjny pojazdu do usuniecie z rejestru");
					String regNum =  menu.next();
					parking.removeFromRegister(regNum);
					break;

				case 4:
					System.out.println("Podaj numer rejestracyjny pojazdu");
					try
					{
						parking.registerIn(menu.next());
					}
					catch (ParkingException e)
					{
						System.out.println(e);
					}					
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz parking " + e);
					}
					
					break;

				case 5:
					System.out.println("Podaj numer rejestracyjny pojazdu");
					try
					{
						parking.registerOut(menu.next());
					}
					catch (ParkingException e)
					{
						System.out.println(e);
					}					
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz parking " + e);
					}
					break;

				case 6:
					System.out.println("Usuniêcie parkingu");
					parking = null;
					break;

				case 7:
					System.out.println("Wyœwietlenie parkingu");
					try
					{
						parking.display();
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz parking " + e);
					}
					
					break;

				case 8:
					break;

				case 9:
					menu.close();
					System.exit(0);
					break;


				default:
					System.out.println("Nie ma tkiej opcji");
					break;
			}
		}
	}
}
