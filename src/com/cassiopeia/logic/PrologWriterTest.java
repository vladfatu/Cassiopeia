package com.cassiopeia.logic;

/**
 * @author vlad
 *
 */
public class PrologWriterTest {
	
	public static void main(String[] args)
	{
		String[] params = {"test1", "test2"};
		PrologFact fact = new PrologFact("ruleId", params);
		System.out.println(fact.toString());
		System.out.println();
		
		PrologRule rule = new PrologRule("ruleId", 2);
		rule.setReflexive(true);
		rule.setSymmetric(true);
		System.out.println(rule.toString());
	}

}
