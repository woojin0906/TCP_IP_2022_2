package user;
/* 
 디자인, 설계 : 전우진
 클래스 : 아이디 찾기
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.dbInfo;
import game.Login;

public class IdCheck extends JFrame implements MouseListener, ActionListener, KeyListener, WindowListener{
	
	private Font font, btnFont, IDFont;
	private JButton btnCancel, btnCheck, btnIdSearch;
	private JTextField tfName, tfEmail;
	private Color blue, skyBlue;

	public IdCheck(String title) {
		setTitle(title);
		setSize(342, 202);
		setLayout(new BorderLayout());
		setLocation(500, 500);
		setResizable(false); // 화면 크기 조절 불가능
		addWindowListener(this);
		
		blue = new Color(26, 67, 141);
		skyBlue= new Color(218, 227, 238);
		
		IDFont = new Font("넥슨 풋볼고딕 B", Font.PLAIN, 16);
		btnFont = new Font("Koverwatch", Font.PLAIN, 16);
		font = new Font("Koverwatch", Font.PLAIN, 14);
		
		setBack();
		
		setVisible(true);
	}
	
	private void setBack() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(null);
		panelCenter.setBackground(skyBlue);
		
		// 아이디 찾기 화면 취소 버튼 출력
		btnCancel = new JButton("취소");
		btnCancel.setFont(font);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnCancel.setBounds(0, 5, 40, 30);
		btnCancel.addActionListener(this);
        panelCenter.add(btnCancel);
        
        // 아이디 찾기 확인 버튼 출력
        btnCheck = new JButton("확인");
		btnCheck.setBounds(218, 55, 70, 70);
		btnCheck.setBackground(blue);
		btnCheck.setForeground(Color.WHITE);
		btnCheck.setFont(btnFont);
		btnCheck.addActionListener(this);
		panelCenter.add(btnCheck);
		
        // 아이디 찾기 텍스트 필드(이름) 출력
		tfName = new JTextField("닉네임");
		tfName.setFont(IDFont);
		tfName.setBounds(38, 55, 160, 30);
		tfName.setBorder(BorderFactory.createEmptyBorder());
		tfName.setFocusTraversalKeysEnabled(false);
		tfName.addActionListener(this);	
		tfName.addMouseListener(this);
		tfName.addKeyListener(this);
		panelCenter.add(tfName);
        
		// 아이디 찾기 텍스트 필드(전화번호) 출력
		tfEmail = new JTextField("이메일");
		tfEmail.setFont(IDFont);
		tfEmail.setBorder(BorderFactory.createEmptyBorder());
		tfEmail.setBounds(38, 98, 160, 28);
		tfEmail.addActionListener(this);	
		tfEmail.addMouseListener(this);
		panelCenter.add(tfEmail);
		
		// 아이디 찾기 -> 비밀번호 찾기 버튼 출력
		btnIdSearch = new JButton("비밀번호를 잃어버리셨나요?");
		btnIdSearch.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 12));
		btnIdSearch.setContentAreaFilled(false);
		btnIdSearch.setBorderPainted(false);
		Color gray = new Color(100, 100, 100);
		btnIdSearch.setForeground(gray);
		btnIdSearch.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnIdSearch.setBounds(180, 130, 140, 30);
		btnIdSearch.addActionListener(this);
		panelCenter.add(btnIdSearch);
        
        add(panelCenter, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 2022-10-26 전우진 기능 구현
		if(obj == btnCancel) {
			Login lg = new Login();
			lg.setLocationRelativeTo(this);
			this.dispose();
		} else if(obj == btnIdSearch) {
			PwCheck pwc = new PwCheck("비밀번호 재설정");
			pwc.setLocationRelativeTo(this);
			this.dispose();
		} else if(obj == btnCheck || obj == tfName || obj == tfEmail) {
			try {
				// 전우진 비밀번호 재설정 DB연결
				dbInfo temp = new dbInfo();
				temp.resetID(this, tfName.getText(), tfEmail.getText());
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		// 2022-10-26 전우진 텍스트필드 클릭 시 초기화
		if(obj == tfName) {
			tfName.setText("");
		} else if(obj == tfEmail) {
			tfEmail.setText("");
		}			
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 2022-10-26 전우진 이메일 필드 탭 연결 및 초기화
		if(e.getKeyCode() == KeyEvent.VK_TAB) {
			tfEmail.requestFocus();
			tfEmail.setText("");
		}				
	}

	@Override
	public void keyReleased(KeyEvent e) {
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
