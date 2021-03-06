package design.singleton;

public class Singleton3 {
    // 线程安全版本
    private static Singleton3 instance = null;

    // 私有的构造方法
    private Singleton3() {
    }

    // 加锁 锁住当前对象
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            // try {
            //     Thread.sleep(2);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            instance = new Singleton3();
        }

        return instance;
    }

    public String toString() 
    {
        return getClass().getSimpleName() + '@' + Integer.toHexString(this.hashCode());
    }

    // 实例方法
    public void SayHi()
    {
        System.out.println(this.getClass().getSimpleName() + " is saying Hi");
    }
}