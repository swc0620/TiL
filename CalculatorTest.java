import java.io.*;
import java.util.Stack;

public class CalculatorTest
{
	static int error = 0;

	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true)
		{
			try
			{
				String input = br.readLine();
				if (input.compareTo("q") == 0)
					break;

				command(input);
			}
			catch (Exception e)
			{
				System.out.println("입력이 잘못되었습니다. 오류 : " + e.toString());
			}
		}
	}

	private static void command(String input_a)
	{
		String input = input_a.replaceAll("\\p{Z}", "").replaceAll("[\\t]", "");
		String input_b = input_a.replaceAll("\\s{2,}", " ").replaceAll("\\t+", " ");

		// sort out error cases caused by consecutive numbers
		for (int i = 0; i < input_b.length(); i++){
			if (i != input_b.length() - 1 && i != 0 && input_b.charAt(i) == ' '){
				if (input_b.charAt(i-1) >= '0' && input_b.charAt(i-1) <= '9' && input_b.charAt(i+1) >= '0' && input_b.charAt(i+1) <= '9'){
					error = 1;
					break;
				}
			}
		}

		// convert input string into array
		char[] expression = new char[input.length()];
		for (int i = 0; i < input.length(); i++){
			expression[i] = input.charAt(i);
		}


		// sort out error cases caused by unbalanced parenthesis
		if (!areParenthesisBalanced(expression)){
			error = 1;			
		}

		// check if '-' is binary minus or unary minus, and switch it to the corresponding one.
		if (error == 0){
			for (int i = 0; i < expression.length; i++){
				if (expression[i] == '-'){
					if (i == 0){
						expression[i] = '~';
					} else {
						expression[i] = unary_or_binary_minus(expression[i-1]);
					}
				}
			}
		}

		// sort out error cases
		if (error == 0){
			for (int i = 0; i < expression.length; i++){
				if (i != 0){
					if (expression[i] == '0' && expression[i-1] == '/'){
						error = 1;
						break;
					} 
					if (expression[i] == '0' && expression[i-1] == '%'){
						error = 1;
						break;
					}
				}
				if (i != expression.length - 2 && i != expression.length - 1){
					if (expression[i] == '0' && expression[i+1] == '^' && expression[i+2] == '-'){
						error = 1;
						break;
					}	
				}
				if (expression[i] == '-'){
					if (expression[i+1] != '0' && expression[i+1] != '1' && expression[i+1] != '2' && expression[i+1] != '3' && expression[i+1] != '4' && expression[i+1] != '5' && expression[i+1] != '6' && expression[i+1] != '7' && expression[i+1] != '8' && expression[i+1] != '9' && expression[i+1] != '(' && expression[i+1] != '~'){
						error = 1;
						break;
					}
				}
				if (i != 0 && i != expression.length - 1){
					if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/' || expression[i] == '%' || expression[i] == '^'){
						if (expression[i-1] != '0' && expression[i-1] != '1' && expression[i-1] != '2' && expression[i-1] != '3' && expression[i-1] != '4' && expression[i-1] != '5' && expression[i-1] != '6' && expression[i-1] != '7' && expression[i-1] != '8' && expression[i-1] != '9' && expression[i-1] != ')'){
							error = 1;
							break;
						}
						if (expression[i+1] != '0' && expression[i+1] != '1' && expression[i+1] != '2' && expression[i+1] != '3' && expression[i+1] != '4' && expression[i+1] != '5' && expression[i+1] != '6' && expression[i+1] != '7' && expression[i+1] != '8' && expression[i+1] != '9' && expression[i+1] != '(' && expression[i+1] != '~'){
							error = 1;
							break;
						}
					}
				}
			}
		}
		

		Stack<Character> operator_stack = new Stack<Character>();
		String postfix = "";

		if (error == 0){
			for (int i = 0; i < expression.length; i++){
				// if expression[i] is operand
				if (expression[i] != '+' && expression[i] != '-' && expression[i] != '*' && expression[i] != '/' && expression[i] != '%' && expression[i] != '^' && expression[i] != '~' && expression[i] != '(' && expression[i] != ')'){
					postfix += expression[i];
					if (i != expression.length - 1){
						if (expression[i+1] == '+' || expression[i+1] == '-' || expression[i+1] == '*' || expression[i+1] == '/' || expression[i+1] == '%' || expression[i+1] == '^' || expression[i+1] == '~' || expression[i+1] == '(' || expression[i+1] == ')'){
							postfix += " ";
						}
					} else {
						postfix += " ";
					}
				}

				// if if expression[i] is opening parenthesis
				else if (expression[i] == '('){
					operator_stack.push(expression[i]);
				}
				else if (expression[i] == ')'){
					while (!operator_stack.isEmpty() && operator_stack.peek() != '('){
						postfix += operator_stack.pop();
						postfix += " ";
					}
					operator_stack.pop();
				}
				// if expression[i] is operator			
				else {
					while (!operator_stack.isEmpty() && operator_stack.peek() != '('){
						if (check_priority(expression[i], operator_stack.peek())){
							postfix += operator_stack.pop();
							postfix += " ";
						} else {
							break;
						}
					}
					operator_stack.push(expression[i]);
				} 			
			}
			while (!operator_stack.isEmpty()){
				postfix += operator_stack.pop();
				postfix += " ";
			}
			postfix.trim();
		}

		long result = calculate(postfix);

		if (error == 0){
			postfix = postfix.trim();
			System.out.print(postfix);
			System.out.print("\n");
			System.out.print(result);
			System.out.print("\n");
		} else {
			// System.out.print("&&&");
			System.out.println("ERROR");
			error = 0;
			// System.out.println("&&&");
		}
		
	}

	private static char unary_or_binary_minus(char pre_minus){
		// if minus sign is preceded by a digit or closing parenthesis, it is binary minus
		if (pre_minus == ')' || pre_minus == '0' || pre_minus == '1' || pre_minus == '2' || pre_minus == '3' || pre_minus == '4' || pre_minus == '5' || pre_minus == '6' || pre_minus == '7' || pre_minus == '8' || pre_minus == '9'){
			return '-';
		} else {
			return '~';
		}
	}

	private static boolean check_priority(char expression_operator, char stack_operator){
		int expression_operator_priority;
		int stack_operator_priority;
		
		// check the priority of expression_operator
		if (expression_operator == '+' || expression_operator == '-'){
			expression_operator_priority = 5;
		} else if (expression_operator == '*' || expression_operator == '/' || expression_operator == '%'){
			expression_operator_priority = 4;
		} else if (expression_operator == '~'){
			expression_operator_priority = 3;
		} else if (expression_operator == '^'){
			expression_operator_priority = 2;
		} else {
			expression_operator_priority = 1;
		}

		// check the priority of stack_operator
		if (stack_operator == '+' || stack_operator == '-'){
			stack_operator_priority = 5;
		} else if (stack_operator == '*' || stack_operator == '/' || stack_operator == '%'){
			stack_operator_priority = 4;
		} else if (stack_operator == '~'){
			stack_operator_priority = 3;
		} else if (stack_operator == '^'){
			stack_operator_priority = 2;
		} else {
			stack_operator_priority = 1;
		}

		if (stack_operator == '~' && expression_operator == '~'){
			return false;
		}
		if (stack_operator == '^' && expression_operator == '^'){
			return false;
		}

		if (stack_operator_priority <= expression_operator_priority){
			return true;
		} else {
			return false;
		}
	}

	private static long calculate(String postfix){
		try {
			String[] evaluate = postfix.split(" ");
			Stack<Long> numbers = new Stack<Long>();

			long first;
			long second;

			for (int i = 0; i < evaluate.length; i++){
				if (!evaluate[i].equals("+") && !evaluate[i].equals("-") && !evaluate[i].equals("*") && !evaluate[i].equals("/") && !evaluate[i].equals("^") && !evaluate[i].equals("%") && !evaluate[i].equals("~")){
					numbers.push(Long.parseLong(evaluate[i]));
				} else if (evaluate[i].equals("~")){
					first = numbers.pop();
					first *= -1;
					numbers.push(first);
				} else if (evaluate[i].equals("+")){
					first = numbers.pop();
					second = numbers.pop();
					numbers.push(second + first);
				} else if (evaluate[i].equals("-")){
					first = numbers.pop();
					second = numbers.pop();
					numbers.push(second - first);
				} else if (evaluate[i].equals("*")){
					first = numbers.pop();
					second = numbers.pop();
					numbers.push(second * first);
				} else if (evaluate[i].equals("/")){
					first = numbers.pop();
					second = numbers.pop();
					numbers.push(second / first);
				} else if (evaluate[i].equals("%")){
					first = numbers.pop();
					second = numbers.pop();
					numbers.push(second % first);
				} else if (evaluate[i].equals("^")){
					first = numbers.pop();
					second = numbers.pop();
					if (first < 0 && second == 0){
						error = 1;
					}
					numbers.push((long)Math.pow(second, first));
				}
			}
			return numbers.pop();
		} catch (Exception e) {
			error = 1;
			return 0;
		}
	}

	private static boolean areParenthesisBalanced(char[] expression){
		Stack<Character> parenthesis = new Stack<Character>();

		for (int i = 0; i < expression.length; i++){
			if (expression[i] == '('){
				parenthesis.push(expression[i]);
			}
			if (expression[i] == ')'){
				if (parenthesis.isEmpty()){
					return false;
				} else {
					if (parenthesis.pop() != '('){
						return false;
					}
				}
			}
		}
		if (parenthesis.isEmpty()){
			return true;
		} else {
			return false;
		}
	}
}

