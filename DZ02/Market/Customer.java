package DZ02.Market;

import java.util.HashMap;

public class Customer {
    private String name;
    private int valet = 0;
    public HashMap<String, Integer> cart = new HashMap<>();

    public Customer(String name, int valet) {
        this.name = name;
        this.valet = valet;
    }
    public Customer(String name) {
        this.name = name;
        this.valet = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addProduct(String productName, Integer productCount) {
        cart.put(productName, productCount);
    }

    @Override
    public String toString(){
        StringBuilder cartString = new StringBuilder();
        for(String product: this.cart.keySet()){
            cartString.append(product).append(": ").append(this.cart.get(product)).append("; ");
        }
        return this.name + "(" + cartString.toString() + ")";
    }
}
