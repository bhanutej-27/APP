package Tutorial7.Q5;

class TrafficJunction extends Thread {
    private String trafficStatus;
    private int delay;

    public TrafficJunction(String name, String trafficStatus, int delay) {
        setName(name);
        this.trafficStatus = trafficStatus;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Traffic Status: " + trafficStatus + " - Report " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}

public class TrafficManagement {
    public static void main(String[] args) {
        Thread junction1 = new TrafficJunction("Junction 1", "Heavy Traffic", 1000);
        Thread junction2 = new TrafficJunction("Junction 2", "Moderate Traffic", 1500);
        Thread junction3 = new TrafficJunction("Junction 3", "Light Traffic", 2000);

        junction1.start();
        junction2.start();
        junction3.start();
    }
}
