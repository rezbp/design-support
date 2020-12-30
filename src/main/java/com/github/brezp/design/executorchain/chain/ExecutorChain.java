package com.github.brezp.design.executorchain.chain;

/**
 * StageExecutorChain
 *
 *
 * @author brezp
 */
public interface ExecutorChain {

    void execute() throws Exception;

    ChainContext getChainContextRef();
}
