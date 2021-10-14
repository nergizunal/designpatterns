public class Hamburger {
    public String name;
    public String sauce;
    public String buns;
    public void prepare(){
        System.out.println("Hamburger is preparing!");
        System.out.print(" Preparing " + name);
        System.out.print(" Adding sauce " + sauce);
        System.out.print(" Adding buns " + buns);
    }
    public void cook() {
        System.out.println("Hamburger is cooking!");
    }
    public void box(){
        System.out.println("Hamburger is boxing!");
    }

}
