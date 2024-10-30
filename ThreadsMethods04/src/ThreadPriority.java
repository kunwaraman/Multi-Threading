public class ThreadPriority extends Thread {
    // This example demonstrates how to assign priority to threads
    public ThreadPriority(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            StringBuilder a = new StringBuilder();
            for (int j = 0; j < 10000000; j++) {
                a.append("a");
            }
            System.out.println(Thread.currentThread().getName() + " - Priority: " +
                    Thread.currentThread().getPriority() + " - Count: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPriority low = new ThreadPriority("Low Priority Thread");
        ThreadPriority medium = new ThreadPriority("Medium Priority Thread");
        ThreadPriority high = new ThreadPriority("High Priority Thread");

        low.setPriority(Thread.MIN_PRIORITY);
        medium.setPriority(Thread.NORM_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        medium.start();
        high.start();
    }
}
