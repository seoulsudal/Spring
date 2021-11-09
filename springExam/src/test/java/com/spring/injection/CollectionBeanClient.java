package com.spring.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	@Test
	public void TestEx() {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean) factory.getBean("CollectionBean");

//		List<String> addressList = bean.getAddressList();
//		Set<String> addressList = bean.getAddressList();
//		Map<String, String> addressList = bean.getAddressList();
		
/*		for (String address : addressList) {
			System.out.println(address.toString());
		}	*/
		
		// 모든 항목을 방문한다.
/*		for (Map.Entry<String, String> addList : addressList.entrySet()) {
			String key = addList.getKey();
			String value = addList.getValue();
			System.out.println("key = " + key +", value = " + value);
		}	*/
		
		Properties addressList = bean.getAddressList();
		System.out.println(addressList.getProperty("홍길동"));
		System.out.println(addressList.getProperty("김철수"));

		factory.close();
		
	}

}
