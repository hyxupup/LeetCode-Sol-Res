package com.freetymekiyan.algorithms.level.medium;

import com.freetymekiyan.algorithms.utils.Utils.ListNode;
import com.freetymekiyan.algorithms.utils.Utils.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * <p>
 * Tags: DFS, Linked list
 */
class ConvertSortedListToBST {

  private ListNode cur;

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    cur = head;
    return buildTree(lengthOfList(head));
  }

  /**
   * Bottom up approach, O(n) (Instead of top-down, O(nlogn))
   * <p>
   * STEP 1: Take left n/2 nodes and recursively construct the left sub tree.
   * <p>
   * STEP 2: After left sub tree is constructed, we allocate memory for root
   * and link the left sub tree with root.
   * <p>
   * STEP 3: Finally, we recursively construct the right sub tree and link it
   * with root.
   */
  public TreeNode buildTree(int n) {
    if (n == 0) return null;
    TreeNode node = new TreeNode(0);
    node.left = buildTree(n / 2);
    node.val = cur.val;
    cur = cur.next;
    // Why n - n/2 - 1?
    // The # of nodes in right subtree is
    // total nodes - nodes in left subtree - root
    node.right = buildTree(n - n / 2 - 1);
    return node;
  }

  private int lengthOfList(ListNode node) {
    int length = 0;
    while (node != null) {
      node = node.next;
      length++;
    }
    return length;
  }
}