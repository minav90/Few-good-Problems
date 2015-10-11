package com.track.Controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.track.model.Location;

@Path("/location")
public class LocationResource {
 
    private final static String NAME = "Name";
    private final static String ID = "Id";
    private final static String LATITUDE = "Latitude";
    private final static String LONGITUDE = "Longitude";
    private Connection con;
    private PreparedStatement stmt;
         
    private Location location = new Location("1", "Minav", "26.265", "33.254");
     
    // The @Context annotation allows us to have certain contextual objects
    // injected into this class.
    // UriInfo object allows us to get URI information (no kidding).
    @Context
    UriInfo uriInfo;
 
    // Another "injected" object. This allows us to use the information that's
    // part of any incoming request.
    // We could, for example, get header information, or the requestor's address.
    @Context
    Request request;
     
    // Basic "is the service running" test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String respondAsReady() {
    	System.out.println("Demo is ready");
        return "Demo service is ready!";
    }
 
    @GET
    @Path("sample")
    @Produces(MediaType.APPLICATION_JSON)
    public Location getLocation() {
         
        System.out.println("Returning sample person: " + location.getLatitude() + " " + location.getLongitude());
         
        return location;
    }
         
    // Use data from the client source to create a new Person object, returned in JSON format.  
    @POST
    @Path("insertlocation")
	@Produces(MediaType.APPLICATION_JSON)
    public String postLocation(
            MultivaluedMap<String, String> locationParams
            ) {
         
    	String id = locationParams.getFirst(ID);
        String name = locationParams.getFirst(NAME);
        String latitude = locationParams.getFirst(LATITUDE);
        String longitude = locationParams.getFirst(LONGITUDE);
         
        System.out.println("Storing posted " + id + " " + name + "  " + latitude + " "+ longitude);
        
        try {
			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/TrackME", "root", "root");
			System.out.println("connected");
			if (con != null)

			{
				System.out.println("connected");
				stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Location VALUES(?,?,?,?)");
				stmt.setString(1, id);
				stmt.setString(2, name);
				stmt.setString(3, latitude);
				stmt.setString(4, longitude);

				int val = stmt.executeUpdate();

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        location.setId(id);
        location.setName(name);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        
         
        System.out.println("Location info: " + location.getId() + " " + location.getName() + " " + location.getLatitude()+ " "+ location.getLongitude());
         
        return location.toString();
                         
    }
    
    
    @POST
	@Path("friendlocation")
	@Produces(MediaType.APPLICATION_JSON)
	public Location getSamplePerson(

	MultivaluedMap<String, String> personParams) {

		String id = personParams.getFirst(ID);

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/TrackME", "root", "root");
			System.out.println("connected");
			if (con != null) {
				System.out.println("connected");
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Location where id="
						+ id);
				if (rs.next()) {
					String name = rs.getString(2);
					String latitude = rs.getString(3);
					String longitude = rs.getString(5);

					location.setId(id);
					location.setName(name);
					location.setLatitude(latitude);
					location.setLongitude(longitude);

				}

			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return location;
	}
    
}
