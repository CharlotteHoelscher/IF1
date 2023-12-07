package Keller;

public class pfz {

    public static intKeller pfz(int n){
        intKeller k= new intArrayKeller();

        for(int i=2; i< n; i++) {
            if(istPrim(i) && n % i == 0) {
                int z=i;

                while(n % z == 0){
                    k.push(i);
                    z= z*i;
                }
            }
        }
        return k;
    }

    public static boolean istPrim(int n){
        for(int i=2; i< n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(pfz(34));
    }
}