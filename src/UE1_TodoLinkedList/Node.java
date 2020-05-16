package UE1_TodoLinkedList;

public class Node
{
    // *** Membervariablen ***
    private String todoText;
    private Node next;

    // *** Konstruktor (optional) ***

    public Node(String todoText) {
        this.todoText = todoText;
        this.next = null;
    }


    // *** Getter- & Setter ***

    public String getTodoText() {
        return todoText;
    }

    public void setTodoText(String todoText) {
        this.todoText = todoText;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
