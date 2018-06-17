package Suchen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ZeilenweiseAuslesen {

	
	/*
	 * File from the main method is read line by line
	 */
    private static void ladeDatei(String filename) {

        File file = new File(filename);				//erstellen des Files

        if (!file.canRead() || !file.isFile())
            System.exit(0);

            BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                System.out.println("Gelesene Zeile: " + zeile);			//wird solange gelesen bis Zeile nicht "null" ist
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();					//schlieﬂen
                } catch (IOException e) {
                }
        }
    }

 
    public static void main(String[] args) {
        String dateiName = "ausgabe.txt";
        ladeDatei(dateiName);
        System.out.println("File wurde erfolgreich erstellt!");
    }
}