package com.github.brezp.design.executorchain.exector;

import com.github.brezp.design.executorchain.chain.ExecutorChain;

/**
 * StageExecutor
 *
 *
 */
public interface Executor<T extends ExecutorContext> {

    void execute(T context, ExecutorChain chain) throws Exception;

    void postExecute(T context, ExecutorChain chain) throws Exception;
}
