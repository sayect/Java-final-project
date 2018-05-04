import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PostFixNotation {
	public static String postFixGenerator(double result, int threshold, Double... requiredNumbers) {

        double answer;
        int operatorLimit = requiredNumbers.length - 1;
        int length = requiredNumbers.length + operatorLimit; // required length
        String expression;

        Stack<Double> shuffledNumbers = new Stack<>();
        int attempts = 0;
        do {
            // reset required fields
            expression = "";
            shuffledNumbers.clear();
            shuffledNumbers.addAll(Arrays.asList(requiredNumbers));
            Collections.shuffle(shuffledNumbers);

            int tracker = 0;
            int operatorCount = 0;
            int count = 0;

            while (count < length) {
                if (shuffledNumbers.empty()) { // check if operator is required
                    expression += getOperator() + " ";
                    tracker -= 2;
                } else if (operatorCount == operatorLimit || tracker - 2 < 0) { // check if an operand is required
                    expression += shuffledNumbers.pop() + " ";
                    tracker++;
                } else if ((int) (Math.random() * 2) == 1) { // add operand
                    expression += shuffledNumbers.pop() + " ";
                    tracker++;
                } else {
                    expression += getOperator() + " "; // add operator
                    tracker -= 1;
                }
                count++;
            }

            answer = evaluateExpression(expression);

            attempts++;
        } while (answer != result && attempts < threshold);

        if (answer == result)
            return expression;
        else
            return "No Solution";
    }
	
	private static String getOperator() {
        String[] expressionOperators = new String[]{"*", "/", "+", "-"};
        return expressionOperators[(int) (Math.random() * expressionOperators.length)];
    }
	
	public static double evaluateExpression(String postFixExpression) {

        String[] expression = postFixExpression.split("\\s+");

        Stack<Double> postfix = new Stack<>();
        for (String token : expression) {
            if (arithmeticOperator(token)) {
                evaluate(postfix, token);
            } else {
                postfix.push(Double.parseDouble(token));
            }
        }

        return postfix.pop();
    }
	
	private static void evaluate(Stack<Double> postFix, String operator) {
        evaluate(postFix, operator.trim().charAt(0));
    }
	
	private static void evaluate(Stack<Double> postFix, char operator) {
        double num1 = postFix.pop();
        double num2 = postFix.pop();
        switch (operator) {
            case '+':
                postFix.push(num1 + num2); break;
            case '-':
                postFix.push(num1 - num2); break;
            case '/':
                postFix.push(num1 / num2); break;
            case '*':
                postFix.push(num1 * num2); break;
            default:
            	Alert error = new Alert(AlertType.ERROR);
                error.setHeaderText("Error!");
                String s1 = "Invalid Operator" + operator;
                error.setContentText(s1);
                error.showAndWait();
        }
    }
	
	private static boolean arithmeticOperator(char ch) {
        
		return (ch == '/' ||
                ch == '+' ||
                ch == '-' ||
                ch == '*');
    }
	
	private static boolean arithmeticOperator(String operator) {
        return arithmeticOperator(operator.trim().charAt(0));
    }
	
	private static boolean isOperator(char ch) {
        return arithmeticOperator(ch) ||
                ch == '(' ||
                ch == ')';
    }
	
	private static boolean isOperator(String operator) {
        return isOperator(operator.trim().charAt(0));
    }
	
	public static double evaluateInfix(String infixExpression) {
        String postfix = convertToPostfix(infixExpression);
        return evaluateExpression(postfix);
    }

    public static String convertToInfix(String postfixExpression) {
        String[] symbols = postfixExpression.split("\\s+");

        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList(symbols));

        for (String symbol : symbols) {
            if (arithmeticOperator(symbol)) {

                // Invalid input
                if (stack.size() < 2) { System.out.println("ERROR"); break; }

                String num2 = stack.pop();
                String num1 = stack.pop();

                stack.push("(" + num1 +" "+ symbol +" "+ num2 + ")");
            } else {
                stack.push(symbol); // is an operand
            }
        }

        String expression = stack.pop();
        // remove extra outer parenthesis, then return infix expression
        return expression.substring(1, expression.length() - 1);
    }

    public static String convertToPostfix(String infixExpression) {

        String[] tokens = infixExpression.split("\\s+");

        Stack<String> stackOperators = new Stack<>();
        String infixString = "";

        for (String token : tokens) {

            if (isOperator(token)) {
                if (stackOperators.empty() || token.equals("(")) {
                    stackOperators.push(token);

                } else if (token.equals(")")) {
                    while (!stackOperators.peek().equals("(")) {
                        infixString += stackOperators.pop() + " ";
                    }
                    stackOperators.pop(); // pop "("
                } else {

                    int topValue = opValue(stackOperators.peek());
                    int current = opValue(token);

                    if (current > topValue) {
                        stackOperators.push(token);
                    } else if (current == topValue) {
                        infixString += stackOperators.pop() + " ";
                        stackOperators.push(token);
                    } else {

                        while (!stackOperators.empty() &&
                                !stackOperators.peek().equals("(") &&
                                current <= opValue(stackOperators.peek())) {

                            infixString += stackOperators.pop() + " ";
                        }
                        stackOperators.push(token);
                    }
                }
            } else {
                infixString += token + " ";
            }
        }


        while (!stackOperators.empty()) {
            infixString += stackOperators.pop() + " ";
        }

        return infixString;
    }
    
    private static int opValue(char operator) {

        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 3;
        }
    }

    private static int opValue(String operator) {
        return opValue(operator.trim().charAt(0));
    }
    
    public static double safeInfixEvaluation(String infixExpression) throws RuntimeException {

        StringBuilder sb = new StringBuilder();

        String operators = "()-+*/";

        // Check for syntax errors. Only only operators and numbers are allowed (including floating points '.')
        // Numbers with spaces in-between will be merged,
        // Example (9 3 + 3) * 2, the string will be read as ( 93 + 3 ) * 2
        for (char ch : infixExpression.toCharArray()) {

            if (ch == ' ') continue; // ignore white space
            if (Character.isAlphabetic(ch)) // no letters
                throw new RuntimeException("No characters allowed");

            if (operators.indexOf(ch) >= 0)
                sb.append(" ").append(ch).append(" ");
            else if (Character.isDigit(ch) || ch == '.')
                sb.append(ch);
            else
                throw new RuntimeException("Invalid character! " + ch);
        }

        // Check if parenthesis overlap
        Stack<String> opStack = new Stack<>();
        String[] symbols = sb.toString().trim().split("\\s+");
        System.out.println(Arrays.toString(symbols));
        for (String symbol : symbols) {
            if (symbol.equals("(")) {
                opStack.push(symbol);
            } else if (symbol.equals(")")) {
                if (opStack.empty())
                    throw new RuntimeException("ERROR: Expected a '(' before ')'");
                else
                    opStack.pop(); // pop (
            }
        }
        if (opStack.size() > 0)
            throw new RuntimeException("Invalid number of parenthesis");

        return evaluateInfix(sb.toString().trim());
    
}
}