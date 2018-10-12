import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;
public class Exercise6 {

	private SimpleDateFormat dateFormat;
	private Calendar calendar;
	
	public Exercise6()
	{
		dateFormat = new SimpleDateFormat ("dd.MM.yyyy");
		Calendar calendar = Calendar.getInstance();
	}
	
	public void calc()
	{
		Calendar calendar = Calendar.getInstance();
		System.out.println("Today: " + dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println("Tomorrow: " + dateFormat.format(calendar.getTime()));
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println("Yesterday: " + dateFormat.format(calendar.getTime()));
	}

}
