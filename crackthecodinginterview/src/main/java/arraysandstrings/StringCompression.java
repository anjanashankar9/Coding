package arraysandstrings;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class StringCompression {
    private String compress(String input) {
        StringBuffer s = new StringBuffer();
        char[] characterArray = input.toCharArray();
        char prev = characterArray[0];
        s.append(prev);
        int count = 1;
        for(int i=1; i< input.length(); i++) {
            char curr = characterArray[i];
            if (curr == prev) {
                count++;
            }
            else {
                s.append(count);
                count = 1;
                s.append(curr);
            }
            prev = curr;
        }
        s.append(count);

        return s.toString().length() < input.length() ? s.toString() : input;
    }
    public static void stringCompression(String[] args) {
        String s1 = "aabcccccaaa";
        System.out.println(new StringCompression().compress(s1));
    }
}

/*
Implement a method to perform basic string compression using the counts of
repeated characters. For example, the string aabcccccaaa
would become a2blc5a3. If the "compressed" string would not become smaller
than the original string, your method should return
the original string.
You can assume the string has only uppercase and lowercase letters (a - z).
 */