package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class ClargestValues {
	 //private TreeNode root; 
	 List<TreeNode> treeNodes = new ArrayList<>();
	 
	 public static List<Integer> largestValues(TreeNode root) {
		 if (root==null) {
			return new ArrayList<>();
		}
		    Queue<TreeNode> queue = new LinkedList<>();
		    queue.add(root);
		    List<Integer> rList = new ArrayList<>();
		    while(!queue.isEmpty()){
		    	int size = queue.size();
		    	int max = Integer.MIN_VALUE;
		    	for (int i = 0; i < size; i++) {
		    		TreeNode cur = queue.poll();
		    		max = Math.max(max, cur.val);
			    	if (cur.left!=null) {
						queue.add(cur.left);
					}
			    	if (cur.right!=null) {
						queue.add(cur.right);
					}
				}
		       rList.add(max);
		    }
	        return rList;
	 }
	//---------------------------------层遍历------------------------------------------//
	 /**
	  * 层遍历
	  */
	 public static void levTrav(TreeNode root) {
		    Queue<TreeNode> queue = new LinkedList<>();
		    queue.add(root);
		    while(!queue.isEmpty()){
		    	TreeNode cur = queue.poll();
		    	System.out.print(cur.val+"  ");
		    	if (cur.left!=null) {
					queue.add(cur.left);
				}
		    	if (cur.right!=null) {
					queue.add(cur.right);
				}
		    }
	 }
	//---------------------------------递归遍历------------------------------------------//
	 /**
	  * 先序递归遍历
	  */
	 public void preRecTrav(TreeNode node) {
		if (node==null) {
			return;
		}
		System.out.print(node.val+"  ");
		preRecTrav(node.left);
		preRecTrav(node.right);
	}
	 /**
	  * 中序递归遍历
	  */
	 public void InRecTrav(TreeNode node) {
			if (node==null) {
				return;
			}
			InRecTrav(node.left);
			System.out.print(node.val+"  ");
			InRecTrav(node.right);
		}
	 
	 /**
	  * 后序递归遍历
	  */
	 public void PostRecTrav(TreeNode node) {
			if (node==null) {
				return;
			}
			PostRecTrav(node.left);
			PostRecTrav(node.right);
			System.out.print(node.val+"  ");
		}
	//---------------------------------非递归遍历------------------------------------------//
	/**
	 * 先序遍历
	 * @param node
	 */
	 public void PreTrav(TreeNode node) {
		   if (node==null) {
			return;
		   }
		   Stack<TreeNode> stack = new Stack<>();
		   while (node!=null||!stack.isEmpty()) {
			  while (node!=null) {
				System.out.print(node.val+"  ");
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
	 }
	 
	 /**
	  * 中序遍历
	  */
	 public void inTrav(TreeNode node) {
		   if (node==null) {
			return;
		   }
		   Stack<TreeNode> stack = new Stack<>();
		   while (node!=null||!stack.isEmpty()) {
			  while (node!=null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			System.out.print(node.val+"  ");
			node = node.right;
		}
	 }
	 /**
	  * 后序遍历
	  */
	 public void postTrav(TreeNode root){  
	        if(root==null)return;  
	        Stack<TreeNode> s=new Stack<TreeNode>();  
	        Map<TreeNode,Boolean> map=new HashMap<TreeNode,Boolean>();   
	        s.push(root);  
	        while(!s.isEmpty()){  
	        	TreeNode temp=s.peek();  
	            if(temp.left!=null&&!map.containsKey(temp.left)){  
	                temp=temp.left;  
	                while(temp!=null){  
	                    if(map.containsKey(temp))break;  
	                    else s.push(temp);  
	                    temp=temp.left;  
	                }  
	                continue;  
	            }  
	            if(temp.right!=null&&!map.containsKey(temp.right)){  
	                s.push(temp.right);  
	                continue;  
	            }  
	            TreeNode t=s.pop();  
	            map.put(t,true);  
	            System.out.print(t.val+"  ");  
	        }  
	    }  
	 
	//---------------------------------构建------------------------------------------//
	 /**
	  * 二叉排序树 二叉查找树 二叉搜索树构建
	  */
	 public void buildTree(TreeNode node, int data) {
		if(data < node.val){  
		if (node.left==null) {
			node.left = new TreeNode(data);
		}
		else{
			buildTree(node.left, data);
		}
		 }
		 else {
			 if (node.right==null) {
					node.right = new TreeNode(data);
				}
				else{
					buildTree(node.right, data);
				}
		}
		
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
		 int[] a = {2,4,12,45,21,6,111};  
		 ClargestValues bTree = new ClargestValues();  
		 /*bTree.root = new TreeNode(1);
	        for (int i = 0; i < a.length; i++) {  
	            bTree.buildTree(bTree.root, a[i]);  
	        }  
	      largestValues(bTree.root);*/
		 bTree.creatTree(a);
		 levTrav(bTree.treeNodes.get(0));
		 System.out.println();
		 bTree.preRecTrav(bTree.treeNodes.get(0));
		 System.out.println();
		 bTree.InRecTrav(bTree.treeNodes.get(0));
		 System.out.println();
		 bTree.PostRecTrav(bTree.treeNodes.get(0));
		 System.out.println();
		 bTree.PreTrav(bTree.treeNodes.get(0));
		 System.out.println();
		 bTree.inTrav(bTree.treeNodes.get(0));
		 System.out.println();
		 bTree.postTrav(bTree.treeNodes.get(0));
		 System.out.println();
		 for (int i : largestValues(bTree.treeNodes.get(0))) {
			System.out.println(i);
		}
	}
}
