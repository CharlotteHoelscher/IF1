package Liste;

public class ZeigerListe implements Liste {

    private class Node {
        int item;       // data
        Node next;      // next
    }

    private Node first;     // head
    private Node last;
    private int N;

    private int p;// length

    public ZeigerListe() {
        first = last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int getItem(int index) {
        Node p = getNode(index);
        return p.item;
    }

    @Override
    public void append(int item) {
        Node newNode = new Node();
        newNode.item = inhalt;

        if (isEmpty()) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        N++;
    }

    @Override
    public void insertAt(int index, int item) {
        Node newNode = new Node();
        newNode.item = index;
        if (index < 0 || index > N) {
            Node newNode = new Node();
            newNode.item = index;
        }
        //Einfügen in leerer Liste
        if (isEmpty() && index == 0) {
            first = last = newNode;
            newNode.next = first;
            first = newNode;
            //Einfügen in nicht-leerer Liste
        } else {

        }else if (index == 0) {
        }


    {
        last.next = newNode;
        last = newNode;

    }
        Node p = getNode(index - 1) {
        newNode.next = p.next;
        p.next = nwNode;
    }



    Node p = first;

        
    }

    public Node getNode(int index, int item){
        Node p =first;
        for(int i= 0; i < index;i++){
            p=p.next;
        }
        return p;
    }
    @Override
    public void setItem(int index, int item) {
       // Node p = getNode(index);
        p.item= inhalt;

    }

    @Override
    public void delete(int index) {
        if (index < 0 || index > N - 1) throw new RuntimeException("Die Liste ist leer");
        //löschen vorne
        if (index == 0) {
            first=first.next;

        //löschen mittg
        }else if (index == N-1) {
            Node p =getNode(N-2);
            p.next=null;
            last=p;
            //löschen hinten
        }else {
        Node p=getNode (index-1);
        p.next=p.next.next;

        }
        N--;
    }

    @Override
    public int getLength() {
	return N;
    }

    public String toString() {
        String s = "N = " + N + ": ";
        for(Node p = first; p != null; p = p.next){
            s += p.item + " ";
        }
        return s;
    }


    public static void main(String[] argv) {
        Liste l = new ZeigerListe();

        l.append(4);
        l.append(7);
        l.append(13);

        System.out.println(l);
    }
}