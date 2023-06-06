package DZ03.Market;

public interface MarketBehaviour {
    void addCustomerToQueue(Customer newCustomer);

    Customer pullFirstFromQueue();

    void queueToString();

    void update();

    void completeOrder(Customer customer);
}
