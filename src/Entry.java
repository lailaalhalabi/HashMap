
import java.util.Random;

/**
 * An entry class that has the key as an integer and the value as a character.
 * @author Laila Alhalabi
 * @param <Integer> * @param <Character>
 */
public class Entry<Integer, Character> {
	
	private int key;
	private char value;
	
	/** 
	 * Entry constructor.
	 */
	public Entry (int key, char value) {
		this.key = key;
		this.value = value;
	}
	
	/** 
	 * Constructor that generates a random entry. 
	 */
	public Entry() {
		key = keyGenerator();
		value = charGenerator();
	}

	/**
	 * Constructor that creates an entry using a passed value and a random key.
	 * @param value
	 */
	public Entry(char value) {
		key = keyGenerator();
		this.value = value;
	}

	/**
	 * A private random key generator method. 
	 * @return Returns the generated kay.
	 */
	private int keyGenerator() {
		Random random = new Random();
		key = (int) random.nextInt(10000000);
		return key;
	}

	/**
	 * A private random character genrator. 
	 * @return Returns the generated random character.
	 */
	private char charGenerator() {
		Random random = new Random();
		value = (char) (random.nextInt(26)+'A');
		return value;
	}
	
	/**
	 * @return Returns the key.
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @return Returns the value.
	 */
	public char getValue() {
		return value;
	}

	/**
	 * Sets a key. * @param key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * Sets a value. * @param value
	 */
	public void setValue(char value) {
		this.value = value;
	}
	
	/**
	 * Returns the key, the called in hash(Entry) to compress the key then insert the lement in the table.
	 */
	@Override
	public int hashCode() {
		return key;
	}
}
