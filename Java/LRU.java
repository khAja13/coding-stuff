import java.util.*;

class Node {
    int key, value;
    Node left, right;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Mainer {
    int capacity;
    Node front = new Node(0, 0), back = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();

    public Mainer(int capacity) {
        this.capacity = capacity;
        front.right = back;
        back.left = front;
    }

    public void put(int key, int val) {
        if(map.containsKey(val)) {
            delete(map.get(val));
        }
        else if(map.size() == capacity) {
            delete(back.left);
        }
        insert(new Node(key, val));
    }

    public int get(int val) {
        if(map.containsKey(val)) {
            Node node = map.get(val);
            delete(node);
            insert(node);    
            return val;
        }
        return -1;
    }

    public void insert(Node node) {
        map.put(node.key, node);
        Node nextFront = front.right;
        front.right = node;
        node.left = front;
        node.right = nextFront;
        nextFront.left = node;
    }

    public void delete(Node node) {
        map.remove(node.key);
        node.left.right = node.right;
        node.right.left = node.left;
    }
}

public class LRU {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("what is the capacity?");
        int capacity = scan.nextInt();
        Mainer main = new Mainer(capacity);
        while(true) {
            System.out.println("1.Insert\t 2.Get\t");
            int choice = scan.nextInt();
            if(choice == 1) {
                System.out.println("Enter the key to put into the cache");
                int key = scan.nextInt();
                System.out.println("Enter the value to put into the cache");
                int val = scan.nextInt();
                main.put(key, val);
            }
            else if(choice == 2) {
                System.out.println("Enter the number to get from the cache");
                int val = scan.nextInt();
                System.out.println("Its value is " + main.get(val));
            }
            else break;
        }
    }
}