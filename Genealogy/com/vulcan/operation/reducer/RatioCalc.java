package  com.vulcan.operation.reducer;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.DataBag;
import org.apache.pig.Accumulator;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.PigException;
import org.apache.pig.Algebraic;
import org.apache.hadoop.fs.*;
import org.apache.pig.impl.util.*;

import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.io.File.*;
import java.io.*;

public class RatioCalc extends EvalFunc<String>  {

    private String _dLotFile;
    private String _dProductFile;
    private String _denominatorFile;
    private HashMap<String, String> dLotlookup = null;
    private HashMap<String, String> dProductlookup = null;
    private HashMap<String, String> denominatorlookup = null;

    public RatioCalc (String dLotFile, String dProductFile, String denominatorFile) {
        _dLotFile = dLotFile;
 	_dProductFile = dProductFile;
	_denominatorFile = denominatorFile;
    }
    
    public String exec(Tuple in) throws IOException, ExecException {
	String retVal = null;
	try {
	   if (dLotlookup == null) {
	      FileSystem fs = FileSystem.get(UDFContext.getUDFContext().getJobConf());
	      String line;

	      dLotlookup = new HashMap<String, String>();
	      DataInputStream inFile = fs.open(new Path(_dLotFile));	      
	      while ((line = inFile.readLine()) != null) {
	         String [] toks = new String[2];
		 toks = line.split("\t", 2);
		 dLotlookup.put(toks[0], toks[1]);
	      }

	      dProductlookup = new HashMap<String, String>();
	      inFile = fs.open(new Path(_dProductFile));
	      while ((line = inFile.readLine()) != null) {
	         String [] toks = new String[2];
		 toks = line.split("\t", 2);
                 if (toks != null && 
			toks[0] != null && 
			toks[1] != null && 
			toks[1].trim() != null) {
		    dProductlookup.put(toks[0], toks[1].trim());
		 }
	      }

	      denominatorlookup = new HashMap<String, String>();
	      inFile = fs.open(new Path(_denominatorFile));
	      while ((line = inFile.readLine()) != null) {
	         String [] toks = new String[2];
		 toks = line.split("\t", 4);
                 if (toks != null && 
			toks[0] != null && 
			toks[1] != null && 
			toks[1].trim() != null) {
		    denominatorlookup.put(toks[0].trim().toString() + '|' + 
					  toks[1].trim().toString() + '|' + 
					  toks[3].trim().toString(), 
					  toks[2].trim().toString());
		 }
	      }
	   }

           String lotIds = (String) in.get(0).toString();
           String amounts = (String) in.get(1).toString();
           String minDayWindow = (String) in.get(2).toString();
 
	   String [] lotIdIter = lotIds.split(".", 20);
	   String [] amountsIter = amounts.split("|", 20);

	   //retVal = dProductlookup.get(dLotlookup.get((String) in.get(0)));
	   retVal = lotIds + '|' + amounts + '|' + minDayWindow;
           for (int i = 0; i < lotIdIter.length; i++) {
		retVal = retVal + '-' + lotIdIter[i] + '-' + amountsIter[i];
           }
	   return retVal;		
        } catch (Exception e) {
            int errCode = 5105;
            String msg = "Error while computing RatioCalc during multiplication using " 
		+ this.getClass().getSimpleName() 
		+ e.getMessage();
            throw new ExecException(msg, errCode, PigException.BUG, e);           
        }
    }    
}
