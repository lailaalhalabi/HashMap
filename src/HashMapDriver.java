import java.io.FileWriter;
import java.util.ArrayList;

/**
 * @author Laila Alhalabi.
 * Assignment 4, COMP352. April 18, 2021.
 */
public class HashMapDriver {
	
	/** A method that tests MyHashMap put(K,V), get(K) and remove(K) methods. */
	static void validate() {
		// MyHashMap object using 100 as the initial capacity.
		MyHashMap<Integer, Character> table = new MyHashMap<Integer, Character>(100);
		// Genrating random 50 entries, adding them to the data array and then to the hash table.
		ArrayList data = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			data.add(i, new Entry());
			table.put(((Entry) data.get(i)).getKey(), ((Entry) data.get(i)).getValue());
		}
		System.out.println("\n---------- Running get(k) method on each of the 50 elements ----------\n");
		for (int k = 0; k < 50; k++) { 
			int curr = ((Entry) data.get(k)).getKey();
			table.get(curr);
		} 
		System.out.println("\n---------- Running remove(k) on each of the first 25 keys ----------\n");
		for (int k = 0; k < 25; k++) {
			int curr = ((Entry) data.get(k)).getKey();
			table.remove(curr);
		}
		System.out.println("\n---------- Runung get(k) method on each one of the 50 keys ----------\n");
		for (int k = 0; k < 50; k++) {
			int curr = ((Entry) data.get(k)).getKey();
	        table.get(curr);
		}
	}

	/** A method that tests the time complexity of the hashMap class by changing the load factor. */
	static void experiment_interpret() {
		// Genrating random 150 entries, and adding them to the data array.
		ArrayList data = new ArrayList<>();
		try {
			FileWriter writer = new FileWriter("timeObservation.txt");
			writer.write("\n   ---------- Testing experiment_interpret() method ---------- \n");
			// Generating entries into the data array
			for (int i = 0; i < 150; i++)
				data.add(i, new Entry());
			// Running put(K, V) for {25, 50, 75, 100, 125, 150}
			for (int n = 25; n <= 150; n += 25) { 
				long start = System.currentTimeMillis();
				// MyHashMap object using 100 as the initial capacity.
				MyHashMap<Integer, Character> table = new MyHashMap<Integer, Character>(100);
				System.out.println("\t\t-------------------------\n" 
				        + "\t\tRunning put(K, V) for " + n + ": \n"
						+ "\t\t-------------------------\n");
				writer.write("\nRunning put(K, V) for " + n + ": \n");
				for (int i = 0; i < n; i++) 
					table.put(((Entry) data.get(i)).getKey(), ((Entry) data.get(i)).getValue());
				long end = System.currentTimeMillis();
				long executionTime = (end - start);
				writer.write("Execution time for " + n + " is " + executionTime + " ms.\n"
					 	+ "-----------------------------------------------------------------------------------");
			}
			writer.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void main(String[] args) {
		
		System.out.println(" --------------- My Hash Map Testing --------------- \n");
		MyHashMap<Integer, Character> map = new MyHashMap<Integer, Character>(100);
	
		map.put(0, 'A');
		map.put(1, 'B');
		map.put(2, 'C');
		map.put(3, 'D');
		map.put(4, 'E');
		map.put(5, 'F');
		map.put(0, 'A');
		map.put(1, 'B');
		map.put(2, 'C');
		map.put(3, 'D');
		map.put(4, 'E');
		map.put(5, 'F');
		map.print();
		map.remove(0);
		map.remove(1);
		map.remove(2);
		map.remove(3);
		map.remove(4);
		map.remove(5);
		map.print();
		map.put(0, 'A');
		map.print();
		
		System.out.println("\n   ------------ Testing validate() method ------------ \n");
		validate();
		
		System.out.println("\n   ------ Testing experiment_interpret() method ------ \n");
		experiment_interpret();	
		
	}
}
