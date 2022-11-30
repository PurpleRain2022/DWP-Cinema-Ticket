package dwp_cinema_ticket_service;

import java.util.HashMap;

// Singleton.
public class BookingRecords
{
	private static final char POUND_SYMBOL = '\u00A3';

	private static BookingRecords bookingRecords;
	
	private static int bookingId = 1;
	private HashMap<Integer, Booking> booking = new HashMap<Integer, Booking>();
	
	private BookingRecords() {}
	
	public static BookingRecords getInstance()
	{
		if (null == bookingRecords)
		{
            bookingRecords = new BookingRecords();
		}
		return bookingRecords;
	}
	
	public void initialiseNewBooking()
	{
		Booking newBooking = new Booking(bookingId);
		newBooking.initialise();
		booking.put(bookingId, newBooking);
		++bookingId;
	}
	
	public void printAllRecordedookings()
	{
		for (Booking booking : booking.values())
		{
			printSingleBooking(booking);
		}
	}
	
	public void printSingleBooking(Booking booking)
	{
		System.out.print
		(
			"\n" +
			"Booking ID: " + booking.getBookingId() + "\n" +
			"Booking Date: " + booking.getDateOfBooking() + "\n" +
			"Total Cost: " + POUND_SYMBOL + booking.getTotalPrice() + "\n" +
			"\n"
		);
	}
}
