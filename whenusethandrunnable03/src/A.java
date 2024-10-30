/*
main a ka thread karna chahtu hu to mujhe thread se extend karwana padge
wo to main nahi kar sakta because in java multiple inheritance not
that case mujhe implements rannable karna padega yaha
 */
public class A extends B implements Runnable{

    // waise agar ek class dushre class ko already extends kar raha ho use runnablke
    // other wise use extebnds threads
    @Override
    public void run() {

    }
}
