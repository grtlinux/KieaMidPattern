package org.tain.utils;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LnsTimeZone {

	/*
	 * Id = UTC+9
	 * ZoneId = Asia/Seoul
	 */
	public static void setTimeZone(String strId) {
		log.info("KANG-20200721 >>>>> {} {}", CurrentInfo.get());
		
		// TO application.yml: spring.jpa.properties.hibernate.jdbc.time_zone: UTC+9
		if (Flag.flag) {
			TimeZone.setDefault(TimeZone.getTimeZone(strId));
			//TimeZone.setDefault(TimeZone.getTimeZone("UTC+9"));
			//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
			//TimeZone.setDefault(TimeZone.getTimeZone("GMT+09:00"));
		}
		
		if (Flag.flag) {
			List<String> lstTimeZone = Arrays.asList(TimeZone.getAvailableIDs());
			lstTimeZone.forEach(timeZoneId -> {
				System.out.println(">>>>> " + timeZoneId);
			});
		}
		
		if (Flag.flag) {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
			System.out.println("Calendar.getTimeZone().getID() >>>>> " + cal1.getTimeZone().getID());
		}
		
		if (Flag.flag) {
			TimeZone timeZone = Calendar.getInstance().getTimeZone();
			System.out.println("현재 TimeZone 구역 의 이름 ::: " + timeZone.getDisplayName());
			System.out.println("현재 TimeZone 구역 의 해당 ID ::: "  + timeZone.getID());
		}
	}
	
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	/*
	 * REF: https://www.daleseo.com/java8-zoned-date-time/
	 */
	public static void printInfo() {
		log.info("KANG-20200721 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			ZoneOffset seoulZoneOffset = ZoneOffset.of("+90:00");
			log.info(">>>>> +9000 Time = {}", ZonedDateTime.now(seoulZoneOffset));
			ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
			log.info(">>>>> Seoul Time = {}", ZonedDateTime.now(seoulZoneId));
		}
	}
}
