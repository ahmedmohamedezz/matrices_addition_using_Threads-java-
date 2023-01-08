public class RowAdder extends Thread{
    private int[][] mat1 ;
    private int[][] mat2 ;
    private int[][] res ;
    private int rowIndex ;
    private int numberOfColumns ;
    public RowAdder(int[][] mat1,int[][] mat2,int[][] res,int rowIndex,int numberOfColumns){
        this.mat1 = mat1 ;
        this.mat2 = mat2 ;
        this.res = res ;
        this.rowIndex = rowIndex ;
        this.numberOfColumns = numberOfColumns ;
    }

    @Override
    public void run(){
        for(int i=0 ; i<numberOfColumns ; ++i)
            this.res[rowIndex][i] = this.mat1[rowIndex][i] + this.mat2[rowIndex][i] ;
    }
}
