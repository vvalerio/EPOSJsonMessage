package org.epos.jm;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class messageID 
{
    private String timestamp;
    private long randomNum;
    private int arrayIndex = 0;
    private String[] template;
    
    public messageID()
    {
	timestamp = new Timestamp(System.currentTimeMillis()).toInstant().toString();
	randomNum = ThreadLocalRandom.current().nextLong(100000000,999999999);
	this.template = "".split(":");
    }
    
    public messageID(String element) {
	String[] temp = element.split("-");
	timestamp = temp[0];
	randomNum = Long.parseLong(temp[1]);
	arrayIndex = Integer.parseInt(temp[2]);
	try {
	    template = temp[3].split(":");
	}
	catch(Exception e){}
    }

    public String getID(){ 
	return timestamp+"-"+randomNum+"-"+arrayIndex+"-"+Arrays.toString(template).replaceAll(", ", ":").replaceAll("\\[", "").replaceAll("\\]", "");
	}
    
}
