import java.util.HashMap;

/**
 * Classe MapTester
 * Implementa uma lista telefônica simples utilizando HashMaps
 * 
 * @author Dahan Schuster
 * @version 1.0.0 (12/04/2022)
 */
public class MapTester {
    /** A lista telefônica representada por um HashMap */
    private HashMap<String, String> lista;

    /**
     * Construtor da classe MapTester
     * Inicializa o HashMap
     */
    public MapTester() {
        lista = new HashMap<>();
    }

    /**
     * Adiciona uma nova entrada à lista telefônica
     * O nome deve ter no mínimo três caracteres
     * 
     * @param name o nome que ficará salvo na lista
     * @param number o número relacionado ao novo nome
     */
    public void enterNumber(String name, String number) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("O nome deve ter no mínimo três caracteres");
        }

        lista.put(name, number);
    }

    /**
     * Procura o nome na lista e, se encontrado,
     * retorna seu número de telefone
     * 
     * @param name o nome a ser procurado
     * @return O número de telefone, como String, ou null
     */
    public String lookupNumber(String name) {
        if (lista.containsKey(name))
            return lista.get(name);
        
        System.out.println("O nome não está incluso na lista");
        return null;
    }
}
