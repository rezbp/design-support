package com.github.brezp.design.executorchain.config;

import com.github.brezp.design.executorchain.context.ExecutorContext;

/**
 * StageExecutorConfig
 *
 *
 */
public interface ExecutorConfig<T extends ExecutorContext> {

    T getExecutorContext() throws Exception;
}
