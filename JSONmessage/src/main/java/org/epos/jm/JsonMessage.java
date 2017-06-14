package org.epos.jm;

import java.sql.Timestamp;

import com.google.gson.JsonObject;

public class JsonMessage 
{
   
    private JsonObject headerValues;
    
    private messageID mid;
    private String serviceType;
    private String type;
    
    @SuppressWarnings("unused")
    private Timestamp updateOn;
    
    private String responseNode;
    
    public JsonMessage()
    {
	mid = new messageID();
    }
    
    public JsonMessage(JsonObject json)
    {
	mid = new messageID(json.get("Header").getAsJsonObject().get("id").getAsString());
    }
    
    public String getServiceType() {
	return serviceType;
    }

    public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getUpdateOn() {
	return new Timestamp(System.currentTimeMillis()).toInstant().toString();
    }

    public String getResponseNode() {
	return responseNode;
    }

    public void setResponseNode(String responseNode) {
	this.responseNode = responseNode;
    }
    
    public JsonObject createHeaderValues()
    {
	headerValues = new JsonObject();
	headerValues.addProperty("id", mid.getID());
	headerValues.addProperty("serviceType", getServiceType());
	headerValues.addProperty("type", getType());
	headerValues.addProperty("updatedOn", getUpdateOn());
	headerValues.addProperty("responseNode", getResponseNode());
	
	return headerValues;
    }
    
    public JsonObject createPayloadValues()
    {
	return new JsonObject();
    }
    

    public JsonObject returnJson()
    {
	JsonObject output = new JsonObject();
	output.add("Header", createHeaderValues());
	output.add("Payload", createPayloadValues());
	return output;
    }

}
