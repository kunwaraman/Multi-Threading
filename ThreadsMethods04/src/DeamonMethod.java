public class DeamonMethod extends Thread{
    // deamon threads ye background main threads chalte hai


    @Override
    public void run() {
        while (true){
            System.out.println("Hello world !");
        }
    }

    public static void main(String[] args) {
        DeamonMethod mythread = new DeamonMethod();
        mythread.setDaemon(true);
        DeamonMethod mythread2 = new DeamonMethod();
     //   mythread2.setDaemon(true);
        mythread2.start();

        mythread.start();
        System.out.println("Main done");
    }

}
/*
use rthreads jo actually main kaam akr rhe hai
deamon threads jo background main chalta hai

agar koi deamon threads chal rha ahi to jvm ushke liye waait nahi kargea
 */
