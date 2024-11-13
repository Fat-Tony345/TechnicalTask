import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        input = input.replaceAll(" ", "");

        char operator = ' ';
        int num1 = 0;
        int num2 = 0;
        int operatorIndex = -1;
        int operatorCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '+' || current == '-' || current == '*' || current == '/') {
                operator = current;
                operatorIndex = i;
                operatorCount++;
            }
        }

        if (operatorCount != 1) {
            throw new IllegalArgumentException("Ввод должен содержать один оператор!");
        }

        if (operatorIndex != -1) {
            num1 = Integer.parseInt(input.substring(0, operatorIndex));
            num2 = Integer.parseInt(input.substring(operatorIndex + 1));
        }

        if (num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1) {
            throw new IllegalArgumentException("Значение операнда должно быть от 1 до 10!");
        }

        int result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            result = num1 / num2;
        } else {
            throw new IllegalArgumentException("Введите корректный оператор!");
        }

        return String.valueOf(result);
    }
}
