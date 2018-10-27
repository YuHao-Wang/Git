package gol2;

import java.util.Random;

public class GolUtil {
	//��ʼ��ϸ�����
	public static void initialBoard(boolean initialBoard[][]) {
		Random random = new Random();
		boolean rand = false;//�洢�����
		for(int i = 0 ;i < initialBoard.length;i++) {
			for(int j = 0;j<initialBoard[0].length;j++) {
				rand = random.nextBoolean();
				initialBoard[i][j] = rand;
			}
		}
	}
	
	//��ֵ
	public static void initialBoardTwo(boolean initialBoard[][],boolean tempBoard[][],boolean nextBoard[][]) {
		for(int i = 0 ;i < initialBoard.length;i++) {
			for(int j = 0;j < initialBoard[0].length;j++) {
				nextBoard[i][j] = initialBoard[i][j];
				tempBoard[i][j] = initialBoard[i][j];
			}
		}
	}
	
	//�ı�ϸ��״̬
	public static void changeCellStatus(boolean nextBoard[][],boolean tempBoard[][]) {
		for(int i = 0 ;i < nextBoard.length;i++) {
			for(int j = 0;j < nextBoard[0].length;j++) {
			    switch (neighborsCount(i, j, tempBoard)) {  
                case 0:  
                case 1:  
                case 4:  
                case 5:  
                case 6:  
                case 7:  
                case 8:  
                    nextBoard[i][j] = false;  
                    break;  
                case 2:  
                    nextBoard[i][j] = tempBoard[i][j];  
                    break;  
                case 3:  
                    nextBoard[i][j] = true;  
                    break;  
                } 
			}
		}
		 copyCellBoard(tempBoard,nextBoard);  
	}
	
	
	public static void copyCellBoard(boolean tempBoard[][],boolean nextBoard[][] ) {
		for (int row = 0; row < nextBoard.length; row++) {  
            for (int col = 0; col < nextBoard[row].length; col++) {  
                tempBoard[row][col] = nextBoard[row][col];  
            }  
        } 
	}
	
	//����ÿһ��ϸ����Χ�Ļ�ϸ���ĸ���
	public static int neighborsCount(int row, int col, boolean tempBoard[][]) {
		int count = 0;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r < 0 || r >= tempBoard.length || c < 0 || c >= tempBoard[0].length) {
					continue;
				}
				if (tempBoard[r][c] == true) {
					count++;
				}
			}
		}
		  if (tempBoard[row][col] == true) {  
	            count--;  
	        }  
		return count;
	}
}
