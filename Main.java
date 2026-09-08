import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // Testing how a stack works
        Stack<String> words = new Stack<>();

        System.out.println("STACK TEST");

        System.out.println("Is the stack empty? " + words.isEmpty());

        words.push("First");
        words.push("Second");
        words.push("Third");

        System.out.println("Top item: " + words.peek());

        System.out.println("Removing: " + words.pop());
        System.out.println("Removing: " + words.pop());
        System.out.println("Removing: " + words.pop());

        System.out.println("Is the stack empty now? " + words.isEmpty());

        System.out.println("\nEDITOR TEST");

        EditorHistory editor = new EditorHistory();

        System.out.println("Starting:");
        editor.printHistory();

        editor.makeChange("one");
        System.out.println("After typing one:");
        editor.printHistory();

        editor.makeChange("one two");
        System.out.println("After typing two:");
        editor.printHistory();

        editor.makeChange("one two three");
        System.out.println("After typing three:");
        editor.printHistory();

        editor.undo();
        System.out.println("After undo:");
        editor.printHistory();

        editor.undo();
        System.out.println("After another undo:");
        editor.printHistory();

        editor.redo();
        System.out.println("After redo:");
        editor.printHistory();

        editor.makeChange("one two four");
        System.out.println("After making a new change:");
        editor.printHistory();

        editor.redo();
        System.out.println("After trying to redo:");
        editor.printHistory();
    }
}
