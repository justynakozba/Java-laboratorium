
public class cHotel {

	private cRoom[][] hotel; //class field representing two-dimensional table of cRoom objects
	private int floors; // class fields representing number of floor
	private final int maxFloorNumber = 15; // class field representing max floor number
	private int roomsPerFloor; // class field representing value how many rooms are per floor
	private final int maxRoomPerFloor = 100; // // class field representing max room number per floor

	public cHotel() {
		// TODO Auto-generated constructor stub
	}

	//class constructor 
	public cHotel(int howManyFloors, int roomsPerFloor)
	{
		if(howManyFloors > maxFloorNumber && roomsPerFloor > maxRoomPerFloor)
		{
			System.out.println("Zbyt du¿a liczba pieter lub pokoi");
			System.exit(0);
		}
		else 
		{
			this.floors = howManyFloors;
			this.roomsPerFloor = roomsPerFloor;
		}
		hotel = new cRoom[this.floors][this.roomsPerFloor];
		for(int i = 0; i < this.floors; i++)
		{
			for(int j = 0; j <this.roomsPerFloor; j++)
			{
				hotel[i][j] = new cRoom(i,j+1+(i*100));
			}
		}
	}

	//Function responsible checking if is any room free
	public boolean isAnyRoomFree()
	{
		for(int i = 0; i < floors; i++ )
		{
			for(int j = 0; j< roomsPerFloor; j++)
			{
				if(!hotel[i][j].isOccupied())
				{
					return true;
				}
			}
		}
		return false;
	}

	//Function check how many rooms is free
	public int howManyFreeRooms()
	{
		int room =0;
		for(int i = 0; i < floors; i++ )
		{
			for(int j = 0; j< roomsPerFloor; j++)
			{
				if(!hotel[i][j].isOccupied())
				{
					room ++;
				}
			}
		}
		return room;
	}

	// Function responsible for renting room
	public int rentRoom (cPerson person)
	{
		if (!isAnyRoomFree())
		{
			System.out.println("Brak wolnych pokoi");
			return 0;
		}
		for(int i = 0; i < floors; i++ )
		{
			for(int j = 0; j< roomsPerFloor; j++)
			{
				if(!hotel[i][j].isOccupied())
				{
					hotel[i][j].assignPerson(person);
					return hotel[i][j].getRoomNumber();
				}
			}
		
		}
		return 0;
	}

	//Function responsible for checking if is any rooms free in neighborhood
	public boolean isNeihgoursRoomsFree(int howManyRooms)
	{
		if (!isAnyRoomFree())
		{
			System.out.println("Brak wolnych pokoi");
			return false;
		}
		int avaiableRoom = 0;
		for ( int i= 0; i < floors; i++)
		{
			for (int j = 0; j < roomsPerFloor; j++)
			{
				if(!hotel[i][j].isOccupied() && j + howManyRooms < roomsPerFloor)
				{
					for (int k = j; k < j+howManyRooms; k++)
					{
						if(!hotel[i][k].isOccupied())
						{
							avaiableRoom ++;
							
						}
					}
					if(avaiableRoom == howManyRooms)
					{
						return true;
					}
					
				}
			}
		}
		return false;
	}

	// Function responsible for checking how many rooms are rented by given person
	public int[] howManyRoomsAreRentedBy(String lastName)
	{
		int [] howMany;
		int size = 0;
		int iter = 0 ;

		for(int i = 0; i < floors; i++)
		{
			for(int j = 0; j < roomsPerFloor; j++)
			{
				if (hotel[i][j].isOccupied())
				{
					if (hotel[i][j].getLastName().equals(lastName))
					{
						size++;
					}
				}
			}
		}

		if (size == 0 )
		{
			return null;
		}
		else
		{
			howMany= new int[size];
		}

		for(int i = 0; i < floors; i++)
		{
			for(int j = 0; j < roomsPerFloor; j++)
			{
				if (hotel[i][j].isOccupied())
				{
					if (hotel[i][j].getLastName().equals(lastName))
					{
						howMany[iter] = hotel[i][j].getRoomNumber();
						iter ++;
					}
				}
			}
		}

		return howMany;
	}
	
	public boolean isAnyRoomRentedBy(String lastName)
	{
		for(int i = 0; i < floors; i++)
		{
			for(int j = 0; j < roomsPerFloor; j++)
			{
				if (hotel[i][j].isOccupied())
				{
					System.out.println(hotel[i][j].getLastName());
					if (hotel[i][j].getLastName().equals(lastName))
					{
						return true;
					}
				}
			}
		}

		return false;
	}
	// function responsible for checking out person from all rooms
	public void checkoutPersonFromAllrooms(String lastName)
	{
		for(int i = 0; i < floors; i++)
		{
			for(int j = 0; j < roomsPerFloor; j++)
			{
				if (hotel[i][j].isOccupied())
				{
					if (hotel[i][j].getLastName().equals(lastName))
					{
						hotel[i][j].checkOut();
					}
				}
			}
		}
	}

	public void dispay()
	{
		for(int i = 0; i < floors; i++ )
		{
			for(int j = 0; j< roomsPerFloor; j++)
			{
				if(hotel[i][j].isOccupied())
				{
					System.out.println(" Pokój o numerze: " + hotel[i][j].getRoomNumber() + "Wynajêty przez: " + hotel[i][j].getLastName() );
				}
				else
				{
					System.out.println(" Pokój o numerze: " + hotel[i][j].getFloorNumber() + " jest wolny");
				}
			}
		}
	}

}
