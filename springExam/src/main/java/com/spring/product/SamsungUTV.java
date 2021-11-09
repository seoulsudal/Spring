package com.spring.product;

public class SamsungUTV implements TV{

	private Speaker speaker;
	private int price;
	
	public SamsungUTV() {
		System.out.println("SamsungUTV 객체 생성");
	}
	
	public SamsungUTV(Speaker speaker) {
		System.out.println("SamsungUTV Speaker 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungUTV(Speaker speaker, int price) {
		System.out.println("SamsungTV 객체 생성과 가격");
		this.speaker = speaker;
		this.price = price;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}

	public void inintMethod() {
		System.out.println("객체 초기화 작업 처리.");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungUTV---전원을 켠다.(가격 : " + price + ")");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungUTV---전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		// speaker = new speaker();
		speaker.volumeUp();
		// System.out.println("SamsungUTV---소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		// speaker = new speaker();
		speaker.volumeDown();
		// System.out.println("SamsungUTV---소리를 내린다.");
	}
	
}
