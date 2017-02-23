package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CfindFrequentTreeSum {
	 //private TreeNode root; 
	 List<TreeNode> treeNodes = new ArrayList<>();
	 static Map<Integer, Integer> rsMap = null;
	 static int max = Integer.MIN_VALUE;
	 public static int[] findFrequentTreeSum(TreeNode root) {
		  rsMap = new HashMap<>();
		  List<Integer> rsList = new ArrayList<>();
		  if (root==null) {
			return new int[0];
		  }
		  postTrav(root);
		  for (Integer element : rsMap.keySet()) {
			if (rsMap.get(element)==max) {
				rsList.add(element);
			}
		}
	    int[] rs  = new int[rsList.size()];
	    for (int i = 0; i < rsList.size(); i++) {
			rs[i] = rsList.get(i);
		}
	    return rs;
	 }
	 
	 
	 public static int postTrav(TreeNode root){
		 int sum;
		 if (root==null) {
			return 0;
		 } 
		int left = postTrav(root.left);
		int right = postTrav(root.right);
		sum = root.val+left+right;
		int count = rsMap.getOrDefault(sum, 0)+1;
		rsMap.put(sum, count);
		max = Math.max(max, count);
		return sum;
	 }
	 /**
	  * 二叉树构建
	  * @param a
	  */
	 public void creatTree(int[] a) {
		for (int i = 0; i < a.length; i++) {
			treeNodes.add(new TreeNode(a[i]));
		}
		for (int i = 0; i < a.length/2-1; i++) {
			treeNodes.get(i).left = treeNodes.get(i*2+1);
			treeNodes.get(i).right = treeNodes.get(i*2+2);
		}
		int lastNode = a.length/2-1;
		treeNodes.get(lastNode).left = treeNodes.get(lastNode*2+1);
		if (a.length%2==1) {
			treeNodes.get(lastNode).right = treeNodes.get(lastNode*2+2);
		}
	}
	 
	 public static void main(String[] args) {
		 int[] a = {5,2,-3};  
		 CfindFrequentTreeSum bTree = new CfindFrequentTreeSum();  
		 bTree.creatTree(a);
		 int[] out = findFrequentTreeSum(bTree.treeNodes.get(0));
		 for (int i : out) {
			System.out.print(i+"   ");
		}
	}
}
