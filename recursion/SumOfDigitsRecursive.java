/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */

void main() {
    int num = 23743297;
    System.out.println(addDigits(num));
}

public int addDigits(int num) {
    int newNum = additionHelper(num);
    if (newNum / 10 != 0) return addDigits(newNum);
    return newNum;
}

int additionHelper(int num) {
    if (num == 0) return 0;
    return num % 10 + additionHelper(num / 10);
}
