public class Thredinterrupt extends Thread {
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("Thread is running....");
        }catch (InterruptedException e){
            System.out.println("Thread interrupt:" + e);
        }
    }

    public static void main(String[] args) {
        Thredinterrupt t1 = new Thredinterrupt();
        t1.start();
        t1.interrupt(); // jish method pe hm call karoge na
        // ushko bole rhe hai jo bhi kar rhe ho ushko wahi rok do
        // jo bhi kar rahe hai waait kar rhe hai sleep kar rhe hai kux bhi kar rahe hai



    }
}
