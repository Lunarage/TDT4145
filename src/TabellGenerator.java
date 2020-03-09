/*
 * Class used to print out 2D arrays as a neat table.
 * @author Magne Halvorsen
*/

import java.util.ArrayList;
import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist

public class TabellGenerator{

private List<List<String>> list;
private List<Integer> widthList;
private Integer columns;
private Integer rows;

public void printTabell(List<List<String>> inputList){
    list = inputList;
    rows = list.size();
    columns = list.get(0).size();//Assuming all rows are of equal size
    widthList = new ArrayList<Integer>(columns);
    //Find the longest field per column
    for(Integer i = 0; i < columns; i++){
        widthList.add(0); //Start with column width at 0
        for(Integer j = 0; j < rows; j++){
            String field = list.get(j).get(i);
            if(widthList.get(i) < field.length()){
                widthList.set(i, field.length());
            }
        }
    }

    //More about printf:
    //https://www.baeldung.com/java-printstream-printf
    for(Integer i = 0; i < rows; i++){
        if(i == 0 || i == 1){
            System.out.print("+");
            for(Integer j = 0; j < columns; j++){
                System.out.print("-".repeat(widthList.get(j)+2) + "+");
            }
            System.out.printf("%n");
        }
        for(Integer j = 0; j < columns; j++){
            String field = list.get(i).get(j);
            System.out.printf("| %-"+widthList.get(j)+"s ", field);
        }
        System.out.printf("|%n");
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

