package com.lau.githubs.rabbitmq;

import java.util.Date;

import com.lau.githubs.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTestApplicationTests {

	@Autowired
	ImmediateSender immediateSender;

	@Resource
	UserService userService;
	
	@Test
	public void test() {
	    /*Booking booking = new Booking();
        booking.setBookingContent("hhaha");
        booking.setBookingName("预定房子");
        booking.setBookingTime(new Date());
        booking.setOperatorName("hellen");*/
//	    immediateSender.send("mmmbka789","23", 10000);

		userService.performTask("mmmbka789");
	}
}
