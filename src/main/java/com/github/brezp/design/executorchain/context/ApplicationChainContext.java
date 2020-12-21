package com.github.brezp.design.executorchain.context;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

/**
 * ApplicationChain处理链中各个阶段 ExecutorContext 的引用
 *
 *
 * @author brezp
 */
@Getter
@Setter
public class ApplicationChainContext extends ChainContext implements Serializable {

    public ApplicationChainContext() {
        configClazz2ExecutorContextMap = new HashMap<>(0);
    }


}
