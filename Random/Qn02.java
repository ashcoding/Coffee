import java.util.Deque;
import java.util.ArrayDeque;

public class Qn02 {
    public static void main(String[] args) {
        String one = "Converse";
        String two = "Conserve";
        // true
        System.out.println(isMeta(one,two));

        String three = "Converse";
        String four = "Conserev";
        // false
        System.out.println(isMeta(three,four));
    }

    public static boolean isMeta(String one, String two) {
        int len = one.length();
        if (len != two.length()) return false;
        int count = 0;
        Deque<Character> dequeA = new ArrayDeque<Character>();
        Deque<Character> dequeB = new ArrayDeque<Character>();

        for (int i = 0; i < len; i++) {
            if (one.charAt(i) != two.charAt(i)) {
                switch (count) {
                    case 0:
                        count++;
                        dequeA.push(one.charAt(i));
                        dequeB.push(two.charAt(i));
                        break;
                    case 1:
                        count++;
                        char a = dequeA.pop();
                        char b = dequeB.pop();
                        if (one.charAt(i) != b) return false;
                        if (two.charAt(i) != a) return false;
                        break;
                    case 2:
                    default:
                        return false;
                }
            }
        }
        return true;
    }

    //https://www.careercup.com/question?id=6247626241474560
}
