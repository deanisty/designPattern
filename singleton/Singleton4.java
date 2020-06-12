package design.singleton;

/**
 * 同步代码块
 * Double Check Lock
 */
public class Singleton4 {
    // 线程安全版本
    private static Singleton4 instance = null;

    // 私有的构造方法
    private Singleton4() {
    }

    // 锁住代码块
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized(Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
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