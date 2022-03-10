package firstjava;

import java.util.*;
public class Armstrong {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers :");
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = a; i<=b; i++)
        {
            if(arm(i))
                System.out.println(i);
        }

    }

    static boolean arm(int num)
    {
        int n = num;
        int sum =0;
        while(n>0)
        {
            int r = n%10;
            sum = sum + (int)(Math.pow(r,3));
            n = n/10;
        }

        if(num==sum)
            return true;
        else
            return false;
    }

}
