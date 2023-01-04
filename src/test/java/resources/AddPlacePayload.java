package resources;
import java.util.ArrayList;

import pojoMyPlace.ChildLocation;
import pojoMyPlace.Place;

public class AddPlacePayload {
	
	public Place addPlacePayload(String name,String language, String address) {
		Place pl=new Place();
		pl.setAccuracy(50);
		
		ChildLocation cl=new ChildLocation();
		cl.setLat(-38.383494);
		cl.setLng(33.427362);
		pl.setLocation(cl);
		
		pl.setName(name);
		pl.setPhone_number("(+91) 983 893 3937");
		pl.setAddress(address);
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		pl.setTypes(list);
		
		pl.setWebsite("http://google.com");
		pl.setLanguage(language);
		return pl;

}
	
	public String deletePlacePayload(String placeid) {
		return("{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}");
		
	}
}