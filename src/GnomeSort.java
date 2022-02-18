import java.util.ArrayList;
import java.util.Collections;

class GnomeSort {

    void gnomeSort(ArrayList<Person> a) {
        int pos = 0;
        while (pos< a.size()) {
            if (pos == 0 || (a.get(pos).getID() >= a.get(pos-1).getID())){
                pos =pos + 1;
            }
            else{
                Collections.swap(a,pos,pos-1);
                pos=pos - 1;
            }
        }
    }

}
