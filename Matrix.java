import java.util.*;
public class Matrix{
    public static void printmatrix(int matrix[][]){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean search(int matrix[][],int key){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==key){
                    System.out.println("Key found at cell: (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Key not found !");
        return false;
    }

    public static void printSpiral(int matrix[][]){
        int startrow = 0;
        int endrow = matrix.length-1;
        int startcol = 0;
        int endcol = matrix[0].length-1;
        while(startrow<=endrow && startcol<=endcol){
            // top
            for(int j=startcol; j<=endcol; j++){
                System.out.print(matrix[startrow][j] + " ");
            }
            //right
            for(int i=startrow+1; i<=endrow; i++){
                System.out.print(matrix[i][endcol] + " ");
            }
            //bottom
            for(int j=endcol-1; j>=startcol; j--){
                if(startrow==endrow){
                    break;
                }
                System.out.print(matrix[endrow][j] + " ");
            }
            //left
            for(int i=endrow-1; i>startrow+1; i--){
                if(startcol==endcol){
                    break;
                }
                System.out.print(matrix[i][startcol] + " ");
            }
            
            startcol++;
            endcol--;
            startrow++;
            endrow--;
        }
        System.out.println();
    }

    public static int diagonalSum(int matrix[][]){
        int sum = 0;
        for(int i=0; i<matrix.length; i++){
            sum+= matrix[i][i];
            if(i!=matrix.length-1-i){
                sum+=matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }

    public static boolean staircaseSearch1(int matrix[][], int key){
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==key){
                System.out.println("Key found at cell: (" + row + "," + col + ")");
                return true;
            }
            else if(key< matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Key not found !!!");
        return false;
    }

    public static boolean staircaseSearch2(int matrix[][], int key){
        int row = matrix.length-1;
        int col=0;
        while(row>=0 && col<matrix[0].length){
            if(matrix[row][col]==key){
                System.out.println("Found key at cell: (" + row + "," + col + ")");
                return true;
            }
            else if(matrix[row][col]>key){
                row--;
            }
            else{
                col++;
            }
        }
        System.out.println("Key not found !");
        return false;
    }

    public static int count(int matrix[][], int key){
        int count = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==key){
                    count+=1;
                }
            }
        }
        return count;
    }

    public static int SumRow(int matrix[][], int rownum){
        int sum = 0;
        for(int i=0; i<matrix[0].length; i++){
            sum+= matrix[rownum][i];
        }
        return sum;
    }

    public static void transpose(int matrix[][]){
        int row = matrix.length-1;
        int column = matrix[0].length-1;
        int transpose[][] = new int[column][row];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
    }

    public static void main(String args[]){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = Sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = Sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0; i<n; i++){
            System.out.println("Enter for row " + i);
            for(int j=0; j<m; j++){
                System.out.print("Enter (" + i + "," + j + "): ");
                matrix[i][j] = Sc.nextInt();
            }
        }
        System.out.println();
        System.out.println("1. print the matrix");
        System.out.println("2. Search");
        System.out.println("3. Print Spiral");
        System.out.println("4. Diagonal Sum");
        System.out.println("5. Staircase Search ");
        System.out.println("6. Count the number of times an element appears");
        System.out.println("7. Sum of elements of a given row");
        System.out.println("8. Transpose of matrix ");
        System.out.println();
        System.out.print("Enter your choice: ");
        int a = Sc.nextInt();
        if(a==1){
            printmatrix(matrix);
        }
        else if(a==2){
            System.out.print("Enter number to search");
            int num = Sc.nextInt();
            search(matrix, num);
        }
        else if(a==3){
            printSpiral(matrix);
        }
        else if(a==4){
            System.out.print("The sum is:" + diagonalSum(matrix));
        }
        else if(a==5){
            System.out.println("choose starting point");
            System.out.println("1. Top right");
            System.out.println("2. Bottom left");
            int ch = Sc.nextInt();
            System.out.print("Enter number to search: ");
            int num = Sc.nextInt();
            if(ch==1){
                staircaseSearch1(matrix,num);
            }
            else if(ch==2){
                staircaseSearch2(matrix,num);
            }
            else{
                System.out.println("Invalid choice !");
            }
        }
        else if(a==6){
            System.out.print("Enter number whose frequency you want to find: ");
            int num = Sc.nextInt();
            System.out.println("The number of time the number comes is: " + count(matrix,num));
        }
        else if(a==7){
            System.out.print("Enter the row number you want to sum: ");
            int rownum = Sc.nextInt();
            System.out.println("Sum of the elements in the given row is: " + SumRow(matrix, rownum));
        }
        else if(a==8){
            transpose(matrix);
            printmatrix(matrix);
        }
        else{
            System.out.println("Invalid Entry !");
        }
    }
}