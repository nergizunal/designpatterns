public class SimpleHamburgerFactory {
    public Hamburger create(String type){
        Hamburger ham = null;
        if(type.equals("cheese")){
            ham = new CheeseBurger();
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
