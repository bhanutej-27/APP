class ExamActivity implements Runnable {
    private String activity;
    private int delay;

    ExamActivity(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + activity);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) throws InterruptedException {
        Thread timer = new Thread(new ExamActivity("Displaying remaining time", 1000));
        Thread autoSave = new Thread(new ExamActivity("Auto-saving student's answers", 1500));
        Thread network = new Thread(new ExamActivity("Checking network connection", 2000));

        timer.setName("Timer Thread");
        autoSave.setName("AutoSave Thread");
        network.setName("Network Thread");

        timer.start();
        autoSave.start();
        network.start();

        timer.join();
        autoSave.join();
        network.join();
    }
}
