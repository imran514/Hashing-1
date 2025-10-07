import java.util.HashMap;
import java.util.HashSet;

/**
 * Leet Code : https://leetcode.com/problems/word-pattern/submissions/1794613733/
 * This class provides a method to check if a string follows a given pattern.
 * Each character in the pattern should map to a unique word in the string and vice versa.
 */
class WordPattern{

    /**
     * Checks if the string s follows the same pattern as the given pattern string.
     * Uses a HashMap to map pattern characters to words and a HashSet to ensure unique mapping.
     */
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> patternMap = new HashMap<>();
        HashSet<String> tSet = new HashSet<>();

        String[] strs = s.split( " ");
        // If lengths differ, cannot match pattern
        if (pattern.length() != strs.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char sChar = pattern.charAt(i);
            String tString = strs[i];
            // If character already mapped, check for consistency
            if (patternMap.containsKey(sChar)) {
                if (!patternMap.get(sChar).equals(tString)) return false;
            }else {
                // If word already mapped to another character, return false
                if(tSet.contains(tString)) return  false;
                patternMap.put(sChar, tString);
                tSet.add(tString);
            }
        }

        return true;
    }

}