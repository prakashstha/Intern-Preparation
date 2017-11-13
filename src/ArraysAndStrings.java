import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ArraysAndStrings {
	
	/**
	 * 1.1. Implement an algorithm to determine if a string has all unique characters.
	 * What if you cannot use additional data structures?
	 * @param str a string to be checked unique or not.
	 * @return
	 */
	public boolean isUnique(String str){
		/* using hashmap */
//		HashMap<Character, Integer> hmap = new HashMap<>();
//		char c;
//		for(int i = 0; i<str.length(); i++){
//			c = Character.toLowerCase(str.charAt(i));
//			if(hmap.containsKey(c)){
//				return false;
//			}
//			hmap.put(c, 1);
//			
//		}
//		return true;
		
		/* not using any data structure */
		if(str.length()>26){
			return false;
		}
		
		boolean[] chars = new boolean[26];
		String lowerStr = str.toLowerCase();
		
		for(int i = 0; i<str.length(); i++){
			
			char c = lowerStr.charAt(i);
			if(chars[(int)c - 'a']){
				return false;
			}
			chars[(int)c - 'a'] = true;
		}
		return true;
	}
	
	/**
	 * 1.2. Given two strings, write a method to decide if one is a permutation of the other.
	 * </br><i>Computation Complexity</i>: O(NlogN), and 
	 * </br><i>Space Complexity</i>: O(N).
	 * @param str1 first string
	 * @param str2 second string
	 * @return <b>true</b> if str2 is permutation of str1, otherwise <b>false</b>
	 */
	public boolean isPermutation(String str1, String str2){
		char[] strArr1 = str1.toCharArray();
		char[] strArr2 = str2.toCharArray();
		
		Arrays.sort(strArr1);
		Arrays.sort(strArr2);
		
		return Arrays.equals(strArr1, strArr2);
	}
	
	/**
	 * 1.4. <p>Given a string, write a function to check if it is a permutation of palindrome. 
	 * A palindrome is a word or phrase that is the same forwards and backward
	 * A permutation is a rearrangement of letters. The palindrome does not need to be 
	 * limited to just dictionary words. </p>
	 * @param str1 first string
	 * @param str2 second string
	 * @return <b>TRUE</b> if two string are palindromic permutation
	 */
	public boolean isPanlindromePermutation(String str1, String str2){
		if(!isPermutation(str1, str2)){
			return false;
		}
		char[] strArr = str2.toCharArray();
		for(int i = 0; i<strArr.length;i ++){
			if(strArr[i] != strArr[strArr.length - 1 - i]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 1.5. <p><b>One Away: </b>There are three typs of edits that can be performed on strings:
	 * <i>insert a character, remove a character, or replace a character.</i> Given two strings,
	 * write a function to check if they are one edit (or zero edits) away. </p>
	 * @param str1 first string
	 * @param str2 second string
	 * @return
	 */
	public boolean isOneEdit(String str1, String str2){
		
		return false;
	}
	
	/**
	 * 1.6 <p><b>String Compression:</b> Implement a method to perform basic string compression using the 
	 * counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the compressed 
	 * string would not become smaller than the original string, your method should return original string.
	 * You can assume the string has only uppercase and lowercase letters (a-z).</p>
	 * @param str string to be compressed
	 * @return compressed string
	 */
	public String stringCompression(String str){
		StringBuilder sb = new StringBuilder();
		int charCount = 1;
		int i;
		for(i = 1; i<str.length(); i++){
			if(str.charAt(i-1) == str.charAt(i)){
				charCount++;
			}else{
				sb.append(str.charAt(i-1) + String.valueOf(charCount));
				charCount = 1;
			}
		}
		sb.append(str.charAt(i-1) + String.valueOf(charCount));
		
		if(sb.toString().length() >= str.length())
			return str;
		
		return sb.toString();
	}
	

	/**
	 * 
	 * @param a square matrix to be rotated
	 * @param size dimension of the matrix
	 * @return 90 degree clockwise rotated matrix
	 */
	public int[][] rotate(int a[][], int size){
		int res[][]= new int[size][size];
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				int temp = a[i][j];
				res[j][size - i - 1] = a[i][j];
			}
		}
		return res;
	}
	
	public void rotate(int a[][]){
		int len = a.length;
		for(int i = 0;i<len;i++){
			for(int j = i; j<len/2; j++){
				int t = a[i][j];
				a[i][j] =  a[len - 1 - j][i];
				a[len - 1 - j][i] = a[len - 1 - i][len - 1 - j];
				a[len - 1 - i][len - 1 - j] = a[j][len - 1 - i];
				a[j][len - 1 - i] = t;
			}
		}
	}
	
	/**
	 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
	 * @param a
	 */
	public void zeroMatrix(int a[][]){
		int r = a.length;
		int c = a[0].length;
		boolean []rows = new boolean[r];
		boolean []cols = new boolean[c];
		HashMap<Integer, Boolean> colsMap = new HashMap<>();
		for(int i = 0; i<r; i++){
			for( int j = 0; j<c; j++){
				if(a[i][j] == 0){
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int i = 0; i<rows.length; i++){
			if(rows[i]){
				for(int k = 0; k<c; k++){
					a[i][k] = 0;
				}				
			}
		}
		for(int i = 0; i<cols.length; i++){
			if(cols[i]){
				for(int k = 0; k<r; k++){
					a[k][i] = 0;
				}
			}
		}
	}
	
	/**
	 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring of another.
	 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring 
	 * (e.g., "waterbottle" is a roation of "erbottlewat" 
	 * @param args
	 */
	public boolean isSubstring(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		
		String newString = s2 + s2; 
		if(newString.contains(s1))
			return true;
		return false;
	}
	
	
	public static long toBinary(int n){
		int rem; int bin = 0;
		
		
		while(n != 0){
			rem = n%2;
			bin = bin*10 + rem;
			n = n/2;
		}
		return bin;
	}

		public static void main (String[] ab) {
			//code
			Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			while(t>0){
			    t--;
			    String num1 = in.next();
			    String num2 = in.next();
			    int i = num1.length() - 1;
			    int j = num2.length() - 1;
			    
			  
			    int n1, n2, sum;
			    int carry = 0;
			    String res = "";
			    while(i>=0 && j>=0){
			    	n1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
			    	n2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
			    	sum = n1 + n2 + carry;
			    	carry = sum/10;;
			    	res = String.valueOf(sum%10) + res;			    		
			    	i--;
			    	j--;
			    	
			   }
			    
			    while(i >= 0){
			    	n1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
			    	sum = n1 + carry;
			    	carry = sum/10;;
			    	res = String.valueOf(sum%10) + res;		
			    	i--;
			    }
			    
			    while(j >= 0){
			    	n2 = Integer.parseInt(String.valueOf(num1.charAt(j)));
			    	sum = n2 + carry;
			    	carry = sum/10;
			    	res = String.valueOf(sum%10) + res;		
			    	j--;
			    }
			    
			    if(carry != 0)
			        res = carry + res;
			    
			    
			    int resLen = res.length();
			    if(resLen != num1.length()){
			        System.out.println(num1);
			    }else{
			        System.out.println(res);
			    }
			
			    
			}
			
		}
	
	
	

}
