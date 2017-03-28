import java.util.*;

public class Quick{

    public static void swap(int[] ary, int i, int j){
		int temp;
		temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;
    }

	public static int partition (int[]data, int start, int end){
		if (start >= end) {
	    	return start;
		}
		int pivotindex = (int)(Math.random() * (end - start + 1)) + start;
		int gt = end;
		int lt = start;
		int i = start;
		int val = data[lt];
		swap(data, pivotindex, start);
		while(i <= gt){
	    	if(data[i] == val)i++;
	    	else if(data[i] < val){
				swap(data,i,lt); 
				i++; 
				lt++;
	    	}
	    	else{
				swap(data,gt,i); 
				gt--;
	    	}
		}
		return lt;		    
    	}

    public static String toStringArray(int[] ary){
	String out = "";
	for (int i = 0; i < ary.length; i ++){
	    out += (ary[i] + ", ");
	}
	return out;
    }

    public static void quicksort(int[] ary){
		quickSortH(ary, 0, (ary.length - 1));
    }
    
    public static void quickSortH(int[] ary, int start, int end){
	if (end - start > 0){
	    int div = partition(ary, start, end);
	    quickSortH(ary, start, div);
	    quickSortH(ary, div + 1, end);
		}
    }
		   
    public static int quickselect(int[] ary, int k){
		return selectH(ary, k, 0, ary.length - 1);
    }

    public static int selectH(int[] ary, int k, int start, int end){
        int pivot = partition (ary, start ,end);
		if (pivot == k) return ary[pivot];
		if (pivot > k) return selectH(ary, k, start, pivot);
		if (pivot < k) return selectH(ary, k, pivot + 1, end);
		return ary[k];
    }
}