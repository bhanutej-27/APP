package Tutorial7.Q4;

class BankingActivity implements Runnable {
    private String activity;
    private int delay;

    public BankingActivity(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int count = 1; count <= 3; count++) {
            System.out.println(Thread.currentThread().getName() + " - " + activity + " - Execution " + count);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        Thread transactionThread = new Thread(new BankingActivity("Transaction processing", 800));
        Thread balanceThread = new Thread(new BankingActivity("Balance updating", 1200));
        Thread smsThread = new Thread(new BankingActivity("SMS notification", 1600));

        transactionThread.setName("Transaction Processor");
        balanceThread.setName("Balance Updater");
        smsThread.setName("SMS Notifier");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();
    }
}
