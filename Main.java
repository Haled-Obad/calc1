import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] parts;
        String operand;

        if (str.contains(" + ")) {
            parts = str.split(" \\+ ");
            operand = "+";
        } else if (str.contains(" - ")) {
            parts = str.split(" - ");
            operand = "-";
        } else if (str.contains(" * ")) {
            parts = str.split(" \\* ");
            operand = "*";
        } else if (str.contains(" / ")) {
            parts = str.split(" / ");
            operand = "/";
        } else {
            throw new Exception("Некорректный знак действия");
        }

        String operand1 = parts[0].replaceAll("\"", "");
        String operation = operand;
        String operand2 = parts[1].replaceAll("\"", "");


        String result = calculate(operand1, operation, operand2);
        System.out.println("\"" + cutString(result, 40) + "\"");
    }


    private static String calculate(String operand1, String operation, String operand2) {
        switch (operation) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1.replaceFirst(operand2, "");
            case "*":
                int num1 = Integer.parseInt(operand2);
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < num1; i++) {
                    result.append(operand1);
                }
                return result.toString();
            case "/":
                int num2 = Integer.parseInt(operand2);
                int length = operand1.length() / num2;
                return operand1.substring(0, length);
            default:
                throw new IllegalArgumentException("Неверная операция " + operation);
        }
    }

    private static String cutString(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        } else {
            return str.substring(0, maxLength) + "...";
        }
    }
}