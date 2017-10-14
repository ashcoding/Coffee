import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.lang.Character;
import java.util.Arrays;
import java.util.Map;

public class Qn03 {
    public static void main(String[] args) {
        // Question from https://www.careercup.com/question?id=5724734743379968
        List<String> list = createSample();
        HashMap<String, LinkedList<String>> map = listWordsWithSameCharSet(list);

        for (Map.Entry<String, LinkedList<String>> pair : map.entrySet()) {
            LinkedList<String> listy = pair.getValue();
            for (String ans : listy) {
                System.out.print(ans + ", ");
            }
            System.out.println();
        }
    }

    public static HashMap<String, LinkedList<String>> listWordsWithSameCharSet(List<String> list) {
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

        for (int i = 0; i < list.size(); i++) {
            String keyString = getKey(list.get(i));
            //System.out.println(Arrays.toString(hashset.toArray()));
            LinkedList<String> val = map.get(keyString);
            if (val == null) {
                val = new LinkedList<String>();
            }
            val.add(list.get(i));
            map.put(keyString, val);
        }

        return map;
    }

    public static String getKey(String in) {
        String check = in.toLowerCase();
        HashSet<Character> hashset = new HashSet<Character>();
        for (char c : check.toCharArray()) {
            hashset.add(c);
        }
        StringBuilder build = new StringBuilder();
        for (Character c : hashset) {
            build.append(c);
        }
        return build.toString();
    }

    public static List<String> createSample() {
        List<String> list = new LinkedList<String>();
        list.add("May");
        list.add("student");
        list.add("students");
        list.add("dog");
        list.add("studentssess");
        list.add("god");
        list.add("Cat");
        list.add("act");
        list.add("tab");
        list.add("bat");
        list.add("flow");
        list.add("wolf");
        list.add("Amy");
        list.add("Yam");
        list.add("balms");
        list.add("lambs");
        list.add("looped");
        list.add("poodle");
        list.add("john");
        list.add("alice");
        return list;
    }
}
