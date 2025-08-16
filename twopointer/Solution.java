package twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
//        Solution sln = new Solution();
//        int[] cardScore = {5,4,1,8,7,1,3};
//        int k = 3;
//        System.out.println(sln.maxScore(cardScore, k)); // Output: 12

//        String s = "abcddabac";
//        Solution sln = new Solution();
//        System.out.println(sln.longestNonRepeatingSubstring(s)); // Output: 3

//        String s = "aababbcaacc";
//        int k = 2;
//        Solution sln = new Solution();
//        System.out.println(sln.kDistinctChar(s, k)); // Output: 5

//        String s = "BAABAABBBAAA";
//        int k = 1;
//        Solution sln = new Solution();
//        System.out.println(sln.characterReplacement(s, k)); // Output: 4

//        String t = "ABC";
//        String s = "ADOBECODEBANC";
//        Solution sln = new Solution();
//        System.out.println(sln.minWindow(s, t)); // Output: "ABsd"

        String s = "ccabcc";
        Solution sln = new Solution();
        System.out.println(sln.numberOfSubstrings(s)); // Output: 9
    }
    public int maxScore(int[] cardScore, int k) {
        //your code goes here
        int n = cardScore.length;

        int maxSum = 0;
        int l = 0, r = 0;
        int i = 0;

        int sum = 0;
        while (i < k) {
            sum += cardScore[i];
            maxSum = Math.max(maxSum, sum);
            r++;
            i++;
        }

        r--;

        i = 0;
        while (i < k) {
            if (r == -1) r = n-1;
            
            sum -= cardScore[r];
            r--;
            l--;
            if (l == -1) l = n-1;
            sum += cardScore[l];

            maxSum = Math.max(maxSum, sum);
            i++;
        } 

        
        return maxSum;
    }

    public int longestNonRepeatingSubstring(String s) {
        //your code goes here
        Map<Character, Integer> present = new HashMap<>();

        int l = 0, r = 0;
        int n = s.length();
        int maxLength = 0;

        while (r < n) {
            char c = s.charAt(r);
            if (!present.containsKey(c)) {
                present.put(c,r);
            } else {
                int idx = present.get(c);
                l = idx + 1;
                present.clear();
                present.put(c, r);
            }
            r++;
            maxLength = Math.max(maxLength, r-l);
        }

        return maxLength;
    }

    public int kDistinctChar(String s, int k) {
        //your code goes here
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;

        int n = s.length();
        int maxLen = 0;

        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            r++;

            if (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }

            if (map.size() <= k) {
                maxLen = Math.max(maxLen, r-l);
            }

        }

        return maxLen;
    }

    public int characterReplacement(String s, int k) {
        //your code goes here
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;

        int n = s.length();
        int maxLen = 0;
        int maxFreq = 0;
        int windowSize = 0;

        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            r++;
            windowSize = r - l;

            if (windowSize - maxFreq <= k) {
                maxLen = Math.max(maxLen, windowSize);
            } else {
                while (windowSize - maxFreq > k) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                    maxFreq = map.values().stream().max(Integer::compare).get();
                    windowSize = r - l;
                }
            }
        }

        return maxLen;
    }

    public String minWindow(String s, String t) {
        //your code goes here
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int n = s.length();

        int l = 0, r = 0;
        int m = t.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = 0;

        while (r < n) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                    count++;
                } else {
                    map.put(c, map.get(c) - 1);
                }
            } else {
                map.put(c, -1);
            }

            while (count == m) {
                minLen = Math.min(minLen, r-l+1);
                startIndex = l;
                char c2 = s.charAt(l);

                if (map.get(c2) < 0) {
                    map.put(c2, map.get(c2) + 1);
                    l++;
                } else {
                    count--;
                }
            }
            r++;
        }

        Optional<Integer> any = map.values().stream().filter(v -> v > 0).findAny();
        if (any.isPresent()) {
            return "";
        }
        return s.substring(startIndex, startIndex+minLen);
    }

    public int numberOfSubstrings(String s) {
        //your code goes here
        Map<Character, Integer> freq = new HashMap<>();

        int n = s.length();
        int l = 0, r = 0;
        int count = 0;

        while (r < n) {
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (l <= r && freq.size() == 3) {
                count += (n - r);
                char c2 = s.charAt(l);
                freq.put(c2, freq.get(c2) - 1);
                l++;
                if (freq.get(c2) == 0) freq.remove(c2);
            }
            r++;
        }

        return count;

    }
}