package enigma;

public class Enigma {


    private static final Rotor rfl = new Rotor("AEBJCMDZFLGYHXIVKWNROQPUST",0);

    private static final Rotor[] ROTOREN = {
            new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 18), // Rotor 1
            new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 6), // Rotor 2
            new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 23), // Rotor 3
            new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 11),    // Rotor 4
            new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 0)    // Rotor 5
    };

    public static final Rotor REFLEKTOR=
            new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT", -1 ); // Reflektor B


    public char encrypt(char c){
        step();

        c= rotoren[2].transform(c,1);
        c= rotoren[1].transform(c,1);
        c= rotoren[0].transform(c,1);

        c= REFLEKTOR.transform(c,1);

        c= rotoren[0].transform(c,0);
        c= rotoren[1].transform(c,0);
        c= rotoren[2].transform(c,0);
        return c;

    }
    public void step(){
        rotoren[2].step();
        if (rotoren[2].getPos() == rotoren[2].getUebertrag()){
            rotoren[1].step();
            if (rotoren[1].getPos() == rotoren[1].getUebertrag())
                rotoren[0].step();

        }
    }

    private Rotor[] rotoren = new Rotor[3]; //left, mid, right

    //Enigma ("145", "EHZ")

    public Enigma (String walzenlage, String grundstellung){

        for(int i = 0; i<3; i++) {
            rotoren[i] = ROTOREN[walzenlage.charAt(i) - 49];

            // es fängt an der Stelle E bei der ersten Walze, bei der Stelle H der Zweiten Zalze und an der Stelle Z der weiten Walze an.

            int c = grundstellung.charAt(i) - 65;


        }

        }





    public static void main (String[] argv) {

        Enigma E = new Enigma("123","");

        String s = "AACHEN";
        String w="";
        for(int i=0; i<s.length(); i++) {


            w+=E.encrypt(s.charAt(i));

        }
        System.out.println(w);

    }
}

