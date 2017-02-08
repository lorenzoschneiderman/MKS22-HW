class Recursion{ 
	public static String name(){
 		return "Schneiderman,Lorenzo";
 	}

	public static double sqrt(double n){
		return sqrtHelper(n, n/3 + .5);
	}

	public static double sqrtHelper(double target, double n){
		if (n * n < target * 1.0001 && n * n > target * .999){
			return n;
		}
		else{
			return sqrtHelper(target, ( target / n + n) / 2);
		}
	}
	public static void main(String[] args) {
		System.out.println(sqrt(100));
	}

}