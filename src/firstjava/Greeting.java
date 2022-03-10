package firstjava;

import java.util.*;
public class Greeting {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name :");
        String str = sc.next();
        System.out.println("Hey, "+str +" !");
    }
}
