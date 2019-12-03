package com.datastructuresbinary.model;

public class NodeTree {

	private Node root;
	
	public boolean add(int key, Object data)
	{
		boolean comp = false;
		if(root  == null) //there is not a tree we have to create a new root
		{
			root = new Node(key,data);
		}
		else
		{
			Node temp = root;
			Node newNode = new Node(key,data);
			
			
			while(temp != null) //we have to iterate in the tree until get the last node without value
			{
				
				//we have to assign values to the tree depending of the key that we have if key is bigger store to the righ and if is less store at the left
				if(temp.getKey() > key) 
				{
					if(temp.getNodeLeft() != null)
					{
						temp = temp.getNodeLeft();
					}
					else
					{
						temp.setNodeLeft(newNode);
						comp = true;
						break;
					}
				}
				if(temp.getKey() < key)
				{
					if(temp.getNodeRight() != null)
					{
						temp = temp.getNodeRight();
					}
					else
					{
						temp.setNodeRight(newNode);
						comp = true;
						break;
					}
				}
			}
			
		}
		
		
		return comp;
	}
	
	public void showAll()
	{
		Node temp = root;
		while(temp != null)
		{
			System.out.println("Node key:["+temp.getKey()+"]="+temp.getData());
			temp = temp.getNodeLeft();
		}
		
		
	}
	
	public boolean update(int key, Object value)
	{
		Node temp = searchNode(key); //we search the node by key
		if(temp != null) //if the node exist we change the value of that node
		{
			temp.setData(value); 
			return true;
		}
		
		return false;
	}
	
	public Node searchNode(int key)
	{
		Node temp = root;
		while(temp != null) //iterate in the tree until find the key of the node 
		{					// and we divide the search by searching according to the key value we go to left or right in the tree
			if(temp.getKey() == key)
			{
				break;
			}
			else
			{
				if(temp.getKey() > key)
				{
					temp = temp.getNodeLeft();
				}
				else if(temp.getKey() < key)
				{
					temp = temp.getNodeRight();
				}
			}
		}
		
		if(temp == null)
		{
			return null;
		}
		return temp;
	}
	
	public boolean delete(int key)
	{
		Node temp = root;
		Node oneBefore = null;
		Node aux = null;

		while(temp != null) 
		{
			if(temp.getKey() == key)
			{
				break;
			}
			else
			{
				oneBefore = temp; // we have to store the node before the node we want to delete to put the next node to null
				if(temp.getKey() > key)
				{
					temp = temp.getNodeLeft();
				}
				else if(temp.getKey() < key)
				{
					temp = temp.getNodeRight();
				}
			}
		}
		
		if(temp == null)
		{
			return false;
		}
		
		
		if(temp.getNodeRight() != null)
		{
			aux = temp;
			oneBefore = temp;
			temp = temp.getNodeRight();
			while(true)
			{
				
				if(temp.getNodeLeft() == null)
				{
					break;
				}
				else 
				{
					oneBefore = temp;
					temp = temp.getNodeLeft();
				}
				
			}
			//we copy all the data to the node we have to delete
			aux.setData(temp.getData());
			aux.setKey(temp.getKey());
			oneBefore.setNodeLeft(null); //we delete the last node that is bigger than the node we have to delete because all the values are stored in our node aux
			temp = null;
			return true;
		}
		else if(temp.getNodeLeft() != null)
		{
			aux = temp;
			temp = temp.getNodeLeft();
			oneBefore = temp;
			while(true)
			{
				
				if(temp.getNodeRight() == null)
				{
					break;
				}
				else 
				{
					oneBefore = temp;
					temp = temp.getNodeRight();
				}
				
			}
			aux.setData(temp.getData());
			aux.setKey(temp.getKey());
			oneBefore.setNodeRight(null);
			temp = null;
			return true;
		}
		else
		{
			oneBefore.setNodeRight(null);
			temp = null;
			return true;
		}
			

	}
	
	
}
