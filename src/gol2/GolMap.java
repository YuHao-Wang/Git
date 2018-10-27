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
	//刷新时间
    private final static int DELAY_TIME = 1200;  
	
    //画正方形的长和宽
	private final static int width = 22;
	private final static int height = 22;
	
	//细胞的生和死
	private final static boolean CELL_ALIVE = true;
	private final static boolean CELL_DEAD = false;

	//下一个细胞板，暂定的细胞版
	private boolean[][] initialBoard = new boolean[22][22];
	private boolean[][] nextBoard = new boolean[22][22];
	private boolean[][] tempBoard = new boolean[22][22];
	
	//画细胞版
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

	//创建时调用
	private void startAnimation() {
		//初始化
		GolUtil.initialBoard(initialBoard);
		
		//赋值
		GolUtil.initialBoardTwo(initialBoard, tempBoard, nextBoard);
		
		//创建计时器
        timer = new Timer(DELAY_TIME,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//改变细胞的状态
				GolUtil.changeCellStatus(nextBoard, tempBoard);
				//重绘
				repaint();
			}
		});  
     // 开启计时器  
        timer.start();  
	}
	
	public MyPanel() {
		this.startAnimation();
	}
}
public class GolMap extends JFrame {
	private static final long serialVersionUID = 1L;
	
	GolMap(){
		this.setTitle("生命游戏");
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
