import java.io.File;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer {

	/**
	 * Salva uma lista de objetos serializáveis em um arquivo binário
	 * 
	 * @param object
	 * @param filename
	 */
	public static void saveObjects(Serializable object, String filename) {
		File file = new File(filename);
		try {
			file.delete();
			file.createNewFile();

			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file));
			objectOut.writeObject(object);
			objectOut.close();

		} catch (NotSerializableException e) {
			System.out.printf("Erro - objeto não serializável: %s", e.getMessage());
		} catch (IOException e) {
			System.out.printf("Erro ao gravar objeto em um arquivo: %s", e.getMessage());
		}
	}

	/**
	 * Recupera os objetos serializados em um arquivo
	 * 
	 * @param filename
	 * @return
	 */
	public static Serializable readObjects(String filename) {
		Serializable object = null;

		try {
			File file = new File(filename);
			if (file.exists()) {
				ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(file));
				object = (Serializable) objectIn.readObject();
				objectIn.close();
			}
		} catch (IOException e) {
			System.out.printf("Erro ao manipular o arquivo: %s", e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.printf("Erro ao ler um objeto do arquivo: %s", e.getMessage());
		}

		return object;
	}

}
