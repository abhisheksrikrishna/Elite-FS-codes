/*
You are playing a game. There are N boxes placed in a row (0-indexed), 
every box has some points. You need to play the game with the following rules:
 - Initially your score is  '0' points.
	- Suppose the box has p points in it.
	  if p>0 you will gain p points, if p<0 you will loose p points.
	- You are allowed to choose any number of consecutive boxes, atleast 1 box.
   	
You are given the points in the N boxes as points[]. 
Your target is to maximize your score by droping atmost one box in the set of 
consecutive boxes, and return the highest score possible. 

Note : The score should be considered for atleast 1 box even after droping a box.
 
Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, points[].
  
Output Format:
--------------
An integer, print the highest score.
    
Sample Input-1:
---------------
9
-3 1 -2 4 -2 2 3 -5 4
 
Sample Output-1:
----------------
 11
   
Explanation:
------------
By selecting consecutive boxes [4,-2,2,3,-5,4] and dropping -5 , has the highest
score is 11.
   
 
Sample Input-2:
---------------
 2
 1 -2
  
Sample Output-2:
----------------
1

Explanation:
------------
By picking the box is [1] has the highest score is 1.

*/

SOLUTION:
GeeksForGeeks Solution
import java.util.*;
class D2P3{
    static int[] arr;
    public static int findMax(int n){
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
         int max = arr[0];
         int max_so_far = arr[0];
         
         arr1[0] = arr[0];
         for(int i=1;i<n;i++){
             max = Math.max(arr[i],max+arr[i]);
             max_so_far = Math.max(max,max_so_far);
             
             arr1[i] = max;
         }
         max=max_so_far = arr2[n-1] = arr[n-1];
         for(int i = n-2;i>=0;i--){
             max = Math.max(arr[i],max+arr[i]);
             max_so_far = Math.max(max_so_far,max);
             
             arr2[i] = max;
             
         }
         int maximum = max_so_far;
         for(int i=1;i<n-1;i++){
             maximum = Math.max(maximum,arr1[i-1]+arr2[i+1]);
         }
         
         return maximum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(findMax(n));
    }
}