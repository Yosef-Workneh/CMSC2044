package application;

public class Notation {

	public static String convertInfixToPostfix(String toPostfix) {

		MyQueue<Character> queue = new MyQueue<>(toPostfix.length());
		MyStack<Character> stack = new MyStack<>(toPostfix.length()); 

		char[] x = toPostfix.toCharArray(); 

		try {		
			for (char chr : x) {

				if (chr == ' ') {

				}		
				if (Character.isDigit(chr)) {
					queue.enqueue(chr);
				}
				if (chr == '(') {
					stack.push(chr);
				}
				if (chr == '*' || chr == '/' || chr == '+' || chr == '-') {

					if (!queue.isEmpty()) {
						char topStack = stack.top();

						if (topStack == '*' || topStack == '/' || chr == '-' && topStack == '-' 
								|| chr == '-' && topStack == '+'
								|| chr == '+' && topStack == '-' || chr == '+' && topStack == '+') {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(chr);
				}
				if (chr == ')') {

					while (stack.top() != '(') {

						queue.enqueue(stack.pop());

						if (stack.top() == null) {
							throw new InvalidNotationFormatException();
						}
					}
					stack.pop();
				}
			}

		} catch (QueueOverflowException | StackOverflowException | StackUnderflowException e) {

			throw new InvalidNotationFormatException();
		}
		return queue.toString();
	}

	public static String convertPostfixToInfix(String toinfix)   {

		MyStack<String> stack = new MyStack<>(toinfix.length());

		for (int i = 0; i < toinfix.length(); i++) {

			char ch = toinfix.charAt(i);

			if (ch == ' ') {

			}
			if (Character.isDigit(ch)) {
				stack.push(Character.toString(ch));

			}
			if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {

				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				String first = stack.pop();
				String second = stack.pop();
				String st = "(" + second + ch + first + ")";
				stack.push(st);
			}
		}
		if (stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}

		return stack.toString();
	}


	public static double evaluatePostfixExpression(String postfixExpr)   {


		MyStack<Double> Stack = new MyStack<Double>(postfixExpr.length());
		char[] chr = postfixExpr.toCharArray();

		for( char x: chr) {

			if (x == ' ') {

			}if (Character.isDigit(x) || x == '(') {
				Stack.push(Double.parseDouble(Character.toString(x)));

			}

			if (x == '*' || x == '/' || x == '+' || x == '-') {

				if (Stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				double y = Stack.pop();
				double z = Stack.pop();

				if(x == '*') {

					Stack.push(z * y);
				}
				else if(x =='/'){

					Stack.push(z / y);
				}
				else if(x == '+') {

					Stack.push(z + y);
				}
				else if( x == '-') {

					Stack.push(z - y);
				}
			}
		}

		if (Stack.size() > 1) {

			throw new InvalidNotationFormatException();
		}

		double st = Double.parseDouble(Stack.toString());

		return st;

	}

}
