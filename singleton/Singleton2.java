package design.singleton;

public class Singleton2 {
    // lazy model
    private static Singleton2 instance = null;

    // private
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            // try {
            //     Thread.sleep(2);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            instance = new Singleton2();
        }

        return instance;
    }

    public void SayHi()
    {
        System.out.println(this.getClass().getSimpleName() + " is saying Hi");
    }
}