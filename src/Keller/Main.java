package Keller;

import Keller.Verschiebebahnhof;

public class Main {
    public static void main(String[] args) {

        Verschiebebahnhof bhf = new Verschiebebahnhof();

        System.out.println(bhf);
        bhf.sortieren();
        System.out.println(bhf);

    }
}