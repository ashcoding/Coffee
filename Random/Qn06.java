public class Qn06 {
    public static void main(String[] args) {
        String one = "abc";

        String resultOne = makePalindrome(one);
        System.out.println(one + " - " + resultOne);

    }

    public static String makePalindrome(String in) {
        // Palindrome, we can only have max 1 odd
        int[] table = new int[26];
        int len = in.length();
        for (int i = 0; i < in.length(); i++) {
            char x = in.charAt(i);
            table[x-'a']++;
        }

        int oddCount = 0;
        int oddLetter = -1;

        for (int i = 0; i < 26; i++) {
            if (table[i] % 2 != 0) {
                if (oddCount == 0) {
                    oddCount++;
                    oddLetter = i;
                } else {
                    table[i]--;
                    len--;
                }
            }
        }

        StringBuilder out = new StringBuilder();
        if (oddCount > 0) {
            out.append((char) (oddLetter + 'a'));
            table[oddLetter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (table[i] != 0) {
                table[i]--;
                table[i]--;
                char x = (char) (i + 'a');
                out.append(x);
                out.insert(0, x);
            }
        }

        return out.toString();
    }
    /*
    'aha' -> 'aha'
    'ttaatta' -> ' ttaaatt'
    'abc' -> 'a' or 'b' or 'c'
    'gggaaa' -> 'gaaag' or 'aggga'
    */

    // https://www.careercup.com/question?id=5631060781039616
}
