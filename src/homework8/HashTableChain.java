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

        @Override
        public String toString() {
            return HashTableChain.this.toString();
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
            if (iter != null) {
                if (iter.hasNext()) {
                    return true;
                }
            }
            for (int i = index; i < table.length; i++) {
                if (table[i] == null) {
                    continue;
                }
                return true;
            }
            return false;
        }

        @Override
        public Map.Entry<K, V> next() {
            if (iter != null) {
                if (iter.hasNext()) {
                    return iter.next();
                } else {
                    iter = null;
                }
            }

            while (index < table.length && table[index] == null) {
                index++;
            }
            if (index >= table.length) {
                return null;
            }
            iter = table[index].iterator();
            index++;

            Map.Entry<K, V> entry = iter.next();

            lastItemReturned = (Entry) entry;

            return entry;
        }

        @Override
        public void remove() {
        	// TODO remove
            HashTableChain.this.remove(lastItemReturned.key);
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
        return this.get(key) != null;
    }

    // returns boolean if table has the searched for value
    @Override
    public boolean containsValue(Object value) {

        Iterator<Map.Entry<K,V>> iter = entrySet().iterator();
        while (iter.hasNext()) {
            if (iter.next().getValue().equals(value)) {
                return true;
            }
        }
        return false;

//        for (Map.Entry<K, V> kvEntry : entrySet()) {
//            if (kvEntry.getValue().equals(value))
//                return true;
//        }
//        return false;
//    	for (int i = 0; i < table.length; i++) {
//    	    if (table[i] == null) {
//    	        continue;
//            }
//
//    	    for (Entry<K, V> entry : table[i]) {
//    	        if (entry.value == value) {
//    	            return true;
//                }
//            }
//        }
//    	return false;
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
        // Allocate a new hash table with twice the capacity
        // Reinsert each old table entry that has not been deleted
        // Reference new hash table instead of the original
        LinkedList<Entry<K,V>>[] newTable = new LinkedList[table.length * 2];
        LinkedList<Entry<K,V>>[] oldTable = table;
        table = newTable;
        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null) {
                continue;
            }
            for (Entry<K, V> entry : oldTable[i]) {
                if (oldTable[i].size() > 1) {
                    System.out.println();
                }
                this.put(entry.key, entry.value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder() ;
        sb.append("[");
        for (int i = 0 ; i < table.length ; i++ ) {
            if (table[i] != null) {
                for (Entry<K, V> nextItem : table[i]) {
                    sb.append(nextItem.toString() + ", ") ;
                }
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
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
        table = new LinkedList[CAPACITY] ;
        numKeys = 0;
    }

    // returns a view of the keys in set view
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        Set<Map.Entry<K, V>> es = entrySet();
        Iterator<Map.Entry<K,V>> iter = es.iterator();

        System.out.println(iter.hasNext());

        while (iter.hasNext()) {
            keys.add(iter.next().getKey());
        }
     	// TODO keySet
        return keys;
    }

    // throws UnsupportedOperationException
    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException() ;
    }


    // returns a set view of the hash table
    @Override
    public Set<Map.Entry<K, V>> entrySet() {

        return new EntrySet();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Map)) {
            return false;
        }
        Map other = (Map) o;
        if (other == this) {
            return true;
        }
        if (this.size() != other.size()) {
            return false;
        }

        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] == null) {
                continue;
            }
            for (Entry<K, V> nextItem : table[i]) {
                if (nextItem.value != other.get(nextItem.key)) {
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public int hashCode() {
        double loadFactor = LOAD_THRESHOLD;
        int h = 0;
        if (numKeys == 0 || loadFactor < 0)
            return h;  // Returns zero

        loadFactor = -loadFactor;  // Mark hashCode computation in progress
        Set<Map.Entry<K,V>> es = entrySet();
        Iterator<Map.Entry<K,V>> iter = es.iterator();
        while (iter.hasNext()) {
            h += iter.next().hashCode();
        }

        loadFactor = -loadFactor;  // Mark hashCode computation complete

        return h;
    }
}
