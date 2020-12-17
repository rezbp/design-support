package com.github.brezp.design.executorchain.exec;

import com.github.brezp.design.executorchain.context.ChainContextRef;

/**
 * StageExecutorChain
 *
 *
 */
public interface ExecutorChain {

    void execute() throws Exception;

    ChainContextRef getChainContextRef();
}
