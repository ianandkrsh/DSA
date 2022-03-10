package firstjava;

import java.util.*;
public class LargestNumber {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a>b)
            System.out.println(a);
        else if(b>a)
            System.out.println(b);
        else
            System.out.println("Both are Equal");

    }
}
