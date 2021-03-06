package binarytree;

import java.util.*;

/**
 * 二叉树中序遍历
 * <p>二叉树中序遍历是指在遍历一颗二叉树的时候首先遍历其左节点然后遍历根节点最后遍历右节点，例如：</p>
 * <pre>
 *     1
 *   /  \
 *  6    2
 *     /  \
 *    3    9
 *
 * 输出: [6,1,3,2,9]
 * </pre>
 * @see 二叉树后序遍历
 * @see 二叉树先序遍历
 * @author ：huangxin
 * @modified ：
 * @since ：2020/06/27 20:50
 */
public class 二叉树中序遍历 {

    private static List<Integer> ans = new ArrayList<>();

    /**
     * 二叉树中序遍历——递归版
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        inOrder(root.left);
        ans.add(root.val);
        inOrder(root.right);
        return ans;
    }

    /**
     * 二叉树中序遍历——非递归版
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //"一头扎下去"
                stack.push(root);
                root = root.left;
            }
            //左--->根--->右
            TreeNode node = stack.pop();
            ans.add(node.val);
            root = node.right;
        }
        return ans;
    }


    public static void main(String[] args) {
        /**
         *             4
         *            / \
         *           3   7
         *          /   / \
         *         1   5   9
         *        / \       \
         *      -1  2       12
         *  温馨提示：二叉排序树的中序遍历结果是一个有序的集合
         */
        int[] arr = new int[]{4, 3, 7, 1, -1, 2, 9, 12, 5};
        System.out.println(Arrays.toString(inOrder(TreeNode.createBinarySearchTree(arr)).toArray()));
        System.out.println(Arrays.toString(inOrder2(TreeNode.createBinarySearchTree(arr)).toArray()));
    }

}
