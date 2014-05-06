package com.cassiopeia.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class KnownExpressions {
	
	public static String getReply(String phrase)
	{
		List<String> greetings = new ArrayList<>();
		greetings.add("hello");
		greetings.add("hi");
		greetings.add("hey");
		
		String tempPhrase = phrase.toLowerCase(Locale.ENGLISH);
		
		for (String greeting : greetings)
		{
			if (tempPhrase.contains(greeting))
			{
				Random r = new Random();
				return greetings.get(r.nextInt(greetings.size()));
			}
		}
		
		if (tempPhrase.equals("what is your name?"))
		{
			return "My name is Cassiopeia";
		}
		
		return null;
	}
	
}

