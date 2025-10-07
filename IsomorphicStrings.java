import java.util.HashMap;
import java.util.HashSet;

/**
 * Leet Code : https://leetcode.com/problems/isomorphic-strings/description/
 * This class provides methods to determine if two strings are isomorphic.
 *  Determines if two strings s and t are isomorphic.
 *      * Two strings are isomorphic if the characters in s can be replaced to get t,
 */
class IsomorphicStrings {

    /**
     * This method uses two hash maps to track the mapping from s to t and t to s.
     * For each character position, it checks if the mapping is consistent in both directions.
     * If any inconsistency is found, it returns false. Otherwise, it returns true.
     *
     * Example:
     *   s = "egg", t = "add" => true (e->a, g->d)
     *   s = "foo", t = "bar" => false
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        // If lengths differ, they cannot be isomorphic
        if (s.length() != t.length()) return false;

        // Iterate through each character in the strings
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // Check if sChar has already been mapped
            if (sMap.containsKey(sChar)) {
                // If mapped value does not match tChar, not isomorphic
                if (sMap.get(sChar) != tChar) return false;
            } else {
                // Create new mapping from sChar to tChar
                sMap.put(sChar, tChar);
            }

            // Check if tChar has already been mapped
            if (tMap.containsKey(tChar)) {
                // If mapped value does not match sChar, not isomorphic
                if (tMap.get(tChar) != sChar) return false;
            } else {
                // Create new mapping from tChar to sChar
                tMap.put(tChar, sChar);
            }
        }

        // All checks passed, strings are isomorphic
        return true;

    }

    /**
     * Alternative implementation to determine if two strings are isomorphic.
     * Uses a HashMap for s->t mapping and a HashSet to track already mapped characters in t.
     */
    public boolean isIsomorphic2(String s, String t) {

        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> tSet = new HashSet<>();

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) return false;
            }else {
                if(tSet.contains(tChar)) return  false;
                sMap.put(sChar, tChar);
                tSet.add(tChar);
            }
        }

        return true;

    }
}