// Даны два Deque, представляющие два целых числа.
// Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
// Одно или два числа могут быть отрицательными.
// Даны два Deque, цифры в обратном порядке.
// [3,2,1,-] - пример Deque
// [5,4,3]- пример второго Deque
// 1) -123 * 345 = -42 435
// Ответ всегда - связный список, в обычном порядке
// [-,4,2,4,3,5] - пример ответа
import java.util.ArrayDeque;
import java.util.Deque;
public class task1 {
    public static void main(String[] args) {
        Deque<Integer> num1 = new ArrayDeque<>();
        num1.add(3);
        num1.add(2);
        num1.add(1);
        num1.add(-1);

        Deque<Integer> num2 = new ArrayDeque<>();
        num2.add(5);
        num2.add(4);
        num2.add(3);

        Calculator calc = new Calculator();

        Deque<Integer> product = calc.multiply(num1, num2);
        System.out.println("Product: " + product); // Output: Product: [-, 4, 2, 4, 3, 5]

        Deque<Integer> sum = calc.add(num1, num2);
        System.out.println("Sum: " + sum); // Output: Sum: [8, 6, 4, 3, 5]
    }
}