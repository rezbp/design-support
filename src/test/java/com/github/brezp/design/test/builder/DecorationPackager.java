package com.github.brezp.design.test.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 装修包
 */
public class DecorationPackager implements BuildMenu {

    private List<Matter> list = new ArrayList<Matter>();  // 装修清单
    private BigDecimal price = BigDecimal.ZERO;      // 装修价格

    private BigDecimal area;  // 面积
    private String grade;     // 装修等级；豪华欧式、轻奢田园、现代简约

    private DecorationPackager() {
    }

    public DecorationPackager(Double area, String grade) {
        this.area = new BigDecimal(area);
        this.grade = grade;
    }

    public BuildMenu appendCeiling(Matter IMatter) {
        list.add(IMatter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(IMatter.price()));
        return this;
    }

    public BuildMenu appendCoat(Matter IMatter) {
        list.add(IMatter);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(IMatter.price()));
        return this;
    }

    public BuildMenu appendFloor(Matter IMatter) {
        list.add(IMatter);
        price = price.add(area.multiply(IMatter.price()));
        return this;
    }

    public BuildMenu appendTile(Matter IMatter) {
        list.add(IMatter);
        price = price.add(area.multiply(IMatter.price()));
        return this;
    }

    public String getDetail() {

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter : list) {
        }

        return detail.toString();
    }

}
