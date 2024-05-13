package com.comcast.crm.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random random= new Random();
		int randomNum = random.nextInt(5000);
		return randomNum;
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date dateobj= new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = sim.format(dateobj);
		return date;
	}
	
	public String getRequiredDateYYYYDDMM(int days)
	{
		Date dateobj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		Calendar cal= sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
		
		
	}

}
