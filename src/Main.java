
public class Main {

    public static void main(String[] args) {

        int[] size={8,16,32,64,128,256,512,1024,2048,4096}; //size array
        Calculation c1 = new Calculation();
        //c1.stability();   //for Calculating stability

        for(int j=0;j<size.length;j++) {
            System.out.println("\n" + "Size --> " + size[j]);
            //doing three situations for every size
            c1.runningRandomDescendingAscendingSituations("Random",size[j]);  //random situations
            c1.runningRandomDescendingAscendingSituations("Ascending",size[j]);//ascending situations
            c1.runningRandomDescendingAscendingSituations("Descending",size[j]);//descending situations

        }
    }
}




