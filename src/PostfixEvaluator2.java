import java.util.Scanner;
import java.util.Stack;
//>>>>>>>>>>>>>>>>>>>>>>>>>>************<<<<<<<<<<<<<<<<<<<<<<
//   Q5.  Implement a program that can input an expression in postfix notation (see Exercise C-6.19) and output its value
public class PostfixEvaluator2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String expression = scanner.nextLine();

        int result = evaluatePostfix(expression);

        System.out.println("Result: " + result);
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (String token : expression.split(" ")) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    private static int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

