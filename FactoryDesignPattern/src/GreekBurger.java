public class GreekBurger extends Hamburger {
    @Override
    public void prepare() {
        System.out.print("Greek ");
        super.prepare();
    }

    @Override
    public void cook() {
        System.out.print("Greek ");
        super.cook();
    }

    @Override
    public void box() {
        System.out.print("Greek ");
        super.box();
    }
}
