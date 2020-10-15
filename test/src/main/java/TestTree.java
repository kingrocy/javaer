import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Date : 2020/10/15 9:56 上午
 * @Author : dushaoyun
 */
public class TestTree {

    public static void main(String[] args) {


        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(3, treeNode7, treeNode9);
        TreeNode treeNode5 = new TreeNode(5, treeNode10, treeNode15);


        TreeNode root = new TreeNode(1, treeNode3, treeNode5);

        TreeNode[] treeNodes = arrayStore(root, 7);

        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode);
        }
    }


    /**
     * 使用数组来存储一颗 完全二叉树
     * @param root
     * @param size
     * @return
     */
    public static TreeNode[] arrayStore(TreeNode root, int size) {
        TreeNode[] arr = new TreeNode[size + 1];
        deep(arr, root, 1);
        return arr;
    }


    public static void deep(TreeNode[] arr, TreeNode node, int i) {
        arr[i] = node;
        if (node.leftChild != null) {
            deep(arr, node.leftChild, i * 2);
        }
        if (node.rightChild != null) {
            deep(arr, node.rightChild, i * 2 + 1);
        }
    }
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class TreeNode {

    int val;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
