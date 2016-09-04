package swingStudy;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MiniClient extends JFrame {

	private JPanel jpanel_chat = null;
	private String serverIP = null;
	private String nickName = null;
	
	public MiniClient(String title, String serverIP, String nickName){
		super(title);
		this.serverIP = serverIP;
		this.nickName = nickName;
		this.initGUI();
	}

	public static void main(String[] args) {
		MiniClient miniClient = new MiniClient(" + ChattingRoom + ", args[0], args[1]);
		miniClient.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		miniClient.setSize(400, 400);
		miniClient.setVisible(true);
		miniClient.setLocation(new Point(200,200));
		miniClient.setResizable(true);
	}
	
	public void initGUI(){
		jpanel_chat = new JPanel();
		jpanel_chat.setLayout(new BorderLayout());
		jpanel_chat.add(BorderLayout.CENTER, new JLabel("serverIP : "+serverIP));
		jpanel_chat.add(BorderLayout.SOUTH, new JLabel("nickName : "+nickName));
		
		this.getContentPane().add(jpanel_chat);
	}

}
