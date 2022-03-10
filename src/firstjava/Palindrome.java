package firstjava;

import java.util.*;
public class Palindrome {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter a String :");
        String str = sc.next();
        String str1 ="";
        for (int i = str.length()-1;i>=0;i--)
        {
            char ch = str.charAt(i);
            str1 =  str1 + ch;
        }

        if(str.equals(str1))
            System.out.print("Palindrome ");
        else
            System.out.print("Not a Palindrome ");

    }
}
