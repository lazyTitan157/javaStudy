/*
 * process : 메모리를 할당받아 실행중인 프로그램, 프로그램의 순서대로 명령어 처리
 *  메모리 할당을 받아 사용하는 것으로 자원을 점유 = 프로세스가 많을 수록 시스템 과부하
 * 쓰레드 : 프로세스 내의 명령어 블록으로 프로세스 내에 존재, 메모리할당 없음
 * 하나의 프로세스에 여러개의 쓰레드로 프로그램을 동시에 처리 : 다중 스레딩
 *  메모리를 점유하지 않으면서 프로그램의 수행 속도 향상
 *  (반대) 단일 스레드 : main()도 포함 - 다른 쓰레드를 서비스(제공)해주는 스레드를 데몬스레드라고 함
 *  setDemon(true)로 데몬스레드 지정
 *  (사용) 자바애니메이션 기능 구현에 중요, 네트워크에서도 클라이언트를 스레드로 취급해야 동시요청 처리 가능, 
 *  	 가비지 컬렉터도 스레드로 우선순위가 낮아서 프로세서가 여유로울 때만 작동됨
 * 하나의 프로세서에 여러개의 프로세스 수행 : 다중 프로그래밍
 * 
 * 쓰레드의 상태전이도 : 운영체제의 프로세스 상태전이도와 유사 
 * 쓰레드 생성 후 Runnable상태, 대기행렬 큐에 등록해서 프로세서로부터 서비스받기를 대기
 * 우선순위가 높은 쓰레드 먼저 Running상태로 전이 = run()메서드이용
 * suspend(), wait(), sleep()이 호출되면 Blocked상태로 전이
 * suspend() -> resume()으로 호출해서 Runnable로 만들어야함
 * wait() -> notify()
 * yield() : 다른쓰레드에게 Running상태를 넘기고 Runnable상태가 되어 대기행렬 큐로 이동
 * stop() : Dead상태가 되어 종료(소멸)
 * 
 * Thread클래스 - Runnable 인터페이스
 * 스레드 동기화 : synchronized키워드로 메서드 선언 , synchronized블록 
 * ㄴ synchronized = 쓰레드의 프로세스화(하나의 메서드나 블럭을 한번에 하나의 쓰레드만 사욯하도록 함)
 * 
 * (Thread클래스 상속)Producer, Consumer 클래스, SharedNotMethod클래스와 SharedNot클래스의 관계
 * Producer 클래스 : 생산자 스레드 - 숫자 생산 : run()
 * Consumer 클래스 : 소비자 스레드 - 숫자 소비 : run()
 * SharedNotMethod클래스 : 생산자 스레드가 생산한 값과 소비자 쓰레드가 소비한 값을 화면에 표시 :produce(int), consume()
 * SharedNot클래스 : main()메서드를 가지고 가각의 객체를 생성해서 수행시킴
 * ㄴ 동기화 되지 않아서 실행시마다 합계의 결과가 다르게 나온다 : libraryStudy.notSync패키지 실행겨로가
 * 
 * 동기화된 생산자와 소비자 문제 - 위와의 차이는 SharedSyncMethod에 synchronized키워드 추가 뿐
 * Producer, Consumer, SharedSyncMethod, SharedSync 클래스간의 관계
 * ㄴ 원형큐를 이용하여 동기화된 생산자와 소비자 예제 : libraryStudy.Sync
 * 
 * 스레드의 우선순위 : setPriority() 
 * 스레드의 활용 : 자바애니메이션 예제 
 */

package libraryStudy;

public class ThreadTest extends Thread{

	public void run() {
		System.out.println("("+getName()+")이 수행되고 있다.");
	}

	static public void main(String args[]){
		System.out.println("("+Thread.currentThread().getName()+")이 수행되고 있다.");
		
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		
		
		t1.start();
		t2.start();
	}
}
