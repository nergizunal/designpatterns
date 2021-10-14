public class VeggieHamburger extends Hamburger {

    @Override
    public void prepare() {
        System.out.print("Veggie ");
        super.prepare();
    }

    @Override
    public void cook() {
        System.out.print("Veggie ");
        super.cook();
    }

    @Override
    public void box() {
        System.out.print("Veggie ");
        super.box();
    }
}
