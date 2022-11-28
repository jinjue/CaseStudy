package studyStru.Graph;

import pojo.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphClone {

    //创建hashmap用于存放已访问过的节点
    HashMap<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node res = new Node(node.val,new ArrayList<>());
        visited.put(node,res);

        for (Node neighbor : node.neighbors) {
            res.neighbors.add(cloneGraph(neighbor));
        }

        return res;
    }
}
