package data;

import android.os.Parcel;
import android.os.Parcelable;

public class ScheduleList implements Parcelable {

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
	
	public ScheduleList(Parcel source){
		this.transportID=source.readInt();
		this.serviceGroup=source.readString();
		this.taxiID=source.readString();
		this.startingPoint=source.readString();
		this.destinationPoint=source.readString();
		this.pickUpTime=source.readString();
		this.date= source.readString();
		this.numbureOfPersons= source.readInt();
		this.comment= source.readString();
		this.status= source.readString();
	}
	public ScheduleList(){
		
	}
	
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

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(transportID);
		dest.writeString(serviceGroup);
		dest.writeString(taxiID);
		dest.writeString(startingPoint);
		dest.writeString(destinationPoint);
		dest.writeString(pickUpTime);
		dest.writeString(date);
		dest.writeInt(numbureOfPersons);
		dest.writeString(phonenumber);
		dest.writeString(comment);
		dest.writeString(status);

	}

	public static final Parcelable.ClassLoaderCreator<ScheduleList> CREATOR =
			new ClassLoaderCreator<ScheduleList>() {
		

		@Override
		public ScheduleList[] newArray(int size) {
			// TODO Auto-generated method stub
			return new ScheduleList[size];
		}

		@Override
		public ScheduleList createFromParcel(Parcel source) {
		
			return new ScheduleList(source);
		}

		@Override
		public ScheduleList createFromParcel(Parcel source, ClassLoader loader) {
			// TODO Auto-generated method stub
			return null;
		}
	};


}
