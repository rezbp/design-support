package com.github.brezp.design.executorchain.exec;

import com.github.brezp.design.executorchain.context.ExecutorContext;

/**
 * StageExecutor
 *
 *
 */
public interface Executor<T extends ExecutorContext> {

//    void init(ExecutorConfig config);

    void execute(T context, ExecutorChain chain) throws Exception;

    void postExecute(T context, ExecutorChain chain) throws Exception;
}
