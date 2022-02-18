import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Calculation{

    public static ArrayList<Person> persons = new ArrayList<>(); //to appending two attributes in the arraylist
    public static long combInt;  //comb execution time
    public static long gnomeInt;  //gnome execution time
    public static long shakerInt;  //shaker execution time
    public static long stoogeInt;  //stooge execution time
    public static long bitonicInt; //bitonic execution time

    void stability(){
        String[] name={"Andrew","Battle","Chen","Fox","Fruia","Gazsi","Kanaga","Rohde"};
        int[] id={3,4,3,3,1,4,3,2};  //two arrays for finding which sorting is stable
        for(int i=0;i<8;i++){
            Person person = new Person();
            person.setName(name[i]);
            person.setPersonID(id[i]);
            persons.add(person);
        }
        stringCompare();
        timeCalculationandRunningforSortings();
    }

    void descendingOrder(){
        Collections.sort(persons, new Person.IntComparator());
    }//descending sort

    void ascendingOrder(){    //ascending sort
        Collections.sort(persons, new Person.IntComparator());
        Collections.reverse(persons);
    }

    void stringCompare(){
        Collections.sort(persons, new Person.StringComparator());
    }

    String randomString(){  //to producing string randomly
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(3);
        for (int i = 0; i < 3; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    void timeCalculationandRunningforSortings(){
        CombSort comb = new CombSort();
        GnomeSort gnome = new GnomeSort();
        Shakersort s1 = new Shakersort();
        Bitonicsort b1 = new Bitonicsort();
        Stoogesort s2 = new Stoogesort();
        ArrayList<Person> person1 = new ArrayList<>(persons);  //saved the array in another array to keep the order of it

        long startTime = System.nanoTime();  //calculating comb sort time in nanoseconds
        comb.combsort(persons);
        long endTime = System.nanoTime();
        combInt += (endTime - startTime);

        Collections.copy(persons, person1); //using the same array order in another sorting algorithm.

        long startTime1 = System.nanoTime(); //calculating gnome sort time in nanoseconds
        gnome.gnomeSort(persons);
        long endTime1 = System.nanoTime();
        gnomeInt += (endTime1 - startTime1);

        Collections.copy(persons, person1);

        long startTime2 = System.nanoTime(); //calculating shaker sort time in nanoseconds
        s1.shakerSort(persons);
        long endTime2 = System.nanoTime();
        shakerInt += (endTime2 - startTime2);

        Collections.copy(persons, person1);//using the same array order in another sorting algorithm.

        long startTime4 = System.nanoTime();
        b1.sort(persons,persons.size(),1);  //calculating bitonic sort time in nanoseconds
        long endTime4 = System.nanoTime();
        bitonicInt += (endTime4 - startTime4);

        Collections.copy(persons, person1);

        long startTime3 = System.nanoTime();
        s2.stoogesort(persons,0,persons.size()-1);  //calculating stooge sort time in nanoseconds
        long endTime3 = System.nanoTime();
        stoogeInt += (endTime3 - startTime3);

        Collections.copy(persons, person1);

    }

    void runningRandomDescendingAscendingSituations(String situation,int size1){
        for (int i = 0; i < size1; i++) {
            Random random = new Random();
            Person person = new Person();
            person.setName(randomString()); //randomly
            person.setPersonID(random.nextInt());  //randomly
            Calculation.persons.add(person); //appending two attributes into the persons arraylist
        }
        if(situation.equals("Ascending")){ //to calculating according to descending or ascending order
            ascendingOrder();
        }
        else if(situation.equals("Descending")){
            descendingOrder();
        }
        timeCalculationandRunningforSortings();

        Calculation.persons.clear(); //clear after every size

        System.out.println(situation+ " Comb "+ (combInt));
        System.out.println(situation+ " Gnome "+ (gnomeInt));
        System.out.println(situation+ " Shaker "+ (shakerInt)); //print time of each algoritms
        System.out.println(situation+ " Stooge "+ (stoogeInt));
        System.out.println(situation+ " Bitonic "+ (bitonicInt));
        combInt=0;gnomeInt=0;shakerInt=0;stoogeInt=0;bitonicInt=0;
    }

}