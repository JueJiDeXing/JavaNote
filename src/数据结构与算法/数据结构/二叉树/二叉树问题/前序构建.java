package 数据结构与算法.数据结构.二叉树.二叉树问题;

import 数据结构与算法.数据结构.二叉树.Node.MyTreeNode;

public class 前序构建 {
    //遍历插入
    public MyTreeNode bstFromPreOrder(int[] preOrder) {
        MyTreeNode root = new MyTreeNode(preOrder[0]);
        for (int i = 1; i < preOrder.length; i++) {
            int value = preOrder[i];
            insert(root, value);

        }
        return root;
    }

    private MyTreeNode insert(MyTreeNode node, int value) {
        if (node == null) {
            return new MyTreeNode(value);
        }
        int nodeValue = (int) node.value;
        if (value < nodeValue) {
            node.left = insert(node.left, value);
        } else if (nodeValue < value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    //上限法
    int i = 0;

    private MyTreeNode insert2(int[] preOrder, int max) {
        if (i == preOrder.length) {
            return null;
        }
        int value = preOrder[i];
        if (value > max) {//超过上限,不能再添加了(preOrder为前序遍历)
            return null;
        }
        MyTreeNode node = new MyTreeNode(value);
        i++;//找到下一个值,看下一个值能否作为左孩子,能否作为右孩子,如果都不能则返回null,这个节点应该插入在别的子树上
        node.left = insert2(preOrder, value);//左上限为当前节点值
        node.right = insert2(preOrder, max);//右上限为从根节点至下传递而来的max
        return node;
    }

    //分治法
    /* preOrder 第一个为根节点,比根节点小的为左子树,大的为右子树,左右子树又可以再次拆分
    8,5,1,7,10,12
    根8   左5,1,7           右10,12
         根5  左1 右7       根10 左null右12
     */
    private MyTreeNode partition(int[] preOrder, int start, int end) {
        if (start > end) {//没有元素,已处理完
            return null;
        }
        MyTreeNode root = new MyTreeNode(preOrder[start]);
        int index = start + 1;
        while (index <= end) {
            if (preOrder[index] > (int) root.value) {
                break;
            }
            index++;
        }
        // start根节点 start+1左子树起点 index-1左子树终点 index右子树起点 end右子树终点
        root.left = partition(preOrder, start + 1, index - 1);
        root.right = partition(preOrder, index, end);
        return root;
    }
}
