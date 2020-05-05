package UE2_MovieLinkedList;

public class MovieLinkedList
{
    // *** Membervariablen
    private Node first;
    private Node last;

    // *** Getter- & Setter-Methoden ***

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    // *** Operationen ***

    public Node getMovieByTitle(String movieTitle)
    {

        return null;
    }

    public Node getMovieAtIndex(int index)      //Ausnahmen die berücksichtigt werdeb müssen: Index ist ungültig/
    {
        // Beginne bei First/ Hilfsvariable
        Node currentNode = first;
        //Zähler auf 0
        int counter = 0;
        //Schleife bis gesuchten Element springen (Zähler<Index)
        while (counter<index){
            if(currentNode == null) //Ausnahme, dass es den index-Wert nicht gibt
                return null;
            currentNode = currentNode.getNext();
            counter++;
        }
        //Liefere Wert/Text zurück
        return currentNode;
    }

    public void insertMovieTitleAtIndex(String movieTitle, int index)
    {
        // neuen Knoten erstellen
        Node newNode = new Node(movieTitle);
        //Beginne bei First/ hierfür Hilfsvariable
        Node vorgaengerNode = first;

        //Schleife bis zum Vorgänger (Zähler < (Index-1))
        for(int i=0; i<index-1; i++){
            vorgaengerNode = vorgaengerNode.getNext();
        }
        //Next vom neuen Knoten auf Nachfolger zeigen lassen
        Node nachfolgerNode = vorgaengerNode.getNext();
        newNode.setNext(nachfolgerNode);

        //Prev vom neuen Knoten auf Vorgänger zeigen lassen
        newNode.setPrevious(vorgaengerNode);

        //Next vom Vorgänger auf neuen Knoten zeigen lassen
        vorgaengerNode.setNext(newNode);

        //Prev vom NAchfolger auf neuen Knoten zeigen lassen
        nachfolgerNode.setPrevious(newNode);
    }

    public void deleteMovieAtIndex(int index)
    {
        // Beginne bei first
        //Schleife bis zum Vorgänger (Zähler<Index-1)
        //Next vom Vorgänger auf Next vom zu löschenden Element zeigen lassen
        //Prev vom Nachfolger auf Vorgänger zeigen lassen
    }




}
