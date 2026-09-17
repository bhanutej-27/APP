class BankingTask implements Runnable {
    private String activity;
    private int delay;

    BankingTask(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int count = 1; count <= 3; count++) {
                System.out.println(Thread.currentThread().getName() + " - " + activity + " - Execution " + count);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BankingApplication {
    public static void main(String[] args) throws InterruptedException {
        Thread transaction = new Thread(new BankingTask("Transaction Processing", 1000));
        Thread balance = new Thread(new BankingTask("Balance Updating", 1500));
        Thread sms = new Thread(new BankingTask("SMS Notification", 2000));

        transaction.setName("Transaction Thread");
        balance.setName("Balance Thread");
        sms.setName("SMS Thread");

        transaction.start();
        balance.start();
        sms.start();

        transaction.join();
        balance.join();
        sms.join();
    }
}
