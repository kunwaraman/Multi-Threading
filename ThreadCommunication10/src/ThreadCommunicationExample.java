
class SharedResource{
    private int data;
    private boolean hasData;
    /*
    hum chah rhe hai producer jo hai wo produce kare data lekin has data tru hai to waiit kare
     */

    public  synchronized void produce(int value){
        while (hasData){ // agar data hai buffer main already to waiit kariye
             try {
                 wait();
             }catch (InterruptedException e){
                 Thread.currentThread().interrupt();

             }
        }
        data=value;
        hasData = true;
        System.out.println("Produced " + value);
        notify();
        /*
        ye kam tab ho rha hai jab buffer main data already hai to aur kyu dalna produce kyu karna
        to waiit karna hai yaha par
        to data main value daal de
        has data ko true kar de
        and notify kr de dushre thread ko sir consume kariye
         */


    }
    public synchronized int consume(){
        /*
        consumer data consume kare tab jab has data true hai
        consume kab karega tab data hoga  agar data nahi hai to ushko wait karo

        agar data hai consume kariye return karake aur has data false kar denge becaue ish return chalne ke baad
        has data khali ho jayega
        and nofity kar denge producer ko ki aab wait karna khatam kar do since has data false aa gaya hai to producer wait karna ktm kar dega
         */
        while (!hasData){
            try {
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData=false;
        System.out.println("Consumed:" + data);
        notify();
        return data;

    }

}
class Producer implements Runnable{
    private SharedResource resource;
    public Producer(SharedResource resource){
        this.resource=resource;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private SharedResource resource;
    public Consumer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            int value = resource.consume();


        }
    }
}

public class ThreadCommunicationExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }

}
/*
this case main sab kux sequence ho rahi hai
producer consume kar rha hai then consumer ko notify kar rha hai
consumer consume kar le rha hai producer ko notify kar rha hai ki sir aap chaliye aab

if more than one thread then we use notify all
 */
