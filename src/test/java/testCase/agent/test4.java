package testCase.agent;

import java.util.Arrays;
import java.util.Scanner;

import org.testng.annotations.Test;

public class test4 {
	
	@Test
	public void test4_01(){
		int[] arr = new int[3];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("请输入第"+(i+1)+"个你想输入的值：");
			Integer integer = Integer.valueOf(scanner.next());
			arr[i] = integer;
		}
		Arrays.sort(arr);
		double sum=0;
		for(int j : arr){
			sum+=j;
		}
		System.out.println("数组求和为："+sum);
	}
	
	@Test
	public void test4_02(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String string = String.valueOf(scanner.next());
		String[] strings = string.split("");
		String string2 = "";
		for(int i = strings.length-1; i >= 0; i--){
			string2+=strings[i];
		}
		System.out.println("倒序后："+string2);		
	}
	
	@Test
	public void test4_03(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String string = String.valueOf(scanner.next());
		String string2 = "";
		for(int i = string.length(); i > 0; i--){
			string2+=string.substring(i-1,i);
		}
		System.out.println("倒序后："+string2);		
	}

}
