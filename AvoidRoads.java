public class AvoidRoads{

     public static void main(String []args){
        String[] bad = new String[2];
        bad[0] = "0 0 0 1";
        bad[1] = "6 6 5 6";
        System.out.println(AvoidRoads.numways(7,7,bad));
        
     }
     
     
     public static int numways(int w, int h, String[] bad){
         
         int[][] blocks = new int[w][h];
         
         for(String b : bad)
         {
             
             int w1 = Character.getNumericValue(b.charAt(0));
             int x = Character.getNumericValue(b.charAt(2));
             int y = Character.getNumericValue(b.charAt(4));
             int z = Character.getNumericValue(b.charAt(6));
             
             blocks[w1][x] = 1;
             blocks[y][z] = 1;
         }
         
         int[][] cnt = new int[w][h];
         
         cnt[0][0] = 0;
         
         for(int i=1; i < w; i++)
         {
        	 if (i == 1 && (!(blocks[0][i] == 1 && blocks[0][i-1] == 1)))
        		 cnt[0][i] = 1;
        	 else if (i > 1 && !(blocks[0][i-1] == 1 && blocks[0][i-2] == 1))
                cnt[0][i] = 1;
         }
         
         for(int j=1; j < h; j++)
         {
        	 
        	 if (j == 1 && (!(blocks[j][0] == 1 && blocks[j-1][0] == 1)))
        		 cnt[j][0] = 1;
        	 else if (j > 1 && (!(blocks[j-1][0] == 1 && blocks[j-2][0] == 1)))
                cnt[j][0] = 1;
        	 
         }
         
         for(int i=1; i < w; i++)
         {
             for(int j=1; j < h; j++)
             {
                if (!(blocks[i-1][j] == 1 && blocks[i-1][j-1] == 1))
                    cnt[i][j] += cnt[i-1][j] ;
                if (!(blocks[i][j-1] == 1 && blocks[i-1][j-1] == 1))
                    cnt[i][j] += cnt[i][j-1];
             }
         }
         
         return cnt[w-1][h-1];
     }
}
