package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	public static RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	

	public RequestSpecification reqSpecBuild() throws IOException {
		
		if (reqSpec==null) {
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		
		reqSpec = new RequestSpecBuilder().setBaseUri(globalProperty("BaseURL")).setContentType(ContentType.JSON)
				.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return reqSpec;
		
		}
		return reqSpec;

	}

	public ResponseSpecification ResSpecBuild() {
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
		return resSpec;
	}
	
	public String globalProperty(String key) throws IOException {
		
		Properties property=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\amarn\\eclipse-workspace\\BDDCucumber\\src\\test\\java\\resources\\global.properties");
		property.load(fis);
		return (property.getProperty(key));
	}
	
	
}
