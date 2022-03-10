package Functions;

import java.util.*;
public class OddEven {
    public static void main(String args[]) {
        int[] n = {9,9,9,9,9,9,9,9,9,9};
        int k = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list = addToArrayForm( n, k);
        System.out.println(list);


    }

    public static ArrayList<Integer> addToArrayForm(int[] num, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum = sum * 10 + num[i];
        }
        sum = sum + k;

        while (sum > 0) {
            int r = sum % 10;
            list.add(r);
            sum = sum / 10;

        }

        Collections.reverse(list);

        return list;
    }


}
