package firstjava;

import java.util.*;
public class Dollar {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter currency in rupees :");
        double rupees = sc.nextDouble();
        double dollar = 0.013*rupees;
                System.out.println("Equivalent in USD " + dollar);
    }
}
