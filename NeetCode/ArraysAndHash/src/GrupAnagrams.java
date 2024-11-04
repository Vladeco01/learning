import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GrupAnagrams {
    public static void main(String[] args) {
        String[] str = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalList = new ArrayList<>();
        HashMap<String, List<String>> anagramWords = new HashMap<>();

        // Loop through all strings
        for (int i = 0; i < strs.length; i++) {
            String sortedWord = sortString(strs[i]); // Sort the word to use as the key

            // If the sorted word is not in the map, create a new list
            if (!anagramWords.containsKey(sortedWord)) {
                anagramWords.put(sortedWord, new ArrayList<>());
            }

            // Add the original word to the list corresponding to the sorted word
            anagramWords.get(sortedWord).add(strs[i]);
        }

        // Convert the map's values (which are lists of anagrams) into a List<List<String>>
        return new ArrayList<>(anagramWords.values());
    }


    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }
}