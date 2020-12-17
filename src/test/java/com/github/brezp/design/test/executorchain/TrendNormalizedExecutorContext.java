package com.github.brezp.design.test.executorchain;
import com.github.brezp.design.executorchain.context.ExecutorContext;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * TrendNormalizedExecutorContext
 *
 * @author wangdahao
 */
@Getter
@Setter
@Accessors(chain = true)
public class TrendNormalizedExecutorContext extends ExecutorContext {

    private AppCategory appCategory;
    /**
     * 社媒数据索引，主要是用于获取待归一化文件中趋势的词频和原文
     * 索引名称与type之间用"/"分隔
     */
    private String socialIndexAndType;

    /**
     * 电商数据索引，主要是用于获取待归一化文件中趋势的词频和原文
     * 索引名称与type之间用"/"分隔
     */
    private String ecomIndexAndType;

    /**
     * 归一化任务名称
     */
    private String normalizedTaskName;
    /**
     * 归一化任务描述
     */
    private String normalizedTaskDescription;

    /**
     * 榜单时间
     */
    private String time;

    /**
     * 上一次待归一化的文件路径，需要这份文件和这一次的待归一文件合并
     */
    private String lastTobeNormalizedFilePath;

    /**
     * 归一化流程中文件存储在hdfs的路径
     */
    private String normalizedHdfsDir;
}
