package Dominostein;

public class Main {

   static Queue<Dominostein > q = new Queue<Dominostein>();
    public static void main (String[] argv){

        q.enqueue (new Dominostein (2,3));
        q.enqueue (new Dominostein (6,4));
        q.enqueue (new Dominostein (4,5));

        System.out.println(q);

        System.out.println (ringPruefen());
    }

    public static boolean ringPruefen(){
        for ( int i=0; i<2;i++){
            int el= q.head().getLinks();
           int er = q.dequeue().getRechts();

           int zl = q.head().getLinks();
            int zr = q.head().getRechts();

           if (!(er == zl)){
               return false;

           }
           q.enqueue( new Dominostein (el,er));








        }
        return true;
    }
}
