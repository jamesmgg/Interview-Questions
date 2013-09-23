package solvePostFix;

import java.util.LinkedList;

/**
 * 
 * @author Jaime Guajardo
 * 
 * Same input:
 * 5 8 +
 * 5 5 8 + *
 *
 */
public class SolvePostFix {
	public static double solve(String str) throws Exception {
		LinkedList<String> stack = new LinkedList<String>();
		String[] strArr = str.split(" ");
		int index = 0;
		double returnValue = -1;
		while (index < strArr.length) {
			String s = strArr[index];
			Double value;
			try {
				value = Double.parseDouble(s);
			} catch (Exception e) {
				value = null;
			}
			// Check if it's an operator.
			if (value == null) {
				returnValue = performOperation(s, stack);
				
			} else {
				// Push number in.
				stack.push(s);
			}
			index++;
		}
		return returnValue;
	}

	static double performOperation(String s, LinkedList<String> stack) throws Exception {
		Double first = Double.parseDouble(stack.pop());
		Double second = Double.parseDouble(stack.pop());
		double val = -1;
		if (s.equals("+")) {
			val = first + second;
			stack.addFirst("" + val);
		} else if (s.equals("-")) {
			val = first - second;
			stack.addFirst("" + val);
		} else if (s.equals("*")) {
			val = first * second;
			stack.addFirst("" + val);
		
		} else if (s.equals("/")) {
			if (second == 0) {
				throw new Exception("Dividing by zero!");
			}
			val = first / second;
			stack.addFirst("" + val);
			
		} else {
			throw new Exception("Operator not identified.");
		}
		return val;
	}

}
