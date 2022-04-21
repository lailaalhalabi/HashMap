import java.util.ArrayList;
import java.util.List;

/**
 * @author Laila Alhalabi.
 * MyHashMap class implemented uning seperate chaining.
 * @param <Integer> * @param <Character>
 */
public class MyHashMap<Integer, Character> extends AbsHashMap<Integer, Character>{
	
	// To insert the the elements of the hashMap
	private ArrayList<Entry<Integer, Character>> entries = new ArrayList<Entry<Integer, Character>>();
	// To calculate the number of elements that each bucket has
	private List bucket = new ArrayList();
	private int totalElements = 0;
	private int collisionKeys;
	
	/**
	 * Constructor that creates an empty chain using the passed capacity.
	 * @param capacity 
	 */
	public MyHashMap(int capacity) {
		super(capacity);
		for (int i = 0; i < capacity; i++)
			entries.add(i, new Entry<>(0, '0'));
	}

	/**
	 * @return Returns the numbers of the map's entries.
	 */
	@Override
	public int size() {
		return totalElements;
	}
	
	/**
	 * @return Returns true if the map is empty.
	 */
	@Override
	public boolean isEmpty() {
		return totalElements == 0;
	}
	
	/**
	 * Searching for the index of a key.
	 * @param key
	 * @return
	 */
	private int findIndex(int key) {
		for (int index = 0; index < entries.size(); index++) {
			int currentKey = hash(entries.get(index));
			if (currentKey == key % getCapacity() && entries.get(index).getValue() != '0') 
				return index;
		}
		return -1;
	}
	
	/**
	 * @param key
	 * @return Returns the value associated with the key.
	 */
	@Override
	public char get(int key) {
		start(); // Start time of the method
		int index = findKey(key);
		if (index == -1 || entries.get(index).getValue() == '0') { // If the index is not found.
			System.out.println("no element found!");
			end();
			return 0;
		}
		System.out.print("The found entry at key '" + key + "' is: " + "(" + entries.get(index).getKey() + ", '" + entries.get(index).getValue() + "') \n");
		end();
		return entries.get(index).getValue();
	}

	public int findKey(int key) {
		for (int index = 0; index < entries.size(); index++) {
			int currentKey = entries.get(index).getKey();
			if (currentKey == key && entries.get(index).getValue() != '0') 
				return index;
		}
		return -1;
	}
	
	/**
	 * A method that adds an entry to the map if it doesn't exist and returns null.
	 * If the entry exists, then it replaces the old value by the new value and returns the old value.
	 * @param key
	 * @param value
	 * @return Returns the value added to the map.
	 */
	@Override
	public char put(int key, char value) {
		start(); // Start time of the method
		if (findIndex(key % getCapacity()) == -1) { // If the key does not exist then add it with the value as a new entry.
			entries.add(key % getCapacity(), new Entry<>(key, value));
			bucket.add(key);
			totalElements++;
			System.out.println("The size of the table is " + getCapacity() 
			+ ", and the number of elements is " + size() + ". \n"
			+ "The number of keys that resulted in collision is " + collisionKeys + ". "
			+ "The number of items in the bucket storing '" + value + "' is " + elementsAt(key) + ". ");
			end();
			return 0;
		} else { // Keep the key and change replace the value.
			entries.get(key % getCapacity()).setValue(value);
			bucket.add(key);
			collisionKeys++;
			System.out.println("The size of the table is " + getCapacity() 
			+ ", and the number of elements is " + size() + ". \n"
			+ "The number of keys that resulted in collision is " + collisionKeys + ". "
			+ "The number of items in the bucket storing '" + value + "' is " + elementsAt(key) + ". ");
			end();
			return entries.get(key % getCapacity()).getValue();
		}
	}
	
	/**
	 * A method that removes the entry associated with the key, and returns its value.
	 * @param key
	 * @return Returns
	 */
	@Override
	public char remove(int key) {
		start(); 
		int index = findIndex(key);
		if (index == -1) {
			System.out.println("No item at key " + key + " has been found to remove! \n");
			return 0;
		}
		char val = entries.get(key % getCapacity()).getValue();
		entries.remove(index); // Remove the element.
		removeBucket(key);
		totalElements--;
		System.out.println("The entry at key " + key + " has been removed!");
		end();
		return val;
	}
	
	/**
	 * Printing elements.
	 */
	public void print() {
		if (isEmpty()) { // If the list is empty
			System.out.println("The HashMap is empty!");
			return;
		}
		System.out.println("The list has a capacity of " + getCapacity() + ", and contains the following " + size() + " items: ");
		System.out.println("{ ");
		for (int i = 0; i < getCapacity(); i++) { // If the list is not empty it will prints till it reach an empty node
			if (entries.get(i).getValue() != '0')
			System.out.println("(" + entries.get(i).getKey() + ", '" + entries.get(i).getValue() + "') ");
		}
		System.out.print("}\n");
	}
	
	/**
	 * @param key
	 * @return Returns the number of similar keys to find how many elements each bucket has.
	 */
	private int elementsAt(int key) {
		int bucketElements = 0;
		for (int i = 0; i < bucket.size(); i++) { 
			int currentKey = (int) bucket.get(i);
			if (key % getCapacity() == currentKey % getCapacity())
				bucketElements++;
		}
		return bucketElements;
	}
	
	/**
	 * Removes the elements the has the same hashCode()
	 * @param key
	 */
	private void removeBucket(int key) {
		for (int i = 0; i < bucket.size(); i++) { 
			int currentKey = (int) bucket.get(i);
			if (key % getCapacity() == currentKey % getCapacity()) {
			    bucket.remove(i);
			    if (!(collisionKeys == 0))
			    collisionKeys--;
			}
		}
	}
	
	/**
	 * @return Returns the start time of the method.
	 */
	public long start() {
		long start = System.currentTimeMillis();
		return start;
	}
	
	/**
	 * Prints execution time.
	 */
	public void end() {
		long end = System.currentTimeMillis(); 
		long executionTime = end - start();
		System.out.println("The method took " + executionTime + " ms to be executed.\n");
	}
}
