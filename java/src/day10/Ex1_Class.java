package day10;

import java.util.Scanner;

public class Ex1_Class {

	public static void main(String[] args) {
		
		
		RemoteController rm = new RemoteController();
		Scanner scan = new Scanner(System.in);
		int menu = -1;
		
		
		for( ; menu != 7;) {
			System.out.println("메뉴");
			menu = scan.nextInt();
			System.out.println("메뉴\n1. 채널up\n2.채널down\n3.채널 변경4.볼륨 up5.볼륨down6.전원7.전원8.메뉴를 선택하세요");
	
			switch(menu) {
				case 1 : 
					rm.channlUp();
				//c채널 up();
					break;
				case 2 : 
					rm.channlDown();
					//채널 다운
					break;
				case 3 : 
					System.out.println("채널 입력 : " );
					int ch = scan.nextInt();
					rm.channel(ch);
					//채널 변경은 없기 때문에 한번더 입력을 받아야합니다.
					break;
				case 4 :
					//볼륨 up
					rm.volumeUp();
					break;
				case 5 :
					rm.volumeDown();
					//볼륨 다운
					break;
				case 6 :
					//전원
					rm.turn();
					break;
				case 7 :
					System.out.println("프로그램 종료");
					//종료
					break;
				default :
					System.out.println("잘못된 메뉴입니다.");
			
			}
		
		}
		
		
		 		scan.close();
		
	}
	
}



/* Tv 리모컨 클래스를 생성하고, 객체를 생성 후 기능들을 테스트해보세요. */
	class RemoteController{
				//전원 온오프, 볼륨, 채널변경
				 //참조변수설정]
			boolean power;
			int channel;
			int volume;
			int minVolume = 0;
			int maxVolume = 32;
			int minChannel = 1;
			int maxChannel = 99;
			/*기능 : tv를 켜는 메소드
			 * 매개 변수	 : 없음 
			 * 리턴타입 	: 없음
			 * 메소드명 	:  trunOn*/
		void turnOnOn() {
			power = true;
			System.out.println("Tv가 켜졌습니다.");
			
		}
		/*기능 : tv를 끄는는 메소드
		 * 매개 변수	 : 없음 
		 * 리턴타입 	: 없음
		 * 메소드명 	:  trunOff*/
	void turnOnOff() {
		power = false;
		System.out.println("Tv가 꺼졌습니다.");
		
	}	
		/*기능 : Tv를 키거나 끄는 메소드
		 * 매개변수 : 없음(설정하기 나름) 
		 * 리턴타입 : 없음
		 * 메소드명 :  turn*/	
	void turn() {
/*기능 : 소리를 한칸 올리는 기능
 * 매개변수 : 없음 
 * 리턴타입 : 없음 = void
 * 메소드명 : volumeUp*/

		power = !power;
		if(power) {
			System.out.println("tv가 켜졋음");
		}else {
			System.out.println("tv가 꺼짐");
		}
	
	}
	/*기능 : 소리를 한칸 올리는기능
	 * 매개변수 없음
	 * 리턴타입엄ㅄ음
	 * 메소드명 볼륨업*/
		void volumeUp() {
		if(power) {
			if(volume < maxVolume)
			volume++;
				
			}
		System.out.println("소리 : "+ volume);
		}
	/*기능 : 소리를 한칸 내리는기능
	 * 매개변수 없음
	 * 리턴타입엄ㅄ음
	 * 메소드명 볼륨다운*/
	void volumeDown() {
		if(power) {
			if(volume < minVolume)
				volume--;
		}
		System.out.println("소리 : "+ volume);	
	}
	
	/*채널을 1씩 증가하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 매소드명 : channelUp
	 * */
	void channlUp() {
		if(power) {
			if(channel < maxChannel) {
				channel++;
			}
			System.out.println("채널 : " + channel);
		}
	}
	
	/*채널을 1씩 감소하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메소드명 : channelDown
	 * */
	void channlDown() {
		if(power) {
			if(channel > minChannel) {
				channel--;
			}
			System.out.println("채널 : " + channel);
		}
	}
	/*기능 : 입력한 채널로 이동하는 메소드
	 * 매개변수 : 이동할 채널 => int ch
	 * 리턴타입 : 없음 => void 
	 * 메소드명 : channel*/
	 void channel(int ch) {
		 if(power) {
			 if(ch < minChannel) {
				 channel = minChannel;
			 }
			 else if(ch > maxChannel) {
				 channel = maxChannel;
			 }else {
				 channel = ch;
			 }
					 System.out.println("채널 : " + channel);
				  
				 
		 }
	 }
	 public RemoteController() { 
		 channel = minChannel;
		 volume = minVolume;
	 }
	 public RemoteController(int ch, int v) {
		if(ch >= minChannel && ch <= maxChannel) {
			channel = ch;
		}else {
			channel = minChannel;
		}
		if(v >= minVolume && v <= maxVolume) {
			volume = v;
		}else {
			volume = minVolume;
		}
			
		
	}
	 
	
}