/**
 * @Date : 2020/10/30 6:26 下午
 * @Author : dushaoyun
 */
public class TestTree2 {


    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(3, treeNode7, treeNode9);
        TreeNode treeNode5 = new TreeNode(5, treeNode10, treeNode15);


        TreeNode root = new TreeNode(1, treeNode3, treeNode5);



    }

    //打印二叉树从跟节点到子节点的所有路径



}
