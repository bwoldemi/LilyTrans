package server.fi;

public interface TaskDataDownloder {
	/**
	 * Retrieve data from REST server 
	 */
	public void retriveData();
	
	/**
	 * upload to server 
	 */
	public void uploadData();
	
}
