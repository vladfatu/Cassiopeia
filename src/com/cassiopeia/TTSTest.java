package com.cassiopeia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import jpl.Query;

import com.cassiopeia.expressions.KnownExpressions;
import com.gtranslate.Audio;
import com.gtranslate.Language;

public class TTSTest {

	public static void main(String[] args)
	{

		Query q;
		q = new Query("consult('foo.pl')");
		System.err.println(q.hasSolution());
		System.out.println();
		q = new Query("s_brother(X, alin)");
		System.err.println(q.hasSolution());

		while (q.hasMoreElements())
		{
			System.err.println(q.nextElement());
		}

		Scanner scanIn = new Scanner(System.in);
		String line = "";
		while (!line.equalsIgnoreCase("Good Bye"))
		{
			line = scanIn.nextLine();

			String reply = KnownExpressions.getReply(line);
			if (reply != null)
			{

				// Translator translate = Translator.getInstance();
				// String text = translate.translate(introductionText, Language.ENGLISH, Language.SPANISH);
				// System.out.println(text); //Eu sou programador

				playSound(reply);
			}
		}
		
		playSound("Good Bye");

		scanIn.close();
	}
	
	public static void playSound(String phrase)
	{
		Audio audio = Audio.getInstance();
		InputStream sound;
		try
		{
			sound = audio.getAudio(phrase, Language.ENGLISH);

			audio.play(sound);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
