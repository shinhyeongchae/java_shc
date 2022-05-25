package day21;

public class Ex01_Lambda1 {

	public static void main(String[] args) {
		//람다식을 안쓰고 쓰레드 생성후 테스트
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("안녕");
				
			}
		});	//람다식을 쓰는 이유, 코드를 간결하게 하려고
			//아무때나 쓸수 있는건 아니고 펑셔널 인터페이스.
			//메소드 이름을 사용하지 않아도 된다.
		th1.start();
		//람다식을 이용하여 스레드 생성후 테스
		
		Thread th2 = new Thread(()->System.out.println("안녕"));
		th2.start();
		
		Thread th3 = new Thread(() ->{                     
			System.out.println("hi");
			
		});
		th3.start();
	}

}

