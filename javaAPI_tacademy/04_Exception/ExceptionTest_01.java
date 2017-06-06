//문법 오류 - 코딩 상단에서 부터 제거, 시작-종료 다음에 코딩 ==>VM
//실행 오류 - 비정상 종료  ==> 업무에 따라 경우수가 다양 (기능 - 비기능 )
public class ExceptionTest_01 {
	public static void main(String[] args) {
		int num=(int)10.5;
		System.out.println(args[0]);
		System.out.println("end");
	}
}