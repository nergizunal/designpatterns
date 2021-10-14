public class main {
    public static void main (String [] args){
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(1));
        System.out.println(isPrime(0));
        System.out.println(isPrime(100));
        System.out.println(isPrime(71));

    }

    public static boolean isPrime(int x){
        int factor = 2;
        int y =  x%factor;
        boolean prime;

        while(y != 0 && factor <= Math.sqrt(x)){
            y = x%factor;
            factor +=1;
        }

        if((y!=0 && x != 1) || x ==2)
            prime = true;
        else
            prime = false;
        return prime;
    }
}
