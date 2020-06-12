package design.singleton;

// 线程安全 并且 无资源浪费
public class Singleton6 
{
    private Singleton6() {}

    // 私有内部静态类
    private static class Singleton6Hepler()
    {
        private static final Singleton6 instance = new Singleton6();
    }

    // 只有当调用 getInstance 方法时内部类才会被加载到内存
    public static Singleton6 getInstance()
    {
        return Singleton6Hepler.instance;
    }
}