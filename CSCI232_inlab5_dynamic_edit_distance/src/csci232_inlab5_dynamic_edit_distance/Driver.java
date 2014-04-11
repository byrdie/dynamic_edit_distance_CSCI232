

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
        EditDistance coins = new EditDistance ("words.txt");
        coins.initialize();
        coins.fillTable();
        coins.solveProblems();
    }
}