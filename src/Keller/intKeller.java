package Keller;

public interface intKeller {

        // liefert true, falls Keller leer, sonst false
        public boolean isEmpty();

        // legt int-Wert x auf den Keller
        public void push(int x);

        // liefert das oberste Kellerelement
        public int peek();

        // löscht das oberste Kellerelement
        public int pop();


    }

