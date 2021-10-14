import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
        List<Product> productList;
        public ShoppingCart(){
            this.productList = new ArrayList<>();
        }

        public void addProduct(Product p){
            this.productList.add(p);
        }
        public void removeProduct(Product p){
            this.productList.remove(p);
        }
        public int calculateCost(){
            int sum = 0;
            for(Product a: productList)
                sum += a.getPrice();
            return sum;
        }
        public void pay(Payment payment){
            int  amount = this.calculateCost();
            payment.pay(amount);
        }
}
