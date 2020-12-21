package com.github.brezp.design.test.executorchain;

import lombok.extern.slf4j.Slf4j;

/**
 * ProductTrendNormalizedExecutor
 *
 */
@Slf4j
public class ProductTrendNormalizedExecutor extends AbstractTrendNormalizedExecutor {


    @Override
    protected boolean generateTobeNormalizedFile(TrendNormalizedExecutorContext context, String toBeNormalizedFilePath) throws Exception {
        return false;
    }

    @Override
    protected boolean generateNormalizedMappingFile(TrendNormalizedExecutorContext context, String normalizedMappingFilePath) throws Exception {
        return false;
    }
}
