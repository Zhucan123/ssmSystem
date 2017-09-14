/**
 * 
 */
package com.game.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MR zhu can
 * @date 2017��8��14��
 * @time ����6:25:25
 */
public class DateFormatUtil {

	public static Date format(String date) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-mm-hh");

		try {
			return sFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
