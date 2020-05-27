package com.cht.kafka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.kafka.common.utils.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KafkaApplicationTests {


	@Test
	public void contextLoads() {
		InputStream in=this.getClass().getClassLoader().getResourceAsStream("kafka.properties");
		byte[] bytes=new byte[2048];
		try {
			while(in.read(bytes)!=0) {
				System.out.println("------------------------------"+new String(bytes));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
