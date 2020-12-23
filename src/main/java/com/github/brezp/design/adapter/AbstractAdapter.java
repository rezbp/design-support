package com.github.brezp.design.adapter;


import cn.hutool.json.JSONUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
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
