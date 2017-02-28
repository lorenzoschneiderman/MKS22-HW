import java.util.ArrayList;
class sortingArrayListTest{
	public static void main(String[] args) {
		
	
		ArrayList<int[]> arrList = new ArrayList<int[]>();
		int[] a = new int[2];
		int[] b = new int[2];
		a[0] = 5;
		a[1] = 6;
		b[0] = 4;
		b[1] = 10;
		// System.out.println(a);
		arrList.add(a);
		arrList.add(b);
		for (int[] term : arrList){
			for (int innerTerm : term){
				System.out.println(innerTerm);
			}
		}
		arrList.sort();
	}
}