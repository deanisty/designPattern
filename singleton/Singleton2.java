package design.singleton;

public class Singleton2 {
    // 懒汉模式
    private static Singleton2 instance = null;

    // 私有的构造方法
    private Singleton2() {
    }

    // 静态获取实例方法
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
