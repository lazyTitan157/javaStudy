/*
 * 프로그램 작성시 중간에 보관할 데이터의 보존을 위해 변수를 이용하는 대신,
 * 영구적인 저장을 위해 영구기억장치 하드디스크 등에 보관 : 파일 / 데이터베이스
 * - 파일저장을 위해 file객체와 fileStream객체 이용
 * file클래스의 메서드 : canRead(), canWrite(), compareTo(pathname), createNewFile() ...
 * 	java.io패키지 import
 * 	파일의 내용에 접근 가능, 해당 파일의 경로 및 디렉터리 정보에 접근 가능
 * fileStream클래스 :
 *  스트림 : 데이터의 발생지부터 목적지까지 흐르는 데이터의 흐름, 프로그램으로 들어가거나 나오는 데이터의 흐름
 *  데이터를 스트림에 쓸 수 있고, 스트림으로부터 데이터를 읽어올 수도 있다. - 입출력장치에 독립적
 *  외부의 입력을 프로그램으로 가져오거나 결과를 출력/저장하기 위해 내보내려면 스트림 사용
 *  java.io패키지 import 
 *  	스트림의 장점 : 입출력장치의 세부구조를 신경쓰지 않아도된다.
 *  			소스를 변경하지 않아도 다양한 입출력장치에 대해 동일한 프로그램 사용가능
 *  - 자바 네트워크 프로그래밍에서 전달할 수 있는 데이터는 반드시 스트림화 : 객체의 직렬화, 스트림에서 객체화
 *  	JSP에서의 활용과 네트워킹 기능이 C보다 훨씬 간단,강력 (느림에도 불구하고 java가 사용되는 이유)
 *  	우리나라 전자정부시스템 지원 언어가 자바 기반, JSP기반웹사이트, 비즈니스로직 개발 컴포넌트는 EJB, 모바일전자정부도 자바기반
 *  	미국은 .NET기반으로 비즈니스로직 개발
 *  1. 바이트 스트림 : inputStream, OutputStream 클래스(추상클래스) - 제공하는 메서드 파악
 *  	그림,동영상 등의 바이너리 파일을 읽고 쓸때 이용 - 파일업로드 등
 *  	inputStream의 하위 클래스 : ByteArrayInputStream, FileInputStream, ObjectInputStream 등 6가지
 *  	outputStream의 하위 클래스 6가지
 *  2. 문자스트림 : Reader, Writer 클래스(추상클래스)
 *  
 *  1. 버퍼스트림 
 *  	버퍼 : 입출력을 향상시키기 위해서 사용하는 방법 - 줄단위로 입출력 가능(최소한의 입출력발생-성능향상)
 *  	버퍼링 : 버퍼라고 불리는 메모리에 데이터를 일정 크기만큼 모았다가 사용하느 ㄴ것
 *  2. 파일입출력 : 자바애플리케이션만 가능, 자바애플릿은 웹공개라서 보안문제때문에 로컬장치에 접근 불가
 *  	FileInputStream, FileOutputStream, FileReader/FileWriter는 파일 입출력에 사용되는 스트림
 *  3. PrintStrema : 주로 출력용
 *  4. DataInput/DataOutputStream : 기본데이터의 입출력에 사용
 *  5. ObjectInput/OutputStream : 입출력스트림에서 중요한 것 - 예제) 563-584
 *  	- 입력된 데이터를 객체로 저장하고, 객체로 읽어오는 방법 (레코드 처럼 사용)
 *  6. RandomAccessFile : 임의접근파일 생성 - 원하는 레코드에 접근가능(seek(pointer)메서드 이용)
 *  	- 5까지는 순차접근 파일
 */
package libraryStudy;

import java.io.File;

import javax.swing.JOptionPane;

public class fileIOTest {

	public static void main(String args[]){
		
		//file 객체 정보출력 예제
		String str = "";
		String name = JOptionPane.showInputDialog("파일명을 입력"); //swing컴포넌트 이용
		File file = new File(name);
		
		if(file.exists()){//입력한 파일이 존재하면
			str+= "파일명:"+file.getName()+"\n" //파일명
					+"file size : "+file.length()+"\n" 
					+"last modified day : "+file.lastModified()+"\n"
					+"parent directory : "+file.getParent();//해당 파일이 있는 디렉터리명
		} else { //존재하지 않으면
			str="입력한 파일이 존재하지 않습니다.";
		}
		
		JOptionPane.showMessageDialog(null, str);
		System.exit(0);
		
		//file 객체 생성 예제
	}
}
