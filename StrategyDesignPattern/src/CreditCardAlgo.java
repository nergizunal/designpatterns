public class CreditCardAlgo implements Payment{
    private  String name;
    private String cardNum;

    public CreditCardAlgo(String name, String cardNum) {
        this.name = name;
        this.cardNum = cardNum;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "Paid with Credit Card");
    }
}
