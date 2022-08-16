
/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2002.02.06
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // The default price of a ticket from this machine.
    static final int defaultPrice = 2;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero.
     */
    public TicketMachine(int ticketCost) throws Exception
    {
        if (ticketCost <= 0) {
            throw new Exception("The ticket cost must be greater than zero.");
        }

        price = ticketCost;
        balance = 0;
        total = 0;
    }
    
    
    /**
     * Create a machine that issues tickets of the default price.
     */
    public TicketMachine()
    {
        price = TicketMachine.defaultPrice;
        balance = 0;
        total = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    public void insertMoney(int amount)
    {
        balance += amount;
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        // Simulate the printing of a ticket.
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        // Update the total collected with the balance.
        total += balance;
        // Clear the balance.
        balance = 0;
    }
}
