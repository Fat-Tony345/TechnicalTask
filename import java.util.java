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

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '+' || current == '-' || current == '*' || current == '/') {
                operator = current;
                operatorIndex = i;
                break;
            }
        }

        if (operatorIndex != -1) {
            num1 = Integer.parseInt(input.substring(0, operatorIndex));
            num2 = Integer.parseInt(input.substring(operatorIndex + 1));
        }

        if (num1 > 10 || num2 > 10) {
            throw new IllegalArgumentException("Максимальное значение операнда - 10!");
        }

        int result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                throw new IllegalArgumentException("Делить на ноль нельзя!!!");
            }
        } else {
            throw new IllegalArgumentException("Введите корректный оператор!");
        }

        return String.valueOf(result);
    }
}
