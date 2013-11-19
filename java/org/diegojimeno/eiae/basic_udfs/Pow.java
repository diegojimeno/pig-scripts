package org.diegojimeno.eiae.basic_udfs;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class Pow extends EvalFunc<Long>{

	/**
	 * Receives a 2 long tuple, with the base and the exponent
	 */
	@Override
	public Long exec(Tuple input) throws IOException {
		
		//Extract from the input tuple
		int base = (Integer)input.get(0);
		int exponent = (Integer)input.get(1);

		return squaring(base, exponent);
	}
	
	//Exponent by squaring method
	private long squaring(int base, int exponent){
		
		int result = 1;
	    while (exponent != 0) {
	        if ((exponent & 1) == 1)
	            result *= base;
	        exponent >>= 1;
	        base *= base;
	    }

	    return result;
	}
	
}
