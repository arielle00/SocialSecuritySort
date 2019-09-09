/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssnsort;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SSNSort {

    public static void main(String[] args) throws FileNotFoundException {
		
		
		String fileName = "Random_SSN.txt";
		String fileName1 = "Quick_SSN.txt";
		String fileName2 = "Bucket_SSN.txt";
		String fileName3 = "Radix_SSN.txt";
		
		PrintWriter Random = new PrintWriter(fileName);
		PrintWriter Quick = new PrintWriter(fileName1);
		PrintWriter Bucket = new PrintWriter(fileName2);
		PrintWriter Radix = new PrintWriter(fileName3);
		
		int[] A = new int[300];
		int[] B = new int[300];
		
		File file = new File(fileName); 
		Scanner sc = new Scanner(file); 
			
		int j =0;
		for (int i=0; i<300; i++) {
			Random random = new Random();
			int num = random.nextInt(((1000-1)+1)+1);
			int num1 = random.nextInt(((100-1)+1)+1);
			int num2 = random.nextInt(((10000-1)+1)+1);
			int numTotal = num*1000000 + num1*10000 + num2;
			
			
			if (num<199) {
				j = j+1;
				
				
			}
			
			A[i]=numTotal;
			B[i]=numTotal;
			
			
			String randomSSN = Integer.toString(numTotal);
			
			while (randomSSN.length()<9) {
				randomSSN = "0"+randomSSN;
			}
			
			randomSSN = randomSSN.substring(0,3)+ "-" + randomSSN.substring(3,5) + "-" +randomSSN.substring(5,9);
			Random.println(randomSSN);
			
			System.out.println("Northeast Coast States: "+i);
		}
		
		Random.close();
		
//		
//			for (int i=0; i<300; i++) {
//				System.out.print(i+": ");
//				System.out.println(A[i]); 
//			}
		
				
			QuickSort(A,0,299);
			
			for (int i=0; i<300; i++) {
				String quick = Integer.toString(A[i]);
				
				while (quick.length()<9) {
					quick = "0" + quick;
				}
				
				quick = quick.substring(0,3)+ "-" + quick.substring(3,5) + "-" +quick.substring(5,9);
				Quick.println(quick);
				
				
			}
			
			Quick.close();
			
			
			
			
			
//			System.out.println("*************Quick**************");
//			for (int i=0; i<300; i++) {
//				System.out.print(i+": ");
//				System.out.println(A[i]); 
//			}
			
			
			BucketSort(B);
			
			for (int i=0; i<300; i++) {
				String bucket = Integer.toString(B[i]);
				
				while (bucket.length()<9) {
					bucket = "0" + bucket;
				}
				
				bucket = bucket.substring(0,3)+ "-" + bucket.substring(3,5) + "-" +bucket.substring(5,9);
				Bucket.println(bucket);
			}
			Bucket.close();
			
	
			
			
			
			radixSort(A,7);
			
			for (int i=0; i<300; i++) {
				String radix = Integer.toString(A[i]);
				
				while (radix.length()<9) {
					radix = "0"+ radix;
				}
				
				radix = radix.substring(0,3)+ "-" + radix.substring(3,5) + "-" + radix.substring(5,9);
				Radix.println(radix);
			}
			
			Radix.close();
	
	} 
	
	
	
	
	
	
		public static void QuickSort(int[] A, int p, int r){
			if (p<r) {
				int q = Partition(A,p,r);
				QuickSort(A,p,q-1);
				QuickSort(A,q+1,r);
			}
		}
		
		public static int Partition(int[] A, int p, int r) {
			int x = A[r];
			int i = p-1;
			for (int j=p; j<=r-1; j++) {
				if (A[j]<= x) {
					i=i+1;
					int tmp = A[i];
					A[i]=A[j];
					A[j]= tmp;
				}
			
			}
			int tmp = A[i+1];
			A[i+1]=A[r];
			A[r]=tmp;
			return i+1;
		}
		
		public static void BucketSort(int[] A) {
			int n = A.length;
			int[] B = new int[n-1];
			int[] C = new int[A.length];
			
			for (int i=0; i<n-1; i++) {
				B[i]=0;
			}
			for (int i=1; i<n; i++) {
				B[(int) Math.floor(n/A[i])]= A[i];
			}
			for (int i=0; i<n-1; n++) {
				insertionSort(B);
			}
			
			for (int i=0; i<300; i++) {
				
			}
		 
		}
		
		public static void insertionSort(int[] B) {
			for (int j=2; j<B.length; j++) {
				int key = B[j];
				int i = j-1;
				while (i>0 && B[i]>key) {
					B[i+1] = B[i];
					i = i-1;		
				}
				B[i+1]=key;
			}
		}
		
		public static void radixSort(int[] A, int d) {
			for (int i=1; i<d; i++)
				insertionSort(A);
		}
	
	}
	



