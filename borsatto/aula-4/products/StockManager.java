import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        Product existingProduct = findProduct(item.getID());
        if (existingProduct != null) {
            System.out.println("Can not add two products with the same ID:");
            System.out.println(existingProduct.toString());
            System.out.println(item.toString());
            return;
        }

        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);

        if (product != null) {
            product.increaseQuantity(amount);
        } else {
            System.out.println("Product not found");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Iterator i = stock.iterator();
        while(i.hasNext()) {
            Product product = (Product) i.next();
            if (product.getID() == id) {
                return product;
            }
        }

        return null;
    }

    /**
     * Find a product by its name
     * @param name
     * @return the product found, or null
     */
    public Product findProduct(String name)
    {
        Iterator i = stock.iterator();
        while(i.hasNext()) {
            Product product = (Product) i.next();
            if (product.getName().equals(name)) {
                return product;
            }
        }

        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);

        if (product != null) {
            return product.getQuantity();
        } else {
            System.out.println("Product not found");
            return -1;
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        Iterator<Product> i = stock.iterator();
        System.out.println("--- Products in stock ---");
        String message = "";
        while(i.hasNext()) {
            Product product = (Product) i.next();
            message += product.toString() + "\n";
        }	

        System.out.println(message + "\n");	
    }

    /**
     * Print details of all the products with stock level bellow the specified.
     */
    public void printProductDetails(int bellowStockLevel)
    {
        Iterator<Product> i = stock.iterator();
        System.out.println("--- Products bellow " + bellowStockLevel + " in stock ---");
        String message = "";
        while(i.hasNext()) {
            Product product = (Product) i.next();
            if (product.getQuantity() < bellowStockLevel)
                message += product.toString() + "\n";
        }	

        System.out.println(message + "\n");	
    }
}
