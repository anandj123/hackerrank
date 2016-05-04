package  com.vulcan.operation.reducer;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.DataBag;
import org.apache.pig.Accumulator;

import org.apache.pig.Algebraic;
import java.io.IOException;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.PigException;
import java.util.Iterator;


public class Multiplication extends EvalFunc<Double> implements Accumulator<Double> {

    /* Accumulator interface */
    
    private Double intermediateProduct = null;
    
    
    public Double exec(Tuple in) throws IOException {
	Double retVal = null;
	try {
	   retVal = (Double) in.get(0); 
        } catch (ExecException ee) {
            throw ee;
	} catch (Exception ex) {
            int errCode = 5106;
            String msg = "Error while evaluating touple to Double during multiplication using " + this.getClass().getSimpleName();
            throw new ExecException(msg, errCode, PigException.BUG, ex);           
 
        }
	
	return retVal;		

	
    }

    @Override
    public void accumulate(Tuple inputT) throws IOException {
        try {
		
            if (inputT == null || inputT.size() == 0) {
                return;
            }

            /* if bag is not null, initialize intermediateProduct to 1.0 */
            if (intermediateProduct == null) {
                intermediateProduct = 1.0;
            }
	    
            DataBag bag = (DataBag) inputT.get(0);
            Iterator it = bag.iterator();
            while (it.hasNext()) {
		Tuple t = (Tuple) it.next();
                if (t != null && t.size() != 0 && t.get(0) != null) {
                    intermediateProduct = intermediateProduct + new Double((t.get(0).toString()));
                }
            }
        } catch (ExecException ee) {
            throw ee;
        } catch (Exception e) {
            int errCode = 5105;
            String msg = "Error while computing intermeditate product during multiplication using " 
		+ this.getClass().getSimpleName() 
		+ e.getMessage();
            throw new ExecException(msg, errCode, PigException.BUG, e);           
        }
    }

    @Override
    public void cleanup() {
        intermediateProduct = null;
    }

    @Override
    public Double getValue() {
        return intermediateProduct;
    }

}
