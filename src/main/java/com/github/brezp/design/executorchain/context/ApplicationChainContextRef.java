package com.github.brezp.design.executorchain.context;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

/**
 * ApplicationChain处理链中各个阶段 ExecutorContext 的引用
 *
 *
 */
@Getter
@Setter
public class ApplicationChainContextRef extends ChainContextRef implements Serializable {

    public ApplicationChainContextRef() {
        configClazz2ExecutorContextMap = new HashMap<>(0);
    }


}
