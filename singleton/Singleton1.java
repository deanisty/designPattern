package design.singleton;

public class Singleton1
{
    // 饿汉模式
    private static Singleton1 instance = new Singleton1();    

    // 私有构造方法
    private Singleton1() {}

    // 静态初始化方法
    public static Singleton1 getInstance()
    {
        return instance;
    }

    // 实例方法
    public void SayHi()
    {
        System.out.println(this.getClass().getSimpleName() + " is saying Hi");
    }
}