package Queue;

import java.util.*;
public class Insert {
    public static void main(String args[])
    {
       Queue<Integer> q = new LinkedList<Integer>();
       q.add(5);
        q.add(1);
        q.add(3);
        q.add(4);
        q.add(2);
//The poll() method of Queue Interface returns and removes the element at the front end of the container.
// It deletes the element in the container.
// The method does not throws an exception when the Queue is empty, it returns null instead.
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
        System.out.println(q.isEmpty());
        q.remove();
        q.remove();  q.remove();  q.remove();
        System.out.println(q.isEmpty());
    }

}
