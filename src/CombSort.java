import java.util.ArrayList;
import java.util.Collections;

public class CombSort {

    void combsort(ArrayList<Person> input ) {

        int gap = input.size(); // Initialize gap size
        double shrink = 1.3; // Set the gap shrink factor
        boolean sorted = false;

        while (sorted == false) {
            gap = (int) Math.floor(gap / shrink);
            if(gap <= 1 ){
                gap = 1;
                sorted = true; // If there are no swaps this pass, we are done
            }
            int i = 0;
            while(i + gap < input.size()) {// See Shell sort for a similar idea
                if (input.get(i).getID() > input.get(i + gap).getID()) {
                    Collections.swap(input,i,i + gap);
                    sorted = false;
                }
                i = i + 1;
            }
        }
    }

}
