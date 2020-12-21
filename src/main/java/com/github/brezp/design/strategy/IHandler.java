package com.github.brezp.design.strategy;

import java.util.Map;

/**
 * AbstractHandler
 *
 *
 */
public interface IHandler<IN> {

    /**
     * 留给子类实现，用于子类实现其任务处理逻辑
     *
     * @param input 输入数据
     * @param extractParams 额外附加的参数
     * @return 下个handler的输入数据或者最终方舟组件的数据格式
     */
    <T> T doHandler(IN input, Map<String, Object> extractParams);
}
