package Keller;

public class intZeigerKeller implements intKeller {

    class Node {
        int item;
        Node next;
    }

    private Node top;
    private int N;

    public boolean isEmpty(){

        return top.next==null;
    }

    public void push(int x){
        Node neu= new Node();
        neu.item=x;
        neu.next= top;
        top=neu ;
        N++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Der Keller ist leer!");
        } else {
            return top.item;
        }
    }



    public int pop(){
        if(isEmpty()) {
            throw new RuntimeException("Der Keller ist leer!");
        }
            int x = peek();
            top = top.next;
            N--;
        return x;
    }


    public int length(){
        return N;
    }

    public String toString(){
        String s= "";

        Node hilf=top;

        while(hilf!=null){

            hilf=hilf.next;
        }
        return s;
    }

}
