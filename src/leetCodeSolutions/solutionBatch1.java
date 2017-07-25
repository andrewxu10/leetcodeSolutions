package leetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class solutionBatch1 {
	public static void main (String[] args) {
		//System.out.println(reverse(-321));	
		//s4N("123");
		Integer[][] a = buildGrid2();
		
		//System.out.println(isValid(a, 8,8));
		
		sudokuSolver(a, 0, 0);
		
		//printGrid(a);
	}
	
	public static boolean sudoku(Integer[][] grid) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(grid[i][j] == null) {
					for (int z = 1; z <= 9; z++) {
						grid[i][j] = z;
						if (isValid(grid, i, j) && sudoku(grid)) {
							return true;
						}
						grid[i][j] = null;
					}
					return false;
				}	
			}
		}
		printGrid(grid);
		return true;
	}
	
	public static boolean isValid(Integer[][] board, int i, int j){
	    HashSet<Integer> set = new HashSet<Integer>();
	 
	    for(int k=0; k<9; k++){
	        if(set.contains(board[i][k]))
	            return false;
	 
	        if(board[i][k]!=null){
	            set.add(board[i][k]);
	        }
	    }
	 
	    set.clear();
	 
	    for(int k=0; k<9; k++){
	        if(set.contains(board[k][j]))
	            return false;
	 
	        if(board[k][j]!=null ){
	            set.add(board[k][j]);
	        }
	    }
	 
	    set.clear();
	 
	    for(int m=0; m<3; m++){
	        for(int n=0; n<3; n++){
	            int x=i/3*3+m;
	            int y=j/3*3+n;
	            if(set.contains(board[x][y]))
	                return false;
	 
	            if(board[x][y]!=null){
	                set.add(board[x][y]);
	            }    
	        }
	    }
	 
	    return true;
	}
	
	public static boolean sudokuSolver(Integer[][] grid, int i, int j) {
		
		if(i > 8 || j > 8) { //base case
			System.out.println("i: " + i);
			System.out.println("j: " + j);
			printGrid(grid);
			return true;
		} else {
			
			if(grid[i][j] != null) {
				
				if(j==8 && isValid(grid,i,j) && sudokuSolver(grid,i++, 0)) {
					return true;
				}
				
				if(isValid(grid, i, j) && sudokuSolver(grid,i,j++)) {
					return true;
				}
				
			} else if(grid[i][j] == null) {//check if already has a value
				for(int z = 1; z <= 9; z++) {//try 1-9
					grid[i][j] = z;
					
					if(j==8 && isValid(grid,i,j) && sudokuSolver(grid,i++, 0)) {
						return true;
					}
					
					if(isValid(grid, i, j) && sudokuSolver(grid,i,j++)) {
						return true;
					}
				}
				return false;
			}

		}
		return false;
	}
	
	public static boolean placeable(Integer[][] grid, int i, int j, int value) {
		if(i >= grid.length || j >= grid.length) {
			return false;
		}
		for(int a = 0; a < 9; a++) { //make sure its not a duplicate value vert/horiz-ally
			if(grid[i][a] != null && grid[i][a] == value) {
				if(a!=j) {
					return false;
				}
			}
			if(grid[a][j] != null && grid[a][j] == value) {
				if(a!=i) {
					return false;
				}
			}
		}
		int i3 = (3*(i / 3)) + 3;
		int j3 = (3*(j / 3)) + 3;
		for(int q = i3 - 3; q < i3; q++) { //check local mini-grid
			for(int z = j3 - 3; z < j3; z++) {
				if(grid[i][j] != null && grid[i][j] == value) {
					return false;
				}
			}
		}
		
		return true; //if no false yet, then true
	}
	private static void printGrid(Integer[][] grid) {
		for(Integer[] row : grid) {
            printRow(row);
        }
//		for (int i = 0; i < grid.length; i++) { //printing rows
//			for (int j = 0; j < grid[0].length; j++) { //printing each value in a row
//				
//			}
//		}
	}
	public static void printRow(Integer[] row) {
        for (Integer i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
	
	public static Integer[][] buildGrid() { //grid[row#][column#]
											//grid[i][j]
		Integer[] row1 = {null, null, 3, 	null, 4, 2, 		null, 9, null};
		Integer[] row2 = {null, 9, null, 	null, 6, null, 		5, null, null};
		Integer[] row3 = {5, null, null, 	null, null, null, 		null, 1, null};
		
		Integer[] row4 = {null, null, 1, 	7, null, null, 		2, 8, 5};
		Integer[] row5 = {null, null, 8, 	null, null, null, 		1, null, null};
		Integer[] row6 = {3, 2, 9, 			null, null, 8, 		7, null, null};
		
		Integer[] row7 = {null, 3, null, 	null, null, null, 		null, null, 1};
		Integer[] row8 = {null, null, 5, 	null, 9, null, 		null, 2, null};
		Integer[] row9 = {null, 8, null, 	2, 1, null, 		6, null, null};
		
		Integer[][] grid = {row1, row2, row3, row4, row5, row6, row7, row8, row9};
		return grid; //build sudoku grid
	}
	
	public static Integer[][] buildGrid1() { //grid[row#][column#]
		//grid[i][j]
		Integer[] row1 = {1, 5, 2, 	4, 8, 9, 	3, 7, 6};
		Integer[] row2 = {7, 3, 9, 	2, 5, 6, 	8, 4, 1};
		Integer[] row3 = {4, 6, 8, 	3, 7, 1, 	2, 9, 5};
		
		Integer[] row4 = {3, 8, 7, 	1, 2, 4, 	6, 5, 9};
		Integer[] row5 = {5, 9, 1, 	7, 6, 3, 	4, 2, 8};
		Integer[] row6 = {2, 4, 6, 	8, 9, 5, 	7, 1, 3};

		Integer[] row7 = {9, 1, 4, 	6, 3, 7, 	5, 8, 2};
		Integer[] row8 = {6, 2, 5, 	9, 4, 8, 	1, 3, 7};
		Integer[] row9 = {8, 7, 3, 	5, 1, 2, 	9, 6, 4};

		Integer[][] grid = {row1, row2, row3, row4, row5, row6, row7, row8, row9};
		return grid; //build sudoku grid
	}
	
	public static Integer[][] buildGrid2() { //grid[row#][column#]
		//grid[i][j]
		Integer[] row1 = {null, null, 2, 	4, null, 9, 	3, 7, 6};
		Integer[] row2 = {7, null, 9, 	2, 5, 6, 	8, 4, 1};
		Integer[] row3 = {4, 6, 8, 	3, null, 1, 	2, 9, 5};
		
		Integer[] row4 = {3, 8, 7, 	1, 2, 4, 	null, 5, null};
		Integer[] row5 = {5, null, null, 	7, 6, 3, 	4, 2, 8};
		Integer[] row6 = {2, 4, 6, 	8, null, 5, 	7, 1, 3};

		Integer[] row7 = {9, 1, 4, 	6, 3, 7, 	5, 8, 2}; //if i change the 1 to null it breaks
		Integer[] row8 = {6, null, 5, 	9, 4, 8, 	1, 3, 7};
		Integer[] row9 = {8, 7, 3, 	5, 1, 2, 	9, 6, null};

		Integer[][] grid = {row1, row2, row3, row4, row5, row6, row7, row8, row9};
		return grid; //build sudoku grid
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static int reverse(int x) { //reverse integer. handle overflow and maintain negatives.
		    int result = 0;
		    while (x != 0)
		    {
		        int tail = x % 10;
		        int newResult = result * 10 + tail;
		        //if (newResult - (result * 10) != result%10)
		        if ((newResult - tail) / 10 != result)
		        { return 0; }
		        result = newResult;
		        x = x / 10;
		    }
		    return result;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void s4N(String input) { //handler for below
		ArrayList<String> output = new ArrayList<String>();
		char[] charArray = input.toCharArray();
		char[] emptyCarry = new char[input.length()];
		stringsForNumbers(charArray, emptyCarry, 0, output);
		for(int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
	}
	public static void stringsForNumbers(char[] input, char[] carry, int current, ArrayList<String> output) { //gets all possible strings (phone number combos) for an input of digits
		if(current > input.length - 1) {
			output.add(new String(carry));
			return;
		}
		char[] chars = getCharForNum(input[current]);
		for(int i = 0; i < chars.length; i++) {
			carry[current] = chars[i];
			stringsForNumbers(input, carry, current+1, output);
		}
	}
	private static char[] getCharForNum(char c) { //helper function
		if(c == '1') {
			char[] r = {'a', 'b', 'c'};
			return r;
		}
		if(c == '2') {
			char[] r = {'d', 'e', 'f'};
			return r;
		}
		if(c == '3') {
			char[] r = {'g', 'h', 'i'};
			return r;
		}
		if(c == '4') {
			char[] r = {'j', 'k', 'l'};
			return r;
		}
		if(c == '5') {
			char[] r = {'m', 'n', 'o'};
			return r;
		}
		if(c == '6') {
			char[] r = {'p', 'q', 'r'};
			return r;
		}
		if(c == '7') {
			char[] r = {'s', 't', 'u'};
			return r;
		}
		if(c == '8') {
			char[] r = {'v', 'w', 'x'};
			return r;
		}
		if(c == '9') {
			char[] r = {'y', 'z'};
			return r;
		}
		return null;
	}
}
