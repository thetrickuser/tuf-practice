/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */
public class SumOfDigitsRecursive {
    public static void main(String[] args) {
        int num = 23743297;
        System.out.println(new SumOfDigitsRecursive().addDigits(num));
    }

    public int addDigits(int num) {
        int newNum = additionHelper(num);
        if (newNum / 10 != 0) return addDigits(newNum);
        return newNum;
    }

    private int additionHelper(int num) {
        if (num == 0) return 0;
        return num % 10 + additionHelper(num / 10);
    }
}
