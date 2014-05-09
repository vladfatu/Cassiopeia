package com.cassiopeia.utils;

/**
 * @author vlad
 *
 */
public class StringUtils {
	
	public static String printStringArray(String[] array)
	{
		StringBuilder builder = new StringBuilder();
		for (int i=0; i< array.length; i++)
		{
			builder.append(array[i]);
			if (i < array.length-1)
			{
				builder.append(", ");
			}
		}
		return builder.toString();
	}
	
	public static String[] getCapitalLettersArray(int count)
	{
		String[] array = new String[count];
		for (int i = 'A'; i < 'A' + count; i++)
		{
			array[i-'A'] = Character.toString((char) i);
		}
		return  array;
	}
	
	public static String[] getSameCapitalLettersArray(int count)
	{
		String[] array = new String[count];
		for (int i = 'A'; i < 'A' + count; i++)
		{
			array[i-'A'] = "A";
		}
		return  array;
	}

}
