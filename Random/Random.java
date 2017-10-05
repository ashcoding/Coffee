import java.util.HashSet;
import java.lang.Integer;
import java.util.Set;
import java.util.LinkedHashSet;

public class Random {
    public static void main(String[] args) {
        Set<Integer> hashset = new LinkedHashSet<Integer>();
        hashset.add(1);
        hashset.add(0);
        hashset.add(9);
        hashset.add(5);

        for (Integer x : hashset) {
            System.out.println(x);
        }

        // clear
        // isEmpty
        // size
        // remove
    }
}
