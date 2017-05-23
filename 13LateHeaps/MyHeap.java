import java.util.*;

public class MyHeap{
    
    public ArrayList<String> heap;
    public int sz;

    public MyHeap(){
		heap = new ArrayList<String>();
		heap.add("end");
		sz = 1;
    }

    public MyHeap(boolean val){
		heap = new ArrayList<String>();
		heap.add("end");
		if (val){
		    sz = 1;
		}
		else{
		    sz = -1;
		}
    }
    
    public void swap(int first, int second){
		String placeholder = heap.get(second);
		heap.set(second,heap.get(first));
		heap.set(first, placeholder);
    }

    public String peek(){
		if ((heap.size() - 1) == 1){
		    return "end";
		}
		else if ((heap.size() - 1) < 1){ // huh okay
		    throw new NoSuchElementException();
		}
		else{
		    return heap.get(1);
		}
    }

    
    public void add(String s){
	heap.add(s);pushUp();
    }

    public void pushUp(){
	int spot;
	int i = (heap.size() - 1);
	while ( (i > 1) && (compareto(heap.get(i), heap.get(i / 2)) > 0) ) {
	    swap (i, i / 2);
	    i = i / 2;
	}
    }
	
    public void pushDown(){
	int i, above;
	above = 2;
	i = 1;


	while ((i * 2) < (heap.size() - 1) && (compareto(heap.get(i), heap.get(i * 2)) < 0 || compareto(heap.get(i), heap.get((i * 2) + 1)) < 0)) {
	    if (compareto(heap.get(i * 2), heap.get((i * 2) + 1)) >= 0){
			above =   i * 2;
		}else {
			above = (i * 2) + 1;
		}
		swap(i, above);
		i = above;
		}
    }
    
    public String remove(){
		swap(1,(heap.size() - 1));
		String removed = heap.remove((heap.size() - 1));
		pushDown();
	return removed;
    
    }
    public int compareto(String thisOne, String otherOne){
		return (thisOne.compareTo(otherOne)*sz);
    }
    
}
