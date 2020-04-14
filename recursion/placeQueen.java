package recursion;

public class placeQueen {
	public boolean placeQueens(int col) {
		if(col> BOARD_SIZE) {
			return true;
		} else{
			boolean queenPlaced = false;
			int row= 1; // square id in column
			while(!queenPlaced && (row<= BOARD_SIZE)) {
				if(isUnderAttack(row, col)) {
					++row; // consider next square
				} else{ // found valid square
					setQueen(row, col);
					queenPlaced = placeQueens(col+1);
					if(!queenPlaced) { // failed
						removeQueen(row, col);
						++row;
					}
				}	
			}
		} // end while
	return queenPlaced;
	}
}
