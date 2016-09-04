//����06-14 StringBufferTest.java
package libraryStudy;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class AboutStringTest {
	public static void main( String args[] )
	{
		StringBuffer buffer =
				new StringBuffer( "Sprinter Trueno AE86" );

		System.out.println("buffer = " + buffer.toString() +
				"\nlength = " + buffer.length() +
				"\ncapacity = " + buffer.capacity());

		buffer.ensureCapacity( 70 );
		System.out.println("New capacity = " + buffer.capacity());
		buffer.reverse();
		System.out.println(buffer.toString());
		buffer.reverse();
		buffer.append(" VS RX-7 Savanna FC3S");
		System.out.println(buffer.toString());
		buffer.insert(0,"Battle ");
		System.out.println(buffer.toString());
		//
		stringTokenizerTest();
		System.out.println();
		//
		String str = "Sprinter Trueno AE86";
		stringTest(str);
	}

	public static void stringTokenizerTest(){
		String out="";

		String str= JOptionPane.showInputDialog("string tokenizer test");
		out="input: " + str +"\n";
		StringTokenizer st = new StringTokenizer(str, " ", false);
		out+="\n input : \n";

		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			out+="what(token) => " + token + "\n";
		}

		JOptionPane.showMessageDialog(null,out);
		System.exit(0);
	}
	public static void stringTest(String str){
		System.out.println("str.length(): "+ str.length());
		System.out.println("str.substring(9): "+str.substring(9));
		System.out.println("str.indexOf('t'): "+str.indexOf('t'));
		System.out.println("str.charAt(11): "+str.charAt(11));
		System.out.println("str : "+str);
	}
}
