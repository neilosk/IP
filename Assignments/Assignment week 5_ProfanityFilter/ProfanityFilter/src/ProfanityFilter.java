
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class ProfanityFilter {

    public static void main(String[] args) {
        ProfanityFilter myTweet = new ProfanityFilter();
    }


    private String inputLine; // first string input with swares
    private String[] swearWords; // Array with the swear words

    private List<String[]> tweet = new ArrayList<>(); // ArrayList of each line of the tweet
    private String[] tweetWords; // Array of every word of each tweet Line
    private String[] punctuations = ",.!?".split(""); // Array with punctuations
    List<String> punctuationList = Arrays.asList(punctuations); // Returns the punctuations Arrays as List

    private Map<String, String> profanityCheck; // Map for swear and replacement words
    // private String swearReplacement; // Initilize replacement word

    public ProfanityFilter() {
        Scanner reader = new Scanner(System.in);

        inputLine = reader.nextLine();
        swearWords = inputLine.split(" "); // Assign swear words in Array from user input

        while (reader.hasNextLine()) { // Assign each line of the tweet to ArrayList
            String tweetLine = reader.nextLine();
            tweetWords = tweetLine.split(" ");
            tweet.add(tweetWords);
        }

        profanityCheck = new HashMap<>(); // Assign swear(K) and replacement(V) words to HashMap (K,V)

        for (String swear : swearWords) {
            swear = swear.toLowerCase(); // toLowerCase for comparison
            StringBuilder replacementBuilder = new StringBuilder(); //Create the swear replacement up to 16 chars
            while (replacementBuilder.length() < swear.length()) {
                        replacementBuilder.append("*&#$%");
                    }
            if (replacementBuilder.length() > swear.length()) {
            replacementBuilder = new StringBuilder(replacementBuilder.substring(0, swear.length()));
            }
            String swearReplacement = replacementBuilder.toString();
            profanityCheck.put(swear, swearReplacement);
        }

        reader.close();
        
            for (int i = 0; i < tweet.size(); i++) { // Loop for each line of the tweet
            String finalTweet = "";
            List<String> tweetBuild = new ArrayList<>(); // In order to build the tweet after word checking
            for (String word : tweet.get(i)) { // Loop for each word of the Line
                if (word.length() < 1) { // check if there is a word
                    tweetBuild.add(word);
                } else if (punctuationList.contains(word.substring(word.length() - 1))) { // Check if word ends with punctuation mark
                    String keepPunctuation = word.substring(word.length() - 1); // Keeping the punctuation at the end of the word
                    String keepWord = word.substring(0, word.length() - 1); // Keeping the word
                    if (profanityCheck.containsKey(keepWord.toLowerCase())) { // Check if the kept word if a swear word which is in lower case
                        word = profanityCheck.get(keepWord.toLowerCase()); // Replace if needed
                        word += keepPunctuation; // add punctuation mark
                        tweetBuild.add(word); // add the word to the tweet Line arrayList
                    } else {
                        tweetBuild.add(word); // if no formating is needed
                    }
                } else if (profanityCheck.containsKey(word.toLowerCase())) { // Since there is a word witout a punctionmark, checking that word
                    word = profanityCheck.get(word.toLowerCase());
                    tweetBuild.add(word);
                } else {
                    tweetBuild.add(word); // It is not a swear word
                }
            }
            System.out.println(finalTweet.join(" ", tweetBuild)); // Print each Word
        }

    }
}
    // public String swearReplacement(String swear) { // Replace swear with special Characters *&#%
    //     StringBuilder replacementBuilder = new StringBuilder(); //Create the swear replacement up to 16 chars
    //     while (replacementBuilder.length() < swear.length()) {
    //                     replacementBuilder.append("*&#$%");
    //                 }
    //     if (replacementBuilder.length() > swear.length()) {
    //         replacementBuilder = new StringBuilder(replacementBuilder.substring(0, swear.length()));
    //     }
    //     String swearReplacement = replacementBuilder.toString();
    //     return swearReplacement;
    // }

    // public void tweetReplace() {

    //     for (int i = 0; i < tweet.size(); i++) { // Loop for each line of the tweet
    //         String finalTweet = "";
    //         List<String> tweetBuild = new ArrayList<>(); // In order to build the tweet after word checking
    //         for (String word : tweet.get(i)) { // Loop for each word of the Line
    //             if (word.length() < 1) { // check if there is a word
    //                 tweetBuild.add(word);
    //             } else if (punctuationList.contains(word.substring(word.length() - 1))) { // Check if word ends with punctuation mark
    //                 String keepPunctuation = word.substring(word.length() - 1); // Keeping the punctuation at the end of the word
    //                 String keepWord = word.substring(0, word.length() - 1); // Keeping the word
    //                 if (profanityCheck.containsKey(keepWord.toLowerCase())) { // Check if the kept word if a swear word which is in lower case
    //                     word = profanityCheck.get(keepWord.toLowerCase()); // Replace if needed
    //                     word += keepPunctuation; // add punctuation mark
    //                     tweetBuild.add(word); // add the word to the tweet Line arrayList
    //                 } else {
    //                     tweetBuild.add(word); // if no formating is needed
    //                 }
    //             } else if (profanityCheck.containsKey(word.toLowerCase())) { // Since there is a word witout a punctionmark, checking that word
    //                 word = profanityCheck.get(word.toLowerCase());
    //                 tweetBuild.add(word);
    //             } else {
    //                 tweetBuild.add(word); // It is not a swear word
    //             }
    //         }
    //         System.out.println(finalTweet.join(" ", tweetBuild)); // Print each Word
    //     }
    // }

//     public static void main(String[] args) {
//         ProfanityFilter myTweet = new ProfanityFilter();
//         myTweet.tweetReplace();
//     }
// }
