public class CheeseBurger extends Hamburger{
    @Override
    public void prepare() {
        System.out.print("Cheese ");
        super.prepare();
    }

    @Override
    public void cook() {
        System.out.print("Cheese ");
        super.cook();
    }

    @Override
    public void box() {
        System.out.print("Cheese ");
        super.box();
    }
}
