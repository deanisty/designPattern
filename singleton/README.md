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

    // 加锁 锁住当前类的 .class 对象
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }

        return instance;
    }
}
```


#### 同步代码块模式

```java
/**
 * 同步代码块
 * Double Check Lock
 */
public class Singleton4 {
    // 线程安全版本 memory reordering issue
    private static Singleton4 instance = null;
    private static Object lock = new Object(); // 提供锁的对象
    // 私有的构造方法
    private Singleton4() {
    }

    // 锁住代码块 DCL
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized(lock) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }

        return instance;
    }
}
```


#### volatile

```java
    ...
    // volatile 关键字阻止编译器和cpu指令重排
    private static volatile Singleton4 instance = null;
    ...
```

#### 静态私有内部类

```java
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

```


` java的反射机制可以破坏上面所有的单例模式实现 `

> https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#eager-initialization




#### 枚举单例

```java
// 可以克服反射机制的破坏
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

```

` 反序列化破坏单例 `

当一个单例类被序列化然后再反序列化，会生成一个完全不同的类的实例，避免这个问题的方法，可以使用`readResolve`方法

##### Read More

* https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
* https://www.internalpointers.com/post/understanding-memory-ordering
* https://www.cnblogs.com/john8169/p/9780494.html
* https://blog.csdn.net/javazejian/article/details/72828483

