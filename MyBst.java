package Practice1DS;

import java.util.LinkedList;
import java.util.Queue;

public class MyBst {
	Node root = null;
	public static void main(String[] args){
		MyBst b = new MyBst();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println(b.find(5));//false
		System.out.println(b.find(16));//true	
		b.display(b.root);		
		System.out.println(" \n is BST?  " + b.isBST(b.root));
//		System.out.println("\nPre Order Traversal "); b.PreOrder(b.root);
//		System.out.println("\n In Order Traversal "); b.InOrder(b.root);
//		System.out.println("\nPost Order Traversal "); b.PostOrder(b.root);
//		System.out.println("\nHeight " + b.findHeight(b.root));
//		System.out.println("\nMin " + b.findMin(b.root));
//		System.out.println("\nMax " + b.findMax(b.root));
//		System.out.println("\nMinRecur " + b.findMinRecur(b.root));
//		System.out.println("\nMaxRecur " + b.findMaxRecur(b.root));
//		System.out.println("\nDeleting leaf node "); b.deleteLeaf(16,b.root);b.display(b.root);
//		System.out.println("\nDeleting node with oneChild "); b.deleteOneChild(15,b.root);b.display(b.root);
//		System.out.println("\nDeleting leaf node 2 "); b.deleteTwoChildren(2,b.root);b.display(b.root);
//		System.out.println("\nDeleting node with one children 15 "); b.deleteTwoChildren(15,b.root);b.display(b.root);
//		System.out.println("\nDeleting node with two children 20 "); b.deleteTwoChildren(20,b.root);b.display(b.root);
//		System.out.println("\nUpdated Deleting node - LeafNode 2 "); b.deleteU(2,b.root);b.display(b.root);
//		System.out.println("\nUpdated Deleting node - with One Child 4 "); b.deleteU(4,b.root);b.display(b.root);
//		System.out.println("\nUpdated Deleting node - with 2 children  10 "); b.deleteU(10,b.root);b.display(b.root);
		System.out.println("Level Order Traversal");
		b.levelOrderTraversal();
	}	
	private void levelOrderTraversal() {
		Queue q = new LinkedList();
		q.add(root);
		while(!q.isEmpty()){
			Node n = (Node) q.poll();
			if(n.left!=null){
				q.add(n.left);
			}
			if(n.right!=null){
				q.add(n.right);
			}
			System.out.print(n.data+" ");
		}
	}
	private void deleteU(int i, Node c) {
		Node parent = null;
		Node r = c;
		boolean isLeftChild = false;
		while(i!= r.data){//not equal
			if(i>r.data){//go right
				parent = r;
				isLeftChild = false;
				r = r.right;
			}
			else if(i<r.data){//go left
				parent = r;
				isLeftChild = true;
				r = r.left;
			}
			else {//not in the tree
				return;
			}
		}
		
		//found the node. i == r.data
		//case 1 - delete the leaf node
		if(r.left == null && r.right == null){
			if(isLeftChild){parent.left = null;}
			else {parent.right = null;}
			r = null;
		}
		//case 2 - had one child
		else 
			if (r.right == null ) //has left child
		{
			if(isLeftChild){
				parent.left = r.left;
			}
			else{
				parent.right = r.left;
			}
			System.out.println("case 2 - had one child - has left child");
			r=null;
				
		}
		else if (r.left== null) //has right child
		{
			if(isLeftChild){
				parent.left = r.right;
			}
			else{
				parent.right = r.right;
			}
			System.out.println("case 2 - had one child - has right child");
			r=null;
		}
		
		//case 3 - had 2 children
		else if ( r.right != null && r.left != null){
			//find min on right
			int minRight = findMinRecur(r.right);
			System.out.println("Min of the right " + minRight);
			deleteU(minRight,parent);
			//replace the data with min
			r.data = minRight;
			//call delete node
			
		}
		
	}
	private void delete(int i, Node current) {
		Node parent = root;
		Node r = current;
		
		boolean isLeftChild = false;
		// to find the node
		while(r.data!=i){			
			 if(i<r.data){//go left
				parent = r;
				r=r.left;
				isLeftChild = true;
			}else if (i>r.data){//go right
				parent = r;
				r = r.right;
				isLeftChild = false;
			}
			else{
				if(r==null) return;
			}		
		}
		//case 1 - delete leaf node
		if(r.left == null && r.right == null){
//			System.out.println("parentt " +parent.data);
			
			System.out.println("r " + r.data);
			if(r == current){r=null;}
//			if(parent != null){
			if(isLeftChild) parent.left = null;
			else parent.right = null;
			r = r.left = r.right = null;
		}else if(r.left == null){//right child to be merged
				if(isLeftChild) parent.left = r.right;
				else parent.right = r.right;
				r = r.left = r.right = null;
			}
		else if(r.right == null) {//left child to be merged
				if(isLeftChild) parent.left = r.left;
				else parent.right = r.left;
				r = null;
			}		
		
		//case 3 - delete node with 2 children
		else if (r.left!= null && r.right != null){
			System.out.println(r.right.data);
			int x =findMinRecur(r.right);
			System.out.println(x);
			r.data=x;
			deleteTwoChildren(x,r.right);		
		}
		
	}

	//while deleting 20, 25 come twice
	private void deleteTwoChildren(int i, Node r) {
		Node parent = null;
//		Node parent = r;
		
		boolean isLeftChild = false;
		// to find the node
		while(r.data!=i){			
			 if(i<r.data){//go left
				parent = r;
				r=r.left;
				isLeftChild = true;
			}else if (i>r.data){//go right
				parent = r;
				r = r.right;
				isLeftChild = false;
			}
			else{
				if(r==null) return;
			}		
		}
		//case 1 - delete leaf node
		if(r.left == null && r.right == null){
//			System.out.println("parentt " +parent.data);
			System.out.println("r " + r.data);
			if(parent != null){
			if(isLeftChild) parent.left = null;
			else parent.right = null;}
			r = r.left = r.right = null;
		}else if(r.left == null){//right child to be merged
				if(isLeftChild) parent.left = r.right;
				else parent.right = r.right;
				r = r.left = r.right = null;
			}
		else if(r.right == null) {//left child to be merged
				if(isLeftChild) parent.left = r.left;
				else parent.right = r.left;
				r = null;
			}		
		
		//case 3 - delete node with 2 children
		else if (r.left!= null && r.right != null){
			System.out.println(r.right.data);
			int x =findMinRecur(r.right);
			System.out.println(x);
			r.data=x;
			deleteTwoChildren(x,r.right);		
		}
		
	}

	private void deleteOneChild(int i, Node r) {
		if(r == null) return;
		Node parent = r;
		boolean isLeftChild = false;		
		while(r!= null){
			//equal
			if(r.data == i) {
				if(r.left == null){//right
					if(isLeftChild) parent.left = r.right;
					else parent.right = r.right;
				}
				else{
					if(isLeftChild) parent.left = r.left;
					else parent.right = r.left;
				}
				r = null;
			}
			else if (i < r.data){//less - left
//				System.out.println("Left " + r.data);
				parent = r;
				isLeftChild = true;
				r = r.left;
			}
			else if (i > r.data){//high - right
//				System.out.println("Right " + r.data);
				parent = r;
				isLeftChild = false;
				r=r.right;
			}		
		}
		
	}	

	private void deleteLeaf(int i, Node r) {
		//if not found return
		//Empty tree
		if(r == null) return;
		Node parent = r;
		boolean isLeftChild = false;
		
		
		while(r!= null){
			//equal
			if(r.data == i) { 
				r = null;
				if(isLeftChild) parent.left = null;
				if(!isLeftChild) parent.right = null;				
			}
			else if (i < r.data){//less - left
				parent = r;
				isLeftChild = true;
				r = r.left;
			}
			else if (i > r.data){//high - right
				parent = r;
				isLeftChild = false;
				r=r.right;
			}		
		}
		
		
		//if found, track the parent and isLeftChild and isRightChild
		//When located, make it null and make the respective child of the parent null
		
	}

	private int findMaxRecur(Node r) {
		// base case
		if(r.right == null) {return r.data;}
		return findMaxRecur(r.right);
	}

	private int findMinRecur(Node r) {
		// base case
		if(r.left == null) {
			System.out.println("min " + r.data);
			return r.data;}
		return findMinRecur(r.left);
	}

	private int findMax(Node r) {
		if(r == null) return -1;
		while(r.right!=null)
			r=r.right;		
		return r.data;
	}

	private int findMin(Node r) {
		if(r==null) return -1;
		while(r.left != null){
			r=r.left;
		}
		return r.data;
	}

	private int findHeight(Node node) {
		//base case
		if(node == null) return -1;
		//find height for left and right sub trees and return the max
		int left = findHeight(node.left);
		int right = findHeight(node.right);
		return Math.max(left, right)+1;
	}

	private void PostOrder(Node n) {
		// base case
		if(n == null) return;
		//left right root
		PostOrder(n.left);
		PostOrder(n.right);
		System.out.print(" " + n.data);
		
	}

	private void InOrder(Node n) {
		// base case
		if(n == null) return;				
		//left root right	
		InOrder(n.left);
		System.out.print(" " + n.data);
		InOrder(n.right);
	}

	private void PreOrder(Node root) {
		//base case
		if(root == null) return;
		//root left right
		System.out.print(" " + root.data);
		PreOrder(root.left);
		PreOrder(root.right);		
	}

	private boolean isBST(Node root) {
		//base case
		if(root == null){return true;}
		
		if(isLeftLess(root.left,root.data) && isRightGreater(root.right,root.data)  && isBST(root.left) && isBST(root.right)){
			return true;
		}
		else
			return false;	
	}
	
	private boolean isRightGreater(Node root, int data) {
		// base case
		if(root == null){return true;}
		if(root.data > data && isRightGreater(root.right, data) && (isRightGreater(root.right,data)) ) return true;
		else
		return false;
	}
	private boolean isLeftLess(Node root, int data) {
		//base case
		if(root == null){return true;}
		if(root.data <= data && isLeftLess(root.left,data) && (isLeftLess(root.left,data))){
			return true;
		}
		else
		return false;
	}
	private void display(Node r) {
		if(r==null) return;
		display(r.left);
		System.out.print(" " + r.data);
		display(r.right);
		
	}
	private boolean find(int i) {
		if(root == null){
			System.out.println("Empty tree");
			return false;
		}
		Node current = root;
		while(current != null){
			
			if(current.data == i){
				return true;
			}
			else if(i < current.data){//go left
				current=current.left;
				
				}
			else{//go right
				current = current.right;
				
			}
		}
		return false;
	}
	private void insert(int i) {
		//create node
		Node n = new Node(i);		
		//Empty tree
		if(root == null){
			root =n;
			System.out.println(n.data + "added as root ");
		}
		else{//Non Empty tree
			Node current = root;
			Node parent = current;
			System.out.println("current " + current.data);
			while(true){
			if(i< current.data )//go left
				{
				parent = current;
				current = current.left;
				
				if(current == null){
					System.out.println("node "+ n.data +" added in left "+parent.data);
					parent.left = n;
					break;
				}
				}
			else{//go right
				parent = current;
				current = current.right;
				if(current == null){
					System.out.println("node "+ n.data +" added in right "+parent.data);
					parent.right = n;
					break;
				}
			}			
		}
		}	
	}
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int d){
			this.data=d;
			this.left=null;
			this.right=null;
		}
		
	}
	

}
