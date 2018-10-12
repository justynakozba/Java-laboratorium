import java.util.Scanner;

public class TextMenu {

	private void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Menu tekstowe dla listy 4");
		System.out.println("==============================================");
		System.out.println(" Aby wybraæ zadanie wpisz odpowiedni¹ liczbê");
		System.out.println(" 0  -Wyœwietl menu");
		System.out.println(" 1  -Stworzenie hotelu o podanej liczbie piêter i pokoi");
		System.out.println(" 2  -Czy jest jakiœ wolny pokój");
		System.out.println(" 3  -Ile jest wolych pokoi");
		System.out.println(" 4  -Wynajêcie dowolnego pokoju podanej osobie");
		System.out.println(" 5  -Czy mo¿na wynaj¹æ k s¹siednich pokoi");
		System.out.println(" 6  -Czy osoba o podanym nazwisku wynajmuje jakiœ pokój");
		System.out.println(" 7 -które pokoje wynajmuje osoba o podanym nazwisku");
		System.out.println(" 8 -Zwolnij wszystkie pokoje wynajmowane przez osobê podanym nazwisku");
		System.out.println(" 9 -Wyswietl wszystkie pokoje w hotelu");
		System.out.println(" 10 -Usuniêcie macierzy");
		System.out.println(" 11 -Wyjœcie");
		
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
					
					System.out.println("Wpisz liczbê piêter");
					int floors = menu.nextInt();
					System.out.println("Wpisz liczbê pokoi na piêtrze");
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
						System.out.println("Najpierw utwórz hotel " + e);
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
						System.out.println("Najpierw utwórz hotel " + e);
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
						System.out.println("Najpierw utwórz hotel" + e);
					}
					break;

				case 5:
					try
					{
					System.out.println("Podaj ile sasiednich pokoi chcesz wynaj¹æ");
					int k = menu.nextInt();
					System.out.println((hotel.isNeihgoursRoomsFree(k)? "Mo¿na wynaj¹æ tyle pokoi": "Nie mo¿2na wynajaæ tylu pokoi"));
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utwórz hotel " + e);
					}
					break;

				case 6:
						System.out.println(" Podaj nazwiko");
						String lastName =menu.next();
						try
						{
							System.out.println( (hotel.isAnyRoomRentedBy(lastName)? " Osoba wynajmuje pokój w hotelu": "Osoba nie wynajmuje pokoju w hotelu"));
						}
						catch (NullPointerException e)
						{
							System.out.println("Najpierw utwórz hotel " + e);
						}
						break;

				case 7:
					try 
					{
						System.out.println("Podaj nazwisko osoby");
						int [] howManyrooms = hotel.howManyRoomsAreRentedBy(menu.next());
						if (howManyrooms == null)
						{
							System.out.println( "Osoba o podanym nazwisku nie wynajmuje ¿adnego pokoju");
						}
						else
						{
							System.out.println( "Osoba o podanym nazwisku wynajmuje nastêpuj¹ce pokoje");
							for(int iter:howManyrooms)
							{
								System.out.print(iter);
								System.out.print(" ");
							}
						}
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utwórz hotel " + e);
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
						System.out.println("Najpierw utwórz hotel " + e);
					}
					break;

				case 9:
					try
					{
						hotel.dispay();
					}
					catch (NullPointerException e)
					{
						System.out.println("Najpierw utwórz hotel " + e);
					}
					break;

				case 10: 
					System.out.println("Usuniêcie hotelu");
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
