package design.singleton;

public enum Singleton7 
{
    instance;

    // 枚举全局可访问  
    // 并且jvm保证枚举只会被初始化一次
    // 无法支持懒加载
    public static void sayHi()
    {
        System.out.println("Enum is saying Hi");
    }
}

