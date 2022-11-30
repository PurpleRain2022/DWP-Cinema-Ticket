package dwp_cinema_ticket_service;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Menu
{
	private static final int NUMBER_OF_CHOICES_AVAILABLE = 3;
	private static final int START_NEW_BOOKING = 1, PRINT_ALL_RECORDED_BOOKINGS = 2,
			QUIT = NUMBER_OF_CHOICES_AVAILABLE;

	private static Menu menu;
	private BookingRecords bookingRecords;
	
	private Menu()
	{
		bookingRecords = BookingRecords.getInstance();
	}
	
	public static Menu getInstance()
	{
		if (null == menu)
		{
			menu = new Menu();
		}
		return menu;
	}
	
	public void displayUserInterface()
	{
		boolean keepMenuActive = true;
		int choice;
		displayWelcomeText();
		while (keepMenuActive)
		{
			choice = -1;
			promptUserAction();
			choice = retrieveUserChoice();
			keepMenuActive = performSelectedAction(choice);
		}
	}
	
	private void displayWelcomeText()
	{
		System.out.println("Welcome to DWP Cinemas ticket booking system");
	}
	
	private void promptUserAction()
	{
		System.out.print
		(
			"Menu choices:\n" +
			"1) Start a new booking.\n" +
			"2) Print all bookings.\n" +
			"3) Quit.\n" +
			"Please choose from the menu, a choice, and then press <Return>: "
		);
	}
	
	private int retrieveUserChoice()
	{
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		String buffer = new String();
		int choice = -1;
		boolean validChoiceMade = false;
		while (!validChoiceMade)
		{
			try
			{
				buffer = stdin.readLine();
				choice = Integer.parseInt(buffer);
				if (!isValidChoice(choice))
				{
					throw new Exception();
				};
				validChoiceMade = true;
			}
			catch (Exception e)
			{
				choice = -1;
				System.out.print("Invalid choice, please type the number corresponding with the choice " +
					"you would like to make: ");
			}
		}
		return choice;
	}
	
	private boolean isValidChoice(int choice)
	{
		return (choice > 0 && choice < NUMBER_OF_CHOICES_AVAILABLE + 1);
	}
	
	private boolean performSelectedAction(int choice)
	{
		boolean permitSucceedingAction = true;
		switch (choice)
		{
		case START_NEW_BOOKING:
			bookingRecords.initialiseNewBooking();
			break;
		case PRINT_ALL_RECORDED_BOOKINGS:
			bookingRecords.printAllRecordedookings();
			break;
		case QUIT:
			permitSucceedingAction = false;
			break;
		}
		return permitSucceedingAction;
	}
}
