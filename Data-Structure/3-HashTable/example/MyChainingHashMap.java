import java.util.LinkedList;

class MyChainingHashMap {

    // inner static class store key-value
    static class KVNode{
        int key;
        int value;

        public KVNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<KVNode>[] table;

    public MyChainingHashMap(int capacity) {
        table = new LinkedList[capacity];
    }

    // calculator hash value
    private int hash(int key){
        return key % table.length;
    }

    // search
    public int get(int key) {
        int index = hash(key);
        if (table[index] == null) {
            // linked list is null
            return -1;
        }
        LinkedList<KVNode> list = table[index];
        //go through every element
        for (KVNode node : list) {
            if (node.key == key) {
                return node.value;
            }
        }
        //not exist the key
        return -1;
    }

    // add or update
    public void  put(int key, int value){
        int index = hash(key);

        if(table[index] == null){
            //linked list is null, create a new one store the key-value
            table[index] = new LinkedList<>();
            table[index].add(new KVNode(key,value));
            return;
        }

        // check if not null, go through to check if exist
        // if exist, then update the value
        LinkedList<KVNode> list = table[index];
        for (KVNode node : list) {
            if(node.key == key){
                node.value = value;
                return;
            }
        }

        // if not exist, then add new one
        list.add(new KVNode(key,value));
    }

    // delete
    public void remove(int key){
        LinkedList<KVNode> list = table[hash(key)];
        if(list == null){
            return;
        }
        // if exist, then delete
        list.removeIf(node -> node.key == key);
    }
}