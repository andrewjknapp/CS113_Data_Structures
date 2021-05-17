package homework8;
import java.util.*;

/**
 * HashTable implementation using chaining to tack a pair of key and value pairs.
 * @param <K> Generic Key
 * @param <V> Generic Value
 */
public class HashTableChain<K, V> implements Map<K, V>  {

    private LinkedList<Entry<K, V>>[] table ;
    private  int numKeys ;
    private static final int CAPACITY = 101 ;
    // Load Threshold is the factor of entries to array slots we will
    // allow before resizing the table
    // If threshold is 1.5 then we will resize once there are
    // 1.5 times as many entries as their are open slots
    private static final double LOAD_THRESHOLD = 1.5 ;

    ///////////// ENTRY CLASS ///////////////////////////////////////

    /**
     * Contains key-value pairs for HashTable
     * @param <K> the key
     * @param <V> the value
     */
    private static class Entry<K, V> implements Map.Entry<K, V>{
        private K key ;
        private V value ;

        /**
         * Creates a new key-value pair
         * @param key the key
         * @param value the value
         */
        public Entry(K key, V value) {
            this.key = key ;
            this.value = value ;
        }

        /**
         * Returns the key
         * @return the key
         */
        public K getKey() {
            return  key;
        }

        /**
         * Returns the value
         * @return the value
         */
        public V getValue() {
            return value ;
        }

        /**
         * Sets the value
         * @param val the new value
         * @return the old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val ;
            return oldVal ;
        }
        @Override
        public String toString() {
            return  key + "=" + value  ;
        }



    }

    ////////////// end Entry Class /////////////////////////////////

    ////////////// EntrySet Class //////////////////////////////////

    /**
     * Inner class to implement set view
     */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {


        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new SetIterator();
        }

        @Override
        public int size() {
            return numKeys ;
        }
    }

    ////////////// end EntrySet Class //////////////////////////////

    //////////////   SetIterator Class ////////////////////////////

    /**
     * Class that iterates over the table. Index is table location
     * and lastItemReturned is entry
     */
    private class SetIterator implements Iterator<Map.Entry<K, V>> {

        private int index = 0 ;
        private Entry<K,V> lastItemReturned = null;
        private Iterator<Entry<K, V>> iter = null;

        @Override
        public boolean hasNext() {
        	// TODO
            return false;
        }

        @Override
        public Map.Entry<K, V> next() {
        	// TODO
            return null;
        }

        @Override
        public void remove() {
        	// TODO
        }
    }

    ////////////// end SetIterator Class ////////////////////////////

    /**
     * Default constructor, sets the table to initial capacity size
     */
    public HashTableChain() {
        table = new LinkedList[CAPACITY] ;
    }

    // returns number of keys
    @Override
    public int size() {
        return numKeys;
    }

    // returns boolean if table has no keys
    @Override
    public boolean isEmpty() {
    	return numKeys == 0;
    }

    // returns boolean if table has the searched for key
    @Override
    public boolean containsKey(Object key) {
    	// TODO
        return true;
    }

    // returns boolean if table has the searched for value
    @Override
    public boolean containsValue(Object value) {
    	// TODO
    	return true;
    }

    // returns Value if table has the searched for key
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null; // key is not in table
        }
        // search through list at table[index]
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        // Key is not in the table
        return null;
    }

    // adds the key and value pair to the table using hashing
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;

        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        // Search list to find key
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                // Replace old value with given value
                V oldVal = entry.getValue();
                entry.setValue(value);
                return oldVal;
            }
        }
        // Key is not in the table
        table[index].addFirst(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) {
            rehash();
        }
        return null;
    }


    /**
     * Resizes the table to be 2X +1 bigger than previous
     */
    private void rehash() {
    	// TODO
        // Allocate a new hash table with twice the capacity
        // Reinsert each old table entry that has not been deleted
        // Reference new hash table instead of the original
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder() ;
        for (int i = 0 ; i < table.length ; i++ ) {
            if (table[i] != null) {
                for (Entry<K, V> nextItem : table[i]) {
                    sb.append(nextItem.toString() + " ") ;
                }
                sb.append(" ");
            }
        }
        return sb.toString() ;

    }

    // remove an entry at the key location
    // return removed value
    @Override
    public V remove(Object key) {
    	int index = key.hashCode() % table.length;

    	if (index < 0) {
    	    index += table.length;
        }
    	// Key is not in table
    	if (table[index] == null) {
    	    return null;
        }

    	for (Entry<K, V> entry : table[index]) {
    	    if (entry.getKey().equals(key)) {
    	        V oldVal = entry.getValue();
    	        table[index].remove(entry);
    	        numKeys--;
    	        if (table[index].isEmpty()) {
    	            table[index] = null;
                }
    	        return oldVal;
            }
        }

    	// Key is not in table
        return null;
    }

    // throws UnsupportedOperationException
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException() ;
    }

    // empties the table
    @Override
    public void clear() {
    	// TODO
    }

    // returns a view of the keys in set view
    @Override
    public Set<K> keySet() {
    	// TODO
        return null;
    }

    // throws UnsupportedOperationException
    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException() ;
    }


    // returns a set view of the hash table
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
    	// TODO

        return null;
    }

    @Override
    public boolean equals(Object o) {
    	// TODO
        return true;
    }

    @Override
    public int hashCode() {
    	//TODO
        return 0;
    }
}
