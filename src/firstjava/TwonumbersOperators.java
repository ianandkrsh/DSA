package firstjava;

import java.util.*;
public class TwonumbersOperators {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers and operator + - * /");
        int a = sc.nextInt();
        int b = sc.nextInt();
        char ch = sc.next().charAt(0);

        switch(ch)
        {
            case '+' :
                           System.out.println(a+b);
                           break;

            case '-' :
                System.out.println(a-b);
                break;

            case '*' :
                System.out.println(a*b);
                break;

            case '/' :
                System.out.println(a/b);
                break;

            default :
                      System.out.println("Invalid Choice");

        }
    }
}
