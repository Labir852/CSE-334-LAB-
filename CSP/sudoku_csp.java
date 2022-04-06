public class sudoku_csp
{



   static int[][] matrix = {{1,4,0,3},{0,0,4,0},{3,0,0,0},{0,0,3,2}};
   
   static void sudoku()
   {
       int flag = 0;
       for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(matrix[i][j] == 0)
                {
                    for(int m = 1;m<=4;m++)
                    {
                        if(i==2 && j==1 && m == 1)
                            continue;
                        if(checkConstraint(i,j,m) == true)
                        {
                            matrix[i][j] = m;
                            break;
                        }
                        else if(m == 4 && checkConstraint(i,j,m)== false )
                        {
                            flag=1;
                            break;
                        }
                        
                    }
                    if(flag == 1)
                        break;
                }
            }
            if(flag == 1)
                 break;
        }
   }
   
   static Boolean checkConstraint(int i,int j,int m)
   {
       int LR = i-i%2;
       int LC = j-j%2;
       for(int k=0;k<4;k++)
       {
           if(matrix[i][k] == m || matrix[k][j] == m)
           {
               return false;
           }
       }
       for(int k = LR;k<=LR+1;k++)
       {
            for(int n = LC;n<=LC+1;n++)
            {
                if(matrix[k][n] == m)
                {
                    return false;
                }
            }
           
       }
       return true;
   }
   
   static void print()
   {
       for(int i=0;i<4;i++)
       {
           for(int j=0;j<4;j++)
           {
               System.out.print(" "+matrix[i][j]+" ");
           }
           System.out.println();
       }
   }
    public static void main(String[] args)
    {
        //Scanner s = new Scanner(System.in);
         
     

       
       
       System.out.println("before solution: ");
        print();
       
        System.out.println();

        sudoku();
        System.out.println();
        System.out.println("After solution: ");
       
        print();
    }
}