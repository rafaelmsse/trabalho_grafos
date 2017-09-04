package ca.pfv.spmf.test;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.algorithms.frequentpatterns.fin_prepost.PrePost;
import ca.pfv.spmf.algorithms.frequentpatterns.fin_prepost.PrePostMax;


public class MainTestPrePostPlusMax {

	public static void main(String [] arg) throws IOException{

		String input = fileToPath("contextPasquier99.txt");

		String output = ".//output.txt";  // caminho para output
		
		double minsup = 0.7;
		

		PrePostMax prepost = new PrePostMax();

		prepost.setUsePrePostPlus(true);
		prepost.runAlgorithm(input, minsup, output);
		prepost.printStats();
		int count = 0;
		for (int[] l : prepost.listaMax) {
			if (l[0] > 0)
				count++;
		}
		System.out.println(count);
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestPrePostPlus.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
