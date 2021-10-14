public class Main {
    public static void main(String [] args){
        System.out.println("Adapter!");
        testingSocketAdapter();
    }
    public static void testingSocketAdapter(){
        SocketAdapter socketAdapter = new SocketObjectAdapterImpl();
        Volt v3 = getVolt(socketAdapter, 3);
        Volt v12 = getVolt(socketAdapter,12);
        Volt v120 = getVolt(socketAdapter, 120);
        System.out.println("V3 : " + v3.getVolts());
        System.out.println("V12 : " + v12.getVolts());
        System.out.println("V120: " + v120.getVolts());

    }
    private static Volt getVolt(SocketAdapter sa, int i){
        switch (i){
            case 3: return sa.get3Volts();
            case 12: return sa.get12Volts();
            case 120: return sa.get120Volts();
            default: return sa.get120Volts();

        }
    }
}
