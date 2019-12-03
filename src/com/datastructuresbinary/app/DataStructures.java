package com.datastructuresbinary.app;

import com.datastructuresbinary.model.NodeTree;


public class DataStructures {

	public static void main(String[] args) {
		NodeTree  nodeTree = new NodeTree();
		
		//declare two arrays of values and keys
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 45, 16, 10, 18, 33 }; 
		
        
        //fill our tree with the values
		for (int i = 0; i < charfreq.length; i++) {
			nodeTree.add(charfreq[i], charArray[i]);
		}
		
		
		for (int i = 0; i < charfreq.length; i++) {
			System.out.println("search of node with key "+charfreq[i]+": "+ nodeTree.searchNode(charfreq[i]).getData());
		}
		
		
		if(nodeTree.delete(18))
		{
			System.out.println("Node 18 Deleted!!");
		}
		if(nodeTree.update(10, "New value"))
		{
			System.out.println("Node 10 Updated!!");
		}
		System.out.println("************new tree values ********************");
		
		for (int i = 0; i < charfreq.length; i++) {
			System.out.println("search of node with key "+charfreq[i]+": "+ nodeTree.searchNode(charfreq[i]));
		}
		

		
	}

}
