package com.github.brezp.design.composite.engine;


import com.github.brezp.design.composite.model.EngineResult;
import com.github.brezp.design.composite.model.Tree;
import com.github.brezp.design.composite.model.TreeNode;
import com.github.brezp.design.composite.model.TreeRoot;

import java.util.Map;

/**
 */
public abstract class EngineBase extends EngineConfig implements IEngine {


    private static final int LEAF = 1;

    @Override
    public abstract EngineResult process(Long treeId, String userId, Tree treeRich, Map<String, String> decisionMatter);

    protected TreeNode engineDecisionMaker(Tree treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
        //节点类型[NodeType]；1子叶、2果实
        while (treeNodeInfo.getNodeType().equals(LEAF)) {
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            treeNodeInfo = treeNodeMap.get(nextNode);
        }
        return treeNodeInfo;
    }

}
