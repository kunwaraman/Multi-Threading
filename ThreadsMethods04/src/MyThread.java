public class MyThread  extends Thread{
    @Override
    public void run() {
       // System.out.println("Thread is running.....");
        // 3rd method sleep
        for (int i=1;i<=5;i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        // 4th method join
        t1.join(); // wait karega jab tak t1start ktm na ho jaye ushke baadi hi ye kux aage karega


    }

}
/*
start run sleep join set priority
 */