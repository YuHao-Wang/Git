package gol2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolUtilTest {

	//用于测试的数据
    private boolean[][] initialBoard = new boolean[22][22];
	private boolean[][] nextBoard = new boolean[22][22];
	private boolean[][] tempBoard = new boolean[22][22];
	
	@Before
	public void setUp() throws Exception {
		//初始化
		for(int i = 0 ;i < initialBoard.length;i++) {
			for(int j = 0;j<initialBoard[0].length;j++) {
				initialBoard[i][j] = false;
			}
		}		
		//赋值
		GolUtil.initialBoardTwo(initialBoard, tempBoard, nextBoard);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test //边缘测试
	public void testChangeCellStatus() {
		GolUtil.changeCellStatus(nextBoard, tempBoard);
	   
		boolean[][] temp = new boolean[22][22];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = false;
			}
		}
		
		boolean flag = true;
		for(int i = 0;i<22;i++) {
			for(int j=0;j<22;j++) {
				if(nextBoard[i][j] !=temp[i][j]) {
					flag = false;
					break;
				}
			}
		}
		
		assertEquals(true, flag);
	}
	
	@Test //错误测试
	public void testChangeCellStatusTwo() {
		
		tempBoard[18][19] = true;
		tempBoard[18][18] = true;
		tempBoard[19][19] = true;
		tempBoard[19][18] = true;
		GolUtil.changeCellStatus(nextBoard, tempBoard);
	   
		boolean[][] temp = new boolean[22][22];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = false;
			}
		}
		
		boolean flag = true;
		for(int i = 0;i<22;i++) {
			for(int j=0;j<22;j++) {
				if(nextBoard[i][j] !=temp[i][j]) {
					flag = false;
					break;
				}
			}
		}
		
		assertEquals(false, flag);
	}
	
	@Test //一般测试
	public void testChangeCellStatusThree() {

		tempBoard[18][19] = true;
		tempBoard[18][18] = true;
		tempBoard[19][19] = true;
		tempBoard[19][18] = true;
		tempBoard[10][10] = true;
		tempBoard[10][11] = true;
		GolUtil.changeCellStatus(nextBoard, tempBoard);
	   
		boolean[][] temp = new boolean[22][22];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = false;
			}
		}
		temp[18][19] = true;
		temp[18][18] = true;
		temp[19][19] = true;
		temp[19][18] = true;
		
		boolean flag = true;
		for(int i = 0;i<22;i++) {
			for(int j=0;j<22;j++) {
				if(nextBoard[i][j] !=temp[i][j]) {
					flag = false;
					break;
				}
			}
		}
		
		assertEquals(true, flag);
	}


	@Test //一般测试
	public void testNeighborsCount() {
		tempBoard[0][2] = true;
		tempBoard[1][1] = true;
		tempBoard[2][0] = true;
		tempBoard[2][1] = true;
		int result=GolUtil.neighborsCount(1, 1, tempBoard);
		assertEquals(3,result);
	}

}
