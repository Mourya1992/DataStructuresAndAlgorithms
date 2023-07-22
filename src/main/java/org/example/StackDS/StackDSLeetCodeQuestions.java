package org.example.StackDS;

import java.util.HashMap;
import java.util.Stack;

public class StackDSLeetCodeQuestions
{


    public static void main(String[] args) {
        int[] nums1 = {4,1,2,8};
        int[] nums2 = {1,3,4,2,8,12,5};
        int [] maxNums = findMaximumNumbers(nums1,nums2);

        for(Integer nums:maxNums){
            System.out.println(nums);
        }
    }

    /*
    There are n cars on an infinitely long road. The cars are numbered from 0 to n - 1 from left to right and each car is present at a unique point.

You are given a 0-indexed string directions of length n. directions[i] can be either 'L', 'R', or 'S' denoting whether the ith car is moving towards the left, towards the right, or staying at its current point respectively. Each moving car has the same speed.

The number of collisions can be calculated as follows:

When two cars moving in opposite directions collide with each other, the number of collisions increases by 2.
When a moving car collides with a stationary car, the number of collisions increases by 1.
After a collision, the cars involved can no longer move and will stay at the point where they collided. Other than that, cars cannot change their state or direction of motion.

Return the total number of collisions that will happen on the road.
     */

    public int countCollisions(String directions) {
        int count =0;
        Stack<Character> directionStack = new Stack<>();

        for(int i=0;i<directions.length();i++){
            while(!directionStack.empty()){
                if(directionStack.peek()==directions.charAt(i)){
                    break;
                }else if(directions.charAt(i)=='S'){
                    count=count+1;
                }
                else{
                    count=count+2;
                    directionStack.pop();
                }
            }
            directionStack.push(directions.charAt(i));
        }


        return count;

    }
    public static  int[]  findMaximumNumbers(int[] num1,int[] nums2){
        int[] res = new int[num1.length];
        Stack<Integer> stackOfNum2 = new Stack<Integer>();
        HashMap<Integer,Integer> maxNums = new HashMap<>();

        for(Integer num2:nums2){
            if(!stackOfNum2.empty() && stackOfNum2.peek()<num2){
                maxNums.put(stackOfNum2.pop(),num2);
            }
            stackOfNum2.push(num2);

        }
       for(int i=0;i<num1.length;i++){
           if(maxNums.containsKey(num1[i])){
               res[i]=maxNums.get(num1[i]);
           }
           else{
               res[i]=-1;
           }
       }

       return res;

    }

}
