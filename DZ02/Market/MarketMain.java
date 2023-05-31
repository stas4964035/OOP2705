package DZ02.Market;

public class MarketMain {
    public static void main(String[] args) {
        Market shop = new Market("Продуктовый магазин");

        shop.showStorage();

        Customer ivan = new Customer("Ivan");
        Customer petr = new Customer("Petr");
        Customer marina = new Customer("Marina");
        Customer oksana = new Customer("Oksana");
        Customer vova = new Customer("Vova");

        shop.fillCartRand(ivan, 5);
        shop.fillCartRand(petr, 5);
        shop.fillCartRand(marina, 5);
        shop.fillCartRand(oksana, 5);
        shop.fillCartRand(vova, 5);

        shop.addCustomerToQueue(ivan);
        shop.addCustomerToQueue(petr);
        shop.addCustomerToQueue(marina);
        shop.addCustomerToQueue(oksana);
        shop.addCustomerToQueue(vova);

        shop.queueToString();

        shop.update();
        shop.update();
        shop.update();
        shop.update();
        shop.update();
        shop.update();
        shop.update();
        shop.update();

        shop.showStorage();
        shop.queueToString();

        shop.showProductRequest();

    }
}
