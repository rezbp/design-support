package com.github.brezp.design.adapter;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 适配器模式的主要作⽤就是把原本不兼容的接⼝，通过适配修改做到统⼀。
 *
 * @author brezp
 */
public abstract class AbstractAdapter {

    public static MetaInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MetaInfo metaInfo = new MetaInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            MetaInfo.class
                    .getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class)
                    .invoke(metaInfo, val.toString());
        }
        return metaInfo;
    }

}
