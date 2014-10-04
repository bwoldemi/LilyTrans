package data;



public class ScheduleList {

	private int transportID;
	private String serviceGroup;
	private String taxiID;
	private String startingPoint;
	private String destinationPoint;
	private String pickUpTime;
	private String date;
	private int numbureOfPersons;
	private String phonenumber;
	private String comment;
	private String status;

	

	public int getTransportID() {
		return transportID;
	}

	public void setTransportID(int transportID) {
		this.transportID = transportID;
	}

	public String getServiceGroup() {
		return serviceGroup;
	}

	public void setServiceGroup(String serviceGroup) {
		this.serviceGroup = serviceGroup;
	}

	public String getTaxiID() {
		return taxiID;
	}

	public void setTaxiID(String taxiID) {
		this.taxiID = taxiID;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumbureOfPersons() {
		return numbureOfPersons;
	}

	public void setNumbureOfPersons(int numbureOfPersons) {
		this.numbureOfPersons = numbureOfPersons;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}