import java.util.*;
import java.io.*;

public class Quiz2Redux{
	public static void main(String[] args) {
		System.out.println(combinations("wxof"));
	}
	public static ArrayList<String> combinations(String s){
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Character> cars = new ArrayList<Character>();
		for (char c : s.toCharArray()){
			cars.add(c);
		}
		combinationsH(words, "", cars);
		Set<String> hs = new HashSet<>();
		hs.addAll(words);
		words.clear();
		words.addAll(hs);
		return words;
	}

	public static void combinationsH(ArrayList<String> words, String s, ArrayList<Character> left){
		words.add(s);
		// for (Character use : left){
		try{
			Character use = left.get(0);
			combinationsH(words, s + use, remove(left, use));
			combinationsH(words, s, remove(left, use));
		}catch (Exception e){
			return;
		}
		
		// }
	}



	public static ArrayList<Character> remove(ArrayList<Character> left, Character use){
		ArrayList<Character> out = new ArrayList<Character>();
		try{
			for (Character character : left){
				if (character == use){}
				else{
					out.add(character);
				}
			}
		}
		catch (Exception e){
			System.out.println("outofbounds");
		}
		return out;
	}
}