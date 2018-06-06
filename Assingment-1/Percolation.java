import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
    
	private int[][] percolationarray;
	private WeightedQuickUnionUF wquF;
	private int N;
	
	public Percolation(int gridSize)                  //constructor for Percolation class
	{
		
			
			N=gridSize+1;
			
			
		if(N<=1)
			throw new IllegalArgumentException();
		
		percolationarray=new int[N][N];
		
		for(int i=0;i<N;i++) 						//Intialize the all cells as blocked
		{
			for(int j=0;j<N;j++)
			{
				percolationarray[i][j]=1;
			}
		}
		
		/*for(int k=0;k<(N*N);k++)
		{
			
			wquF[k]=k;
		}*/
		
		wquF= new WeightedQuickUnionUF((N*N)+2); 
		
	}

	public void open(int row,int col)         //Opens a cell
	{
		
		
			error(row,col);
			
		if(percolationarray[row][col]!=0)
		{
			percolationarray[row][col]=0;
			
			int node1=xyto1(row,col);
			
			if((row!=1)&&(row!=(N-1))&&(col!=1)&&(col!=(N-1)))    //subsequent if creteria to check the corner cases of matrix
			{
				connectTop(row,col);
				connectBottom(row,col);
				connectLeft(row,col);
				connectRight(row,col);
			}
			
			if((row==1)&&(col!=1)&&(col!=(N-1)))
			{
				connectBottom(row,col);
				connectLeft(row,col);
				connectRight(row,col);
			}
			
			if((row==(N-1))&&(col!=1)&&(col!=(N-1)))
			{
				connectTop(row,col);
				connectLeft(row,col);
				connectRight(row,col);
			}
			
			if((row!=1)&&(row!=(N-1))&&(col==1))
			{
				connectTop(row,col);
				connectBottom(row,col);
				connectRight(row,col);
			}
			
			if((row!=1)&&(row!=(N-1))&&(col==(N-1)))
			{
				connectTop(row,col);
				connectBottom(row,col);
				connectLeft(row,col);
			}
			
			if((row==1)&&(col==1))
			{
				connectBottom(row,col);
				connectRight(row,col);
			}
			
			if((row==(N-1))&&(col==(N-1)))
			{
				connectTop(row,col);
				connectLeft(row,col);
			}
			
			if((row==1)&&(col==(N-1)))
			{
				connectBottom(row,col);
				connectLeft(row,col);
			}
			
			if((row==(N-1))&&(col==1))
			{
				connectTop(row,col);
				connectRight(row,col);
			}
			
			
			
			
			if(row==1)						//connects top row cell to top root node if the top cell is opened
			{
				wquF.union(node1,0);
					
				//System.out.println("Connected to top root node");
			
			}
			else if(row==(N-1))
			{
				wquF.union(node1,(N-1));
				
				//System.out.println("Connects to bottom root node");   //connects bottom row cell to bottom root node if the cell is open
			}
		}

			//System.out.println("Site already open");
		
	}
	
	public int numberOfOpenSites()
	{
		int count=0;
		int N=percolationarray.length;
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(percolationarray[i][j]==0)
				{
					count++;
				}
			}
		}
		
		return count;
		
	}
	
	public boolean isOpen(int row,int col)
	{
		
		error(row,col);
		
		
		if(percolationarray[row][col]==0)
			return true;
		
		else
			return false;
		
		
	}
	
	public boolean isFull(int row,int col)
	{
		error(row,col);
		
		if(wquF.connected(xyto1(row,col),0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		
	public boolean percolates()
	{
		/*for(int i=0;i<N;i++)
		{
			
			if(isFull(N-1,i))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}*/
		
		if(wquF.connected(0,N-1))
		{
			//System.out.println("The system percolates");
			
			return true;
			
		}	
		
		else
		{
			//System.out.println("The system does not percolates");
			
			return false;
			

		}
		
	}

	private void error(int row,int col)
	{
		if(row<=0||col<=0||row>=percolationarray.length||col>=percolationarray[0].length)
			throw new IllegalArgumentException();
	
	}
	private int xyto1(int x,int y)
	{
		
		int index= (x*N) + y + 1;
		
		return index;
		
	}
	
	private void connectTop(int row,int col)      //connects Adjacent-top Cell if open
	{
		
		if(exists(row,(col + 1)))
		{
		int node1=xyto1(row,col);
		
		if(isOpen((row-1),col))                 
			{
				int node2=xyto1(row-1,col);
				
				wquF.union(node1,node2);
				
				//System.out.println("Adjacent-top connected");
			
			}
		}
	}
	
	
	private void connectBottom(int row,int col)       //connects Adjacent-bottom cell if open
	{
		if(exists(row + 1),col)
		{
		int node1=xyto1(row,col);
		
	     if(isOpen((row+1),col))                    
		 	 {
				int node2=xyto1(row+1,(col));
				
				wquF.union(node1,node2);
				
				//System.out.println("Adjacent-bottom connected");
			
			 }
		}
	}
	
	private void connectLeft(int row,int col)      //connects Adjacent-Left Cell if open
	{
		if(exists(row,(col - 1)))
		{
		
		int node1=xyto1(row,col);
		
		if(isOpen(row,(col-1)))    
			{
				int node2=xyto1(row,(col-1));
				
				wquF.union(node1,node2);
				
				//System.out.println("Adjacent-Left connected");
			
			}
		}
	}
	
	
	private void connectRight(int row, int col)        //connects Adjacent-Right Cell if open
	{
		if(exists(row,(col + 1)))
		{
		int node1=xyto1(row,col);
		
		if(isOpen(row,(col+1)))           
			{
				int node2=xyto1(row,(col+1));
				
				wquF.union(node1,node2);
			
				//System.out.println("Adjacent-Right connected");
			}
		}
	}
	
	
	private boolean exists(int row,int col)
	{
			if(row > 0 && col > 0 && row < percolationarray.length && col < percolationarray[0].length)
			{
				return true;
			}
			else
				false;
	}
}

