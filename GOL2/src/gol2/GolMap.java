package gol2;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
class MyPanel extends JPanel{
	private static final long serialVersionUID = 5640668174921441140L;
	
	Timer timer;
	//ˢ��ʱ��
    private final static int DELAY_TIME = 1200;  
	
    //�������εĳ��Ϳ�
	private final static int width = 22;
	private final static int height = 22;
	
	//ϸ����������
	private final static boolean CELL_ALIVE = true;
	private final static boolean CELL_DEAD = false;

	//��һ��ϸ���壬�ݶ���ϸ����
	private boolean[][] initialBoard = new boolean[22][22];
	private boolean[][] nextBoard = new boolean[22][22];
	private boolean[][] tempBoard = new boolean[22][22];
	
	//��ϸ����
	public void paint(Graphics g) {
		super.paint(g);
		for(int i = 0 ;	i < 22 ; i++) {
			for(int j = 0; j < 22; j++){				
				if(nextBoard[i][j] == CELL_ALIVE) {
					g.fillRect(j * width, i * height , width, height);
				} else if(nextBoard[i][j] == CELL_DEAD) {
					g.drawRect(j * width, i * height , width, height);
				}
			}
		}
	}

	//����ʱ����
	private void startAnimation() {
		//��ʼ��
		GolUtil.initialBoard(initialBoard);
		
		//��ֵ
		GolUtil.initialBoardTwo(initialBoard, tempBoard, nextBoard);
		
		//������ʱ��
        timer = new Timer(DELAY_TIME,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ı�ϸ����״̬
				GolUtil.changeCellStatus(nextBoard, tempBoard);
				//�ػ�
				repaint();
			}
		});  
     // ������ʱ��  
        timer.start();  
	}
	
	public MyPanel() {
		this.startAnimation();
	}
}
public class GolMap extends JFrame {
	private static final long serialVersionUID = 1L;
	
	GolMap(){
		this.setTitle("������Ϸ");
		this.setSize(490,510);
		this.add(new MyPanel());
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GolMap();
	}
}
