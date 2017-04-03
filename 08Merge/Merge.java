public class Merge{
    
    public static void mergesort(int[]ary){
		if (ary.length < 2)
	    	return;
		else{
	    	int part = ary.length / 2;
		    int[] left = new int[part];
		    int[] right = new int[ary.length - part];
		    for (int i = 0; i < left.length; i++){
				left[i] = ary[i];
		    }
		    for (int i = 0; i < right.length; i++){
				right[i] = ary[part + i];
		    }
		    mergesort(right);
		    mergesort(left);
		    merge(right,left,ary);
		}	    
    }

    private static void merge(int[] a, int[] b, int[] destination){	
		int la = 0;
		int lb = 0;
		while (la < a.length && lb < b.length) {
		    if (a[la] < b[lb]) {
				destination[la + lb] = a[la];
				la++;
		    }
		    else {
				destination[la + lb] = b[lb];
				lb++;
		    }
		}	
		for (int i = la; i < a.length; i++) {
		    destination[i + lb] = a[i];
		}
		for (int j = lb; j < b.length; j++) {
		    destination[j + la] = b[j];
		}
	}    
}
