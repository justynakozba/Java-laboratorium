import java.util.Scanner;

public class TextMenu {

	private void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Menu tekstowe dla listy 4");
		System.out.println("==============================================");
		System.out.println(" Aby wybra� zadanie wpisz odpowiedni� liczb�");
		System.out.println(" 0  -Wy�wietl menu");
		System.out.println(" 1  -Stworzenie hotelu o podanej liczbie pi�ter i pokoi");
		System.out.println(" 2  -Czy jest jaki� wolny pok�j");
		System.out.println(" 3  -Ile jest wolych pokoi");
		System.out.println(" 4  -Wynaj�cie dowolnego pokoju podanej osobie");
		System.out.println(" 5  -Czy mo�na wynaj�� k s�siednich pokoi");
		System.out.println(" 6  -Czy osoba o podanym nazwisku wynajmuje jaki� pok�j");
		System.out.println(" 7 -kt�re pokoje wynajmuje osoba o podanym nazwisku");
		System.out.println(" 8 -Zwolnij wszystkie pokoje wynajmowane przez osob� podanym nazwisku");
		System.out.println(" 9 -Wyswietl wszystkie pokoje w hotelu");
		System.out.println(" 10 -Usuni�cie macierzy");
		System.out.println(" 11 -Wyj�cie");
		
		System.out.println("==============================================");
	}

	public void textMenu()
	{
		cHotel hotel = null;
		Scanner menu = new Scanner(System.in);

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
					
					System.out.println("Wpisz liczb� pi�ter");
					int floors = menu.nextInt();
					System.out.println("Wpisz liczb� pokoi na pi�trze");
					int rooms = menu.nextInt();
					hotel = new cHotel(floors, rooms);
					break;
					

				case 2:
					try
					{
						System.out.println((hotel.isAnyRoomFree()? "W hotelu sa wolne pokoje": " w holtelu nie ma wolnych pokoi"));
					}
					catch( NullPointerException e)
					{
						System.out.println("Najpierw utw�rz hotel " + e);
					}
					break;

				case 3:
					try
					{
					int freeRooms = hotel.howManyFreeRooms();
					System.out.println("W hotelu jest wolnych pokoi " + freeRooms);
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utw�rz hotel " + e);
					}
					break;

				case 4:
					try
					{
						System.out.println("Podaj imie");
						String name = menu.next();
						System.out.println("Podaj nazwisko");
						String lastName = menu.next();
						System.out.println("Podaj adres");
						String address = menu.next();
						cPerson person = new cPerson(name, lastName, address);
						hotel.rentRoom(person);
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utw�rz hotel" + e);
					}
					break;

				case 5:
					try
					{
					System.out.println("Podaj ile sasiednich pokoi chcesz wynaj��");
					int k = menu.nextInt();
					System.out.println((hotel.isNeihgoursRoomsFree(k)? "Mo�na wynaj�� tyle pokoi": "Nie mo�2na wynaja� tylu pokoi"));
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utw�rz hotel " + e);
					}
					break;

				case 6:
						System.out.println(" Podaj nazwiko");
						String lastName =menu.next();
						try
						{
							System.out.println( (hotel.isAnyRoomRentedBy(lastName)? " Osoba wynajmuje pok�j w hotelu": "Osoba nie wynajmuje pokoju w hotelu"));
						}
						catch (NullPointerException e)
						{
							System.out.println("Najpierw utw�rz hotel " + e);
						}
						break;

				case 7:
					try 
					{
						System.out.println("Podaj nazwisko osoby");
						int [] howManyrooms = hotel.howManyRoomsAreRentedBy(menu.next());
						if (howManyrooms == null)
						{
							System.out.println( "Osoba o podanym nazwisku nie wynajmuje �adnego pokoju");
						}
						else
						{
							System.out.println( "Osoba o podanym nazwisku wynajmuje nast�puj�ce pokoje");
							for(int iter:howManyrooms)
							{
								System.out.print(iter);
								System.out.print(" ");
							}
						}
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utw�rz hotel " + e);
					}
					break;

				case 8:
					try {
					System.out.println("Podaj nazwisko osoby" );
					String lastname = menu.next();
					hotel.checkoutPersonFromAllrooms(lastname);
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utw�rz hotel " + e);
					}
					break;

				case 9:
					try
					{
						hotel.dispay();
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utw�rz hotel " + e);
					}
					break;

				case 10: 
					System.out.println("Usuni�cie hotelu");
					hotel = null;
					break;

				case 11:
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
