/*프로젝트때 사용하는 컴포넌트들을 import*/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class EditProfile extends JFrame { //JFrame을 상속받은 새로운 class//

	private JPanel contentPane; //contentpane에 부착할 JPanel//
	private JTextField textField; /*textfield를 4개 구현*/
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	public EditProfile() {
		setTitle("Edit Profile"); //타이틀//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //화면이 꺼지면 프로그램도 종료//
		setBounds(600, 300, 450, 300); //프레임 사이즈 조절//
		contentPane = new JPanel(); //contentPane에 붙힐 새로운 JPanel//
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //contentPane 설정//
		setContentPane(contentPane); 
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back"); //뒤로가기 버튼을 JButton을 사용하여 구현//
		btnNewButton.addActionListener(new ActionListener() { /*이벤트리스너 사용*/
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //뒤로가기를 누르면 화면이 보이지 않고//
				new StartPage(); //시작화면으로 이동//
			}
		});
		btnNewButton.setBounds(327, 226, 105, 27); //버튼 사이즈 조절//
		contentPane.add(btnNewButton); //contentPane에 버튼 부착//
		 
		JButton btnOk = new JButton("OK"); //ok버튼을 아까와 똑같이 JButton을 사용//
		btnOk.addActionListener(new ActionListener() { /*이벤트리스너를 사용하여 버튼을 눌렀을때 작동하는 동작 구현*/
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //ok를 누르면 프로그램이 종료되도록 구현//
			}
		});
		btnOk.setBounds(220, 226, 105, 27); //ok버튼의 크기를 조절//
		contentPane.add(btnOk); //ok버튼을 contentPane에 부착//
		
		JLabel lblNewLabel = new JLabel("Name"); //JLabel을 사용해서 Name을 만듦//
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); //위치를 수평으로 조절//
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20)); //폰트 굵기 사이즈 조절//
		lblNewLabel.setBounds(29, 29, 136, 18); //글이 출력될 좌표 설정//
		contentPane.add(lblNewLabel); //contentPane에 부착//
		
		JLabel lblNewLabel_1 = new JLabel("Date Of Birth"); //생년월일//
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER); //위치 조절//
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20)); //폰트의 디테일 설정//
		lblNewLabel_1.setBounds(29, 70, 136, 18); //좌표 설정//
		contentPane.add(lblNewLabel_1); //글씨가보이도록 contentPane에 부착//
		
		JLabel lblNewLabel_2 = new JLabel("Nationality"); //국적 설정//
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER); //수평으로 위치를 조절//
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 20)); //폰트의 세부사항 설정//
		lblNewLabel_2.setBounds(29, 111, 136, 18); //좌표 설정//
		contentPane.add(lblNewLabel_2); //contentPane에 부착//
		
		JLabel lblNewLabel_3 = new JLabel("Sex"); //성별 확인//
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER); //수평으로 위치를 맞춤//
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 20)); //글씨 설정//
		lblNewLabel_3.setBounds(29, 153, 136, 18); //글씨 위치 설정//
		contentPane.add(lblNewLabel_3); //contentPane에 컴포넌트를 부착//
		
		/*textfield 구현
		 * textfield의 column수를 설정
		 * 텍스트 필드의 위치를 조절
		 * 컴포넌트들을 contentPane에 붙혀줌
		 */
		textField = new JTextField(); 
		textField.setBounds(179, 30, 223, 24);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 71, 223, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(179, 112, 223, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(179, 154, 223, 24);
		contentPane.add(textField_3);
		
		setVisible(true); //화면에 나오도록 출력//
	}
}
