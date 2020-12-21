package com.github.brezp.design.executorchain.config;

import com.github.brezp.design.executorchain.exec.Executor;
import com.github.brezp.design.executorchain.context.ExecutorContext;

/**
 * AbstractExecutorConfig
 *
 *
 * @author brezp
 */
public abstract class AbstractExecutorConfig<T extends ExecutorContext> implements ExecutorConfig<T> {

    private Executor<T> executor;

    public AbstractExecutorConfig(Executor<T> executor) {
        this.executor = executor;
    }

    public Executor<T> getExecutor() {
        return executor;
    }

}
