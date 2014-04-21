import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
*MASTER CHANGE!!
*/

public class Backpack 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner fin;
		if(args.length > 0)
		{
			fin = new Scanner(new File(args[0]));
		}
		else
			fin = new Scanner(new File("backpack.in"));
		
		
		int cases = fin.nextInt();
		
		for(int i= 0; i< cases; i++)
		{
			int max = fin.nextInt() +1;
			int numItems = fin.nextInt() +1;
			int[] values = new int[numItems];
			int [] weights = new int[numItems];
			for(int j=1; j< numItems; j++)
			{
				values[j] = fin.nextInt();
				weights[j] = fin.nextInt();
			}
			int [][] dblAra = new int[numItems][max];
			run(values,weights, dblAra, numItems, max);
		}
		
		
		fin.close();
	}//end main

	public static void run(int [] values, int [] weights, int [][] dblAra, int numItems, int max)
	{
		for(int i=0; i<max; i++)
		{
			dblAra[0][i] = 0;
		}

		for(int j=1; j < numItems; j++)
		{
			dblAra[j][0] = 0;
		}
		
		for(int k=1; k < numItems; k++)
		{
			for(int l=0; l < max; l++)
			{
				if(values[k] <= l) 
						if(weights[k] + dblAra[k-1][l-values[k]] > dblAra[k-1][l])
							dblAra[k][l] = weights[k] + dblAra[k-1][l- values[k]];
						else
							dblAra[k][l] = dblAra[k-1][l];
				else 
					dblAra[k][l] = dblAra[k-1][l]; 
				  
			}//end inner for
		}//end outer for
		System.out.println(dblAra[numItems-1][max-1]);
		/*
		for(int i=0; i < numItems; i++)
		{
			for(int k=0; k< max; k++)
			{
				System.out.print(dblAra[i][k]);
			}
			System.out.println();
		}
		*/
		
	}
	
}//end class
