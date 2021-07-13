# UndoRedoCalculator
This program simulates the undo/redo features of an application. A simple calculator is implemented that asks the user for the basic arithmetic operation
that they would like to perform on the last result.

The program will:
- Prompt the user to enter an initial number (first operand)
- Then
- prompt the user for the next operator and second operand
- evaluate the expression
- present the user with the result, which will be the new first operand
- This will continue until the user chooses to quit, or undo (redo) an operation
- 
The undo operation will restore the last state. The redo operation restores the next state if an
undo was previously performed.
