package design.singleton;

public class Singleton3 {
    // 线程安全版本
    private static Singleton3 instance = null;

    // 私有的构造方法
    private Singleton3() {
    }

    // 加锁 锁住当前对象
    // synchronized实现原理：
    //   https://www.cnblogs.com/john8169/p/9780494.html
    //   https://blog.csdn.net/javazejian/article/details/72828483
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
        return getClass().getSimpleName() + '@' + Integer.toHexString(getClass().hashCode());
    }

    // 实例方法
    public void SayHi()
    {
        System.out.println(this.getClass().getSimpleName() + " is saying Hi");
    }
}