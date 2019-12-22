
package dao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A simple class to write the winner and loser of a match to a text file, and
 * to read them when needed.
 * @author eero
 */
public class StatsDAO {
    
    public void write(String won, String lost) throws IOException {
        PrintWriter pw = new PrintWriter("stats.txt");
        pw.println(won + "’" + lost);
        pw.close();
    }
    
    public String get() {
        String line = "";
        try (Scanner reader = new Scanner(new File("stats.txt"))) {
            while (reader.hasNextLine()) {
                line = reader.nextLine();
            }
        } catch (Exception e) {
            
        }
        return line;
    }
}
