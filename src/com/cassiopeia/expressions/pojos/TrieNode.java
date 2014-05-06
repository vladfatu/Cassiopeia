package com.cassiopeia.expressions.pojos;

import java.util.HashSet;
import java.util.Set;

public class TrieNode {
	
	private char c;
	
	private Set<TrieNode> childNodes;
	
	public TrieNode(char c)
	{
		this.c = c;
		this.childNodes = new HashSet<>();
	}

	public char getC()
	{
		return c;
	}

	public void setC(char c)
	{
		this.c = c;
	}
	
	public Set<TrieNode> getChildNodes()
	{
		return childNodes;
	}

	public void setChildNodes(Set<TrieNode> childNodes)
	{
		this.childNodes = childNodes;
	}

	public boolean isEmpty()
	{
		return childNodes.size() == 0;
	}

}
