package Practice1DS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Not Successful
//public class MyTreee<T>{
//	class NodeT<T> {
//		T data;
//		MyTreee<T> parent = null;
//		List<NodeT> children = new ArrayList<NodeT>();
//	}
//	NodeT<T> root = null;
//	private Object children;
//	private MyTreee<T> parent;
//	
//	
//	public static void main(String[] args){
//		MyTreee<String> t = new MyTreee<String>();
//		t.add("root");//add Root Node
//		t.add("child1");//add Child1 node
//		MyTreee<String> c = new MyTreee<String>();
//		c.add("Child2");//add Root Node
//		c.add("GrandChildren21");
//		c.add("GrandChildren22");
//		t.add(c);
//		t.display();
//	}	
//		
//	}
//
//
//	private void add(MyTreee<String> c) {
//		c.parent = (MyTreee<String>) this;
//		((List<NodeT>) this.children).add(c);	
//	}
//
//
//	private void add(T string) {//add child
//		NodeT<T> n = new NodeT<T>();
//		n.data = string;
//		if(root == null){
//			root=n;
//		}else{
//			n.parent = this;
//			((List<NodeT>) this.children).add(n);
//		}
//		
//	}
//	
//}