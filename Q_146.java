import java.util.*;





class LRUCache {

    HashMap<Integer, Node> map;
    int capacity, count;
    Node head, tail;

    public LRUCache(int capacity) {

        //build a double linklist to save the data
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;

    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void AddtoHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            AddtoHead(node);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            AddtoHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                AddtoHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                AddtoHead(node);
            }
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */