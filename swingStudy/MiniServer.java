/*
 * server GUI 
 */

package swingStudy;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MiniServer extends JFrame {

	public MiniServer(String title){
		super(title);
	}
	
	public static void main(String[] args) {
		MiniServer miniServer = new MiniServer("+ ChatServer +");
		miniServer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		miniServer.setSize(200, 50);
		miniServer.setVisible(true);
		miniServer.setLocation(new Point(200,200));
		miniServer.setResizable(false);
	}

}
