/*
 * stand alone 방식이 되기 위해 main메소드를 가진다.
 * stand alone 방식 : 
 */

package swingStudy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;


public class MiniChatter extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3765014567211135963L;
	
	private JPanel jpanel_login;
	private JPanel jpanel_login_top_image;
	private JLabel jlabel_status_image;
	//chap 02
	private JPanel jpanel_login_top;
	//Login Section 내부 컴포넌트 추가 - jPanel_login_top부분에 하위 컴포넌트 추가함
	private JLabel jlabel_authType;
	private JPanel jpanel_authType;
	private ButtonGroup buttonGroup_authType;
	private JRadioButton jradioButton_authType_server;
	private JRadioButton jradioButton_authType_client;
	//위 컴포넌트들은 miniChatter를 server모드 혹은 client모드로 실행시킬지 여부를 받아들이는 리스너부분
	private TitledBorder jTitledBorder;
	private JPanel jpanel_login_top_inner;
	private JPanel jpanel_login_top_inner_01;
	private JPanel jpanel_login_bottom;
	private JPanel jpanel_login_bottom_inner;
	private JLabel jlabel_message;
	//리스너 추가 및 서버/클라이언트 모드 표시
	public String auth_state;
	private Font jFont;
	//client/sever권한 선택하는 대로 변화하도록  GUI하단의 View Control
	private JButton jbutton_server;
	private JPanel jpanel_login_bottom_inner_01;
	private JLabel jlabel_serverIP;
	private JTextField jtextfield_serverIP;
	private JPanel jpanel_login_bottom_inner_02;
	private JLabel jlabel_nickName;
	private JTextField jtextfield_nickName;
	private JButton jbutton_client;

	public MiniChatter(String title){
		super(title);
		initGUI();
	}

	public static void main(String[] args) {

		MiniChatter miniChatter = new MiniChatter("Mini Chatter");
		miniChatter.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		miniChatter.setIconImage(getChatterImage("image/minichatter.jpg"));
		//getChatterImage 함수 아래에서 정의
		miniChatter.setSize(400, 320);
		miniChatter.setVisible(true);
	}
	
	//InetAddress클래스 : 인터넷 프로토콜을 표시하고 대표하는 클래스
	//인터넷프로토콜(IP) : 32bit/128bit의 unsigned number 또는 UDP(user datagram protocol)나 TCP(transmission control protocol) 등의 하위 프로토콜을 의미
	//이 클래스를 이용해 IP주소로 hostname, localNode의 ip주소 얻기 등 가능
	public String getLocalIP(){
		String serverIp = null;
		try{
			serverIp = InetAddress.getLocalHost().getHostAddress();
		} catch(UnknownHostException unknownEx){
			setInformationMessage("LocalHost IP주소를 알 수 없습니다.");
			serverIp = "127.0.0.1";
			unknownEx.printStackTrace();
		} catch(Exception ex){
			setInformationMessage("LocalHost IP주소를 얻어오는 중에 Exception이 발생하였습니다.");
			serverIp = "127.0.0.1";
			ex.printStackTrace();
		}
		return serverIp;
	}
	
	private void setInformationMessage(String message) {
		jlabel_message.setText(message);
	}

	//신규추가 메소드 : setClientTypeUI
	public void setClientTypeUI(String authType, String message){
		if(auth_state != authType){
			if(authType == "server"){
				//jpanel_login_bottom_inner컴포넌트를 없앤다.
				jpanel_login_bottom_inner.removeAll();
				jlabel_message.setText("- server ip-address : "+getLocalIP()+"[port:9988]");
				jbutton_server = new JButton("LaunchServer");
				//miniServer와 연결하기 위한 리스너
				jbutton_server.addActionListener(new LoginListener());
				jpanel_login_bottom_inner.add(BorderLayout.CENTER, jlabel_message);
				jpanel_login_bottom_inner.add(BorderLayout.SOUTH, jbutton_server);
				//jpanel_login_bottom_inner컴포넌트의 변경사항을 확인한다.
				jpanel_login_bottom_inner.validate();
				//폰트 객체를 추가해서 setText()
				jlabel_status_image.setText(message);
				jFont = new Font("TAHOMA", Font.PLAIN, 30);
				jlabel_status_image.setFont(jFont);
			} else {
				jpanel_login_bottom_inner.removeAll();
				jlabel_message.setText("[접속정보 입력]");
				
				jpanel_login_bottom_inner_01 = new JPanel(new BorderLayout());
				
				jlabel_serverIP = new JLabel("- server IP /");
				jtextfield_serverIP = new JTextField(16);
				jtextfield_serverIP.setText(getLocalIP());
				jtextfield_serverIP.setBackground(Color.black);
				jtextfield_serverIP.setForeground(Color.white);
				jtextfield_serverIP.setCaretColor(Color.gray);
				jpanel_login_bottom_inner_01.add(BorderLayout.WEST, jlabel_serverIP);
				jpanel_login_bottom_inner_01.add(BorderLayout.CENTER, jtextfield_serverIP);
				
				jpanel_login_bottom_inner_02 = new JPanel(new BorderLayout());
				
				jlabel_nickName = new JLabel("- chat name/");
				jtextfield_nickName = new JTextField(5);
				jtextfield_nickName.setBackground(Color.black);
				jtextfield_nickName.setForeground(Color.white);
				jtextfield_nickName.setCaretColor(Color.gray);
				jbutton_client = new JButton("login");
				//miniClient연결 리스너
				jbutton_client.addActionListener(new LoginListener());
				jpanel_login_bottom_inner_02.add(BorderLayout.WEST, jlabel_nickName);
				jpanel_login_bottom_inner_02.add(BorderLayout.CENTER, jtextfield_nickName);
				jpanel_login_bottom_inner_02.add(BorderLayout.EAST, jbutton_client);
				jpanel_login_bottom_inner.add(BorderLayout.NORTH, jlabel_message);
				jpanel_login_bottom_inner.add(BorderLayout.CENTER, jpanel_login_bottom_inner_01);
				jpanel_login_bottom_inner.add(BorderLayout.SOUTH, jpanel_login_bottom_inner_02);
				
				jlabel_status_image.setText(message);
				jFont = new Font("TAHOMA", Font.PLAIN, 30);
				jlabel_status_image.setFont(jFont);
			}
		} else {
		}
	}

	public static Image getChatterImage(String imgPath) {
		URL imgURL = MiniChatter.class.getResource(imgPath);
		if(imgURL!=null){
			return new ImageIcon(imgURL).getImage();
		} else {
			return null;
		}
	}

	public void initGUI(){
		try{
			//setting position :x,y좌표로 minichatter의 생성 위치를 잡아준다. 
			//좌표의 맨 좌측 상단 모서리가 0,0
			this.setLocation(new Point(500,300));
			//login tab
			jpanel_login = new JPanel();
			jpanel_login.setLayout(new BorderLayout()); 
			//JPannel은 FlowLayout(default), setLayout(new BorderLayout())으로 설정해 배치필요
			//jpanel_login이라는 JPnel안에, 
			// jpanel_login_top_image, jpanel_login_top, jpanel_login_bottom의 Panel 생성
			
			//상태 표시 라벨
			{
				{
					jpanel_login_top_image = new JPanel(); //server/client모드를 표시하는 display성격의 pannel
					jlabel_status_image = new JLabel(); 
					jpanel_login_top_image.add(jlabel_status_image); 
				}
				//로그인컴포넌트들 
				{
					jpanel_login_top = new JPanel(); 
					jTitledBorder = new TitledBorder("[LOGIN]");
					jTitledBorder.setTitleColor(Color.GRAY);          
					jpanel_login_top.setBorder(jTitledBorder); 
					//server/client모드를 선택할 수 있는 radio버튼 포함 pannel
					{
						jpanel_login_top_inner = new JPanel();            
						{
							jpanel_login_top_inner_01 = new JPanel(new BorderLayout());
							//하위 컴포넌트 추가
							jlabel_authType = new JLabel();
							jlabel_authType.setToolTipText("-Authority :");
							//제목추가용 jPanel
							jpanel_authType = new JPanel();
							//radioButton 그룹핑하여 포함하는 Jpanel
							buttonGroup_authType = new ButtonGroup();
							//jradioButton의 event컨트롤을 용이하게 하기 위해 buttonGroup으로 그룹핑
							jradioButton_authType_server = new JRadioButton("server");
							jradioButton_authType_server.setSelected(false);
							//최초 실행시 server모드 선택되어 있지 않도록 false처리해둠
							//리스너 추가
							jradioButton_authType_server.addActionListener(new LoginListener());
							jradioButton_authType_client = new JRadioButton("client");
							//리스너 추가
							jradioButton_authType_client.addActionListener(new LoginListener());
							buttonGroup_authType.add(jradioButton_authType_server);
							buttonGroup_authType.add(jradioButton_authType_client);
							jpanel_authType.add(jradioButton_authType_server);
							jpanel_authType.add(jradioButton_authType_client);
							jpanel_login_top_inner_01.add(BorderLayout.WEST, jlabel_authType);
							jpanel_login_top_inner_01.add(BorderLayout.CENTER, jpanel_authType);
						}
						jpanel_login_top_inner.add( jpanel_login_top_inner_01);
					}
					jpanel_login_top.add(jpanel_login_top_inner);   
				}
				//메세지 컴포넌트들
				{
					jpanel_login_bottom = new JPanel(); //server/client모드에 따라 입력 패턴을 바꾸는 pannel
					jTitledBorder = new TitledBorder("[INFORMATION]");
					jTitledBorder.setTitleColor(Color.GRAY);
					jpanel_login_bottom.setBorder(jTitledBorder);
					{
						jpanel_login_bottom_inner = new JPanel(new BorderLayout());
						{
							jlabel_message = new JLabel();
							jlabel_message.setText("");
						}
						jpanel_login_bottom_inner.add(jlabel_message);
					}
					jpanel_login_bottom.add(jpanel_login_bottom_inner);
				}
				//jPanel_login의 layout을 null로 설정 - 자동배치되는 컴포넌트배치를 사용하지 않고, 직접 위치 지정할 것
				jpanel_login.setLayout(null);
				jpanel_login.add(jpanel_login_top_image);
				jpanel_login.add(jpanel_login_top);
				jpanel_login.add(jpanel_login_bottom);
				jpanel_login_top_image.setBounds(0, 10, 390, 50);
				//setBountds는 java.awt.Component라는 추상클래스의 메소드
				jpanel_login_top.setBounds(0, 70, 390, 100);
				jpanel_login_bottom.setBounds(0, 180, 390, 110);
			}
			//main GUI 붙이기
			//getContentPane()의 add()를 사용해서 jpanel_login을 BorderLayout의 중앙에 배치
			this.getContentPane().add(BorderLayout.CENTER, jpanel_login);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//action listener를 구현하는 loginListener라는 내부 클래스 추가 - actionPerformed함수를 반드시 구현해야한다.
	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//파라미터 e에 따라 GUI상단에 상태표신를 다르게하는 setClientTypeUI()메소드로 상태정보 전송
			if(e.getSource() == jradioButton_authType_server){
				setClientTypeUI("server", "Server Mode");
				//String auth_state값으로 한번 선택한 authority에 대한 연속 클릭 체크 - 또 클릭하면 
				auth_state = "server";
				// setClientTypeUI함수의 1줄에서 걸러짐
			} else if(e.getSource() == jradioButton_authType_client){
				setClientTypeUI("client", "Client Mode");
				auth_state = "client";
			} else if(e.getSource() == jbutton_client){
				String serverIP = jtextfield_serverIP.getText();
				String nickName = jtextfield_nickName.getText();
				launchChatClient(serverIP, nickName);
			} else if(e.getSource() == jbutton_server){
				launchChatServer();
			}
		}
	}

	public void launchChatServer() {
		try{
			//외부 애플리케이션이나 스크립트/쉘 호출 가능 (재귀호출은 불가능)
			//실행 경로 주의 javaProject에서 그 이하 프로젝트를 인식할 수 있게 환경변수 설정
			Runtime.getRuntime().exec("java swingStudy.MiniServer");
			jbutton_server.setText("Server is launched");
			//반복호출 방지
			jbutton_server.setEnabled(false);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void launchChatClient(String serverIP, String nickName) {
		try{
			//miniClient호출하면서 인자 2개 넘김
			Runtime.getRuntime().exec("java swingStudy.MiniClient "+serverIP+" "+nickName);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}


