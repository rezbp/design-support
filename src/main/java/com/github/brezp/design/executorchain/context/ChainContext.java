package com.github.brezp.design.executorchain.context;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * Chain处理链中各个阶段 ExecutorContext 的引用
 *
 *
 * @author brezp
 */
@Getter
@Setter
public class ChainContext implements Serializable {

    /**
     * ExecutorConfig类名与ExecutorContext实例的映射
     * 不同阶段的ExecutorConfig内部如果使用了相关的ExecutorContext，只是Executor不一样，则后面的阶段可以复用前一个阶段的ExecutorContext
     * 注：ExecutorContext中有些属性是在Executor运行时生成
     */
    Map<String, Object> configClazz2ExecutorContextMap;
}
