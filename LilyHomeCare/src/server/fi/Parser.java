package server.fi;

import java.util.Vector;

import model.Tasks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class Parser {
	
	public static Vector<Tasks> parse(String content)throws JSONException {
		Vector<Tasks> tasks = new Vector<Tasks>();

		JSONArray jsonArray = new JSONArray(content);
		Tasks task;
		for (int i = 0; i < jsonArray.length(); i++) {
			task = new Tasks();
			JSONObject object = jsonArray.getJSONObject(i);
			
			task.setFirstName(object.getString("FirstName"));
			task.setLastName(object.getString("LastName"));
			task.setPhoneNumber(object.getString("PhoneNumber"));
			task.setTagId(object.getString("TagId"));
			task.setAddress(object.getString("Address"));
			task.setCleaning(object.getString("Cleaning"));
			task.setMedicalCare(object.getString("MedicalCare"));
			task.setShoppingList(object.getString("ShoppingList"));
			task.setOther(object.getString("Other"));
			tasks.add(task);
		}
		return tasks;
	}
	
}
