package com.github.brezp.design.composite.engine;

import com.github.brezp.design.composite.model.EngineResult;
import com.github.brezp.design.composite.model.Tree;

import java.util.Map;

/**
 * @author brezp
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, Tree tree, final Map<String, String> decisionMatter);

}
