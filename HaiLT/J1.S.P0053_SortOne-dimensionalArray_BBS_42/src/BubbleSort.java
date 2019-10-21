public class BubbleSort {
 
    private int [] array;
    
    public void arrayLength(int length){
        array = new int [length];
    }
    
    public void addValue(int value, int index){
        array[index] = value;
    }
    
    /*
    Display element of the array 
    */
    public void displayArray(String arow){
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
            if (i < array.length - 1){
                System.out.print(arow);
            }
        }
        System.out.println("");
    }
    
    /*
     Sort in ascending order
    */
    public void sortAscending(){
        if(array!=null){
            for (int i = 0; i < array.length -1 ; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if(array[j] > array[j+1]){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
            displayArray("->");
            return;
        }
        System.out.println("No data");
    }
    
    /*
    Sort in Descending order
    */
    public void sortDescending(){
        if(array!=null){
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if(array[j] < array[j+1]){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
            displayArray("<-");
            return;
        }
        System.out.println("No data");
    }
}
