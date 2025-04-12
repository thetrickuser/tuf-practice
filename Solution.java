import java.lang.*;
import java.math.BigInteger;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution sln = new Solution();
        String s = "himynameisslimshady";
        String t = "slimshadyhimynameis";
        boolean f = sln.anagramStrings(s,t);
        System.out.println(f);
    }

    public int secondMostFrequentElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE, secondMaxFreq = Integer.MIN_VALUE;
        for (int freq : map.values()) {
            if (freq > maxFreq) {
                secondMaxFreq = maxFreq;
                maxFreq = freq;
            } else if (freq > secondMaxFreq && freq < maxFreq) {
                secondMaxFreq = freq;
            }
        }

        int num = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == secondMaxFreq) {
                num = Math.min(num, entry.getKey());
            }
        }

        return num;
    }

    // public void reverseString(Vector<Character> s) {
    //     Collections.reverse(s);
    // }

    public boolean palindromeCheck(String s) {
        int l = s.length();
        for (int i=0; i<=l/2; i++) {
            if (s.charAt(i) != s.charAt(l-1-i)) return false;
        }

        return true;
    }

    public String largeOddNum(String s) {
        //your code goes here
        int l = s.length();
        for (int i=l-1; i>=0; i--) {
            int k = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (k % 2 == 1) return String.valueOf(new BigInteger(s.substring(0,i+1)));
        }

        return "";
    }

    public String longestCommonPrefix(String[] str) {
        //your code goes here
        int l = Integer.MAX_VALUE;
        for (String s: str) {
            int k = s.length();
            if (k < l) {
                l = k;
            }
        }

        int ls = str.length;
        for (int i=l; i>0; i--) {
            String sub = str[0].substring(0,i);
            boolean flag = true;
            for (int j=1; j<ls; j++) {
                if (!str[j].substring(0,i).equals(sub)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) return sub;
            else continue;
        }

        return "";
    }

    public boolean isomorphicString(String s, String t) {
        //your code goes here
        if (s.length() != t.length()) return false;
        Map<Character,Character> map = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();

        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (c2 != map.get(c1)) return false;
            } else {
                if (mapped.contains(c2)) return false;
                map.put(c1, c2);
                mapped.add(c2);
            }
        }

        return true;
    }

    public boolean rotateString(String s, String goal) {
        char goalFirstChar = goal.charAt(0);
        List<Integer> indices = new ArrayList<>();

        int k = s.length();

        for (int i=0; i<k; i++) {
            if (s.charAt(i) == goalFirstChar) {
                indices.add(i);
            }
        }

        boolean isRotated = true;

        for (int i=0; i<indices.size(); i++) {
            for (int j=0; j<k; j++) {
                if (goal.charAt(j) != s.charAt((indices.get(i)+j) % k)) {
                    isRotated = false;
                    break;
                } else {
                    isRotated = true;
                }
            }

            if (isRotated) break;
        }

        return isRotated;
    }

    public boolean anagramStrings(String s, String t) {
        //your code goes here
        if (s.length() != t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }

        for (char c: t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c)-1);
        }

        for (int i: map.values()) {
            if (i != 0) return false;
        }

        return true;
    }

    public Vector<Character> reverseString(Vector<Character> s) {
        //your code goes here
        reverseHelper(s, 0, s.size() - 1);
        return s;
    }

    private void reverseHelper(Vector<Character> s, int left, int right) {
        if (left >= right) return;
        char temp = s.get(left);
        s.set(left, s.get(right));
        s.set(right, temp);
    }

    public boolean isSorted(ArrayList<Integer> nums) {
        //your code goes here
        if (nums.size() == 1) return true;
        if (nums.get(0) > nums.get(1)) return false;
        return isSorted(new ArrayList<>(nums.subList(1, nums.size())));
    }


}


