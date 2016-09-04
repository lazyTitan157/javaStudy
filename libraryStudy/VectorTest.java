//����06-13 VectorTest.java
package libraryStudy;
import java.util.*;
import javax.swing.*;

public class VectorTest {
	public static void main(String args[]) {
		String out="";
		Vector<Object> vector = new Vector<Object>(1);
		
		for(int i=0;i<5;i++){
         Object x=JOptionPane.showInputDialog("input");
		 vector.addElement(x);
		}
		
		out+="capacity = "+vector.capacity()+"\n";
		out+="size = "+vector.size()+"\n";
		out+="\n\n ";
		
		for(int i=0;i<5;i++){
			Object o= vector.elementAt(i);
			out+=o.toString()+"\n";
		}
	
		JOptionPane.showMessageDialog(null, out);
		
		System.exit(0);
		
	}
}