import java.util.Set;
import java.util.HashSet;

class LinkedList{
    int val;
    LinkedList next; 

    LinkedList(int val){
        this.val = val;
    }
}

public class linkedlist{
    public static LinkedList head = null;
    
    public void insert(int val){
        LinkedList node = new LinkedList(val);
        if(head == null){
            node.next = null;
            head = node;
        }
        else{
            node.next = head;
            head = node;
        }
    }

    public void insertTail(int val){
        LinkedList node = new LinkedList(val);
        if(head == null){
            node.next = null;
            head = node;
        }
        else{
            LinkedList temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public void display(LinkedList head){
        if(head == null){
            System.out.println("Linked List is empty");
        }
        else{
            LinkedList temp = head;
            while(temp!=null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }
        System.out.println();
    }

    public LinkedList reverse(LinkedList dupHead){
        LinkedList nextAdd, present = dupHead, prev = null;
        while(present != null){
            nextAdd = present.next;

            present.next = prev;

            prev = present;
            present = nextAdd;
        }
        head = prev; //this thing is important bcz head was changed so regive the address of the linked list to head
        return prev;
    }

    public Boolean palindromCheck(LinkedList dupHead){
        LinkedList rev, fast = dupHead, slow = dupHead, prev = dupHead, anotherRev, start = dupHead;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(fast == null) rev = reverse(slow);
        else rev = reverse(slow.next);
        anotherRev = rev;
        boolean flag = true;
        while(rev!=null){
            if(rev.val != dupHead.val) {
                flag = false;
                break;
            }
            rev = rev.next;
            dupHead = dupHead.next;
        }

        rev = reverse(anotherRev);
        if(fast == null) prev.next = rev;
        else slow.next = rev;

        head = start;
        return flag? true:false;
    }

    public void printRec(LinkedList head){
        if(head == null) return;
        printRec(head.next);
        System.out.print(head.val + " ");
    }

    public void middle(LinkedList head){
        LinkedList slow = head, fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null){
            System.out.println("It is an even length linked list soo the printing second middle value and it is " + slow.val);
        }
        else{
            System.out.println("It is an odd length linked list soo the middle value " + slow.val);
        }
    }

    public void removeDupSortedList(LinkedList head){
        LinkedList cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
    }

    public void removeDupUnsortedList(LinkedList head){
        LinkedList cur = head, prev = head;
        Set<Integer> s = new HashSet<>();
        while(cur != null){
            if(s.contains(cur.val)){
                prev.next = cur.next;
            }
            else{
                s.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
    }

    public void makeLoop(LinkedList head){
        LinkedList forSecondvalue = head.next, temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = forSecondvalue;
    }
    public boolean detectLoop(LinkedList head){
        LinkedList fast = head, slow = head;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                System.out.println("Loop detected");
                System.out.println("And I am removing the loop, please wait...");
                return true;
            }
        }
        System.out.println("No loop detected");
        return false;
    }
    public void removeLoop(LinkedList head){
        LinkedList fast = head, slow = head;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
                System.out.println("Loop was removed from the linkedlist successfully!!!");
            }
        }
    }
    public void findIntersection(LinkedList head1, LinkedList head2){

        // ey listen you little shit..if you want to make me run, first make two linked lists and try connecting the last node of 2nd linkedlist to any node of the 1st linkedlist and then send me those two fucking linkedlists as parameters of my function. And just don't use your brain by sending me the only one linkedlist as both parameters of my function. But, anyway if i found that you are using your brain then i will just tell you that your linkedlists are having a intersection without using my brain by just seeing the first nodes of your linkedlists. DUH!!!

        LinkedList cur1 = head1, cur2 = head2;
        while(cur1!=cur2){
            if(cur1==null) cur1 = head2;
            else cur1 = cur1.next;
            if(cur2==null) cur2=head1;
            else cur2 = cur2.next;
        }
        if(cur1 == cur2){
            System.out.println("There's a intersection point at " + cur1.val);
        }
        else System.out.println("Can't find any intersection point between two linked lists. Sorry!!!");
    }

    public void OddEven(LinkedList head){
        LinkedList odd = head, even = head.next, startEven = even;
        while(odd.next!=null && even.next!=null){
            odd.next = even.next;
            if(odd.next!=null)odd = odd.next;
            even.next = odd.next;
            if(even.next!=null)even = even.next;
        }
        odd.next = startEven;
        // head = start;
    }

    public LinkedList merge(LinkedList h1, LinkedList h2){
        if(h1 == null || h2 == null){
            return h1==null ? h2:h1;
        }
        if(h1.val < h2.val){
            h1.next = merge(h1.next, h2);
            return h1;
        }
        else{
            h2.next = merge(h1, h2.next);
            return h2;  
        }
    }
    public LinkedList MergeSortList(LinkedList head){
        if(head == null || head.next==null) return head;

        LinkedList fast = head, slow = head, pre = slow, start = head;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        head = start;
        LinkedList h1 = MergeSortList(head);
        LinkedList h2 = MergeSortList(slow);
        return merge(h1, h2);
    }
    public static void main(String[] args) {
        linkedlist linkedlist = new linkedlist();
        // for(int i=10; i>0; i--){
            linkedlist.insertTail(7);
            linkedlist.insertTail(6);
            linkedlist.insertTail(2);
            linkedlist.insertTail(5);
            linkedlist.insertTail(4);
            linkedlist.insertTail(3);
            // linkedlist.insertTail(1);
        // }
        System.out.println("Linked List before making it reverse ");
        linkedlist.display(head);
        // System.out.println("\nLinked List after making it reverse ");
        // LinkedList ReversedList = linkedlist.reverse(head);
        // linkedlist.display(ReversedList);
        // System.out.println();
        // linkedlist.display(head);

        // linkedlist.printRec(head);
        // System.out.println( (linkedlist.palindromCheck(head) ? "Palindromic LinkedList":"Not a palindromic LinkedList"));
        // linkedlist.middle(head);
        // linkedlist.removeDupUnsortedList(head);

        // linkedlist.makeLoop(head);
        // if(linkedlist.detectLoop(head)){
        //     linkedlist.removeLoop(head);
        // }
        // linkedlist.OddEven(head);
        // linkedlist.MergeSortList(head);//it's not working
        linkedlist.display(head);
        // linkedlist.findIntersection(head, head); //before running this function atleast have a look at the implementation of this function for God's sake
    }
}