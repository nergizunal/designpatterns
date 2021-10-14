public class Main {

    public static void main(String [] args){
        IceCream basicIceCream = new BasicIceCream();
        System.out.println(basicIceCream.cost());
        IceCream choco = new ChocolateIceCream(basicIceCream);
        System.out.println(choco.cost());
        IceCream mint = new MintIceCream(choco);
        System.out.println(mint.cost());


    }
}
