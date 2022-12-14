package user;
/* 
 디자인, 설계 : 허유진 + 기능 : 전우진
 클래스 : 회원가입
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.dbInfo;
import game.Login;

public class SignUp extends JFrame implements ActionListener, MouseListener, WindowListener {
	
	private Font mainFont, subFont, IDFont;
	private JTextField SignUp_textfield_id, SignUp_textfield_Nickname, SignUp_textfield_Email;
	private JPasswordField SignUp_pw, SignUp_pwcheck;
	private String id, nickName, email;
	private dbInfo db;
	private JButton SignUp_btn, exit_btn;
	private int count;
	private Color blue, skyBlue;

	public SignUp(String title) {
		setTitle(title);
		setLocation(300, 300);
		setSize(530, 430);
		setLayout(new BorderLayout());
		setResizable(false); // 화면 크기 조절 불가능
		addWindowListener(this);
		
		blue = new Color(26, 67, 141);
		skyBlue= new Color(218, 227, 238);
		
		IDFont = new Font("넥슨 풋볼고딕 B", Font.PLAIN, 16);
		mainFont = new Font("Koverwatch", Font.PLAIN, 20);
		subFont = new Font("Koverwatch", Font.PLAIN, 15);
		
		SignUpPannel();
		setVisible(true);
		
		}
	
	private void SignUpPannel() {
		JPanel SignUp_Pannel = new JPanel();
		SignUp_Pannel.setLayout(null);
		SignUp_Pannel.setPreferredSize(new Dimension(520, 430));
		SignUp_Pannel.setBackground(skyBlue);
		
		//2022-10-23 신규유저 라벨
		JLabel Signup_title = new JLabel("신규 유저");
		Signup_title.setBounds(45, 25, 200, 30);
		Signup_title.setForeground(Color.BLACK);
		Signup_title.setFont(new Font("Koverwatch", Font.BOLD, 30));
		SignUp_Pannel.add(Signup_title);
		
		//2022-10-23 아이디 라벨
		JLabel SignUp_ID = new JLabel("아이디");
		SignUp_ID.setForeground(Color.DARK_GRAY);
		SignUp_ID.setBounds(90, 80, 100, 30);
		SignUp_ID.setFont(IDFont);
		SignUp_Pannel.add(SignUp_ID);
		
		//2022-10-23 비밀번호 라벨
		JLabel SignUp_PW = new JLabel("비밀번호");
		SignUp_PW.setForeground(Color.DARK_GRAY);
		SignUp_PW.setBounds(90, 130, 100, 30);
		SignUp_PW.setFont(IDFont);
		SignUp_Pannel.add(SignUp_PW);
		
		//2022-10-23 비밀번호 확인 라벨
		JLabel SignUp_PW_Check = new JLabel("비밀번호 확인");
		SignUp_PW_Check.setForeground(Color.DARK_GRAY);
		SignUp_PW_Check.setBounds(90, 180, 110, 30);
		SignUp_PW_Check.setFont(IDFont);
		SignUp_Pannel.add(SignUp_PW_Check);
		
		//2022-10-23 닉네임 라벨
		JLabel SignUp_Nickname = new JLabel("닉네임");
		SignUp_Nickname.setForeground(Color.DARK_GRAY);
		SignUp_Nickname.setBounds(90, 230, 100, 30);
		SignUp_Nickname.setFont(IDFont);
		SignUp_Pannel.add(SignUp_Nickname);
		
		//2022-10-23 이메일 라벨
		JLabel SignUp_Email = new JLabel("이메일");
		SignUp_Email.setForeground(Color.DARK_GRAY);
		SignUp_Email.setBounds(90, 280, 100, 30);
		SignUp_Email.setFont(IDFont);
		SignUp_Pannel.add(SignUp_Email);
		
		//2022-10-23 취소 버튼 
		exit_btn = new JButton("취소");
		exit_btn.setBounds(440, 10, 65, 30);
		exit_btn.setFont(new Font("Koverwatch", Font.BOLD, 20));
		exit_btn.setForeground(Color.DARK_GRAY);
		exit_btn.setBackground(blue);
		exit_btn.setBorderPainted(false);
		exit_btn.setOpaque(false);
		exit_btn.addActionListener(this);
		SignUp_Pannel.add(exit_btn);
		
		//2022-10-23 등록 버튼 
		SignUp_btn = new JButton("등록");
		SignUp_btn.setBounds(90, 335, 320, 35);
		SignUp_btn.setFont(new Font("Koverwatch", Font.BOLD, 15));
		SignUp_btn.setBackground(blue);
		SignUp_btn.setForeground(Color.WHITE);
		SignUp_btn.addActionListener(this);
		SignUp_Pannel.add(SignUp_btn);
		
		//2022-10-24 아이디 텍스트
		SignUp_textfield_id =new JTextField();
		SignUp_textfield_id.setBounds(210, 80, 200, 30);
		SignUp_textfield_id.setFont(IDFont);
		SignUp_textfield_id.addActionListener(this);
		SignUp_textfield_id.addMouseListener(this);
		SignUp_Pannel.add(SignUp_textfield_id);
				
		//2022-10-24 패스워드 텍스트
		SignUp_pw = new JPasswordField();
		SignUp_pw.setBounds(210, 130, 200, 30);
		SignUp_pw.addActionListener(this);
		SignUp_Pannel.add(SignUp_pw);
				
		//2022-10-24 패스워드 확인 텍스트
		SignUp_pwcheck = new JPasswordField();;
		SignUp_pwcheck.setBounds(210, 180, 200, 30);
		SignUp_pwcheck.addActionListener(this);
		SignUp_Pannel.add(SignUp_pwcheck);
				
		//2022-10-24 닉네임 텍스트
		SignUp_textfield_Nickname =new JTextField();
		SignUp_textfield_Nickname.setBounds(210, 230, 200, 30);
		SignUp_textfield_Nickname.setFont(IDFont);
		SignUp_textfield_Nickname.addActionListener(this);
		SignUp_Pannel.add(SignUp_textfield_Nickname);
				
		//2022-10-24 이메일 텍스트
		SignUp_textfield_Email =new JTextField();
		SignUp_textfield_Email.setBounds(210, 280, 200, 30);
		SignUp_textfield_Email.setFont(IDFont);
		SignUp_textfield_Email.addActionListener(this);
		SignUp_Pannel.add(SignUp_textfield_Email);
		
		add(SignUp_Pannel);
		
	}

	public JTextField getId() {
		return SignUp_textfield_id;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			// 2020-10-26 전우진 기능 구현
			if(obj == SignUp_btn || obj == SignUp_textfield_id || obj == SignUp_pw || obj == SignUp_pwcheck || obj == SignUp_textfield_Nickname || obj == SignUp_textfield_Email) {
				id = SignUp_textfield_id.getText();
				char[] pw = SignUp_pw.getPassword();
				char[] pwch = SignUp_pwcheck.getPassword();
				nickName = SignUp_textfield_Nickname.getText();
				email = SignUp_textfield_Email.getText();

				
					if(id.equals("") || pw.equals("")
							|| pwch.equals("") || nickName.equals("") 
							|| email.equals("")) {
					 JOptionPane.showMessageDialog(this, "입력 정보를 다시 확인해주세요.");
					} else {
						char[] temp = pw;
						String resultpw = "";
						String resultpwch = "";
						
						for(char ch	: temp) {
							Character.toString(ch);
							resultpw += ""+ch+"";
						}
						
						temp = pwch;
						
						for(char ch	: temp) {
							Character.toString(ch);
							resultpwch += ""+ch+"";
						}
						if(id.length() >= 4 && id.length()<= 10) {
							if(resultpw.equals(resultpwch)) {
								if(resultpw.length() <= 18 && resultpw.length() >= 8 && resultpwch.length() <= 18 && resultpwch.length() >= 8) {
										if(nickName.length() >= 4 && nickName.length() <= 10) {
												// 전우진 회원가입 DB 연결
												db = new dbInfo();
												db.infoInsert(SignUp_textfield_id.getText(), SignUp_pw.getText(), SignUp_textfield_Nickname.getText(), SignUp_textfield_Email.getText(), count);
												JOptionPane.showMessageDialog(this, "회원가입이 완료 되었습니다");
												Login lg = new Login();
												lg.setLocationRelativeTo(this);
												this.dispose();
										} else {
											JOptionPane.showMessageDialog(this, "닉네임은 4자리 이상 10자리 이하로 작성해주세요.");
										}
								} else {
									JOptionPane.showMessageDialog(this, "비밀번호는 8자리 이상 18자리 이하로 작성해주세요.");
								}
							} else {
								JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
							}
						} else {
							JOptionPane.showMessageDialog(this, "아이디는 4자리 이상 10자리 이하로 작성해주세요.");
						}
					}
			} else if(obj == exit_btn) {
				this.dispose();
				Login lg = new Login();
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		// 2022-10-26 전우진 아이디 중복 확인 프레임 연결
		if(obj == SignUp_textfield_id) {
			IdOverlap idOverlap = new IdOverlap("아이디 중복 확인", this);
			idOverlap.setLocationRelativeTo(this); // 프레임 정가운데 출력
			this.dispose();		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
