import java.util.LinkedList;
import java.util.List;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 21/08/2024 20:30
 * @Description : implemented a example of hashmap with General(K key, V value)
 */
class ExampleChainingHashMap<K, V> {

    // using Linked list to store Key-Value
    private static class KVNode<K, V> {
        K key;
        V value;

        public KVNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // each element in the array is a linked list
    // each node is a key-value
    private LinkedList<KVNode<K, V>>[] table;

    // size
    private int size;
    // initial capacity
    private static final int INIT_CAP = 4;

    public ExampleChainingHashMap() {
        this(INIT_CAP);
    }

    public ExampleChainingHashMap(int initCapacity) {
        size = 0;
        // keep at least one element, make sure % operation not error
        initCapacity = Math.max(initCapacity, 1);
        // init hashtable
        table = (LinkedList<KVNode<K, V>>[]) new LinkedList[initCapacity];

        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // add & update
    public void put(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        // if key is exist, then update the value
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                node.value = val;
                return;
            }
        }

        // if key is not exist, then add new one, count++
        list.add(new KVNode<>(key, val));
        size++;

        // if the amount of the list is more than Multiple, then resize to size*2
        if (size >= table.length * 0.75) {
            resize(table.length * 2);
        }
    }

    // delete
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        //if exist, then delete
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                list.remove(node);
                size--;

                //resize
                if (size <= table.length / 8) {
                    resize(table.length / 4);
                }
                return;
            }
        }
    }

    // search
    // return with val of key, if not exist, then return null
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    // return all keys
    public List<K> keys() {
        List<K> keys = new LinkedList<>();
        for (LinkedList<KVNode<K, V>> list : table) {
            for (KVNode<K, V> node : list) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    // return size
    public int size() {
        return size;
    }

    // resize the table
    private void resize(int newCap) {
        // construct a new hashMap
        // get rid of error of " % with 0"
        newCap = Math.max(newCap, 1);
        ExampleChainingHashMap<K, V> newMap = new ExampleChainingHashMap<>(newCap);
        // relocate all element to new hashmap
        for (LinkedList<KVNode<K, V>> list : table) {
            for (KVNode<K, V> node : list) {
                newMap.put(node.key, node.value);
            }
        }
        this.table = newMap.table;
    }

    // calculate hash value
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }
}
