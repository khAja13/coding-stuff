import java.util.*;
import java.util.LinkedList;

class del {
    int data;
    del left;
    del right;

    del(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class vertical {
    int vertOrder;
    del node;

    vertical(int vertOrder, del node) {
        this.vertOrder = vertOrder;
        this.node = node;
    }
}

public class trees {
    del head = null, head2 = null;

    public void insert(int data) {
        del node = new del(data);
        if (head == null) {
            head = node;
        } else {
            del temp = head;
            while (true) {
                if (temp.data > node.data) {
                    if (temp.left == null) {
                        temp.left = node;
                        break;
                    }
                    temp = temp.left;
                } else if (temp.data < node.data) {
                    if (temp.right == null) {
                        temp.right = node;
                        break;
                    }
                    temp = temp.right;
                }
            }
        }
    }

    public void insert2(int data) {
        del node = new del(data);
        if (head2 == null)
            head2 = node;
        else {
            Queue<del> q = new LinkedList<>();
            q.add(head2);

            while (!q.isEmpty()) {
                del top = q.remove();
                if (top.left != null) {
                    q.add(top.left);
                } else {
                    top.left = node;
                    return;
                }
                if (top.right != null) {
                    q.add(top.right);
                } else {
                    top.right = node;
                    return;
                }
            }
        }
    }

    public void levelOrder(del head) {
        if (head == null)
            return;
        else {
            Queue<del> q = new LinkedList<>();
            q.add(head);
            while (!q.isEmpty()) {
                del node = q.poll();
                System.out.print(node.data + " ");
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            System.out.println();
        }
    }

    public void iterativePreOrder(del head) {
        Stack<del> s = new Stack<>();
        s.push(head);
        while (!s.empty()) {
            del node = s.pop();
            System.out.print(node.data + " ");
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
        System.out.println();
    }

    public void iterativeInorder(del head) {
        Stack<del> s = new Stack<>();
        del node = head;
        while (true) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                if (s.isEmpty())
                    break;
                node = s.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
        System.out.println();
    }

    public int height(del head) {
        if (head == null)
            return 0;

        int left = height(head.left);
        int right = height(head.right);

        return Math.max(left, right) + 1;
    }

    public int isBalanced(del head) {
        if (head == null)
            return 0;

        int left = isBalanced(head.left);
        if (left == -1)
            return -1;
        int right = isBalanced(head.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public int diameter(del head) {
        int[] max = new int[1];
        dia(head, max);
        return max[0];
    }

    public int dia(del head, int[] max) {
        if (head == null)
            return 0;

        int left = dia(head.left, max);
        int right = dia(head.right, max);
        max[0] = Math.max(max[0], left + right);

        return Math.max(left, right) + 1;
    }

    public int maxGo(del head) {
        int maxNum[] = new int[1];
        maxNum[0] = Integer.MIN_VALUE;
        maxPath(head, maxNum);
        return maxNum[0];
    }

    public int maxPath(del head, int[] maxNum) {
        if (head == null)
            return 0;

        // for left and right -- to handle negatives
        int left = Math.max(0, maxPath(head.left, maxNum));
        int right = Math.max(0, maxPath(head.right, maxNum));

        maxNum[0] = Math.max(maxNum[0], left + right + head.data);

        return (head.data) + Math.max(left, right);
    }

    public void zigzag(del head) {
        if (head == null)
            return;

        Queue<del> q = new LinkedList<>();
        Vector<Vector<Integer>> V = new Vector<>();
        boolean flag = true;
        q.add(head);

        while (!q.isEmpty()) {
            Vector<Integer> v = new Vector<>();
            int size = q.size();
            v.setSize(size);

            for (int i = 0; i < size; ++i) {
                del top = q.remove();

                int index = flag ? i : (size - i - 1);

                v.add(index, top.data);
                if (top.left != null)
                    q.add(top.left);
                if (top.right != null)
                    q.add(top.right);
            }
            flag = !flag;
            V.add(v);
        }

        System.out.println("ZigZag traversal is");
        for (Vector<Integer> i : V) {
            for (Integer j : i) {
                if (j != null)
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void verticalOrderTraversal(del head) {
        if (head == null)
            return;

        TreeMap<Integer, List<Integer>> hp = new TreeMap<>();
        Queue<vertical> q = new LinkedList<>();

        q.add(new vertical(0, head));
        while (!q.isEmpty()) {
            vertical top = q.remove();
            int level = top.vertOrder;
            del node = top.node;

            if (hp.containsKey(level)) {
                hp.get(level).add(node.data);
            } else {
                List<Integer> a = new ArrayList<Integer>();
                a.add(node.data);
                hp.put(level, a);
            }

            if (node.left != null) {
                q.add(new vertical(level - 1, node.left));
            }
            if (node.right != null) {
                q.add(new vertical(level + 1, node.right));
            }
        }
        System.out.println("The vertical order is");
        for (Map.Entry<Integer, List<Integer>> entry : hp.entrySet()) {
            System.out.print(entry.getKey() + " ");
            for (int i = 0; i < entry.getValue().size(); ++i) {
                System.out.print(entry.getValue().get(i) + " ");
            }
            System.out.println();
        }
    }

    public void topView(del head) {
        if (head == null)
            return;
        Queue<vertical> q = new LinkedList<>();
        TreeMap<Integer, Integer> hp = new TreeMap<>();
        q.add(new vertical(0, head));
        System.out.print("Top view is ");

        while (!q.isEmpty()) {
            vertical top = q.remove();
            int index = top.vertOrder;
            del node = top.node;

            if (hp.get(index) == null)
                hp.put(index, node.data);
            if (node.left != null)
                q.add(new vertical(index - 1, node.left));
            if (node.right != null)
                q.add(new vertical(index + 1, node.right));
        }
        System.out.print(hp.values());
        System.out.print(hp.keySet());
    }

    public void bottomView(del head) {
        if (head == null)
            return;
        Queue<vertical> q = new LinkedList<>();
        Map<Integer, Integer> hp = new TreeMap<>();
        q.add(new vertical(0, head));
        System.out.print("\nBottom view is ");

        while (!q.isEmpty()) {
            vertical top = q.remove();
            int index = top.vertOrder;
            del node = top.node;

            hp.put(index, node.data);
            if (node.left != null)
                q.add(new vertical(index - 1, node.left));
            if (node.right != null)
                q.add(new vertical(index + 1, node.right));
        }

        System.out.print(hp.values());
        System.out.println(hp.keySet());
    }

    public void leftView(del head) {
        if (head == null)
            return;
        List<Integer> l = new ArrayList<>();
        leftSide(head, l, 0);
        System.out.println("Left view is " + l);
    }

    public void leftSide(del head, List<Integer> l, int level) {
        if (head == null)
            return;
        System.out.println("the size of the list is " + l.size() + " and value is " + head.data);
        if (level == l.size())
            l.add(head.data);
        leftSide(head.left, l, level + 1);
        leftSide(head.right, l, level + 1);
    }

    public void rightView(del head) {
        if (head == null)
            return;
        List<Integer> l = new ArrayList<>();
        rightSide(head, l, 0);
        System.out.println("Right view is " + l);
    }

    public void rightSide(del head, List<Integer> l, int level) {
        if (head == null)
            return;
        if (level == l.size())
            l.add(head.data);
        rightSide(head.right, l, level + 1);
        rightSide(head.left, l, level + 1);
    }

    public void symmetric(del head) {
        if (head == null)
            return;
        if (isSymmetric(head.left, head.right))
            System.out.println("It is symmetric tree");
        else
            System.out.println("It isn't symmetric tree");
    }

    public boolean isSymmetric(del one, del two) {
        if (one == null || two == null)
            return one == two;
        if (one.data != two.data)
            return false;
        return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
    }

    public void rootToNode(del head, int dest) {
        if (head == null)
            return;
        Stack<Integer> s = new Stack<>();
        path(head, s, dest);
        if (s.size() == 0)
            System.out.println("No path found");
        else {
            // I can use ArrayList but I didn't bcz it was giving some senseless error and I
            // didn't liked that. So that's why I made it complicated.
            Vector<Integer> v = new Vector<>();
            while (!s.isEmpty()) {
                v.add(s.pop());
            }
            Collections.reverse(v);
            System.out.println(v);
        }
    }

    public boolean path(del head, Stack<Integer> s, int dest) {
        if (head == null)
            return false;

        s.push(head.data);
        if (head.data == dest) {
            return true;
        }
        if (path(head.left, s, dest) || path(head.right, s, dest))
            return true;

        s.pop();
        return false;
    }

    public int LCA(del head, int a, int b) {
        if (head == null)
            return 0;
        if (head.data == a || head.data == b)
            return head.data;

        int left = LCA(head.left, a, b);
        int right = LCA(head.right, a, b);

        if (left == 0)
            return right;
        else if (right == 0)
            return left;
        else
            return head.data;
    }

    public int getLevel(del head, int key, int level) {
        if (head == null)
            return 0;
        if (head.data == key)
            return level;

        return getLevel(head.left, key, level + 1) | getLevel(head.right, key, level + 1);
    }

    public String serialize(del head) {
        if (head == null)
            return "";
        String txt = "";
        Queue<del> q = new LinkedList<>();
        q.add(head);

        while (!q.isEmpty()) {
            del top = q.remove();

            if (top != null) {
                txt += (top.data + ",");
                q.add(top.left);
                q.add(top.right);
            } else {
                txt += ("#" + ",");
            }
        }
        System.out.println("\nSerialize text is " + txt);
        return txt;
    }

    public del deSerialize(String txt) {
        if (txt == "")
            return null;
        Queue<del> q = new LinkedList<>();
        String[] arr = txt.split(",");
        del head2 = new del(Integer.parseInt(arr[0]));
        q.add(head2);
        for (int i = 1; i < arr.length; ++i) {
            del top = q.poll();
            if (!arr[i].equals("#")) {
                del left = new del(Integer.parseInt(arr[i]));
                top.left = left;
                q.add(left);
            }
            if (!arr[++i].equals("#")) {
                del right = new del(Integer.parseInt(arr[i]));
                top.right = right;
                q.add(right);
            }
        }
        return head2;
    }

    public boolean identicalTrees(del one, del two) {
        if (one == null && two == null)
            return true;
        if (one == null || two == null)
            return false;
        return (one.data == two.data) && identicalTrees(one.left, two.left) && identicalTrees(one.right, two.right);
    }

    // this works if the values of tree doesn't have duplicates.
    public boolean isBST(del head, int min, int max) {
        if (head == null)
            return true;

        if (head.data < min || max < head.data) {
            return false;
        }

        return isBST(head.left, min, head.data) && isBST(head.right, head.data, max);
    }

    public void searchNode(del head, int data) {
        if (head == null)
            return;
        Queue<del> q = new LinkedList<>();
        q.add(head);
        while (!q.isEmpty()) {
            del top = q.remove();
            if (top.data == data) {
                System.out.println("Data found in the tree");
                return;
            } else if (top.data < data) {
                if (top.right != null)
                    q.add(top.right);
            } else {
                if (top.left != null)
                    q.add(top.left);
            }
        }
        System.out.println("Data not found..:(");
    }

    del prev = null;

    public del flattenToLL(del head) {
        if (head == null)
            return null;
        flattenToLL(head.right);
        flattenToLL(head.left);

        head.right = prev;
        head.left = null;
        prev = head;
        return head;
    }

    public void displayLL(del head) {
        if (head == null)
            return;
        System.out.println("LinkedList elements are");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    static int preIndex = 0;

    public del TreePreInorder(int pre[], int in[], Map<Integer, Integer> map, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        del newNode = new del(pre[preIndex++]);
        if (inStart == inEnd)
            return newNode;
        int inIndex = map.get(newNode.data);
        newNode.left = TreePreInorder(pre, in, map, inStart, inIndex - 1);
        newNode.right = TreePreInorder(pre, in, map, inIndex + 1, inEnd);
        return newNode;
    }

    public static void main(String[] args) {
        trees obj = new trees();
        Scanner scan = new Scanner(System.in);

        System.out.println("Wanna create a BST or....?!?!?(y/n)");
        char choice = scan.next().charAt(0);
        if (choice == 'n') {
            while (true) {
                int val = scan.nextInt();
                if (val == 0)
                    break;
                else {
                    obj.insert2(val);
                }
            }
            obj.head = obj.head2;
        }
        while (true && choice == 'y') {
            int val = scan.nextInt();
            if (val == 0)
                break;
            else {
                obj.insert(val);
            }
        }
        System.out.print("Level Order is ");
        obj.levelOrder(obj.head);
        System.out.print("Pre order is ");
        obj.iterativePreOrder(obj.head);
        System.out.print("Inorder is ");
        obj.iterativeInorder(obj.head);
        int height = obj.height(obj.head);
        System.out.println("Height of the tree is " + height);
        System.out.println("Diamter of the tree is " + obj.diameter(obj.head));
        int check = obj.isBalanced(obj.head);
        if (check != -1)
            System.out.println("It is a balanced tree");
        else
            System.out.println("It is not a balanced tree");
        System.out.println("Maximum path sum is " + obj.maxGo(obj.head));
        obj.zigzag(obj.head);
        obj.verticalOrderTraversal(obj.head);
        obj.topView(obj.head);
        obj.bottomView(obj.head);
        obj.leftView(obj.head);
        obj.rightView(obj.head);
        obj.symmetric(obj.head);
        System.out.println("Enter the node value to get the path from root to that node");
        int dest = scan.nextInt();
        obj.rootToNode(obj.head, dest);
        System.out.println("Enter the src and dst to find LCA");
        int src = scan.nextInt();
        int dst = scan.nextInt();
        System.out.println("LCA of " + src + " and " + dst + " is " +
                obj.LCA(obj.head, src, dst));
        System.out.println("Enter the value to find out the level ");
        int key = scan.nextInt();
        System.out.print("It's level is " + obj.getLevel(obj.head, key, 0));
        String txt = obj.serialize(obj.head);
        del head2 = obj.deSerialize(txt);
        if (obj.identicalTrees(obj.head, head2)) {
            System.out.println("The tree which obtained from deserialize is correct.");
        } else {
            System.out.println("Not identical");
        }
        if (obj.isBST(obj.head, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("It is a BST");
        } else
            System.out.println("Not a BST");
        if (choice == 'y') {
            System.out.println("Wanna search any node?(y/n)");
            char c = scan.next().charAt(0);
            if (c == 'y') {
                System.out.println("Enter the node to search");
                int data = scan.nextInt();
                obj.searchNode(obj.head, data);
            }
        }
        del LL = obj.flattenToLL(obj.head);
        System.out.println("BST is converted to singly LinkedList.");
        obj.displayLL(LL);

        System.out.println("\nHow many nodes in a tree");
        int n = scan.nextInt();
        System.out.println("Enter the preorder traversal of a tree");
        int pre[] = new int[n];
        for (int i = 0; i < n; ++i)
            pre[i] = scan.nextInt();
        System.out.println("Enter the inorder traversal of a tree");
        int in[] = new int[n];
        for (int i = 0; i < n; ++i)
            in[i] = scan.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i)
            map.put(in[i], i);
        del newHead = obj.TreePreInorder(pre, in, map, 0, n - 1);
        System.out.println("PreOrder and Inorder's are");
        obj.iterativePreOrder(newHead);
        obj.iterativeInorder(newHead);

        scan.close();
    }
}