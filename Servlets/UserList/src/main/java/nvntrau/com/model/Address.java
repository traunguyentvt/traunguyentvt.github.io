package nvntrau.com.model;

import org.json.JSONObject;

public class Address {

    private String street;
    private String city;

    // Constructor
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Convert Address to JSON
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("street", street);
        json.put("city", city);
        return json;
    }

}
