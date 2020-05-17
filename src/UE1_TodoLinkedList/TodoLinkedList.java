package UE1_TodoLinkedList;

public class TodoLinkedList
{
    // *** Membervariablen ***
    private Node first;
    private Node last;

    // *** Get-Methoden (Set-Methoden nicht notwendig) ***

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }


    // *** Operationen ***

    public void appendTodoText(String todoText)
    {
        //neuen Knoten erstelle
        Node neuerKnoten = new Node(todoText);
        //das next vom (bisher) letzten Knoten zeigt jetzt auf den neuen Knoten (statt auf null)
       if(last == null){
           first = neuerKnoten;
           last = neuerKnoten;
       }
       else{
        last.setNext(neuerKnoten);
        //next vom neuen Knoten zeigt jetzt auf null (= Letzte in der Liste)
        //neuerKnoten.setNext(null);    Überflüssig, da next vom neuen Knoten bereits auf null zeigt
        //der neue Knoten ist jetzt der letzte Knoten
        last = neuerKnoten;}

    }

    public void deleteLastTodoText()
    {
        //Sonderfall1: Liste ist leer = es gibt nichts zu löschen
        if(first == null){
            return;
        }
        //Sonderfall2: Nur 1 Element (first = last), dann ist durch löschen die Linked list leer (first und last sind null)
        if (first == last){
            first = null;
            last = null;
        }
        else {
            //zu vorgängerknoten von last gehen, hierzu muss bei First eingestiegen werden, dann mit .getNext zum nächsten gehen, solange bis der
            //nächste Knoten der Letzte ist, dann sind wir am richtigen (vorgänger) Knoten
            Node vorgaenger = first;
            if (vorgaenger.getNext() != last) {
                vorgaenger = vorgaenger.getNext();
            }
            //next von Vorgängerknoten auf null zeigen lassen
            vorgaenger.setNext(null);
            //Vorgängerknoten ist neuer letzter Knoten
            last = vorgaenger;
            //alten Last-knoten löschen
        }
    }

    public String getTodoTextAtIndex(int index)
    {//Wir suchen die Daten des Koten an einem bestimmeten Punkt, wir müssen also zählen an welcher Stelle wir uns befinden
        //zum Start wird der Counter auf 0 gesetzt (=erste Position in Linked List)
       int counter = 0;
       //Wir haben den aktuellen Knoten, den wir betrachten und beginnen beim ersten Knoten in der Liste
       Node currentNode = first;

      // Falls die Liste leer ist (first = null) können wir nicht in linked list weiter gehen und
        // ist das erste Element nicht null, schauen wir ob wir bereits gesuchte die Position erreicht haben (counter = index)
        //wenn wir noch nicht beim Index-Knoten sind (counter<index) dann gehen wir zum nächsten Knoten
       while (counter<index && currentNode != null){
           counter++;
           currentNode = currentNode.getNext();
       }
       //wenn wir jetzt beim Indexknoten angekommen sind (wir gehen nicht mehr in Schleife, sondern weiter)
        //muss geschaut werden, ob der aktuelle Knoten einen Wert hat. Wenn nicht kann das zwei gründe haben: Es handelt sich um eine leere liste
        //oder ob wir haben den Index nicht gefunden, also bereits die komplette Liste durchlaufen (Indexzahl zu groß)
       if(currentNode == null)
           return null;
       //wenn also alle Randbedingungen berücksichtigt wurden (lerre Liste, Liste mit einem Element, Index zu groß), köönen Daten aus
        //Knoten mit der gesuchten Indexzahl zurückgegeben werden
       return currentNode.getTodoText();

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
