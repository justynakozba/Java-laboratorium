public class cRoom {
	
	private int floorNumber; // class field representing floor number;
	private int roomNumber; // class field representing room number;
	private cPerson person; // class field representing person;
	private boolean isEmpty; // class field representing if room is empty;

	public cRoom() {
		// TODO Auto-generated constructor stub
	}

	public cRoom(int floorNumber, int roomNumber)
	{
		this.floorNumber = floorNumber;
		this.roomNumber = roomNumber;
		this.isEmpty = true;

	}

	// function responsible for setting floor number
	public int getFloorNumber()
	{
		return floorNumber;
	}

	// function responsible for setting floor number
	public void setFloorNumber(int floorNumber)
	{
		this.floorNumber = floorNumber;
	}

	// function responsible for setting room number
	public int getRoomNumber()
	{
		return roomNumber;
	}

	// function responsible for setting room number
	public void setRoomNumber(int roomNumber)
	{
		this.roomNumber = roomNumber;
	}

	public boolean isOccupied()
	{
		return !isEmpty;
	}

	//function responsible for assigning person to room
	public void assignPerson(cPerson person)
	{
		this.person = person;
		isEmpty = false;
	}

	//function responsible for giving last name
	public String getLastName()
	{
		try
		{
			return person.getLastName();
		}
		catch(NullPointerException e) 
		{
			return "";
		}
	}

	// function responsible for checking out person from room
	public void checkOut()
	{
		person = null;
		isEmpty = true;
	}

	
}
