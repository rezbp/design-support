package com.github.brezp.design.test.builder;

import com.github.brezp.design.builder.IMenu;
import com.github.brezp.design.builder.IMatter;

interface BuildMenu extends IMenu {

    /**
     * 吊顶
     */
    BuildMenu appendCeiling(Matter IMatter);

    /**
     * 涂料
     */
    BuildMenu appendCoat(Matter IMatter);

    /**
     * 地板
     */
    BuildMenu appendFloor(Matter IMatter);

    /**
     * 地砖
     */
    BuildMenu appendTile(Matter IMatter);

    /**
     * 明细
     */
    String getDetail();

}
