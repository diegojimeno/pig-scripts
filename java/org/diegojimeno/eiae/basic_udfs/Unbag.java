package org.diegojimeno.eiae.basic_udfs;

import java.io.IOException;
import java.util.Iterator;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;

/**
 * Gets a bag as input and returns a tuple
 */
public class Unbag extends EvalFunc<Tuple>{

	private static TupleFactory tupleFactory = TupleFactory.getInstance();
	
	@Override
	public Tuple exec(Tuple input) throws IOException {
		
		//Construct tuple via static factory
		Tuple tuple = tupleFactory.newTuple();

		//Error handling
		if( input.size() < 1 || input.isNull(0) ) {
			tuple.set(0, "The tuple is empty");
			return tuple;
		}
		
		//Casts to DataBag
		DataBag bag = (DataBag)input.get(0);
		Iterator<Tuple> iterator = bag.iterator();
		
		while(iterator.hasNext()) {
			Tuple tup = iterator.next();
			if( tup != null && tup.size() > 0)
				tuple.append(tup);
		}
		return tuple;
	}
}
