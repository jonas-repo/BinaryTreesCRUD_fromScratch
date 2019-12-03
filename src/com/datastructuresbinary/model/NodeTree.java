package com.datastructuresbinary.model;

public class NodeTree {

	private Node root;
	
	public boolean add(int key, Object data)
	{
		boolean comp = false;
		if(root  == null)
		{
			root = new Node(key,data);
		}
		else
		{
			Node temp = root;
			Node newNode = new Node(key,data);
			
			
			while(temp != null)
			{
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
		Node temp = searchNode(key);
		if(temp != null)
		{
			temp.setData(value);
			return true;
		}
		
		return false;
	}
	
	public Node searchNode(int key)
	{
		Node temp = root;
		while(temp != null)
		{
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
				oneBefore = temp;
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
			aux.setData(temp.getData());
			aux.setKey(temp.getKey());
			oneBefore.setNodeLeft(null);
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
