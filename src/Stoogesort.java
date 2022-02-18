import java.util.ArrayList;
import java.util.Collections;

class Stoogesort {

    ArrayList<Person> stoogesort(ArrayList<Person> L, int i , int j){
        // If the leftmost element is larger than the rightmost element

        if (L.get(i).getID()>L.get(j).getID()){
            Collections.swap(L,i,j);
        }
        if ((j - i + 1) > 2) {
            int t = (int) Math.floor((j - i + 1) / 3);
            stoogesort(L, i, j - t);  // Sort the first 2/3 of the array
            stoogesort(L, i + t, j);  // Sort the last 2/3 of the array
            stoogesort(L, i, j - t);   // Sort the first 2/3 of the array again
        }
        return L;
    }
}
