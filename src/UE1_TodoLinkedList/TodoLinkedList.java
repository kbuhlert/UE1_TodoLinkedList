package UE1_TodoLinkedList;

public class TodoLinkedList
{
    // *** Membervariablen ***
    private Node first;
    private Node last;

    // *** Get-Methoden (Set-Methoden nicht notwendig) ***

    public Node getFirst()
    {
        // Implementierung offen
        return null;
    }

    public Node getLast()
    {
        // Implementierung offen
        return null;
    }

    // *** Operationen ***

    public void appendTodoText(String todoText)
    {
        // Implementierung offen
    }

    public void deleteLastTodoText()
    {
        // Implementierung offen
    }

    public String getTodoTextAtIndex(int index)
    {
        // Implementierung offen
        return null;
    }

    // Bereits vorhandene Methode
    public void deleteTodoTextAtIndex(int index)
    {
        int counter = 0;
        Node currentNode = first;
        Node prevNode = null;

        // Vorgängerknoten von Knoten an der Position index suchen
        while (counter < index && currentNode != null)
        {
            counter++;
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        // Knoten nicht gefunden
        if (currentNode == null)
            return;

        // Erster Knoten soll gelöscht werden
        if (currentNode == first)
        {
            first = currentNode.getNext();
        }

        // Letzter Knoten soll gelöscht werden
        if (currentNode == last)
        {
            last = prevNode;
        }

        if (prevNode != null)
        {
            prevNode.setNext(currentNode.getNext());
        }
    }
}
