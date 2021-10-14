public class Main {
    public static void main(String [] args){
        System.out.println("HamburgerStoree");
        SimpleHamburgerFactory simpleHamburgerFactory = new SimpleHamburgerFactory();
        HamburgerStore store = new JamaicanHambugerStore();
        HamburgerStore store2 = new MozHamburgerStore();
        store.orderHamburger("cheese");
        store2.orderHamburger("cheese");
        store.orderHamburger("veggie");

    }
}
