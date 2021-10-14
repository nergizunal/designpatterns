public class PayPalAlgo implements Payment{
    private String email;
    private String password;

    public PayPalAlgo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println( amount + " Paid with Paypal Payment");
    }
}
