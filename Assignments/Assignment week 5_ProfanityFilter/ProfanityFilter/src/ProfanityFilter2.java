import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProfanityFilter2 {
    public static void main(String[] args) {
        new ProfanityFilter2();
    }

    public ProfanityFilter2() {
        Map<String, String> swearMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        String[] swearWords = sc.nextLine().split(" ");
        for (String swearWord : swearWords) {
            swearMap.put(swearWord.toLowerCase(), "");
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            String separator = "";
            for (String word : words) {
                String word2;
                String punctuation;
                if (word.endsWith(".") || word.endsWith(",") || word.endsWith("!") || word.endsWith("?")) {
                    word2 = word.substring(0, word.length() - 1);
                    punctuation = word.substring(word.length() - 1);
                } else {
                    word2 = word;
                    punctuation = "";
                }
                StringBuilder replacement = new StringBuilder();
                if (swearMap.containsKey(word2.toLowerCase())) {
                    while (replacement.length() < word2.length()) {
                        replacement.append("*&#$%");
                    }
                    if (replacement.length() > word2.length()) {
                        replacement = new StringBuilder(replacement.substring(0, word2.length()));
                    }
                } else {
                    replacement = new StringBuilder(word2);
                }
                System.out.print(separator);
                System.out.print(replacement);
                System.out.print(punctuation);
                separator = " ";
            }
            System.out.print("\n");
        }
        sc.close();
    }
}

