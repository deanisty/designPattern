package design.singleton;

/**
 * 同步代码块
 * Double Check Lock
 */
public class Singleton5 {
    // 线程安全版本
    private static volatile Singleton5 instance = null;
    private static Object lock = new Object(); // 提供锁的对象
    // 私有的构造方法
    private Singleton5() {
    }

    // 锁住代码块 DCL
    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized(lock) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
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