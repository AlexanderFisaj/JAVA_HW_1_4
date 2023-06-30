import java.util.ArrayDeque;
import java.util.Deque;
public class Calculator {
    public static Deque<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        int sign = 1;
        if (num1.peekLast() < 0 && num2.peekLast() >= 0 || num1.peekLast() >= 0 && num2.peekLast() < 0) {
            sign = -1;
        }

        num1.removeLast();
        num2.removeLast();

        Deque<Integer> result = new ArrayDeque<>();
        result.add(0);

        for (int digit1 : num1) {
            int carry = 0;
            Deque<Integer> tempResult = new ArrayDeque<>();

            for (int digit2 : num2) {
                int product = (digit1 * digit2) + carry;
                tempResult.add(product % 10);
                carry = product / 10;
            }

            if (carry > 0) {
                tempResult.add(carry);
            }

            addZeros(result, 1);
            addZeros(tempResult, 0);
            result = add(result, tempResult);
        }

        if (sign == -1) {
            result.addFirst(0);
            result.addFirst(-1);
        }

        return result;
    }

    public static Deque<Integer> add(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> result = new ArrayDeque<>();

        int carry = 0;
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int sum = carry;

            if (!num1.isEmpty()) {
                sum += num1.removeFirst();
            }

            if (!num2.isEmpty()) {
                sum += num2.removeFirst();
            }

            result.add(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            result.add(carry);
        }

        return result;
    }

    public static void addZeros(Deque<Integer> num, int count) {
        for (int i = 0; i < count; i++) {
            num.addFirst(0);
        }
    }
}