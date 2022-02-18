import java.util.ArrayList;
import java.util.Collections;

class Shakersort {

    void shakerSort(ArrayList<Person> A ) {
        boolean swapped = false;
        do {
            for (int i = 0; i <= A.size() - 2; i = i + 1) {
                if (A.get(i).getID()> A.get(i + 1).getID()) {// test whether the two elements are in the wrong order
                    Collections.swap(A,i,i+1);  // let the two elements change places
                            swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;

            for (int i = A.size()-2 ;i >= 0;i = i - 1){
                if (A.get(i).getID() > A.get(i+1).getID()) {
                    Collections.swap(A,i,i+1);
                    swapped = true;
                }
            }
        }
        while (swapped);// if no elements have been swapped, then the list is sorted
    }
}
