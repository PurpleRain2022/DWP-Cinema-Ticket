package dwp_cinema_ticket_service;

import java.util.LinkedHashSet;
import java.util.Arrays;

public final class TickeType
{
    private TickeType() {}
    private static final LinkedHashSet<String> TICKET_TYPES =
        new LinkedHashSet<String>(Arrays.asList
            (
                "Adult",
                "Infant",
                "Child"
            )
        );

    public static Ticket getTicket(String ticketType)
    {
        if (null == ticketType) { return null; }

        if (ticketType.equals("Adult"))
        {
            return new AdultTicket();
        }
        else if (ticketType.equals("Infant"))
        {
            return new InfantTicket();
        }
        else
        {
            return new ChildTicket();
        }
    }

    public static LinkedHashSet<String> getTicketTypes()
    {
        return TICKET_TYPES;
    }

}