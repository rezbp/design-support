package com.github.brezp.design.composite.engine;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**

 * @author brezp
 */
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        //logicFilterMap.put("userAge", new UserAgeFilter());
        //logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }

}
