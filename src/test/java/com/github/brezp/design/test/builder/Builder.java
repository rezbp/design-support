package com.github.brezp.design.test.builder;


import com.github.brezp.design.builder.AbstractBuilder;
import com.github.brezp.design.test.builder.ceiling.LevelOneCeiling;
import com.github.brezp.design.test.builder.ceiling.LevelTwoCeiling;
import com.github.brezp.design.test.builder.coat.DuluxCoat;
import com.github.brezp.design.test.builder.coat.LiBangCoat;
import com.github.brezp.design.test.builder.floor.ShengXiangFloor;

public class Builder extends AbstractBuilder {

    public BuildMenu levelOne(Double area) {
        return new DecorationPackager(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public BuildMenu levelTwo(Double area) {
        return new DecorationPackager(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())// 吊顶，二级顶
                .appendCoat(new LiBangCoat());        // 涂料，立邦
    }

    public BuildMenu levelThree(Double area) {
        return new DecorationPackager(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat());        // 涂料，立邦

    }

}
