package Vigenere;

import java.util.Arrays;

public class vigenere {

    public static String encode(String klar, String schlüsselwort) {
        String geheim = "";

        int j = 0;

        for (int i = 0; i < klar.length(); i++) {
            char c = klar.charAt(i);

            int schlüssel = schlüsselwort.charAt(j) - 65;
            geheim += (char)((c - 65 + schlüssel) % 26 + 65);

            j = (j + 1) % schlüsselwort.length();
        }

        return geheim;
    }

    public static String decode(String geheim, String key) {
        return "";
    }

    public static void main(String[] argv) {
        System.out.println(encode("DERKLARTEXTWIRDZUMGEHEIMTEXT", "PLUTO")); // SPLDZPCNXLIHCKROFGZSWPCFHTIN
        System.out.println(encode("DERKLARTEXTWERDEGEHEIMTEXT", "PLUTO")); // SPLDZPCNXLIHYKRTRYASXXNXLI

        String g1 = "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUEKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVKVLWZKV";
        String g2 = "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPSNCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZAYGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFPGUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYLSKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJRGPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVLWNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFCMPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFTWGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEEDCLDHWTVBUVGFBIJGYYIDGMVRDGMPLSWGJLAGOEEKJOFEKNYNOLRIVRWVUHEIWUURWGMUTJCDBNKGMBIDGMEEYGUOTDGGQEUJYOTVGGBRUJYS";

        // Finde Wiederholungen und berechne Abstände
        //  findeWiederholungen(g1);    // vermutete Schlüsselwortlänge: 7

        // bilde Zeichengruppen
        String[] gruppen = bildeZeichengruppen(g1, 7);
        System.out.println(Arrays.toString(gruppen));


        // erstelle Häufigkeitsverteilungen der Zeichengruppen

        for (int j = 0; j < 7; j++) {
            double[] h = häufigkeiten(gruppen[j]);
            System.out.println(Arrays.toString(h));

        //  Map<Double,Character>map =new TreeMap <Double,Character>();
            double summe = 0;
            //Verschiebezahl0;
            for (int verscchiebung = 0; verscchiebung < 26; verscchiebung++) {
              summe=0;
                for (int i = 0; i < 26; i++) {
                    summe += Math.abs(h[(i + verscchiebung) % 26] - relHDeutsch[i]);
                }
              System.out.println( verscchiebung+" "+ (char) (65+verscchiebung)+" "+summe);
            }
        }
    }

    public static String[] bildeZeichengruppen (String geheim, int anz) {
        String[] gruppen = new String[anz];
        for(int i=0; i<anz; i++) {
            gruppen[i] = "";
        }

        for(int i=0; i<geheim.length(); i++) {
            gruppen[i % anz] += geheim.charAt(i);
        }

        return gruppen;
    }
    private static double[] relHDeutsch = {6.51, 1.89, 3.06, 5.08, 17.4, 1.66, 3.01, 4.76, 7.55, 0.27, 1.21, 3.44, 2.53, 9.78, 2.51, 0.79, 0.02, 7.00, 7.27, 6.15, 4.35, 0.67, 1.89, 0.03, 0.04, 1.13};
        //Math.abs()Maßzahl (6.51-4.67)+...
    public static double[] häufigkeiten(String text) {
        double[] h = new double[26];

        for(int i=0; i< text.length();i++){
            char c=text.charAt(i);
            h[c-'A']++;
            }
        for(int i=0;i<26;i++){
            h[i]=h[i]/text.length()*100;
        }
        return h;
        }





    public static void findeWiederholungen(String text) {
        //String text = "HOOLAHOOLAGIRLSLIKEHOOLIGANS";

        for(int l=15; l>=3; l--) {
            for (int j = 0; j < text.length()-l+1; j++) {
                String muster = text.substring(j, j+l);
                for (int i = j + l; i < text.length(); i++) {
                    if (text.startsWith(muster, i)) {
                        System.out.println(muster + ":" + j + ":" + i + ":" + (i - j));
                    }
                }
            }
        }
    }

}
