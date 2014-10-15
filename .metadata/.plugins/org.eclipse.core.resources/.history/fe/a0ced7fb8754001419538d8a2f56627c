package com.example.translili;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import data.ScheduleList;

public class Parser {
	public static Vector<ScheduleList> parse(String content)
			throws JSONException {
		Vector<ScheduleList> schedules = new Vector<ScheduleList>();

		JSONArray jsonArray = new JSONArray(content);
		ScheduleList schedule;
		for (int i = 0; i < jsonArray.length(); i++) {
			schedule = new ScheduleList();
			JSONObject object = jsonArray.getJSONObject(i);
			
			schedule.setTransportID(Integer.parseInt(object.getString("ID")));
			schedule.setServiceGroup(object.getString("ServiceGroup"));
			schedule.setTaxiID(object.getString("GroupId"));
			schedule.setStartingPoint(object.getString("StartingPoint"));
			schedule.setDestinationPoint(object.getString("Destination"));
			schedule.setPickUpTime(object.getString("PickUpTime"));
			schedule.setDate(object.getString("Date"));
			schedule.setNumbureOfPersons(Integer.parseInt(object
					.getString("Capacity")));
			schedule.setPhonenumber(object.getString("PhoneNumber"));
			schedule.setComment(object.getString("Comment"));
			schedule.setStatus(object.optString("status"));
			System.out.println(object.optString("status")+"*************");
			schedules.add(schedule);
		}
		return schedules;
	}
	
	
	
	public static Vector<ScheduleList> parseBookedRides(String content)
			throws JSONException {
		Vector<ScheduleList> schedules = new Vector<ScheduleList>();

		JSONArray jsonArray = new JSONArray(content);
		ScheduleList schedule;
		for (int i = 0; i < jsonArray.length(); i++) {
			schedule = new ScheduleList();
			JSONObject object = jsonArray.getJSONObject(i);
			
			schedule.setTransportID(Integer.parseInt(object.getString("ID")));
			schedule.setServiceGroup(object.getString("ServiceGroup"));
			schedule.setTaxiID(object.getString("GroupId"));
			schedule.setStartingPoint(object.getString("StartingPoint"));
			schedule.setDestinationPoint(object.getString("Destination"));
			schedule.setPickUpTime(object.getString("PickUpTime"));
			schedule.setDate(object.getString("Date"));
			schedule.setNumbureOfPersons(Integer.parseInt(object
					.getString("Capacity")));
			schedule.setPhonenumber(object.getString("PhoneNumber"));
			schedule.setComment(object.getString("Comment"));
			schedules.add(schedule);
		}
		return schedules;
	}

}
