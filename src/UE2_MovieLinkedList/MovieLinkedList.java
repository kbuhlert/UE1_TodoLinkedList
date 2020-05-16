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

    public void insertMovieTitleAtIndex(String movieTitle, int index)   //Spezialfälle: Index zu groß
    {

        // neuen Knoten erstellen
        Node newNode = new Node(movieTitle);

        //Spezialfälle:
        // a)Liste ist leer (hat keine Knoten)
        if(first == null){
            first = newNode;
            last = newNode;
        }
        //b) Neues Element ganz zu Beginn einfügen
        else if (index==0){
            first.setPrevious(newNode);
            newNode.setNext(first);
            first = newNode;    //neuer Knoten ist jetzt erster
        }
        else{

        //Beginne bei First/ hierfür Hilfsvariable
        Node vorgaengerNode = first;

        //Schleife bis zum Vorgänger (Zähler < (Index-1))
        for(int i=0; i<index-1; i++){
            vorgaengerNode = vorgaengerNode.getNext();
        }
        //Next vom neuen Knoten auf Nachfolger (auch mit Hilfsvariable) zeigen lassen
        Node nachfolgerNode = vorgaengerNode.getNext();
        newNode.setNext(nachfolgerNode);

        //Prev vom neuen Knoten auf Vorgänger zeigen lassen
        newNode.setPrevious(vorgaengerNode);

        //Next vom Vorgänger auf neuen Knoten zeigen lassen
        vorgaengerNode.setNext(newNode);

        //Prev vom NAchfolger auf neuen Knoten zeigen lassen (nur wenn Knoten nicht letzter ist)
        if(nachfolgerNode != null)
        nachfolgerNode.setPrevious(newNode);

        //Spezialfall c) neues Element ganz zum Schluss einfügen;
        if (vorgaengerNode == last)
            last = newNode;
        }

    }

    public void deleteMovieAtIndex(int index)
    {
        //Spezialfall Liste noch leer
        if(first==null)
            return;
        //Spezialfall: Liste besteht nur aus 1 Element (next vom first ist null)
        else if (first.getNext() == null) {
        first = null;
        last = null;
        }
        else{
        // Beginne bei first
        Node vorgaengerNode = first;
        //Schleife bis zum Vorgänger (Zähler<Index-1)
        for (int i = 0; i<index-1; i++){
            vorgaengerNode = vorgaengerNode.getNext();
        }
        //Next vom Vorgänger auf Next vom zu löschenden Element zeigen lassen
        Node zuLoeschendeNode = vorgaengerNode.getNext();
        Node nachfolgerNode = zuLoeschendeNode.getPrevious();

        vorgaengerNode.setNext(nachfolgerNode);
        //Prev vom Nachfolger auf Vorgänger zeigen lassen
        if(nachfolgerNode != null){nachfolgerNode.setPrevious(vorgaengerNode);}


        }
    }




}
