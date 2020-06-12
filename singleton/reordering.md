### CPU缓存一致性(MESI协议)

> http://tutorials.jenkov.com/java-concurrency/volatile.html

> https://www.jianshu.com/p/bf08e4546bfa

![cpu-cache](/singleton/cpu-cache-main-memory.png)


#### CPU指令重排

示例代码：

```java
public class ReorderTest
{
    public static void main(String[] args)
    {
        ReorderTest r = new ReorderTest();
    }
}
```

反汇编：`javap -l -v -c ./classes/main/ReorderTest.class > reorder_asm`


#### CPU指令执行周期

> https://software.intel.com/content/www/cn/zh/develop/articles/book-processor-architecture_cpu_work_process.html



因为一条汇编指令的执行被cpu分为多个指令周期，cpu在执行多条指令的过程中会根据情况来选择指令执行的先后顺序，比如

* cpu高速缓存当前在等待同步，转而去处理其他指令
* cpu为了保证流水线的并发速度，会将部分取指（FI）指令提前执行
* 编译器也会在某些情况下将编译后的机器指令重排序，提高cpu的处理速度













