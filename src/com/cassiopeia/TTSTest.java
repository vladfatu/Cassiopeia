package com.cassiopeia;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;

import com.cassiopeia.expressions.KnownExpressions;
import com.cassiopeia.utils.Constants;
import com.gtranslate.Audio;
import com.gtranslate.Language;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.morph.WordnetStemmer;

/**
 * @author vlad
 *
 */
public class TTSTest {

	public static void main(String[] args)
	{

//		Query q;
//		q = new Query("consult('foo.pl')");
//		System.err.println(q.hasSolution());
//		System.out.println();
//		q = new Query("s_brother(X, alin)");
//		System.err.println(q.hasSolution());
//
//		while (q.hasMoreElements())
//		{
//			System.err.println(q.nextElement());
//		}

		Scanner scanIn = new Scanner(System.in);
		String line = "";
		while (!line.equalsIgnoreCase("Good Bye"))
		{
			line = scanIn.nextLine();

			String reply;
			line = line.toLowerCase();
			if (line.contains("what is the definition of "))
			{
				line = line.replace("what is the definition of ", "");
				line = line.replace("?", "");
				reply = wordNetDefinition(line);
				reply = reply.split(";")[0];
				System.out.println(reply.length());
			}
			else
			{
				reply = KnownExpressions.getReply(line);
			}
			if (reply != null)
			{

				// Translator translate = Translator.getInstance();
				// String text = translate.translate(introductionText, Language.ENGLISH, Language.SPANISH);
				// System.out.println(text); //Eu sou programador
				System.out.println(reply);
				playSound(reply);
			}
			else
			{
				playSound("Please rephrase");
			}
		}
		
		playSound("Good Bye");

		scanIn.close();
	}
	
	public static String wordNetDefinition(String initialWord)
	{
		URL url;
		try
		{
			url = new URL("file", null, Constants.WORDNET_PATH);
		// construct the dictionary object and open it
		IDictionary dict = new Dictionary(url);
		dict.open();
		
		WordnetStemmer stemmer = new WordnetStemmer(dict);
		List<String> stems = stemmer.findStems(initialWord, POS.NOUN);
		if (stems.size() > 0)
		{
			IIndexWord idxWord = dict.getIndexWord(stems.get(0), POS.NOUN);
			IWordID wordID = idxWord.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);
			dict.close();
			return word.getSynset().getGloss();
		}

		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
