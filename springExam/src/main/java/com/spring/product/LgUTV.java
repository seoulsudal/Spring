package com.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgUTV implements TV{
	@Autowired
	private Speaker speaker;
	
	public LgUTV() {
		System.out.println("LgUTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgUTV---전원 켠다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgUTV---전원 끈다.");
	}
	
	@Override
	public void volumeUp() {
		// System.out.println("LgUTV---소리를 올린다.");
		speaker.volumeUp();
	}
	
	@Override
	public void volumeDown() {
		// System.out.println("LgUTV---소리를 내린다.");
		speaker.volumeDown();
	}
	
}
