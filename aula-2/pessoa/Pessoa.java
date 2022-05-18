
/**
 * Person class
 *
 * @author Dahan Schuster
 * @version 1
 */
public class Pessoa
{
    private String name;
    private int age;

    /**
     * Constructor for objects of class Pessoa
     */
    public Pessoa(String name, int age)
    {   
        this.name = name.length() > 0 ? name : "unkown";
        this.age = age >= 0 ? age : 0;
        
        if (name.length() == 0)
            System.out.println("Please especify a name.");
        
        if (age < 0)
            System.out.println("Age must be greater than or equal to zero. You tried to set an age of "+ age +", but zero was defined by default.");
    }
    
    public void setAge(int age) {        
        if (age < 0)
            System.out.println("Age must be greater than or equal to zero.");
        else
            this.age = age;
    }

    /**
     * Return details about the person
     *
     * @return String
     */
    public void details()
    {
        System.out.println(String.format("The name of this person is %s and their's age is %d", name, age));
    }
}
