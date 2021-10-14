public class Main {
    public static void main(String[] args){
        System.out.println("SingleTon");

        SingleClass sc = SingleClass.getInstance();
        sc.name = "Single Object";
        System.out.println("SingleClass addreess " + sc);
        sc = SingleClass.getInstance();
        System.out.println("SingleClass addreess " + sc);
        Person p = new Person();
        System.out.println("Person addreess " + p);
        p = new Person();
        System.out.println("Person addreess " + p);

    }
}
