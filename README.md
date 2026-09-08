# Phase 1

LIFO works well for undo because the last change made should be the first
change removed. FIFO would remove the oldest change first, which would not
make sense for an undo button.

# Phase 2

If the user presses undo before making a change, the undo stack will be empty.
I used isEmpty() to check the stack first. If it is empty, the program says
there is nothing to undo instead of giving an error.

# Phase 3

The redo stack needs to be cleared after a new change because the user has
started a different editing path. The changes that were undone no longer
match the new text.

# Phase 4

The item at the end of each stack is the item on top.

1. The editor starts empty.
   - Current: ""
   - Undo: []
   - Redo: []

2. The user types "one."
   - Current: "one"
   - Undo: [""]
   - Redo: []

3. The user types "one two."
   - Current: "one two"
   - Undo: ["", "one"]
   - Redo: []

4. The user types "one two three."
   - Current: "one two three"
   - Undo: ["", "one", "one two"]
   - Redo: []

5. The user presses undo.
   - Current: "one two"
   - Undo: ["", "one"]
   - Redo: ["one two three"]

6. The user presses undo again.
   - Current: "one"
   - Undo: [""]
   - Redo: ["one two three", "one two"]

7. The user presses redo.
   - Current: "one two"
   - Undo: ["", "one"]
   - Redo: ["one two three"]

8. The user makes a new change.
   - Current: "one two four"
   - Undo: ["", "one", "one two"]
   - Redo: []

9. The user tries to redo, but nothing happens because the redo stack is empty.
   - Current: "one two four"
   - Undo: ["", "one", "one two"]
   - Redo: []
