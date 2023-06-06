package DZ03.Market;


public interface QueueBehaviour {
    void addCustomerToQueue(Customer newCustomer);
    Customer pullFirstFromQueue();
    void queueToString();

}
