public class SingleClass {
    String name;
    private static SingleClass uniqueInstance;
    private SingleClass(){}
    public static synchronized SingleClass getInstance(){
        if(uniqueInstance == null)
             uniqueInstance = new SingleClass();
        return  uniqueInstance;
    }
}
