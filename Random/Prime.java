import java.util.*;
import java.lang.Math;

public class Prime {
    public static void main(String[] args) {
        List list = trialDivision(1000);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
    }

    public static List<Integer> trialDivision(int n) {
        List<Integer> list = new LinkedList<Integer>();
        if (n < 2) return list;
        list.add(2);

        for (int i = 3; i <= n; i++) {
            // Logic here
            int check = 1;
            for (int j = 0; j < list.size(); j++) {
                check *= i % list.get(j);
                if (check == 0) break;
            }
            if (check != 0) {
                list.add(i);
            }
        }
        return list;
    }

    /*  Additional notes
        Please see:
        1) https://en.wikipedia.org/wiki/Trial_division
        2) https://en.wikipedia.org/wiki/Prime_number
        3) https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    */
}
