package com.github.brezp.design.strategy;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * AbstractHandlerFactory
 *
 *
 * @author brezp
 */
@Slf4j
@UtilityClass
public class AbstractHandlerFactory {

    /**
     * 创建handler处理，并返回第一个handler实例
     *
     * @param handlerName handler名称
     * @return 第一个handler实例
     */
    public IHandler createHandler(String handlerName) throws Exception {
        if (!"".equals(handlerName)) {
            Handler handler = Handler.getHandler(handlerName);
            return (IHandler) Class.forName(handler.getClazz().getName()).newInstance();
        } else {
            throw new RuntimeException("参数'handlerNames'不能为空");
        }
    }

    @Getter
    public enum Handler {

        ;

        private String handlerName;
        private Class<? extends IHandler> clazz;

        Handler(String handlerName, Class<? extends IHandler> clazz) {
            this.handlerName = handlerName;
            this.clazz = clazz;
        }

        public static Handler getHandler(String name) {
            return Lists.newArrayList(values()).stream().filter(handler -> handler.getHandlerName().equals(name)).findFirst().orElse(null);
        }
    }
}
