package com.github.brezp.design.test.builder;

import com.github.brezp.design.builder.IMatter;

import java.math.BigDecimal;

/**
 * 装修物料
 */
public interface Matter extends IMatter {

    /**
     * 场景；地板、地砖、涂料、吊顶
     */
    String scene();

    /**
     * 品牌
     */
    String brand();

    /**
     * 型号
     */
    String model();

    /**
     * 平米报价
     */
    BigDecimal price();

    /**
     * 描述
     */
    String desc();

}
