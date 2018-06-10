package PatternDateisystem;

import java.awt.List;
import java.io.File;

import LOL.DirectoryVisitor;

/**
 * @author Timo
 *
 */
public class FilePattern {
	private File wurzel;
	static List dateien = new List();

	/**
	 * Erzeugt ein neues Filepatter mit einem übergebenen File als Wurzel
	 * 
	 * @param wurzel
	 */
	public FilePattern(File wurzel) {
		if (!wurzel.exists()) {
			throw new IllegalArgumentException();
		}
		this.wurzel = wurzel;
	}

	/**
	 * Accept Methode, die mit Hilfe eines übergebenen DirectoryVisitors ein
	 * Verzeichnis besucht
	 * 
	 * @param v
	 *            Directory Visitor
	 */
	public void accept(DirectoryVisitor v) {
		// Wenn die wurzel ein Ordner ist, werden die Unterdateien einzeln
		// durchlaufen
		if (wurzel.isDirectory()) {
			for (File f : wurzel.listFiles()) {
				// Jedes Unterfile wird in der Methode durchlauf aufgerufen
				durchlauf(f, v);
			}

		} else {
			// Falls die Wurzel eine Datei ist, wird ein mal Visit File
			// aufgerufen und das Programm ist beendet
			//speichern den Pfad der Datei die durchsucht werden muss in dateien
			dateien.add(wurzel.getPath());
			v.visitFile(wurzel);
		}
	}

	/**
	 * Durchläuft die Unterverzeichnisse mit Hilfe des Directory Visitors und
	 * eines aktuellen Files
	 * 
	 * @param now
	 *            akt. File
	 * @param v
	 *            Directory Visitor
	 * @return
	 */
	private int durchlauf(File now, DirectoryVisitor v) {
		// Falls aktuelle Datei nicht gelesen werden kann, wird Fehler
		// aufgerufen
		if (!now.canRead()) {
			return v.fehler(now);
		}
		// Falls es sich bei dem akt. Element um ein Verzeichnis handelt,wird
		// zunächst das aktuelle Element ausgegeben
		// und dann werden die Unterfiles erneut
		// gelistet und jedes erneut rekursiv mit durchlauf überprüft
		if (now.isDirectory()) {

			int rek = v.erstesAnzeigenVorRek(now);

			if (rek == 1) {
				File[] z = now.listFiles();

				System.out.println();
				for (File f : z) {
					// Falls bei einem durhclaufenen Unterverzeichnisse ein
					// Fehler auftritt,
					// Soll direkt minus -1 zurück gegeben werden
					if (durchlauf(f, v) == -1)
						return -1;

				}
				// sorgt nur dafür, dass bei der Ausgabe der String wieder
				// gekürzt wird, damit es vernünftig eingerückt ist
				rek = v.anzeigeFallsRek();
				System.out.println();
			}
			if (rek == -1 || rek == 0) {
				return rek;
			}
		} else {
			// Falls es sich bei dem besuchten Objekt um ein File handelt, wird
			// visitFile aufgerufen
			// und wie oben schon der dateipfad gespeichert
			// Rekursionsanker
			dateien.add(now.getPath());
			return v.visitFile(now);

		}
		return 0;

	}
}
