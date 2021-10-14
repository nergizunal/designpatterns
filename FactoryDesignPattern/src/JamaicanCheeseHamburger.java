public class JamaicanCheeseHamburger extends Hamburger{
    public JamaicanCheeseHamburger(){
            name = "Jamaican Cheese Burger";
            sauce = "Spicy jamaican sauce";
            buns = "Cookies!";
    }

    @Override
    public void cook() {
        System.out.println( "Cooking Jamaican Style");
    }
}
