package com.github.brezp.design.composite.engine;

import com.github.brezp.design.composite.model.EngineResult;
import com.github.brezp.design.composite.model.Tree;
import com.github.brezp.design.composite.model.TreeNode;

import java.util.Map;

public class EngineHandle extends EngineBase {

    @Override
    public EngineResult process(Long treeId, String userId, Tree treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }

}
