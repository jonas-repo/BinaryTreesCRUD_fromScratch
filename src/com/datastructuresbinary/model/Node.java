package com.datastructuresbinary.model;

public class Node {

	private int key;
	private Object data;
	private Node nodeLeft;
	private Node nodeRight;
	
	public Node(int key, Object data) {
		this.key = key;
		this.data = data;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNodeLeft() {
		return nodeLeft;
	}
	public void setNodeLeft(Node nodeLeft) {
		this.nodeLeft = nodeLeft;
	}
	public Node getNodeRight() {
		return nodeRight;
	}
	public void setNodeRight(Node nodeRight) {
		this.nodeRight = nodeRight;
	}
	
	
	@Override
	public String toString() {
		return "Node [key=" + key + ", data=" + data + ", nodeLeft=" + nodeLeft + ", nodeRight=" + nodeRight + "]";
	}
	
	
}
