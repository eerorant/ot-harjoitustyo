package dao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eero
 */
public class StatsDAOTest {
    
    public StatsDAOTest() {
    }

    @Test
    public void writeToFileTest() {
        StatsDAO statsDao = new StatsDAO();
        try {
            statsDao.write("Eero", "Ei Eero");
        }
        catch (Exception E) {
            
        }
        String line = statsDao.get();
        if (line.length() > 0) {
            String[] parts = line.split("’");
            assertTrue(parts[0].equals("Eero") && parts[1].equals("Ei Eero"));
        }
        
    }
}