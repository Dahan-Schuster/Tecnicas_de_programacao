/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2002.02.06
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int[] prices;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int[] ticketsCost)
     {
         
        boolean invalidPrice = false;
        for (int i = 0; i < ticketsCost.length; i++) {
            if (ticketsCost[i] <= 0) {
                invalidPrice = true;
                break;
            }
        }
        
        if (invalidPrice) {
            System.out.println("All prices must be greater than zero!");
        } else {
           prices = ticketsCost;
           balance = 0;
           total = 0;   
        }
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice(int index)
    {
        try {
            return prices[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid price index.");
            return 0;
        } catch (NullPointerException e) {
            System.out.println("This machine's prices hasn't been defined.");
            return 0;
        }
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance += amount;
        }
        else {
            System.out.println("Use a positive amount: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket(int index)
    {
        int price = getPrice(index);
        
        if (price <= 0) {
            return;
        }
        
        int amountLeftToPay = price - balance;
        
        if(amountLeftToPay <= 0) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            if (balance == price)
                System.out.println("# Just Right!");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total += price;
            // Reduce the balance by the prince.
            balance -= price;
        }
        else {
            System.out.println("Too Expensive!");
            System.out.println("You must insert at least: " +
                               (amountLeftToPay) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
