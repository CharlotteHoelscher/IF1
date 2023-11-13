package Schlange;

public class intArraySchlange implements intSchlange{
    private int vorne=0;
    private int hinten=0;
    public int[] data;
    private int N;

    public intArraySchlange(){
        data = new int [100];
        vorne=0;
        hinten=0;
        N=0;
    }




    public void enqueue(int x) {
        if (N == data.length) {
            throw new RuntimeException("Schlange ist voll");
        }

            data [hinten] = x;
            hinten = (hinten + 1) % data.length;
            N++;
          /* if (hinten == intArraySchlange.length()){
            hinten=0;
        }else {
            hinten++;
        }
          */
        }


        public int dequeue () {

            if (isEmpty()) {
                throw new RuntimeException("Schlange ist leer");
            }
            int erstes = data[vorne];
            vorne = (vorne + 1) % data.length;
            N--;
            return erstes;
        }

        public int head () {
            if (isEmpty())
                throw new RuntimeException("Schlange ist leer");

            return data[vorne];
        }

        public boolean isEmpty () {
            return hinten == vorne;

            /* if(N=0) */
        }

        public String toString () {
            String s = "";

            for (int i = 0; i < N; i++) {
                s += data[vorne + i % data.length] + " ";
            }
            return s;
        }
    }

