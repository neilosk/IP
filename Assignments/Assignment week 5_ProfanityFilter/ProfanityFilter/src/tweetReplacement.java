import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tweetReplacement {

    private List<String[]> tweet;
    private String[] punctuations;
    List<String> punctuationList;
    private Map<String, String> profanityCheck;

    public tweetReplacement(){
        tweet = new ArrayList<>();
        punctuations = ",.!?".split("");
        punctuationList = Arrays.asList(punctuations);
        profanityCheck = new HashMap<>();
    }
    

    public void tweetReplace() {


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
