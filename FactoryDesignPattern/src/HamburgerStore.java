public abstract class HamburgerStore {

    public Hamburger orderHamburger(String type){
        Hamburger ham;
        ham = createHamburger(type);
        ham.prepare();
        ham.cook();
        ham.box();
        return ham;
    }

    public abstract Hamburger createHamburger(String type);
}
