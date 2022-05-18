public class Main {
    public static void main(String[] args) {

        boolean iIsPrime = false;
        for (int i = 0; i > -100; i--) {
            iIsPrime = Main.isPrime(i);

            System.out.println(String.format(
                "%02d %s prime",
                i,
                iIsPrime ? "is" : "isn't"
            ));
        }
    }

    public static boolean isPrime(int integer) {
        // transforma integer em seu módulo
        integer = integer < 0
            ? integer * -1
            : integer;

        for(int i = 2; i <= integer - 1; i++)
            if (integer % i == 0)
                return false;
        
        return true;
    }
}
