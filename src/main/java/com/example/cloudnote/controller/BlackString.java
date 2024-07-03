package com.example.cloudnote.controller;

import java.util.Scanner;

/**
 * 暗黑字符串：
 * 给定A B C
 * 例如：BAACAACCBAAA连续子串“CBA”中包含了A B C 个一个，所以是纯净的字符串
 * AABBCCAABB不存在一个长度为3的连续子串不阿含A B C，所以是暗黑的字符串
 */
public class BlackString {

	public static void main(String[] args) {
		
		//获取输入，转成数组
		char[] arr = new Scanner(System.in).nextLine().toCharArray();
		
		//System.out.println(arr);
		//判断。
		int i=0;
		//如果第i i+1 和i+2的值加起来等于198
		//循环数组长度-2次
		for(i=0;i<arr.length-2;i++){
			if(arr[i]+arr[i+1]+arr[i+2]==198){ //ABC的ASCII加起来是198
				
				if(arr[i]!=arr[i+1]){ //3个B的和加起来也是这种情况，需要排除
					System.out.println(String.valueOf(arr)+":是纯净字符串");
					return;//结束整个for循环
				}else{
					System.out.println(arr.toString()+"是暗黑字符串");
				}
				
				}
			else{
				if(arr.length-i==3){//判断当i是倒数第三个字符时，若还不是纯净字符串，则直接输出暗黑字符串
					System.out.println(String.valueOf(arr)+"是暗黑字符串");
				}
			}
		}
		
	}

}
