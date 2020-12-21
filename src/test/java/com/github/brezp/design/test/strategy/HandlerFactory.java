package com.github.brezp.design.test.strategy;


import com.github.brezp.design.strategy.AbstractHandlerFactory;
import com.github.brezp.design.strategy.IHandler;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * HandlerFactory
 *
 */
@Slf4j
public class HandlerFactory extends AbstractHandlerFactory {

    @Getter
    public enum Handler {

        /**
         * 占比计算
         */
        RATIO("ratio", RatioHandler.class);

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
