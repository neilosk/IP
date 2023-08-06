import java.util.regex.*;
import java.util.Scanner;

public class PepTalk {

    public static void pepTranslate(String s){
    Pattern syllable = Pattern.compile("(?<Consonants>[a-zA-Z&&[^aeiouAEIOU]]*)(?<oneVowel>[aeiouAEIOU])(?=(?<LAConsonants>[a-z&&[^aeiou]]*)(?<LAVowels>[aeiouAEIOU]*))");
    Pattern vowel = Pattern.compile("[aeiouAEIOU]");
    Matcher m = syllable.matcher(s);
    String pepWord = "";

    boolean wordStarts = true;
    boolean wordEnds = false;

    while(m.find()){
        String buildSyllable = "";
        int ConsonantsLength = m.group("Consonants").length();
        int LAConsonantsLength = m.group("LAConsonants").length();

        if(wordStarts && m.group("LAVowels").isEmpty()){
            buildSyllable = m.group("Consonants") + m.group("oneVowel") + m.group("LAConsonants");
            wordEnds = true;
        }else if(wordStarts){
            buildSyllable = m.group("Consonants");
            buildSyllable += m.group("oneVowel");
            buildSyllable += m.group("LAConsonants").substring(0, LAConsonantsLength/2);
            wordStarts = false;
            wordEnds = false;
        }else if(m.group("LAVowels").isEmpty()){
            buildSyllable = m.group("Consonants").substring(ConsonantsLength/2);
            buildSyllable += m.group("oneVowel");
            buildSyllable += m.group("LAConsonants");
            wordStarts = true;
            wordEnds = true;
        }else{
            buildSyllable = m.group("Consonants").substring(ConsonantsLength/2);
            buildSyllable += m.group("oneVowel");
            buildSyllable += m.group("LAConsonants").substring(0, LAConsonantsLength/2);
            wordStarts = false;
            wordEnds = false;
        }

        if(vowel.matcher(buildSyllable.substring(0,1)).matches()){
            buildSyllable += "p" + buildSyllable.toLowerCase();
            if(wordEnds) buildSyllable += " ";
        }else{
            buildSyllable +=buildSyllable.replaceFirst("[a-zA-Z&&[^aeiouAEIOU]]*", "p");
            if(wordEnds) buildSyllable += " ";
        }
        pepWord += buildSyllable;
    }
    System.out.println(pepWord);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        PepTalk.pepTranslate(s);
    }
}
