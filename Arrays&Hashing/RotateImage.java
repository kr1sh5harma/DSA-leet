// leet 48
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] matrix){
        int m = matrix.length;
        for(int i=0; i<m; i++){
            int x= 0;
            int y = m-1;
            while(x<y){
                int temp = matrix[i][x];
                matrix[i][x]= matrix[i][y];
                matrix[i][y] = temp;
                x++;
                y--;
            }
        }
    }
}
