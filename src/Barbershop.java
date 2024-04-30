import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Barbershop {
    private final int capacity;
    private final int barbersQuantity;
    private final List<Barber> barbers = new ArrayList<>();
    private final Semaphore barberChairs;
    private Semaphore waitSofa;
    private final LinkedBlockingQueue<Customer> customers;
    private volatile boolean isOpen = true;

    public Barbershop(int capacity, int barbersQuantity) {
        this.capacity = capacity;
        this.barbersQuantity = barbersQuantity;
        this.customers = new LinkedBlockingQueue<>();
        this.barberChairs = new Semaphore(barbersQuantity);

        for (int i = 0; i < barbersQuantity; i++) {
            this.barbers.add(new Barber(String.valueOf(i), this));
        }
    }


    public synchronized void getIn(Customer customer) {
//        System.out.println(customer.getName() + " Chegou na barbearia!");
        if (customers.size() < capacity) {
            customers.offer(customer);
            System.out.println(customer.getName() + " Entrou na barbearia");
        } else {
            System.out.println(customer.getName() + " Foi embora pois barbearia está cheia");
        }

    }

    public boolean isOpen() {
        return isOpen;
    }

    public synchronized Customer nextCustomer() {
        return this.customers.poll();
    }

    public void startDay() {
        System.out.println("Começando o dia!");
        barbers.forEach(barber -> new Thread(barber).start());
    }

    public void allocateChair() {
        try {
            barberChairs.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseChair() {
        barberChairs.release();
    }

    public void endDay() {
        System.out.println("Encerrando o dia!");
        barbers.forEach(barber -> new Thread(barber).start());
    }
}
