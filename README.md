package Palindrom;

import Keller.intArrayKeller;
import Keller.intKeller;

public class Main {

    private String word = "anna";
    intKeller r = new intArrayKeller();
    intKeller f = new intArrayKeller();


        public void wordToStack(String x){

            String result = x.replaceAll("\\s+", "");
            x = result;

            for (int i = 0; i < x.length(); i++) {
                r.push(x.charAt(i));
            }

            for (int i = x.length(); i > 0; i--) {
                f.push(x.charAt(i));
            }

       public boolean palindromPruefen() {
                while(!r.isEmpty()&&!f.isEmpty){
            if (r.peek() == f.peek()) {
                 r.pop();
                 f.pop();
                 } else {
                        System.out.println("Es handelt sich nicht um eine Palindrom");
                        palindromPruefen= false;
                    }
                }


            }
        }
    }

