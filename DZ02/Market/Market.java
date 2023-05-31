package DZ02.Market;

import java.util.Iterator;
import java.util.Random;

public class Market implements MarketBehaviour, QueueBehaviour {
    String name;

    public Market(String name) {
        this.name = name;
        this.fillStorage();
    }

    /***
     * Добавляет покупателя в конец очереди
     * @param newCustomer
     */
    @Override
    public void addCustomerToQueue(Customer newCustomer) {
        QUEUE.add(newCustomer);
    }

    /***
     * Возвращает экзепляр класса Customer или null
     * @return
     */
    @Override
    public Customer pullFirstFromQueue() {
        return QUEUE.poll();
    }

    @Override
    public void queueToString() {
        for(Customer c: QUEUE){
            System.out.println(c.toString());
        }
    }

    /***
     * Добавляет некоторое количество товаров на склад по умолчанию
     */
    @Override
    public void fillStorage() {
        fillStorage("Bread", 5);
        fillStorage("Milk", 5);
        fillStorage("Beer", 5);
    }

    /***
     * Добавляет товар на склад
     * @param productName
     * @param productCount
     */
    @Override
    public void fillStorage(String productName, int productCount) {
        if(!isInStorage(productName)) {
            STORAGE.put(productName, productCount);
        }else{
            STORAGE.put(productName, getRemainsFromStorage(productName) + productCount);
        }
    }

    /***
     * Добавляет в продукт и количество в список недостающих продуктов
     * @param productName
     * @param productCount
     */
    @Override
    public void setProductRequest(String productName, int productCount) {
        if(!PRODUCT_REQUEST.containsKey(productName)){
            PRODUCT_REQUEST.put(productName, productCount);
        }else {
            PRODUCT_REQUEST.put(productName, getProductRequest(productName) + productCount);
        }
    }

    @Override
    public int getProductRequest(String productName) {
        return PRODUCT_REQUEST.get(productName);
    }

    /***
     * Метод работает с очередью, берет первого покупателя, выдает ему продукты со склада.
     * В случае нехватки продуктов оставляет в списке товаров недостающее количество и помещает покупателя в конец очереди
     */
    @Override
    public void update() {
        Customer currentCust = pullFirstFromQueue();//извлекаем первого покупателя из очереди
        if(currentCust != null){
            getProductsByCart(currentCust);//выдаем товары со склада по списку
            if(currentCust.cart.size() > 0){//если выданы все товары, то полкупатель не возвращается в очередь
                System.out.println("На складе не хватило товаров для выдачи! Покупатель уходит в конец очереди, в лист запроса добавляются недостающие позиции.");
                addCustomerToQueue(currentCust);
            }else {
                System.out.println("Товары выданы со склада по списку покупателя. Покупатель удаляется из очереди.");
            }
        }else{
            System.out.println("Очередь пуста");
        }

    }

    /***
     * Метод забирает товары со склада по названию товара, возвращает количество забранных товаров, если товаров на складе меньше,
     * чем необходимо, то ворвращает количество доступных, обнуляя остаток на складе и записывает в список запроса необходимое количество.
     *
     * @param productName
     * @param productCount
     * @return
     */
    @Override
    public int pullFromStorage(String productName, int productCount) {
        int res = 0;
        if(getRemainsFromStorage(productName) - productCount >= 0) {
            setRemainsInStorage(productName, getRemainsFromStorage(productName) - productCount);
            res = productCount;
        }else{
            res = getRemainsFromStorage(productName);
            setRemainsInStorage(productName, 0);
            setProductRequest(productName, productCount - res);
        }
        return res;
    }

    @Override
    public int getRemainsFromStorage(String productName) {
        return STORAGE.get(productName);
    }

    @Override
    public void setRemainsInStorage(String productName, int count) {
        STORAGE.put(productName, count);
    }

    @Override
    public boolean isInStorage(String productName) {
        return STORAGE.containsKey(productName);
    }

    @Override
    public void showStorage() {
        System.out.println("Остаток на складе:");
        for (String product: STORAGE.keySet()){
            System.out.printf("%s: %d\n", product, STORAGE.get(product));
        }
    }

    @Override
    public void showProductRequest() {
        System.out.println("Не хватает на складе:");
        for (String product: PRODUCT_REQUEST.keySet()){
            System.out.printf("%s: %d\n", product, PRODUCT_REQUEST.get(product));
        }
    }

    /***
     * Забирает со склада товары по списку покупателя, удаляет товар из списка, если необходимое количество было выдано
     * @param customer
     */
    @Override
    public void getProductsByCart(Customer customer) {
        Iterator<String> prIter = customer.cart.keySet().iterator();
        while(prIter.hasNext()){
            String product = prIter.next();
            int issued = pullFromStorage(product, customer.cart.get(product));
            if(issued == customer.cart.get(product)){
                prIter.remove();
            }else{
                customer.addProduct(product, customer.cart.get(product) - issued);
            }
        }
    }

    /***
     * Случайное заполнение списка покупок
     * @param customer
     * @param maxCount
     */
    @Override
    public void fillCartRand(Customer customer, int maxCount) {
        String[] productNames = STORAGE.keySet().toArray(new String[0]);
        Random rand = new Random();
        int i = rand.nextInt(1, STORAGE.size());
        for (int k = 0; k<i;k++){
            customer.addProduct(productNames[rand.nextInt(productNames.length)], rand.nextInt(1, maxCount));
        }
    }
}
