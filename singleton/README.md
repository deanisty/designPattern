### 单例模式

#### 定义

* 创建型模式
* 只允许有一个类的实例存在
* 提供一个全局公共的访问点

#### 饥饿模式

```java
// 资源浪费
public class Singleton1
{
    // 饥饿模式
    private static Singleton1 instance = new Singleton1();    

    // 私有构造方法
    private Singleton1() { /**可能会有大量资源的操作，比如连接db，打开文件系统等**/ }

    // 静态初始化方法
    public static Singleton1 getInstance()
    {
        return instance;
    }
}
```

#### 懒加载模式

```java
// 非线程安全
public class Singleton2 {
    // 懒加载模式
    private static Singleton2 instance = null;

    // 私有的构造方法
    private Singleton2() {
    }

    // 静态获取实例方法
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }

        return instance;
    }
}
```

#### 对象锁模式

```java
public class Singleton3 {
    // 线程安全版本
    private static Singleton3 instance = null;

    // 私有的构造方法
    private Singleton3() {
    }

    // 加锁 锁住当前对象
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }

        return instance;
    }
}
```



##### Read More

Synchronized
* https://www.cnblogs.com/john8169/p/9780494.html
* https://blog.csdn.net/javazejian/article/details/72828483

