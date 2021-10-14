public class DoubleCheckinSingleTon {
    private volatile static DoubleCheckinSingleTon unique;
    private DoubleCheckinSingleTon() {
    }
    public static DoubleCheckinSingleTon getInstance(){
        if(unique == null)
            {
                synchronized ((DoubleCheckinSingleTon.class)){
                    if(unique == null)
                        unique = new DoubleCheckinSingleTon();
                }
            }
        return unique;
    }
}
