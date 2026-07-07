/**
 * Given an input string as an array of characters, write a function that reverses the string.
 */
import java.util.ArrayList;

public class ReverseString {
    public static void main(String[] args) {
        ArrayList<Character> s = new ArrayList<>();
        s.add('h');
        s.add('e');
        s.add('l');
        s.add('l');
        s.add('o');
        var res = new ReverseString().reverseString(s);
        System.out.println(res);
    }

    public ArrayList<Character> reverseString(ArrayList<Character> s) {
        reverseHelper(s, 0, s.size() - 1);
        return s;
    }

    private void reverseHelper(ArrayList<Character> s, int left, int right) {
        if (left >= right) return;

        Character c = s.get(right);
        s.set(right, s.get(left));
        s.set(left, c);

        reverseHelper(s, left + 1, right - 1);
    }
}


