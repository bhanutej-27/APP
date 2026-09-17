class TrafficJunction extends Thread {
    private String trafficStatus;
    private int delay;

    TrafficJunction(String name, String trafficStatus, int delay) {
        setName(name);
        this.trafficStatus = trafficStatus;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " - Traffic Status: " + trafficStatus);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class TrafficManagement {
    public static void main(String[] args) throws InterruptedException {
        TrafficJunction j1 = new TrafficJunction("Junction 1", "Heavy Traffic", 1000);
        TrafficJunction j2 = new TrafficJunction("Junction 2", "Moderate Traffic", 1500);
        TrafficJunction j3 = new TrafficJunction("Junction 3", "Low Traffic", 2000);

        j1.start();
        j2.start();
        j3.start();

        j1.join();
        j2.join();
        j3.join();
    }
}
