package com.cassiopeia;

import java.io.IOException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import jpl.Query;

import com.gtranslate.Audio;
import com.gtranslate.Language;

public class TTSTest {
	
	public static void main(String[] args)
	{
		
		Query q;
		q = new Query("consult('foo.pl')");
		System.err.println(q.hasSolution());
		System.out.println();
		q = new Query("tedge(X, b)");
		System.err.println(q.hasSolution());

		while (q.hasMoreElements())
		{
			System.err.println(q.nextElement());
		}

		String introductionText = "I am Cassiopeia, meaning she whose words excel.";
		
		
//		Translator translate = Translator.getInstance();
//		String text = translate.translate(introductionText, Language.ENGLISH, Language.SPANISH);
//		System.out.println(text); //Eu sou programador
		
		Audio audio = Audio.getInstance();
		InputStream sound;
		try
		{
			sound = audio.getAudio(introductionText, Language.ENGLISH);
			
//			OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("temp.mp3")));  
//		    byte[] buf = new byte[256];  
//		    int n = 0;  
//		    while ((n=sound.read(buf))>=0) {  
//		       out.write(buf, 0, n);  
//		    }  
//		    out.flush();  
//		    out.close();  
			
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
