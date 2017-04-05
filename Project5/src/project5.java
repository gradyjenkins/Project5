/**
 * Title: Project 5
 *
 * Description: Program calculates the mean, standard deviation and variance, z-score, middle riemann sum, and normal distribution  
 *
 * @ Author: Tejal Deshpande, Grady Jenkins, Joe Gudzak
 * 
 * @ Version: 1.0
 *
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Scanner;

public class project5 {

	// Running the main method for DoublyLinkedList

	// This method contains the main method while also calculation the correlation
 	 
	public static void main(String args[]) throws IOException {

		Scanner in = new Scanner(System.in);
		
		System.out.println("Specify an input file (enter 'Input')");
		
		String filename = in.nextLine();
		
		Scanner sc = new Scanner(new File(filename));

//		sc.nextLine();
//		sc.nextLine();

		//create linked lists for proxy size and development hours
		DoublyLinkedList<Float> proxySize = new DoublyLinkedList<>();
		DoublyLinkedList<Float> devHours = new DoublyLinkedList<>();

		while (sc.hasNext()) {
			sc.next();	//reading values U1, U2.....
			proxySize.addFirst(Float.valueOf(sc.next()));	//reads the second column values
			devHours.addFirst(Float.valueOf(sc.next()));	// reads the third column values
		}

		//initialize variables for calculating correlation
		double x_square = 0;
		double y_square = 0;
		
		double xmulty = 0;
		
		int count = 0;
		
		//instantiate mean variables
		double sum_x = 0;
		double sum_y = 0;
		
		double total_x = 0;
		double total_y = 0;
		double mean_x = 0;
		double mean_y = 0;
		
		//instantiate stdev variables
		double total2 = 0;
		double sum2 = 0;
        double stdev = 625.63;
        
		//instantiate z-score variables
        double z_num = 0;
        double z_den = 0;	
        double z = 0;
        
		//instantiate riemann sum variables
        int delta_x = 1;
        double rectangle = 0;
        double riemann_sum = 0;

//return first element of each linked list
		DoublyLinkedList.Node<Float> current_proxy = proxySize.getFirst();
		DoublyLinkedList.Node<Float> current_dev = devHours.getFirst();

//calculate correlation r and r squared
		
		while (current_proxy != null && current_dev != null) { //loop until list is empty
			float x = current_proxy.getData();
			float y = current_dev.getData();

			x_square = x_square + (x * x);
			y_square = y_square + (y * y);
			
			xmulty = xmulty + (x * y);
			
			sum_x = sum_x + x;
			sum_y = sum_y + y;
			
			count = count + 1;
			
			total_x += x;
			total_y += y;
			
			//mean
			mean_x = total_x/(count);
			mean_y = total_y/(count);
			
			//std dev
			double xmin = (x - 638.9);
			sum2 = Math.pow((xmin), 2);
	    	total2 += sum2;	    	        

	    	//z-score
	    	 z_num = (x - 638.9);
	    	 z_den = stdev; 	    	 
	    	 z = (z_num)/(z_den);	    	
	    	 System.out.println("z-score of " + x + " is: " + z);
	    	 
	    	 //middle riemann sum -> for function F(x) = 2x
	    	 rectangle = 2*delta_x/2 ;
	    	 riemann_sum += rectangle;
	    	 delta_x+=2;
	    	 
	    	 
			current_proxy = current_proxy.getNext(); // return next proxy node 
			current_dev = current_dev.getNext(); // return next development node
			
		}
		
		System.out.println("The middle riemann sum is: " + riemann_sum);

    	total2 = total2/(count-1);

		stdev=Math.sqrt(total2);
		
		double variance = Math.pow(stdev, 2);
		
		System.out.println("The standard deviation is " + stdev);
		System.out.println("The variance is " + variance);

		System.out.println("The x mean: " + mean_x);
		System.out.println("The y mean is: " + mean_y);
		double r;
		double r_square;

		//instantiate mean variables

		
		
		
		r = count * (xmulty) - (sum_x * sum_y);
		double denominator;
		denominator = count * x_square - (sum_x * sum_x);
		denominator = denominator * (count * y_square - (sum_y * sum_y));
		denominator = Math.sqrt(denominator);
		r = r / denominator;
		r_square = r * r;
		System.out.println("The value of r is: " + new DecimalFormat("#0.00000").format(r));
		System.out.println("The value of r squared is: " + new DecimalFormat("#0.00000").format(r_square));

		//normal distribution
		double distribution = 0;
		for(int i = 0; i <= count; i++)
		{
			double exponent;
			double denominator2 = Math.sqrt(2*Math.PI);
			exponent = (-0.5);
			distribution = (1/denominator2)*(Math.pow(Math.E, exponent));
		}
		System.out.println("The normal distribution is: "+ distribution);
	}

}
