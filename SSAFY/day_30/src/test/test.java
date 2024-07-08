package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = "2018-09-11 05:11:22";
		Date yo = sdf.parse(date);
		System.out.println(sdf.format(yo));
	}

}
