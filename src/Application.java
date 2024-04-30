import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop(20, 3);

        List<Thread> customers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            customers.add(new Thread(new Customer(String.valueOf(i), barbershop)));
        }

        barbershop.startDay();

        customers.forEach(customer -> {
            try {
                Thread.sleep(1000);
                customer.start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
