package com.github.brezp.design.composite.engine;

import com.github.brezp.design.composite.model.EngineResult;
import com.github.brezp.design.composite.model.Tree;

import java.util.Map;

/**
 *
 * 可以看到这有点像螺丝 ( 和螺⺟，通过⼀堆的链接组织出⼀棵结构树。⽽这种通过把相似对象
 * (也可以称作是⽅法)组合成⼀组可被调⽤的结构树对象的设计思路叫做组合模式。
 * 这种设计⽅式可以让你的服务组节点进⾏⾃由组合对外提供服务，例如你有三个原⼦校验功能( A：身份
 * 证 、 B：银⾏卡 、 C：⼿机号 )服务并对外提供调⽤使⽤。有些调⽤⽅需要使⽤AB组合，有些调⽤⽅需要
 * 使⽤到CBA组合，还有⼀些可能只使⽤三者中的⼀个。那么这个时候你就可以使⽤组合模式进⾏构建服
 * 务，对于不同类型的调⽤⽅配置不同的组织关系树，⽽这个树结构你可以配置到数据库中也可以不断的
 * 通过图形界⾯来控制树结构。
 * @author brezp
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, Tree tree, final Map<String, String> decisionMatter);

}
