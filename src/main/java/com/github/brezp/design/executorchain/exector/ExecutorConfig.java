package com.github.brezp.design.executorchain.exector;

/**
 * StageExecutorConfig
 *
 *
 * @author brezp
 */
public interface ExecutorConfig<T extends ExecutorContext> {

    T getExecutorContext() throws Exception;
}
