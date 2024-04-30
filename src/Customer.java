import enums.CustomerState;

public class Customer implements Runnable {
    private String name;
    private Barbershop barbershop;
    private CustomerState state;

    public Customer(String name, Barbershop barbershop) {
        this.name = name;
        this.barbershop = barbershop;
    }

    public String getName() {
        return "Customer " + name;
    }

    public Barbershop getBarbershop() {
        return barbershop;
    }

    @Override
    public void run() {
        barbershop.getIn(this);
    }
}
