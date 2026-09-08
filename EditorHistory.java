import java.util.Stack;

public class EditorHistory {
    private String currentState;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public EditorHistory() {
        currentState = "";
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void makeChange(String newState) {
        undoStack.push(currentState);
        currentState = newState;

        // New changes remove the old redo history
        redoStack.clear();
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("There is nothing to undo.");
        } else {
            redoStack.push(currentState);
            currentState = undoStack.pop();
        }
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("There is nothing to redo.");
        } else {
            undoStack.push(currentState);
            currentState = redoStack.pop();
        }
    }

    public String currentStatus() {
        return currentState;
    }

    public void printHistory() {
        System.out.println("Current text: " + currentState);
        System.out.println("Undo stack: " + undoStack);
        System.out.println("Redo stack: " + redoStack);
        System.out.println();
    }
}
