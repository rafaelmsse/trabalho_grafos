package ca.pfv.spmf.test;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.algorithms.frequentpatterns.fin_prepost.PrePost;
import ca.pfv.spmf.algorithms.frequentpatterns.fin_prepost.PrePostMax;

/**
 * Example of how to use PrePost+ algorithm from the source code.
 * @author Philippe Fournier-Viger, 2015
 */
public class MainTestPrePostPlus {

	public static void main(String [] arg) throws IOException{

		//String input = fileToPath("contextPasquier99.txt");
		String input = fileToPath("bd_commits.txt");
		String output = ".//xdxd.txt";  // the path for saving the frequent itemsets found
		
		double minsup = 0.5; // means a minsup of 2 transaction (we used a relative support)
		
		// Applying the algorithm
		PrePostMax prepost = new PrePostMax();
		// this line is to indicate that we want PrePost+ instead of PrePost
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
