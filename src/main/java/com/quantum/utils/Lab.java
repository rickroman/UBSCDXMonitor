package com.quantum.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab {

	public static void main(String[] args) {
		
		
		
		String updatedOn = "AS OF 8/24/2022 5:19 PM ET";
        
        Pattern pattern = Pattern.compile("((\\d){1,2}/){2}(\\d){4}");
        
        Matcher matcher = pattern.matcher(updatedOn);
        
        if(matcher.find()) {
        	
        	String updatedOnStr = matcher.group();
        	
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            
            Date updatedOnDate;
    		try {
    			updatedOnDate = sdf.parse(updatedOnStr);
    			
    			 Calendar calendar = new GregorianCalendar();
    		        calendar.setTime(updatedOnDate);
    		        
    		        int year = calendar.get(Calendar.YEAR);
    		        
    		        System.out.println(year);
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        
        
        
       
        
	}

}
