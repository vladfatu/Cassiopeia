package com.cassiopeia.logic;

import com.cassiopeia.utils.StringUtils;

/**
 * @author vlad
 *
 */
public class PrologFact {
	
	private String ruleId;
	private String[] params;
	
	public PrologFact(String ruleId, String[] params)
	{
		this.ruleId = ruleId;
		this.params = params;
	}
	
	public String getRuleId()
	{
		return ruleId;
	}
	public void setRuleId(String ruleId)
	{
		this.ruleId = ruleId;
	}
	public int getNumberOfParams()
	{
		return this.params.length;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(PrologConstants.FACT_PREFIX).append(this.ruleId).append("(");
		builder.append(StringUtils.printStringArray(this.params));
		builder.append(").");
		return builder.toString();
	}

}
