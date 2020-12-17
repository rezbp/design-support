package com.github.brezp.design.executorchain.exec;

import com.github.brezp.design.executorchain.context.ChainContext;

/**
 * StageExecutorChain
 *
 *
 */
public interface ExecutorChain {

    void execute() throws Exception;

    ChainContext getChainContextRef();
}
