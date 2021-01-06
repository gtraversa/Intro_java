package MeanAndVariance;
import java.util.*;


public class MeanAndVariance {
    //Declaring the instance variables
    private double[] data;
    private int nData;

    //Method to get the mean of the data
    public double mean(){
        double sum = 0;
        for(double i:data) {
            sum += i;
        }
        return sum/nData;
    }

    //Method to get the vadiance of the data
    public double variance(){
        double mean = mean();
        double sumDiffSquared = 0;
        for(double i: data) {
            sumDiffSquared += Math.pow((i-mean),2);
        }

        return sumDiffSquared/(nData-1);
    }

    //Convention to be able to access the private data from outside the class
    //Although  it d8efeats the purpose of having a private instance
    public double[] getData() {
        return data;
    }

    //Method to set data using an already existing data array
    public void setData (double[] newData) {
        data = newData;
        nData = newData.length;
    }

    //Method to convert the array of data to a formatted string
    @Override
    public String toString(){
        String output = "[" + data[0];
        for (int i = 1; i < nData; i++) {
            output += ", " + data[i];
        }
        return output + "]";
    }

    //Method which asks the user for the amount of data they want to input
    //and does some basic error handling but does not use exception handling
    //as this program was completed before we began lectures
    private static int getNumOfData (Scanner input) {
        System.out.printf("Enter the number of arguments:\n");
        int nData;
        while (true) { // loop until we get it correctly nData = input.nextInt();
            nData = input.nextInt();
            if (nData < 2) {
                System.out.printf("the number of data should be >=2 !\n");
                continue; // continue looping }
            }
            break; // we got it correctly, so break out of the loop
        }
        return nData;
    }

    //Method which  accepts exactly the amount of data specified by the user
    //and once again does some basic error handling excluding exceptions
    public void getDataSet (Scanner input) {
        nData = getNumOfData(input);
        data = new double[nData]; // we create the array instance variable
        int i = 0;
        System.out.printf("Enter the arguments:\n");
        while (true) { // loop until we get it correctly nData = input.nextInt()
            if(i < nData) {
                data[i] = input.nextDouble();
                i++;
                continue;
            }
            break;
        }
    }

    //Null constructor
    public MeanAndVariance () { // constructor with no data, called indirectly via new data = null;
        data = null;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);     //Scanner  object used to get input
        MeanAndVariance mv = new MeanAndVariance(); //MeanAndVariance object instantiated

        mv.getDataSet(input); // get data set 1
        System.out.printf("The mean and variance of the following numbers are:\n");
        System.out.printf("Numbers: %s\n", mv.toString());
        System.out.printf("Mean: %f Variance: %f\n", mv.mean(), mv.variance());
        System.out.printf("\n");

        mv.getDataSet(input); // get data set 2
        System.out.printf("\nThe mean and variance of the following numbers are:\n");
        System.out.printf("Numbers: %s\n", mv.toString());
        System.out.printf("Mean: %f Variance: %f\n", mv.mean(), mv.variance());
    }
}
