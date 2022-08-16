import java.security.InvalidParameterException;
import java.util.Random;

/**
 * Classe RandomTester
 * Imprime números aleatórios no terminal
 * 
 * @author Dahan Schuster
 * @version 1.0.0 (12/04/2022)
 */
public class RandomTester {
    private Random randomGenerator;
    private int limit;

    /**
     * Construtor da classe RandomTester
     * Inicializa o objeto com um limite para
     * os números que serão gerados
     * 
     * @param limit número inteiro positivo que
     * determina o limite dos números aleatórios,
     * que irão variar entre 0 e limite.
     */
    public RandomTester(int limit) {
        if (limit < 0)
            throw new IllegalArgumentException("O limite deve ser positivo.");

        this.limit = limit;
        this.randomGenerator = new Random();
    }

    /**
     * Gera e imprime no terminal um único aleatório
     * entre 0 e o limite especificado no construtor
     */
    public void printOneRandom() {
        System.out.println(randomGenerator.nextInt(limit));
    }

    /**
     * Gera e imprime no terminal a quantidade de números
     * aleatórios indicada por parâmetro
     * Os números variam de 0 ao limite especificado no
     * construtor
     */
    public void printOneRandom(int howMany) {
        if (howMany < 0)
            throw new IllegalArgumentException("A quantidade deve ser positiva.");

        for (int i = 0; i < howMany; i++)
            System.out.println(randomGenerator.nextInt(limit));
    }
}
