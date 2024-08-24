import java.util.LinkedList;
import java.util.List;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 22/08/2024 14:35
 * @Description :
 */
class MyLinearProbingHashMap2<K, V> {

    private static class KVNode<k, V> {
        K key;
        V val;

        public KVNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // placeholder deleting
    private final KVNode<K, V> DUMMY = new KVNode<>(null, null);
    // array table store K-V
    private KVNode<K, V>[] table;
    // amount
    private int size;
    // init capacity
    private static final int INIT_CAP = 4;

    public MyLinearProbingHashMap2() {
        this(INIT_CAP);
    }

    public MyLinearProbingHashMap2(int cap) {
        size = 0;
        table = (KVNode<K, V>[]) new KVNode[cap];
    }

    // add / update
    public void put(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        // load factor = 0.75
        if (size >= table.length * 0.75) {
            resize(table.length * 2);
        }
        int index = getKeyIndex(key);
        if (index != -1) {
            table[index].val = val;
            return;
        }
        KVNode<K, V> x = new KVNode<>(key, val);
        //
        index = hash(key);
        while (table[index] != null && table[index] != DUMMY) {
            index = (index + 1) % table.length;
        }
        table[index] = x;
        size++;
    }

    // delete
    public void remove(K key){
        if(key == null){
            throw new IllegalArgumentException("Key is null");
        }
        //resize
        if(size < table.length / 8){
            resize(table.length  / 2);
        }
        int index = getKeyIndex(key);
        if(index == -1){
            return;
        }
        table[index] = DUMMY;
        size--;
    }

    //search
    public V get(K key){
        if(key == null){
            throw new IllegalArgumentException("Key is null");
        }
        int index = getKeyIndex(key);
        if (index == -1) {
            return null;
        }
        return table[index].val;
    }

    // return all keys
    public List<K> keys(){
        LinkedList<K> keys = new LinkedList<>();
        for (KVNode<K, V> entry : table) {
            if (entry != null){
                keys.addLast(entry.key);
            }
        }
        return keys;
    }

    // ======================================================
    public int size(){
        return size;
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    private void resize(int cap ){
        MyLinearProbingHashMap2<K, V> newMap = new MyLinearProbingHashMap2<>(cap);
        for (KVNode<K, V> entry : table) {
            if(entry != null && entry != DUMMY){
                newMap.put(entry.key, entry.val);
            }
        }
        this.table = newMap.table;
    }

    private int getKeyIndex(K key){
        int step = 0;
        for (int i = hash(key); table[i] != null; i = (i+1)% table.length) {
            KVNode<K,V> entry = table[i];
            //
            if(entry == DUMMY){
                continue;
            }
            if(entry.key.equals(key)){
                return i;
            }
            step ++ ;
            if(step == table.length){
                resize(table.length);
                return -1;
            }
        }
        return -1;
    }
}
