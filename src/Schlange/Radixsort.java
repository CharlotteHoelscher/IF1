package Schlange;

import java.util.Arrays;

public class Radixsort {

    public static void main(String[] argv) {

        String[] zahlen = {"124", "523", "483", "128", "923", "584"};
        StringSchlange[] buckets = new StringSchlange[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new StringZeigerSchlange();
        }

        for (int x = 2; x > 0; x--) {
            for (int i = 0; i < 6; i++) {
                int a = zahlen[i].charAt(x) - 48;
                buckets[a].enqueue(zahlen[i]);
            }

            System.out.println(Arrays.toString(buckets));

            int i = 0;
            for (int j = 0; j < 10; j++) {
                while (!buckets[j].isEmpty()) {
                    zahlen[i] = buckets[j].dequeue();
                    i++;
                }
            }

            System.out.println(Arrays.toString(zahlen));
        }
    }
}