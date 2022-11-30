package dwp_cinema_ticket_service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;


public class Booking
{
    private static final char POUND_SYMBOL = '\u00A3';
    private static final int TICKET_LIMIT = 20;
    private static final int TICKET_MINUS_LIMIT = -1;
    private static int ticketId = 1;
    private int bookingId;
    private Date dateOfBooking;
    private int totalPrice = 0;
    private HashMap<Integer, Ticket> ticketsPurchased = new HashMap<Integer, Ticket>();

    public Booking(int bookingId)
    {
        setBookingId(bookingId);
        dateOfBooking = new Date();
    }

    public void initialise()
    {
        numberOfTickets();
        sumTicketCosts();
        printBookingTotal();
    }

    private void numberOfTickets()
    {
        int amountOfTickets;
        for (String currentTicketType : TickeType.getTicketTypes())
        {
            amountOfTickets = -1;
            promptTicketType(currentTicketType);
            amountOfTickets = retrieveTicketAmount();
            for (int i = 0; i < amountOfTickets; ++i)
            {
                ticketsPurchased.put(ticketId++, TickeType.getTicket(currentTicketType));
            }
        }
    }

    private void sumTicketCosts()
    {
        for (Ticket ticket : ticketsPurchased.values())
        {
            setTotalPrice(totalPrice + ticket.getTicketPrice());
        }
    }

    private void printBookingTotal()
    {
        System.out.print("\nThis booking cost of total tickets " + POUND_SYMBOL + totalPrice + ".\n\n");
    }

    private void promptTicketType(String ticketType)
    {
        System.out.print("Please enter how many " + ticketType + " tickets you would like: ");
    }

    private int retrieveTicketAmount()
    {
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(inStream);
        String buffer = new String();
        int amountOfTickets = 0;
        boolean validChoiceMade = false;
        while (!validChoiceMade)
        {
            try
            {
                buffer = stdin.readLine();
                amountOfTickets = Integer.parseInt(buffer);
                if (amountOfTickets == Booking.TICKET_MINUS_LIMIT)
                {
                    throw new Exception();
                }
                else if (amountOfTickets > Booking.TICKET_LIMIT)
                {
                    throw new Exception();
                }
                validChoiceMade = true;
            }
            catch (Exception e)
            {

                System.out.print("Invalid amount of tickets specified, please type a number: ");
            }
        }
        return amountOfTickets;
    }

    private boolean isAmountValid(int amount)
    {
        return (amount > Booking.TICKET_MINUS_LIMIT && amount <= Booking.TICKET_LIMIT);
    }

    private void setBookingId(int bookingIdId)
    {
        this.bookingId = bookingId;
    }

    public int getBookingId()
    {
        return bookingId;
    }

    public Date getDateOfBooking()
    {
        return dateOfBooking;
    }

    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice()
    {
        return this.totalPrice;
    }
}