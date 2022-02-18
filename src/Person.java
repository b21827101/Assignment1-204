import java.util.Comparator;

class Person {

    private String name; //two attributes
    private int personID;

    String getName() { return name; }

    int getID() {
        return personID;
    }

    void setName(String name) {
        this.name = name;
    }

    void setPersonID(int personID) {
        this.personID = personID;
    }

    static class IntComparator implements Comparator<Person> {
        public int compare(Person l1, Person l2) {
            if (l1.getID() == l2.getID()) {
                return 0;
            } else if (l1.getID() < l2.getID()) {//to compare integers
                return 1;
            } else {
                return -1;
            }
        }
    }

     static class StringComparator implements Comparator<Person> {//to compare strings and it is using to stability
        public int compare(Person obj1, Person obj2) {
            return obj1.getName().compareTo(obj2.getName());
        }
    }
}

