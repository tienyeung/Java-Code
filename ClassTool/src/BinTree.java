public class BinTree {
    public static void main(String[] args) {

    }
}
class Tree<T extends Comparable<T>>{
    private class Node{
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;
        public Node(Comparable<T> data){
            this.data = data;
        }
        public void addNode(Node newNode){
            if(newNode.data.compareTo((T)this.data)<=0){//比当前节点数据小
                if(this.left==null){//现在没有左子树
                    this.left = newNode;
                    newNode.parent = this;
                }else{
                    this.left.addNode(newNode);
                }
                }else{
                if(this.right == null){
                    this.right = newNode;
                    newNode.parent=this;
                }else{
                    this.right.addNode(newNode);
                }
            }
        }
        public void toArrayNode(){
            //中序遍历
            if(this.left!=null){
                this.left.toArrayNode();
            }
            Tree.this.returnData[Tree.this.foot++] = this.data;
            if(this.right!=null){
                this.right.toArrayNode();
            }

        }
    }
    //-------binaryTree操作--------
    private Node root;
    private int count;
    private Object[] returnData;
    private int foot = 0;
    public void add(Comparable<T> data){
        if(data==null){
            throw new NullPointerException("不允许为空!");
        }
        Node newNode = new Node(data);
        if(this.root==null){
            this.root=newNode;
        }else{
            this.root.addNode(newNode);
        }
        count++;
    }
    public Object[] toArray(){
        if(this.count==0){
            return null;
        }
        this.returnData = new Object[this.count];
        this.foot=0;
        this.root.toArrayNode();
        return this.returnData;
    }
}

