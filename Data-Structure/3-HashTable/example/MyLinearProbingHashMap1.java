import java.util.LinkedList;
import java.util.List;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 22/08/2024 13:54
 * @Description : implement linear probing hashmap with rehash
 */
class MyLinearProbingHashMap1<K, V> {

    private static class KVNode<K, V> {
        K key;
        V val;

        public KVNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // store K-V
    private KVNode<K, V>[] table;
    // size
    private int size;
    //init capacity
    private static final int INIT_CAP = 4;

    public MyLinearProbingHashMap1() {
        this(INIT_CAP);
    }

    public MyLinearProbingHashMap1(int initCapacity) {
        size = 0;
        table = (KVNode<K, V>[]) new KVNode[initCapacity];
    }

    // add & update
    public void put(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }

        // set load factor = 0.75, then resize
        if (size >= table.length * 0.75) {
            resize(table.length * 2);
        }

        // if already exist, then update, not then add new one
        int index = getKeyIndex(key);
        // update value
        if (table[index] != null) {
            table[index].val = val;
            return;
        }

        // add new one
        table[index] = new KVNode<>(key, val);
        size++;
    }

    // delete
    public void remove(K key) {
        if (key == null) throw new IllegalArgumentException("Key is null");

        // resize with load factor 0.125
        if (size <= table.length / 8) {
            resize(table.length / 4);
        }

        int index = getKeyIndex(key);

        if (table[index] == null) {
            return;
        }

        table[index] = null;
        size--;

        //rehash
        index = (index + 1) % table.length;
        for (; table[index] != null; index = (index + 1) % table.length) {
            KVNode<K, V> entry = table[index];
            table[index] = null;
            size--;
            put(entry.key, entry.val);
        }
    }

    // search
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        int index = getKeyIndex(key);

        if (table[index] == null) {
            return null;
        }

        return table[index].val;
    }

    // return all keys
    public List<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (KVNode<K, V> entry : table) {
            if (entry != null) {
                keys.addLast(entry.key);
            }
        }
        return keys;
    }

    // =============================================================== //
    public int size() {
        return size;
    }

    // linear probing, return index
    // if is not exist, return next null index, used for add
    private int getKeyIndex(K key) {
        int index;
        for (index = hash(key); table[index] != null; index = (index + 1) % table.length) {
            if (table[index].key.equals(key)) {
                return index;
            }
        }
        return index;
    }

    // calculate hash value
    // [0, table.length - 1]
    private int hash(K key) {
        // int: 0000 0000 0000 ... 0000
        //    : 0111 1111 1111 ... 1111
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    private void resize(int newCap) {
        MyLinearProbingHashMap1<K, V> newMap = new MyLinearProbingHashMap1<>(newCap);
        for (KVNode<K, V> entry : table) {
            if (entry != null) {
                newMap.put(entry.key, entry.val);
            }
        }
        this.table = newMap.table;
    }
}
