
/**
 * @author Laila Alhalabi.
 * Abstract hashMap class.
 * @param <Integer> * @param <Character>
 */
public abstract class AbsHashMap<Integer, Character> extends Entry<Integer, Character> {
	
	private int capacity;
	
	/**
	 * A constructor that initializes a hashmap object with an initial capacity as a parameter.
	 * @param capacity
	 */
	public AbsHashMap(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * @return Returns the compression function result to ensure the capacity and insert the element at the resulted value.
	 */
	public int hash(Entry entry) {
		int hash = entry.hashCode() % capacity;
		return hash;
	}
	
	/**
	 * @return Returns the capacity.
	 */
	public int getCapacity() {
		return capacity;
	}
	 
	/**
	 * @return Returns the numbers of the map's entries.
	 */
	public abstract int size();
	
	/**
	 * @return Returns true if the map is empty.
	 */
	public abstract boolean isEmpty();
	
	/**
	 * @param key
	 * @return Returns the value associated with the key.
	 */
	public abstract char get(int key);
	
	/**
	 * A method that adds an entry to the map if it doesn't exist and returns null.
	 * If the entry exists, then it replaces the old value by the new value and returns the old value.
	 * @param key
	 * @param value
	 * @return Returns the value added to the map.
	 */
	public abstract char put(int key, char value);
	
	/**
	 * A method that removes the entry associated with the key, and returns its value.
	 * @param key
	 * @return Returns
	 */
	public abstract char remove(int key);
	
}
