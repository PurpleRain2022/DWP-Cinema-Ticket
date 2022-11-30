package dwp_cinema_ticket_service;

import java.util.Calendar;
import java.util.Date;

public abstract class Ticket 
{
	private int ticketPrice;
	
	public Ticket(int ticketPrice)
	{
		setTicketPrice(ticketPrice);
	}
	
	public int getTicketPrice()
	{
		return this.ticketPrice;
	}
	
	private void setTicketPrice(int ticketPrice)
	{
		// Applies the -2GBP discount on Wednesdays.
		if (isWednesday())
		{
			ticketPrice -= 2;
		}
		this.ticketPrice = ticketPrice;
	}
	
	private boolean isWednesday()
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY;
	}
	
}
