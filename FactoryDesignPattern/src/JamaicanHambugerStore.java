public class JamaicanHambugerStore extends HamburgerStore{
    @Override
    public Hamburger createHamburger(String type) {
        Hamburger ham = null;
        if(type.equals("cheese")){
            ham = new JamaicanCheeseHamburger();
        }
        else if(type.equals("greek")){
            ham = new GreekBurger();
        }
        else if(type.equals("veggie")){
            ham = new VeggieHamburger();
        }
        return ham;
    }
}
