package Functions;

import java.util.*;
public class Factorial {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
        System.out.println(n);
    }

    static int fact(int n)
    {
        if(n==0)
            return 1;
        return n *fact(n-1);
    }
}
