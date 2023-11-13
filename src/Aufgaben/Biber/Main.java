package Aufgaben.Biber;

import Keller.*;
import Schlange.*;

public class Main {
    public static void main(String[] args) {

        intSchlange biber = new intArraySchlange();
        intKeller teller = new intArrayKeller();
        intArrayKeller speicher= new intArrayKeller();

        biber.enqueue(0);
        biber.enqueue(0);
        biber.enqueue(0);
        biber.enqueue(0);
        biber.enqueue(1);
        biber.enqueue(1);


        teller.push(0);
        teller.push(1);
        teller.push(0);
        teller.push(0);
        teller.push(1);
        teller.push(1);



        while (!teller.isEmpty() && !biber.isEmpty()) {
            if(biber.dequeue()==teller.pop()){

                System.out.println("ist korrekt");
            }else{
               System.out.println("Nicht korrekt");
            }
        }

        if(!teller.isEmpty() || !biber.isEmpty()){

            System.out.println("Nicht korrekt, weil ungleiche Anzahl an Elementen");

        }

    }

}