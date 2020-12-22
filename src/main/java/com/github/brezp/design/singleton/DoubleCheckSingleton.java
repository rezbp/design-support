package com.github.brezp.design.singleton;

/**
 * 双检锁写法
 *
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 *
 * @author brezp
 */
public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheckSingleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheckSingleton == null) {
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }
}
