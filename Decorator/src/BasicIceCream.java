public class BasicIceCream implements IceCream{

    public BasicIceCream() {
        System.out.println("Creating basic icecream!");
    }

    @Override
    public double cost() {
        return 0.5;
    }
}
