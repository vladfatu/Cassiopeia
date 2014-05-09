package com.cassiopeia.logic;

import com.cassiopeia.utils.StringUtils;

/**
 * @author vlad
 * 
 */
public class PrologRule {

	private String ruleId;
	private int numberOfParams;
	private boolean isSymmetric;
	private boolean isTransitive;
	private boolean isReflexive;

	public PrologRule(String ruleId, int numberOfParams) {
		this.ruleId = ruleId;
		this.numberOfParams = numberOfParams;
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
		return numberOfParams;
	}

	public void setNumberOfParams(int numberOfParams)
	{
		this.numberOfParams = numberOfParams;
	}

	public boolean isSymmetric()
	{
		return isSymmetric;
	}

	public void setSymmetric(boolean isSymmetric)
	{
		this.isSymmetric = isSymmetric;
	}

	public boolean isTransitive()
	{
		return isTransitive;
	}

	public void setTransitive(boolean isTransitive)
	{
		this.isTransitive = isTransitive;
	}

	public boolean isReflexive()
	{
		return isReflexive;
	}

	public void setReflexive(boolean isReflexive)
	{
		this.isReflexive = isReflexive;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		if (this.isReflexive)
		{
			builder.append(this.ruleId);
			builder.append("(");
			builder.append(StringUtils.printStringArray(StringUtils.getSameCapitalLettersArray(this.numberOfParams)));
			builder.append(")");

			builder.append(".\n");

		}

		builder.append(this.ruleId);
		builder.append("(");
		builder.append(StringUtils.printStringArray(StringUtils.getCapitalLettersArray(this.numberOfParams)));
		builder.append(")");

		builder.append(" :- ");

		if (this.isTransitive)
		{
			builder.append(PrologConstants.TRANSITIVITY_PREFIX).append(this.ruleId);
			builder.append("(");
			builder.append(StringUtils.printStringArray(StringUtils.getCapitalLettersArray(this.numberOfParams)));
			builder.append(")");

			builder.append(".\n\n");
		} else
		{
			if (this.isSymmetric)
			{
				builder.append(PrologConstants.SYMMETRY_PREFIX);

			} else
			{
				builder.append(PrologConstants.FACT_PREFIX);
			}
			builder.append(this.ruleId);
			builder.append("(");
			builder.append(StringUtils.printStringArray(StringUtils.getCapitalLettersArray(this.numberOfParams)));
			builder.append(")");

			builder.append(".\n\n");
		}
		
		if (this.isSymmetric)
		{
			builder.append(PrologConstants.SYMMETRY_PREFIX);
			builder.append(this.ruleId);
			builder.append("(");
			builder.append(StringUtils.printStringArray(StringUtils.getCapitalLettersArray(this.numberOfParams)));
			builder.append(")");
			
			builder.append(" :- ");
			
			builder.append(this.ruleId);
			builder.append("(");
			builder.append(StringUtils.printStringArray(StringUtils.getCapitalLettersArray(this.numberOfParams)));
			builder.append(")");

		}
		
		
		return builder.toString();
	}

}
