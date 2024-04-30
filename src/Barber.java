import enums.BarberState;

import java.util.Random;

public class Barber implements Runnable {
    private String name;
    private final Barbershop barbershop;
    private BarberState state = BarberState.SLEEPING;

    public Barber(String name, Barbershop barbershop) {
        this.name = name;
        this.barbershop = barbershop;
    }

    public String getName() {
        return name;
    }

    public BarberState getState() {
        return state;
    }

    public void updateStatus(BarberState state) {
        this.state = state;
    }

    @Override
    public void run() {
        System.out.println("O barbeiro " + name + " começou o dia e está " + state);
        while (barbershop.isOpen()) {
            Customer customer = barbershop.nextCustomer();
            if (customer != null) {
                barbershop.allocateChair();
                cutHair(customer);
                barbershop.releaseChair();
            }
        }
    }

    private void cutHair(Customer customer) {
        System.out.println("O barbeiro " + name + " está cortando o cabelo do " + customer.getName());
        updateStatus(BarberState.CUTTING);
        cutTime();
        System.out.println("O barbeiro " + name + " terminou o corte do " + customer.getName());
        updateStatus(BarberState.SLEEPING);
    }

    private static void cutTime() {
        try {
            int cutTime = new Random().nextInt(6);
            cutTime++;
            Thread.sleep(1000 * cutTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
