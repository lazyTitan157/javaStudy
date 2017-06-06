
public class ExceptionTest_02 {
	public static void main(String[] args) {
		int num=Integer.parseInt("1234");//NonCheckedException VM-X
		new String();
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
