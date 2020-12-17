package com.github.brezp.design.executorchain;

import com.github.brezp.design.executorchain.config.AbstractExecutorConfig;
import com.github.brezp.design.executorchain.context.ApplicationChainContextRef;
import com.github.brezp.design.executorchain.context.ExecutorContext;
import com.github.brezp.design.executorchain.exec.Executor;
import com.github.brezp.design.executorchain.exec.ExecutorChain;

import java.util.LinkedList;
import java.util.Map;

/**
 * ApplicationExecutorChain
 *
 *
 */
public class ApplicationExecutorChain<T extends ExecutorContext> implements ExecutorChain {

    private LinkedList<AbstractExecutorConfig<T>> executorConfigs;

    private int pos = 0;

    @Override
    public void execute() throws Exception {
        if (pos < executorConfigs.size()) {
            AbstractExecutorConfig<T> executorConfig = executorConfigs.get(pos++);
            Executor<T> executor = executorConfig.getExecutor();

            T executorContext;
            Map<String, Object> clazz2ExecutorContextMap = this.getChainContextRef().getConfigClazz2ExecutorContextMap();
            String key = executorConfig.getClass().getName();
            if (clazz2ExecutorContextMap.containsKey(key)) {
                //noinspection unchecked
                executorContext = (T) clazz2ExecutorContextMap.get(key);
            } else {
                executorContext = executorConfig.getExecutorContext();
            }
            // 执行具体业务逻辑代码
            executor.execute(executorContext, this);

            // 执行完成之后缓存ExecutorContext实例
            clazz2ExecutorContextMap.put(key, executorContext);

            // 执行后续操作，做一些资源关闭、任务状态更新等操作，并调用下一个Executor
            executor.postExecute(executorContext, this);
        }
    }

    public void addExecutor(AbstractExecutorConfig<T> executorConfig) {
        if (executorConfigs == null) {
            executorConfigs = new LinkedList<>();
        }
        executorConfigs.add(executorConfig);
    }

    private ApplicationChainContextRef chainContextRef = new ApplicationChainContextRef();

    @Override
    public ApplicationChainContextRef getChainContextRef() {
        return this.chainContextRef;
    }
}
