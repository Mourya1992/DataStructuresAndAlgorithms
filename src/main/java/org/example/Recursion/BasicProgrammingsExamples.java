package org.example.Recursion;

import java.util.ArrayList;
import java.util.List;

public class BasicProgrammingsExamples {

    public static BasicProgrammingsExamples basicProgrammingsExamples = new BasicProgrammingsExamples();
    int count=0;
    public static void main(String[] args) {

        //System.out.printf("the factorial of the number is ::"+basicProgrammingsExamples.findFactorialOfNumber(0));
       // basicProgrammingsExamples.printFibonacciSeries(8);
      //  basicProgrammingsExamples.understandingRecursion(10);
       // long factorial = basicProgrammingsExamples.findFactorialUsingRecursion(5);
      //  System.out.println(factorial);
       // long sum = basicProgrammingsExamples.findSumOfNPositiveIntegersUsingRecusrsion(10);
       // System.out.println(sum);
        int[] list = {4,5,6,8,11,15};
        int index = basicProgrammingsExamples.binarySearch(15,list);
         index = basicProgrammingsExamples.binarySearchWithRecursion(15,list,5,0);
        System.out.println(index);

    }

    public long findFactorialOfNumber(int n){
        long fact = n;
        String display="";
        if(n<=1){
            return 1;
        }else {
            for (int i = n; i > 1; i--) {
                if (n > 1) {
                    fact = fact * (i - 1);
                }
                display=display+i+"x";
            }
            System.out.println("the factorial of n is :"+display+":"+fact);
        }
        return  fact;
    }

    public void printFibonacciSeries(int n){

        /*0,1,1,2,3,5,8,13,21,34,55
        Numbers gets added up to computed the next number .

        */
        List<Integer> fibonnocciNumbers = new ArrayList<Integer>();

        int x=0;
        int y=1;
        int next=1;
        fibonnocciNumbers.add(x);
        fibonnocciNumbers.add(y);
        for(int i=1;i<=n;i++){
            next = x+y;
            fibonnocciNumbers.add(next);
            x=y;
            y=next;
        }
fibonnocciNumbers.stream().forEach(num->{
    System.out.print(num+",");
});
    }


    public int understandingRecursion(int n){

        n--;
        if(n==1){
            System.out.println("the count is :"+n);
            return n;
        }

            return understandingRecursion(n);

    }

    public long findFactorialUsingRecursion(int n){
        if(n<=1){
            return 1;
        } else {
            System.out.println("currently n value is :"+n);
            return n*findFactorialUsingRecursion(n-1);
        }

    }

    public long findSumOfNPositiveIntegersUsingRecusrsion(int n){
        System.out.println(count++);
        if(n<1){
            return 0;
        }
        else {
            return n+findSumOfNPositiveIntegersUsingRecusrsion(n-1);
        }
    }

    public int findFibonacciSeriesUsingRecursion(int n){
        if(n==2||n==1){
            return 1;
        }
        else {
            return findFibonacciSeriesUsingRecursion(n-1)+findFibonacciSeriesUsingRecursion(n-2);
        }
    }

    public int binarySearch(int n , int[] list){
        System.out.println(n);
        int low=0;
        int high=list.length-1;
        int midIndex=0;
        while(low<=high){
            midIndex=((high)+low)/2;
            if(n==list[midIndex]){
                return midIndex;
            }
            if(n>list[midIndex]){
              low = midIndex+1;
            }
            else {
               high=midIndex-1;
            }
            System.out.println("Low:"+low+"High:"+high+"middleIndex:"+midIndex);
        }



        return -1;
    }

    public int binarySearchWithRecursion(int n , int[] list,int high,int low){
        System.out.println(n);
        if(high-low>=0){
         int  midIndex=(high+low)/2;
            if(n==list[midIndex]){
                return midIndex;
            }else if(n>list[midIndex]){
                return binarySearchWithRecursion(n,list,high,midIndex+1);

            }
            else
                return binarySearchWithRecursion(n, list,midIndex-1,high);


        }

return -1;
    }



}
