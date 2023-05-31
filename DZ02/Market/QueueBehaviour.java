package DZ02.Market;

import java.util.LinkedList;
import java.util.Queue;

public interface QueueBehaviour {
    Queue<Customer> QUEUE = new LinkedList<>();

    void addCustomerToQueue(Customer newCustomer);

    Customer pullFirstFromQueue();
    void queueToString();
}
