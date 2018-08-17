package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {
	public static void main(String[] args) {


		String start = "2015-04-01";
		String end = "2015-05-05";

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate =  fmt.parse(start);
			Date endDate =  fmt.parse(end);

			long diff= endDate.getTime() - startDate.getTime();
			long diffday = diff / (24*60*60*1000);

			System.out.println(diffday);


		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
