package UE2_MovieLinkedList;

public class TestMovieLinkedList
{
    public static void printLinkedList(MovieLinkedList movieLinkedList)
    {
        Node currentNode = movieLinkedList.getFirst();

        System.out.print("Start LinkedList: ");
        while (currentNode != null)
        {
            System.out.print(currentNode.getMovieTitle() + "; ");
            currentNode = currentNode.getNext();
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        MovieLinkedList movieLinkedList = new MovieLinkedList();

        movieLinkedList.insertMovieTitleAtIndex("Inception", 0);
        movieLinkedList.insertMovieTitleAtIndex("Die Verurteilten", 1);
        movieLinkedList.insertMovieTitleAtIndex("Ziemlich beste Freunde", 2);

        printLinkedList(movieLinkedList);

        movieLinkedList.insertMovieTitleAtIndex("Forrest Gump", 9);

        printLinkedList(movieLinkedList);

        Node foundNode;

        foundNode = movieLinkedList.getMovieAtIndex(0);
        System.out.println( foundNode != null ? foundNode.getMovieTitle() : "null");

        foundNode = movieLinkedList.getMovieAtIndex(25);
        System.out.println( foundNode != null ? foundNode.getMovieTitle() : "null");

        movieLinkedList.deleteMovieAtIndex(1);
        printLinkedList(movieLinkedList);

        movieLinkedList.deleteMovieAtIndex(0);
        printLinkedList(movieLinkedList);

        System.out.println("First: " + movieLinkedList.getFirst().getMovieTitle());
        System.out.println("Last: " + movieLinkedList.getLast().getMovieTitle());

        movieLinkedList.deleteMovieAtIndex(1);
        movieLinkedList.deleteMovieAtIndex(0);
        printLinkedList(movieLinkedList);
    }
}
