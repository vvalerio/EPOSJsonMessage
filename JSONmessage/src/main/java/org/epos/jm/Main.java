package org.epos.jm;

public class Main 
{
    public static void main(String[] args)
    {
	JsonMessage jm = new JsonMessage();
	System.out.println(jm.returnJson().toString());
    }
    
}
