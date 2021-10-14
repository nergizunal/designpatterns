public class MintIceCream extends IceCreamDecorator{
    public MintIceCream(IceCream iceCream) {
        super(iceCream);
    }
    @Override
    public double cost() {
        System.out.println("Adding Mint Ice Cream");
        return super.cost() + 1.50;
    }
}
