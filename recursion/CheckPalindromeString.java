/**
 * Given a string s, return true if the string is palindrome, otherwise false.
 * A string is called palindrome if it reads the same forward and backward.
 */

void main() {
    String s = "aab";
    System.out.println(checkPalindrome(s));
}

boolean checkPalindrome(String s) {
    return checkPalindromeHelper(s, 0, s.length() - 1);
}

private boolean checkPalindromeHelper(String s, int left, int right) {
    if (left >= right) return true;

    if (s.charAt(left) != s.charAt(right)) return false;
    return checkPalindromeHelper(s, left + 1, right - 1);
}
