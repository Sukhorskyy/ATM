package atm;

public abstract class TrayAbstract implements Tray{
    private Tray next;
    private final int bill;

    public TrayAbstract(int bill) {
        this.bill = bill;
    }

    public void process(int amount) {
        if (next != null) {
            next.process(amount % bill);
        } else if (amount % bill > 0) {
            throw new IllegalArgumentException("Illegal input");
        }
        System.out.println("expected " + amount/bill + " with amount of " + bill);
    }

    public void setNext(Tray tray) {
        this.next = tray;
    }
}
