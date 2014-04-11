

package csci232_inlab5_dynamic_edit_distance;

/**
 *
 * @author Roy Smart
 */
import java.io.FileNotFoundException;

public class Driver
{
    public static void main (String [] args) throws FileNotFoundException
    {
        EditDistance words = new EditDistance ("words.txt");
        words.calculateDistance();
        //coins.initialize();
        //coins.fillTable();
        //coins.solveProblems();
    }
}