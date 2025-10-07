import java.math.BigInteger;
import java.util.*;

/**
 * Leet Code : https://leetcode.com/problems/group-anagrams/
 * Solution for LeetCode 49: Group Anagrams.
 * Groups a list of strings into anagram groups using two approaches:
 * 1. Sorting each string and using the sorted string as a key.
 * 2. Using the product of prime numbers mapped to each character as a unique hash key.
 */
class GroupAnagrams {

    // Array of first 26 prime numbers, one for each lowercase English letter
    private static final int[] PRIMES = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
        43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
    };

    /**
     * Groups anagrams by sorting each string and using the sorted string as a key.
     * Time Complexity: O(N*K*logK), where N = number of strings, K = max string length.
     *   - Sorting each string takes O(K*logK), repeated for N strings.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map from sorted string to list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // Sort characters to form key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            // Add string to corresponding anagram group
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }
        // Return all anagram groups
        return new ArrayList<>(map.values());
    }

    /**
     * Groups anagrams using the product of prime numbers as a unique hash for each group.
     * Time Complexity: O(N*K), where N = number of strings, K = max string length.
     *   - Calculating the prime product for each string is O(K), repeated for N strings.
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<BigInteger, List<String>> map = new HashMap<>();
        for (String str : strs) {
            BigInteger hash = getPrimeProduct(str);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * Calculates the product of primes for the characters in the string.
     * Each character is mapped to a unique prime number.
     * Time Complexity: O(K), where K = length of the string.
     */
    public BigInteger getPrimeProduct(String s){
        char[] chars = s.toCharArray();
        BigInteger hash = BigInteger.ONE;
        for(char c : chars){
            hash = hash.multiply(BigInteger.valueOf(PRIMES[c - 'a']));
        }
        return hash;
    }

}