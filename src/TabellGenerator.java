import java.util.ArrayList;
import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist

/**
 * Holds a method to print out 2-dimensional lists as neat tables.
*/
public class TabellGenerator{

/**
 * Print out a 2-dimensional list as a neat table.
 * Assumes the first row contains column headers.
 *
 * @param inputList The list to be printed.
 */
public void printTabell(List<List<String>> inputList){
    Integer rows = inputList.size();
    Integer columns = inputList.get(0).size();//Assuming all rows are of equal size
    List<Integer> widthList = new ArrayList<Integer>(columns);
    //Find the longest field per column
    for(Integer i = 0; i < columns; i++){
        widthList.add(0); //Start with column width at 0
        for(Integer j = 0; j < rows; j++){
            String field = inputList.get(j).get(i);
            if(widthList.get(i) < field.length()){
                widthList.set(i, field.length());
            }
        }
    }

    //More about printf:
    //https://www.baeldung.com/java-printstream-printf
    //Print the table
    for(Integer i = 0; i < rows; i++){
        //Horizontal line
        //Before first row and before second row
        if(i == 0 || i == 1){
            System.out.print("+");
            for(Integer j = 0; j < columns; j++){
                System.out.print("-".repeat(widthList.get(j)+2) + "+");
            }
            System.out.printf("%n");
        }
        //Print the actual content of the list
        for(Integer j = 0; j < columns; j++){
            String field = inputList.get(i).get(j);
            System.out.printf("| %-"+widthList.get(j)+"s ", field);
        }
        System.out.printf("|%n");
        //Horizontal line
        //After last row
        if(i == rows - 1){
            System.out.print("+");
            for(Integer j = 0; j < columns; j++){
                System.out.print("-".repeat(widthList.get(j)+2) + "+");
            }
            System.out.printf("%n");
        }
    }
}

}

