# MyHashMap

MyHashMap project was implemented by creating entry, AbsHashMap, MyHashMap classes using seperate chaining method. 

The elements were inserted based on hashCode()%CAPACITY, where the hashCode() returns the key itself.

The created methods are:

size(): Returns the numbers of the map's entries.
      
isEmpty(): Returns true if the map is empty.
      
get(key): Returns the value associated with the key.
      
put(key, value): Adds an entry to the map if it doesn't exist. If the entry exists, then it replaces the old value by the new value.
      
remove(key): Removes the entry associated with the key, and returns its value.
    
-----------------------------------------------------------------------------------------------------------------------------------------

# validate() Method Time Complexity Analysis:

After running validate() method that generates 50 random elements, adds them to the hash table using put(K, V), then does the following:

1. runs get(K) for all the 50 elements

2. runs remove(K) for the first 25 elements

3. runs get(K) for all the 50 elements again

All the methods took 0 ms to be executed.

-----------------------------------------------------------------------------------------------------------------------------------------

# experiment_interpret() Method Analysis:

Running put(K, V) for 25: 

Execution time for 25 is 0 ms.

Running put(K, V) for 50: 

Execution time for 50 is 3 ms.

Running put(K, V) for 75: 

Execution time for 75 is 4 ms.

Running put(K, V) for 100: 

Execution time for 100 is 4 ms.

Running put(K, V) for 125: 

Execution time for 125 is 5 ms.

Running put(K, V) for 150: 

Execution time for 150 is 4 ms.

After testing experiment_interpret() method that adds elements using the method put(K, V) for n ∈{25, 50, 75, 100, 125, 150}, the above values in milli seconds were observed. When the number of elements inserted in the table increases, the time complexity increases. In other words, when the load factor increases n/capacity, the running time increases.

-----------------------------------------------------------------------------------------------------------------------------------------

