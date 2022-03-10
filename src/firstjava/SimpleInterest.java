package firstjava;

import java.util.*;
public class SimpleInterest {
    public static void main(String args[])
    {
        double p , r,t;
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter principal amount :");
        p = sc.nextDouble();
        System.out.print("Enter rate of interest:");
        r = sc.nextDouble();
        System.out.print("Enter time of period in year:");
        t = sc.nextDouble();

        double si = (p*r*t)/100;
        System.out.println("Simple Interest :" +si);

    }
}
