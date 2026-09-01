//Approch-1 (Using extra space of m*n)
//T.C : O(m*n*(m+n))
//S.C : O(m*n)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] temp = new int[m][n];

        //copy matrix to temp array
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = matrix[i][j];
            }
        }
        //modify temp array 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    for(int k=0; k<n; k++){
                        temp[i][k] = 0; //marking ith row as 0
                    }
                    for(int k=0; k<m; k++){
                        temp[k][j] = 0; //marking jth column as 0
                    }
                }
            }
        }
        // copy temp to matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }
}


//Approch-2 (Using m+n extra space)
//T.C : O(m*n)
//S.C : O(m+n)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //create two arrays which stores boolean values of 0's
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        Arrays.fill(row, false);
        Arrays.fill(col, false);

        //if any 0 is found update row and col arrays
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        //iterate again to mark the elements which occur in same row and col with true values
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i]==true || col[j]==true){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

//Approach-3 (In place constant space)
//T.C : O(m*n)
//S.C : O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;

        boolean firstRowImpacted = false;
        boolean firstColImpacted = false;

        //check if first row is impacted or not (corner case)
        for(int col = 0; col<n; col++){
            if(matrix[0][col]==0){
                firstRowImpacted = true;
                break;
            }
        }
        //check if first col is impacted or not (corner case)
        for(int row = 0; row<m; row++){
            if(matrix[row][0]==0){
                firstColImpacted = true;
                break;
            }
        }

        //set markers in the first row/col
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowImpacted){
            for(int j=0; j<n; j++){
                matrix[0][j] = 0;
            }
        }
        if(firstColImpacted){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
