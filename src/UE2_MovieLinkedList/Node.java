package UE2_MovieLinkedList;

public class Node
{
    // *** Membervariablen ***
    private final String movieTitel;
    private Node next;
    private Node previous;

    // *** Konstruktor ***

    public Node(String movieTitel) {
        this.movieTitel = movieTitel;
        this.next = null;
        this.previous = null;
    }


    public String getWert() {
        return movieTitel;
    }


    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public String getMovieTitle()
    {
        // Implementierung offen
        return null;
    }

    public Node getNext()
    {
        // Implementierung offen
        return null;
    }


}
