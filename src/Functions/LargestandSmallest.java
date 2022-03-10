package Functions;

import java.util.*;
public class LargestandSmallest {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int largest = (a>b)?(a>c?a:c):(b>c?b:c);
        int smallest = (a>b)?(b>c?c:b):(a>c?c:a);

        System.out.println(largest);
        System.out.println(smallest);
    }
}
