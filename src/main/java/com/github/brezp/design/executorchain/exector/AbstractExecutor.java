package com.github.brezp.design.executorchain.exector;

/**
 * AbstractExecutor
 *
 *
 * @author brezp
 */
public abstract class AbstractExecutor<T extends ExecutorContext> implements ExecutorConfig<T> {

    private Executor<T> executor;

    public AbstractExecutor(Executor<T> executor) {
        this.executor = executor;
    }

    public Executor<T> getExecutor() {
        return executor;
    }

}
