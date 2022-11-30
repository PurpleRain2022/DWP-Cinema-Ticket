package dwp_cinema_ticket_service;

public class AdultTicket extends Ticket
{
	private static final int ADULT_TICKET_PRICE = 20;
	
	public AdultTicket()
	{
		super(ADULT_TICKET_PRICE);
	}
}
