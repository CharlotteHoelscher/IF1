package Dominostein;

import Schlange.intArraySchlange;

public class Main {

   static Queue<Dominostein > q = new Queue<Dominostein>();
    public static void main (String[] argv){

        q.enqueue (new Dominostein (2,3));
        q.enqueue (new Dominostein (3,4));
        q.enqueue (new Dominostein (4,5));

        System.out.println(q);

        System.out.println (ringPruefen());
     //  ringBilden();

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

    public static void ringBilden(){
        Queue<Dominostein> ring = new Queue<Dominostein>();
        Dominostein aktuell = q.dequeue();
       ring.enqueue(aktuell);
        Dominostein neachster;

        while (!q.isEmpty()){
           if (q.head().getLinks()== aktuell.getRechts() ){
               System.out.println (ring);
               while (!ring.isEmpty()) {
                   ring.dequeue();
               }
              aktuell= q.dequeue();
               ring.enqueue(aktuell);
           }
           if (q.isEmpty()) {
               break;
           }else{
               neachster = q.dequeue();
           }
           if (aktuell.getRechts()== neachster.getLinks()){
               ring.enqueue(neachster);
               aktuell = neachster;
           }else{
               q.enqueue(neachster);
           }
           if(q.head().getLinks()== aktuell.getRechts()){
               System.out.println(ring);
           }else{
         //      throw new RuntimeException("Vorausetztung nicht erfüllt");
           }
       }
    }
}
