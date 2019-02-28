package com.svit.java.Algorithm;

import java.util.ArrayList;
import java.util.List;
//	1 1 1 1 1 1 1   top-left (r1, c1)	top row (r1, c) c = c1...c2
//	1 2 2 2 2 2 1	bottom-right (r2, c2)	right col (r, c2) r = r1+1...r2
//	1 2 3 3 3 2 1				bottom row (r2, c) c = c2-1...c1+1
//	1 2 2 2 2 2 1				left col (r, c1) r = r2...r1+1
//	1 1 1 1 1 1 1
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> res = new ArrayList<Integer>();
		if(matrix.length == 0) return res;
		int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) res.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) res.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) res.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) res.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
	}
}
