/*프로그램을 구동하기 위한 컴포넌트들을 import*/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JTree;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarReview extends JFrame implements TreeSelectionListener{ //treeactionlistener를 요소로 가지고 있는 JFrame을 상속받은 클래스//

	private JPanel contentPane; //Jpanel 을 붙일 contentPane//
	private JTree tree; //Jtree 구축//
	private MyImgPane imgPane; //이미지 삽입할 imgpane 구축//
	
	public CarReview() { 
		setTitle("Automobile Company Review"); //타이틀//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창이 닫히면 프로그램도 종료//
		setBounds(600, 300, 500, 400); //프레임 사이즈//
		contentPane = new JPanel(); //contentpane에 부착할 새로운 JPanel//
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //간격 설정//
		contentPane.setLayout(new BorderLayout(0, 0)); //borderlayout 세팅//
		setContentPane(contentPane); //contentpane 설정//
		
		tree = new JTree(); //JTree 실행//
		tree.setShowsRootHandles(true); //밑의 루트로 진행하는것 보여주기//
		tree.setModel(new DefaultTreeModel( //JTree의 모습, 가장 기본적인 DefaultTreeModel 사용//
			new DefaultMutableTreeNode("Automobile Company Review") { //노드의 시작인 루트 노드의 이름//
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Domestic Cars"); //첫번째 자식노드//
						node_1.add(new DefaultMutableTreeNode("Hyundai")); /*자식노드의 항목인 국산차 모델*/
						node_1.add(new DefaultMutableTreeNode("Kia"));
						node_1.add(new DefaultMutableTreeNode("Renault Samsung"));
					add(node_1); //노드를 화면에 보이도록 추가//
					node_1 = new DefaultMutableTreeNode("Abroad Cars"); //두번째 자식노드//
						node_1.add(new DefaultMutableTreeNode("BMW")); /* 두번째 자식노드인 외제차*/
						node_1.add(new DefaultMutableTreeNode("Mercedes Benz"));
						node_1.add(new DefaultMutableTreeNode("Audi"));
					add(node_1); //노드를 화면에 보이도록 추가//
				}
			}
		));
		tree.addTreeSelectionListener((TreeSelectionListener) this); //treeseletionlistener 사용//
		contentPane.add(tree, BorderLayout.WEST); //Jtree는 BorderLayout의 왼편(서쪽)에 배치//
		
		JPanel panel = new JPanel(); //JPanel 추가//
		FlowLayout flowLayout = (FlowLayout) panel.getLayout(); //flowlayout 사용//
		flowLayout.setAlignment(FlowLayout.LEFT); //Flowlayout을 왼쪽 (BorderLayout으로는 서쪽에 배치//
		contentPane.add(panel, BorderLayout.NORTH); //그리고 Borderlayout 기준 북쪽에 부착//
		
		JButton btnback = new JButton("\uB4A4\uB85C \uAC00\uAE30"); //북쪽에 부착하는것은 뒤로가기//
		btnback.addActionListener(new ActionListener() { //버튼눌렀을때 이벤트 리스너 추가//
			public void actionPerformed(ActionEvent arg0) { //상호작용했을때//
				setVisible(false); //화면이 보이지 않게 설정//
				new StartPage(); //시작 화면으로 돌아감//
			}
		});
		panel.add(btnback); //버튼을 JPanel에 추가//
		
		JPanel mainPane = new JPanel(); //mainPane을 부착//
		contentPane.add(mainPane, BorderLayout.CENTER); //contentPane의 중앙에 부착//
		mainPane.setLayout(null); //Layout 값은 설정 안함//
		
		imgPane = new MyImgPane(); //사진을 보여주는 ImgPane사용//
		imgPane.setBounds(0, 0, 315, 206); //imgpane 크기 설정//
		mainPane.add(imgPane); //imgpane 화면에 보이도록 설정//
		
		JTextPane textPane = new JTextPane(); //글자를 입력할수 있는 textpane 사용//
		textPane.setBounds(0, 204, 315, 102); //textpane의 크기 설정//
		mainPane.add(textPane); //textpane 화면에 나오도록 부착//
		
		setVisible(true); //화면에 나오도록//
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) { //이벤트리스너 추가//
		DefaultMutableTreeNode node;  //DefaultMutableTreeNode 모델 사용//
		node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent(); //노드의 마지막까지 선택한 길을 보여줌//
		
		if(node == null) return; //만약 아무것도 안골랐으면 리턴//
		
		
		if(1 < node.getLevel()) //1보다 작으면//
		{
			String nodeName = (String) node.getUserObject();
			imgPane.setImg("images/"+nodeName + ".jpg");
			imgPane.repaint();
		}
		/*String nodeName = (String) node.getUserObject(); 캐스팅은 꼭해주어야 함
		System.out.println();
		System.out.println(nodeName);
		label.setText("선택된 노드 : " + nodeName);*/
	}
	
	
	class MyImgPane extends JPanel{ //JPanel에서 상속받은 imgPane//
		Graphics screenGraphics; //그래픽 보여주기//
		Image screenImage; //이미지 추가//
		Image introBackground; // 이미지를 넣기 위해 이렇게 3개의 필드를 생성 //
		public MyImgPane() {
			
			//생성자 메소드를 정의하는 과정에서 이렇게 이미지를 얻음//
			setLayout(new BorderLayout());

			setDefaultCloseOperation(EXIT_ON_CLOSE); //화면이 꺼지면 프로그램도 종료//
			setResizable(false); //사이즈 설정 불가//
			setLocationRelativeTo(null); //위치값을 따로 지정 안함//
			setVisible(true); //화면에 보이게 설정//

		}
		
		ImageIcon imageSetSize(ImageIcon icon, int i, int j) { //이미지를 임의값을 설정//
			Image ximg = icon.getImage(); //이미지의 x 좌표값//
			Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH); //속도보다는 이미지가 부드럽게 출력되는것을 우선시//
			ImageIcon xyimg = new ImageIcon(yimg); //얻은 좌표값을 통해서 이미지를 출력//
			
			return xyimg; //그 값을 리턴//
		}
		
		public void setImg(String src)
		{
			introBackground = imageSetSize(new ImageIcon(src), this.getWidth(), this.getHeight()).getImage();
		}

		public void paint(Graphics g) {
			screenImage = createImage(this.getWidth(), this.getHeight());
			screenGraphics = screenImage.getGraphics();
			draw(screenGraphics);
			g.drawImage(screenImage, 0, 0, null);

		}

		public void draw(Graphics g) {
			g.drawImage(introBackground, 0, 0, null);
			this.repaint();
		}
	}
}
