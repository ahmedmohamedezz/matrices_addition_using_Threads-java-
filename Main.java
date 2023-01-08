import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter The Size Of The Matrices ");
        Scanner obj = new Scanner(System.in) ;
        int rows = obj.nextInt() ;
        int cols = obj.nextInt() ;
        int[][] mat1 = new int[rows][cols] ;
        int[][] mat2 = new int[rows][cols] ;
        int[][] res = new int[rows][cols] ;
        // take the first matrix
        System.out.println("Enter The Elements Of The First Matrix");
        for(int i=0 ; i<rows ; ++i){
            for(int j=0 ; j<cols ; ++j){
                mat1[i][j] = obj.nextInt() ;

                // initialize res with zeros
                res[i][j] = 0 ;
            }
        }
        // take the second matrix
        System.out.println("Enter The Elements Of The Second Matrix");
        for(int i=0 ; i<rows ; ++i){
            for(int j=0 ; j<cols ; ++j)
                mat2[i][j] = obj.nextInt() ;
        }
        // since we will create a thread for each row summation , we can use array of Threads of size : rows
        Thread[] threads = new Thread[rows] ;
        for(int i=0 ; i<rows ; ++i){
            Thread thread = new RowAdder(mat1,mat2,res,i,cols) ;
            threads[i] = thread ;
        }
        // start all the threads
        for (int i=0 ; i<rows ; ++i){
            threads[i].start();
            threads[i].join();
        }

        // the final answer
        System.out.println("The result : ");
        for (int i=0 ; i<rows ; ++i){
            for (int j=0 ; j<cols ; ++j)
                System.out.print(res[i][j]+" ");
            System.out.println();
        }

    }
}