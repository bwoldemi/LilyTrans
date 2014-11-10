package server.fi;

import model.Tasks;

public interface TaskDataDownloder {
	/**
	 * Retrieve data from REST server 
	 */
	public void retriveData();
	
	/**
	 * upload to server 
	 */
	public void uploadData(Tasks task, String customerName);
	
}
