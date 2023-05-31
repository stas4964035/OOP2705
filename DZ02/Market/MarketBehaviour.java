package DZ02.Market;

import java.util.HashMap;

public interface MarketBehaviour {

    HashMap<String, Integer> STORAGE = new HashMap<>();
    HashMap<String, Integer> PRODUCT_REQUEST = new HashMap<>();

    void fillStorage();
    void fillStorage(String productName, int productCount);

    void setProductRequest(String productName, int productCount);
    int getProductRequest(String productName);

    void update();

    int pullFromStorage(String productName, int productCount);
    int getRemainsFromStorage(String productName);
    void setRemainsInStorage(String productName, int count);
    boolean isInStorage(String productName);
    void showStorage();
    void showProductRequest();
    void getProductsByCart(Customer customer);
    void fillCartRand(Customer customer, int maxCount);
}
