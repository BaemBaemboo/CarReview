import java.awt.BorderLayout; /*프로젝트에서 사용하기 위한 컴포넌트들을 import*/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPage extends JFrame { //JFrame에서 상속받은 시작화면 //

	private JPanel contentPane; //컴포넌트들을 부착하기 위한 contentpane//

	public static void main(String[] args) { //기초 메소드 작성//
		StartPage frame = new StartPage();
		
	}

	public StartPage() { //시작화면에 관한 코드//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //화면을 종료하면 프로그램도 종료되도록 구현//
		setTitle("Automobile Company Review"); //타이틀//
		setBounds(600, 300, 450, 300); //크기//
		contentPane = new JPanel(); //contentpane 에 JPanel 부착//
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //보더간격 조절//
		setContentPane(contentPane); //contentpane 설정//
		contentPane.setLayout(null); //배치관리자 없는 컨테이너 구축//
		
		JButton btnStart = new JButton("Start"); //start 버튼//
		btnStart.addActionListener(new ActionListener() { //actionlistener 설정//
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //화면이 보이지 않게//
				new CarReview(); //다른 화면으로 전환//
			}
		});
		btnStart.setBounds(132, 39, 180, 50); //시작버튼 크기 조절//
		contentPane.add(btnStart); //시작버튼 부착//
		
		JButton btnWriteProfile = new JButton("Write Your Profile"); //Write Your Profile 버튼//
		btnWriteProfile.addActionListener(new ActionListener() { //actionlistener 설정// 
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //화면이 보이지 않도록//
				new EditProfile(); //다음 화면으로 전환//
				
			}
		});
		btnWriteProfile.setBounds(132, 101, 180, 50); //버튼 크기 설정//
		contentPane.add(btnWriteProfile); //contentpane에 버튼 부착//
		
		JButton btnClose = new JButton("Close"); //close 버튼//
		btnClose.addActionListener(new ActionListener() { //actionlistener 설정//
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //누르면 창이 종료
			}
		});
		btnClose.setBounds(130, 163, 182, 50); //버튼 크기 설정//
		contentPane.add(btnClose); //버튼 종료 추가//
		
		setVisible(true); /*화면이 보이도록 설정*/
	}
}
