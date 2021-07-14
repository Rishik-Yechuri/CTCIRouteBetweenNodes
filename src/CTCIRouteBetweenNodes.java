import java.util.*;
public class CTCIRouteBetweenNodes {
    public static void main(String[] args) {
        try{
            CTCIRouteBetweenNodes obj = new CTCIRouteBetweenNodes();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        Node[] holdNodes = new Node[]{new Node(0),new Node(1),new Node(2),new Node(3),new Node(4),new Node(5),new Node(6),new Node(7),new Node(8),new Node(9),new Node(10),new Node(11)};
        holdNodes[0].children = new Node[]{holdNodes[6]};
        holdNodes[1].children = new Node[]{holdNodes[5],holdNodes[8]};
        holdNodes[2].children = new Node[]{holdNodes[5],holdNodes[11]};
        holdNodes[3].children = new Node[]{holdNodes[1],holdNodes[2],holdNodes[4],holdNodes[5]};
        holdNodes[4].children = new Node[]{holdNodes[7]};
        holdNodes[6].children = new Node[]{holdNodes[9]};
        holdNodes[7].children = new Node[]{holdNodes[0]};
        holdNodes[8].children = new Node[]{holdNodes[4]};
        holdNodes[9].children = new Node[]{holdNodes[11]};
        holdNodes[10].children = new Node[]{holdNodes[10]};
        Graph graph = new Graph(holdNodes);
        System.out.println(isConnected(holdNodes[11],holdNodes[5]));
    }
    public boolean isConnected(Node node1,Node node2){
        if(checkIfPathExists(node1,node2)){
            return true;
        }
        if(checkIfPathExists(node2,node1)){
            return true;
        }
        return false;
    }
    public boolean checkIfPathExists(Node node1,Node node2){
        HashSet<Node> visitedNodes = new HashSet<Node>();
        Queue<Node> queue = new LinkedList<>();
        visitedNodes.add(node1);
        queue.add(node1);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            visitedNodes.add(currentNode);
            if(currentNode == node2){
                return true;
            }
            Node[] nodes = currentNode.children;
            if(nodes != null){
                for(int x=0;x<nodes.length;x++){
                    if(!visitedNodes.contains(nodes[x])){
                        queue.add(nodes[x]);
                    }
                }
            }
        }
        return false;
    }
}
class Graph {
    public Node[] nodes;
    public Graph(Node[] nodes){
        this.nodes = nodes;
    }
}
class Node {
    public int num;
    public Node[] children;
    public Node(int tempNum,Node[] tempChildren){
        num = tempNum;
        children = tempChildren;
    }
    public Node(int tempNum){
        num = tempNum;
    }
}