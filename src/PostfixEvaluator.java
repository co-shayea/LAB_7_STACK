public class PostfixEvaluator {
// >>>>>>>>>>>>>>>>>>>>>>>>>******<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    Q3.  Postfix notation is an unambiguous way of writing an arithmetic expression without parentheses.
//    It is defined so that if “(exp1)op(exp2)” is a normal fully parenthesized expression whose operation
//    is op, the postfix version of this is “pexp1 pexp2 op”, where pexp1 is the postfix version of exp1
//    and pexp2 is the postfix version of exp2. The postfix version of a single number or variable
//    is just that number or variable. So, for example, the postfix version
//    of “((5 + 2) ∗ (8 − 3))/4” is “5 2 + 8 3 − ∗ 4 /”. Describe a nonrecursive way of evaluating an expression in postfix notation.
    public static int evaluatePostfix(String postfixExpression) {
        StackClass<Integer> stack = new StackClass<>();
        for (String token : postfixExpression.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "5 2 + 8 3 - * 4 /";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("نتيجة التعبير: " + result);

    }
}
