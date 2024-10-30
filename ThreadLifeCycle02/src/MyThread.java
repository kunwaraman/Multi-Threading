public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUnning");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(100);// main method ko pause kar de rahe hai 100 milisecond ke liye
        //taki run wala method chal jaye
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());

    }
}
