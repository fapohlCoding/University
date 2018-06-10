package PersArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * 	@author Fabian Pohl
 */

public class PersArray {
	RandomAccessFile f;
    String name;
    int pos = 0;

    /**
     * open the Random AccessFile with the transferring name, if 
     * the file with this name does not exists, a new file is generated
     * 
     * 
     * @param name of the file
     *           
     * @throws FileNotFoundException
     *             if the mode is "r" but the given string does not denote an
     *             existing regular file, or if the mode begins with "rw" but
     *             the given string does not denote an existing, writable
     *             regular file and a new regular file of that name cannot be
     *             created, or if some other error occurs while opening or
     *             creating the file
     */
    
    PersArray(String name) {
	this.name = name;
	try {
	    f = new RandomAccessFile(name, "rw");
	} catch (FileNotFoundException e) {
	    System.out.println("Datei nicht gefunden!");
	}
    }

    /**
     * @param name
     *            uebergebener Name des Files
     * @param x
     *            Integer Array mit dem das File befuellt werden soll
     * 
     * @throws FileNotFoundException
     *             if the mode is "r" but the given string does not denote an
     *             existing regular file, or if the mode begins with "rw" but
     *             the given string does not denote an existing, writable
     *             regular file and a new regular file of that name cannot be
     *             created, or if some other error occurs while opening or
     *             creating the file
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    
    

   
    
    PersArray(String name, Integer[] x) {
	this.name = name;
	File file = new File(name);
	
	if (!file.exists()) {							// we check if a file still exists
      try {											// if the file exists, the file will be override
		file.createNewFile();
	} catch (IOException e) {
		e.printStackTrace();
	}
      
	}
	
	
	try {
	    f = new RandomAccessFile(name, "rw");		
	    
	    for (int i = 0; i < x.length; i++) {
		try {
		    f.writeInt(x[i]);					 // Fuellen der Datei mit objekten aus dem Integer array
		} catch (IOException e) {

		    e.printStackTrace();
		}
	    }

	} catch (FileNotFoundException e) {
	    System.out.println("Datei nicht gefunden");
	}
	

    }

    /**
     * Setzt die Position an die man im Array springen moechte. Vergleichbar mit
     * array[stelle]
     * 
     * @param stelle
     *            Stelle an die man im Array springen moechte
     */
    
    public void setPos(int stelle) {				
	if(stelle > this.getAnzahl())					// the point must not exceed the array length 
	    throw new ArrayIndexOutOfBoundsException();
	this.pos = stelle * 4;							// to determine the position, we have to multiply it with 4 
													// because 4 bytes in a file are one position in an array 
    }
    
    
 
    
    /**
     * Returns the actual element of the array
     * 
     * @return das aktuelle Element
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    
    public int elem() {
	try {
	    f.seek(pos);		// set the pointer of the file on the actual position in the array
	} catch (IOException e) {
	    System.out.println("Position nicht gefunden");

	}

	try {
	    return f.readInt();		// read the actual elemt and return it
	} catch (IOException e) {
	    System.out.println("Fehler");
	    return 0;

	}

    }

    /**
     * override the actual elemt
     * 
     * @param neu
     *            neuer Wert
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    public void change(Integer neu) {
	try {
		 f.seek(pos);
	    f.writeInt(neu);		// the actual element will be overwritten
	} catch (IOException e) {
	    System.out.println("Fehler!");
	}

    }
    


    /**
     * Gibt die Anzahl der Elemente des Arrays zurueck
     * 
     * @return Anzahl der Elemente
     * 
     * @throws IOException
     *             if an I/O error occurs
     * 
     */
    public long getAnzahl() {

	try {
	    long anzbytes = f.length();		//  safe the length of the file
	    long anz = anzbytes / 4;		// divided with 4, because of 4 positions
	    return anz;						// to get the number  
	} catch (IOException e) {
	    return -1;						
	    
	}

    }

    /**
     * Close the file
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    public void close() {
	try {
	    f.close();					// file wird  endgültig geschlossen
	} catch (IOException e) {
	    System.out.println("Schliessen hat nicht funktioniert. Bitte erneut versuchen!");
	    e.printStackTrace();
	}
    }

}
