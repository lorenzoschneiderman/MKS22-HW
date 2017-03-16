import java.util.*;
import java.io.*;

public class Quiz2Redux{
	public static void main(String[] args) {
		System.out.println(combinations("abcd"));
	}
	public static ArrayList<String> combinations(String s){
		ArrayList<String> words = new ArrayList<String>();

		ArrayList<Character> cars = new ArrayList<Character>();
		
		for (char c : s.toCharArray()){
			cars.add(c);
		}
		combinationsH(words, "", cars);
		return words;

	}

	public static void combinationsH(ArrayList<String> words, String s, ArrayList<Character> left){
		words.add(s);
		for (Character use : left){
			combinationsH(words, s + use, remove(left, use));

		}
	}

	public static ArrayList<Character> remove(ArrayList<Character> left, Character use){
		ArrayList<Character> out = new ArrayList<Character>();

		for (Character character : left){
			if (character == use){}
			else{
				out.add(character);
			}
		}

		return out;

	}
}