package data;

public class BookedSchedule {
	private int bookId;
	private String name;
	private String phonenumber;
	private int TransportID;
	private String status;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getTransportID() {
		return TransportID;
	}

	public void setTransportID(int transportID) {
		TransportID = transportID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
