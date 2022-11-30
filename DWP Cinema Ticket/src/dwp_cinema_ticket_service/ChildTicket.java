package dwp_cinema_ticket_service;

public class ChildTicket extends Ticket
{
	private static final int CHILD_TICKET_COST = 10;
	
	public ChildTicket()
	{
		super(CHILD_TICKET_COST);
	}
}
