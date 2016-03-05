package hackerrank.datastructures;

import java.util.ArrayList;

public class GetNodeBackwards {

	public static class Node{
		int data;
		Node next;
		@Override
		public String toString() {
			StringBuilder b = new StringBuilder();
			Node n = this;
			while(n!=null){
				b.append(" -> "+n.data);
				n=n.next;
			}
			return b.toString();
		}

	}

	public static void main(String[] args){
		Node n = makeList(new Node());
		System.out.println(n);
		System.err.println(GetNode(n, 1));
		
	}
	
	public static Node makeList(final Node head){
		if(head!=null){
			Node n = head;
			int[] arr = {1,5,3,7,4,6,7};
			for (int i =0; i<arr.length; i++) {
				n.data = arr[i];
				if(i != arr.length-1){
					n.next=new Node();
					n = n.next;
				}
			}
		}
		return head;
	}
	
	public static int GetNode(Node head, int n){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Node nd = head;
		while (nd!=null){
			arrayList.add(nd.data);
			nd = nd.next;
		}
		int listSize = arrayList.size();
		return arrayList.get(listSize-n-1); 
	}
}
