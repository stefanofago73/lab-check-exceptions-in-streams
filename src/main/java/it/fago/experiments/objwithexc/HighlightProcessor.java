package it.fago.experiments.objwithexc;

import java.io.IOException;
import java.util.Random;

/**
 * 
 * ...This is only a simple definition to have a starting point
 * to create our use-case...
 * 
 * @author Stefano
 *
 */
public class HighlightProcessor {
	//
	private int state;
    //
	private int failAt;
	
	public HighlightProcessor(int failAt){
	  this.failAt = failAt;	
	}
	
	/**
	 * 
	 * The "guilty method"
	 * 
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String methodThatThrows(String data) throws IOException {
		if((state++)==failAt){
			state = 0;
			throw new IOException("DUMMY!");
		}
		return "<<" + data + ">>";
	}

}// END