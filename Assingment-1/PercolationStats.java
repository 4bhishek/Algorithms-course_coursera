import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.Math;
import java.lang.Integer;
//import java.util.*;


public class PercolationStats
{
	
	private double[] percolationThreshold;
	
	private double mean;
	private double stddev;
	private double confidenceLo;
	private double confidenceHi;
	
	//StdStats std;
	
	
	public PercolationStats(int N,int T)
	{
		if(N<=0||T<=0)
		{
			throw new IllegalArgumentException();
		}
				
		percolationThreshold=new double[T];
		//std=new StdStats();
		
	}
	
	public double mean()
	{
    	
		mean=StdStats.mean(percolationThreshold) ;
		
		return mean;
	}
	
	public double stddev()
	{
		
		stddev=StdStats.stddev(percolationThreshold);
		
		return stddev;
		
	}
	
	public double confidenceLo()
	{
				
		confidenceLo=mean - ((1.96*stddev)/Math.sqrt(percolationThreshold.length));
		
		return confidenceLo;
	}
	
	public double confidenceHi()
	{
				
		confidenceHi=mean + ((1.96*stddev)/Math.sqrt(percolationThreshold.length));
		
		return confidenceHi;
	}
	
	
	
	
	public static void main(String[] args)
	{
	
	 int n=Integer.parseInt(args[0]);
	 
	 int T=Integer.parseInt(args[1]);
	 
	 PercolationStats Percstats=new PercolationStats(n,T);
	 
	 //StdRandom rand=new StdRandom();
	 
	 for(int i=0;i<T;i++)
	 {
		 Percolation Perc=new Percolation(n);
		 
		 while(!Perc.percolates())
		 {
			 Perc.open(StdRandom.uniform(1,(n+1)),StdRandom.uniform(1,(n+1)));
		 }
		 
		 Percstats.percolationThreshold[i]=(Perc.numberOfOpenSites()/n);
	 }
		
		double mean=Percstats.mean();
		
		double stddev=Percstats.stddev();
		
		double confiHi=Percstats.confidenceHi();
		
		double confiLo=Percstats.confidenceLo();
		
		System.out.println("mean= "+ mean);
		System.out.println("Stddev= "+ stddev);
		System.out.println("95% confidence interval= ["+confiHi+", "+ confiLo+"]");
	}
	
	
}