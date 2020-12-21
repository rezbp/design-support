package com.github.brezp.design.test.executorchain;

import com.github.brezp.design.executorchain.ExecutorChainBootstrap;
import com.github.brezp.design.executorchain.config.AbstractExecutorConfig;
import com.github.brezp.design.executorchain.context.ExecutorContext;
import lombok.Builder;
import lombok.experimental.UtilityClass;

/**
 * AppStageExecutorFactory
 *
 */
@SuppressWarnings("rawtypes")
@UtilityClass
public class ExecutorFactory {


    /**
     * 创建导出数据的处理器链
     * csvUtil 写入csv文件
     */
    public <T extends ExecutorContext> ExecutorChainBootstrap<T> createNormalizedExecutorChain(TobeNormalizedExecutorChainInitParam initParam) {
        ExecutorChainBootstrap<T> executorChain = new ExecutorChainBootstrap<>();

        // 数据导出
        AbstractExecutorConfig normalizedExecutorConfig = new TrendNormalizedExecutorConfig(new ProductTrendNormalizedExecutor(), initParam.appCategory, initParam.socialIndexAndType, initParam.ecomIndexAndType,
                initParam.normalizedTaskName, initParam.normalizedTaskDescription, initParam.time, initParam.lastTobeNormalizedFilePath, "product.trend.normalized.hdfsPath");
        executorChain.addExecutor(normalizedExecutorConfig);
        return executorChain;
    }

    @Builder
    public static class TobeNormalizedExecutorChainInitParam {
        private long startTime;
        private long endTime;
        private AppCategory appCategory;
        //      private TrendAlgoParam trendAlgoParam;
        String yarnQueue;
        /**
         * 归一化需要使用到的字段
         */
        private String socialIndexAndType;
        private String ecomIndexAndType;
        private String normalizedTaskName;
        private String normalizedTaskDescription;
        private String time;
        private String lastTobeNormalizedFilePath;
    }


}
