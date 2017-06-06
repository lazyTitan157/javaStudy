import java.util.Scanner;
//need to import package! 

public class StudentInfoManager {

	public static void main(String[] args) {

		System.out.print("ID: ");
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();
		System.out.print("PW: ");
		String pw = scan.nextLine();
		//pw comparison
		//쓸모없는 테스트 코드 불필요
		
	}
	//constructor! it makes you to create object.
	
	public void gradeCheck(int studentNumber){
		System.out.println("grade1"+StudentInformation.grade1);
		System.out.println("grade2"+StudentInformation.grade2);
		System.out.println(StudentInformation.grade3);
	}
}
