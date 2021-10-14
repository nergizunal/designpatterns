public class ChocolateIceCream extends IceCreamDecorator {
    public ChocolateIceCream(IceCream iceCream) {
        super(iceCream);
    }
    @Override
    public double cost() {
        System.out.println("Adding Chocolate Ice Cream");
        return super.cost() + 1.0;
    }
}
