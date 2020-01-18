/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode deleteTree(TreeNode root, int key) {
    // T: 找到key之前的部分 + findSmallest的while部分 => max： O(h); S: O(h);
    if(root == null) {
      return root;
    }
    //find the key,有4种情况考虑
    if(root.key == key) {
      if(root.left == null) {
          return root.right;
      } else if(root.right == null) {
        return root.left;
      } else if(root.right.left == null) {
        root.right.left = root.left;
        return root.right;
        //最后两个情况不分开写，如果合并在一起
        //在findS函数中会出现N，语句 cur = cur.left会出现PE
      } else {
        //这里注意是找右子树的最小值，传入值是root.right
        TreeNode smallest = findSmallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
      }
    }
    if(root.key > key) {
      root.left = deleteTree(root.left, key);
    } else if(root.key < key ) {
      root.right = deleteTree(root.right, key);
    }
    return root;
  }

  private TreeNode findSmallest(TreeNode cur) {
    //一路从left走到底，cur为最小值，pre为cur的parent
      TreeNode prev = cur;
      cur = cur.left;
      while(cur.left != null) {
        prev = cur;
        cur = cur.left;
      }
      // cur 为最小值，pre要与cur的right child 挂钩
      prev.left = cur.right;
      return cur;
  }
}
