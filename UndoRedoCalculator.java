/**
 * @author Justin Baraniuk
 */
import java.util.Scanner;
public class UndoRedoCalculator {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Stack<Integer> undo = new ArrayStack<>();
		Stack<Integer> redo = new ArrayStack<>();
		String nextOperation = "q";
		boolean validOperator = true;  
		int current = 0;
		int result = 0;
		
		// Get first number
		System.out.println("Enter the first number: ");		
		String input = kb.next();

		// If first number is not "q" (continue)
		if (!input.equals("q")) {
			current = Integer.parseInt(input);
			System.out.println("Enter the next operation " +
								"on " + current + ":");	
			nextOperation = kb.next();		
		}
		
		// If operation is not "q" (continue)
		while (!nextOperation.equals("q")) {
			
			// Undo operation
			if (nextOperation.equals("z")) {
				if (undo.top() != null) {
					System.out.println("UNDO: " + undo.top());
					redo.push(current);
					current = undo.top();
					undo.pop();
				} else {
					
					// Undo stack empty
					System.out.println("UNDO: " + undo.top());
				}
			
			
			// Redo operation
			} else if (nextOperation.equals("y")) {
				if (redo.top() != null) {
						redo.push(current);
						undo.push(redo.pop());
						System.out.println("REDO: " + redo.top());
						current = redo.top();
						redo.pop();	
				} else {
					
					// Redo stack empty
					System.out.println("REDO: " + redo.top());
				}
			
			// Calculate result
			} else {
				undo.push(current);
				int num = kb.nextInt();
				
				switch (nextOperation) {
					case "-": result = current - num; break;
					case "+": result = current + num; break;
					case "/": result = current / num; break;
					case "*": result = current * num; break;
					default: 
						validOperator = false;
						System.out.println("Invalid operator. Use +,-,/,* " +
											"(eg: + 5)");
				}
			// Display result
				if (validOperator == true) {
					System.out.println("= " + result);		
					//undo.push(current);
					current = result;
				}
			}
			
			// Clear scanner
			kb.nextLine();
			
			// Reset operator validator
			validOperator = true;
			
			// Ask for next operation
			System.out.println("Enter the next operation on " + current + ":");
			nextOperation = kb.next();				
		}
		
		// End program
		System.out.println("Goodbye!");
	} 
}

