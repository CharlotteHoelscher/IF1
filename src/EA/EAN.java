package EA;

import java.math.BigInteger;
import java.util.Arrays;

public class EAN {


    public static BigInteger[] eea( BigInteger a,  BigInteger b) {

        if (b.compareTo(BigInteger.ZERO)==0)
            return new BigInteger []{a, BigInteger.ONE, BigInteger.ZERO};

        BigInteger[] erg = eea(b, a.mod(b) );


        BigInteger x_neu = erg[2];
        BigInteger y_neu = erg[1] .subtract(erg[2].multiply(a.divide(b)));
        return new BigInteger []{erg[0], x_neu, y_neu};
    }


    public static void main(String[] argv) {
        BigInteger s = new BigInteger("16717861150380844246015271389168398245436901032358311217835038446929062655448792237114490509578608655662496577974840004057020373");
        BigInteger N = new BigInteger ("114381625757888867669235779976146612010218296721242362562561842935706935245733897830597123563958705058989075147599290026879543541");
        BigInteger c= new BigInteger("96869613754622061477140922254355882905759991124574319874695120930816298225145708356931476622883989628013391990551829945157815154");
        BigInteger d= new BigInteger("9007");
        BigInteger p=new BigInteger("3490529510847650949147849619903898133417764638493387843990820577");
        BigInteger q=new BigInteger("32769132993266709549961988190834461413177642967992942539798288533");


        BigInteger p_Jana = new BigInteger("251456987523648524598754554589");
        BigInteger q_Jana = new BigInteger("542135423135431354354313213561");
        BigInteger pq_Jana = p_Jana.subtract(BigInteger.ONE).multiply(q_Jana.subtract(BigInteger.ONE));
        BigInteger N_Jana = p_Jana.multiply(q_Jana);
        System.out.println(N_Jana);

        BigInteger d_Jana = new BigInteger("2465485468541515678458611");
        System.out.println(pq_Jana.gcd(d_Jana));


        BigInteger e_Jana = d_Jana.modInverse(pq_Jana);
        System.out.println(e_Jana);

        BigInteger N_Janie = new BigInteger("136323740331494075768855065753667934422716267840713789581429");
        BigInteger e_Janie = new BigInteger("27984344012068887203747137516318441776087487293185289536411");
        BigInteger Schlotti_Janie = new BigInteger("1915131351800191514140519011407180901");
       BigInteger c_Janie = Schlotti_Janie.modPow(e_Janie, N_Janie);

        System.out.println(c_Janie);

        BigInteger N_Flori = new BigInteger("6710320879940273693186866373198020940980084800378281191621062189554257109834407893448414383997094254889133483515066703971686801749139880899615293104948582107433135794314719574222160343443931062116301");
        BigInteger e_Flori = new BigInteger("37465627834572364586478676189037589734959768978773402895789");
        BigInteger Schlotti_Flori = new BigInteger("23051203080500200905180011011414000104090518051400040518001511201516122119");
        BigInteger c_Flori = Schlotti_Janie.modPow(e_Flori, N_Flori);

        System.out.println(c_Flori);
        // BigInteger e = d.modInverse(p.subtract(BigInteger.ONE).multiply((q.subtract(BigInteger.ONE))));

        //BigInteger erg = s.modPow( d, N );
        //System.out.println(erg);
        //BigInteger e = d.modInverse(p.subtract(BigInteger.ONE).multiply((q.subtract(BigInteger.ONE))));
        // System.out.println(e);
        // BigInteger i = c.modPow(e,N);
        // System.out.println(i);

    }
}


