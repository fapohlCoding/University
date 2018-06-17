package Suchen;

import java.io.*;

class WriteFile
{
  public static void main(String[] args) throws IOException
  {
    FileWriter fw = new FileWriter("ausgabe.txt");
    BufferedWriter bw = new BufferedWriter(fw);

    bw.write("Die Blockchain erfreut sich immer größerer Beliebtheit. So konnte man bei Banken und Finanzinstituten eine ");
    bw.write("\n");
    bw.write("Budget-Erhöhung von 1,7 Milliarden US-Dollar für ebenjene Technologie warnte. Die Tochtergesellschaft");
    bw.write("\n");
    bw.write("des südkoreanischen Messenger-Marktführers Kakao, Ground X, will die Blockchain für die ");
    bw.write("\n");
    bw.write("Lösung humanitärer Probleme nutzen. In Abu Dhabi plant die erste Börse den Einsatz der Blockchain, ");
    bw.write("\n");
    bw.write("um Transaktionen zu optimieren und die Sicherheit zu erhöhen. Das weltweite ");
    bw.write("\n");
    bw.write("Interesse unterschiedlichster Sektoren an der Blockchain lässt sich mit den sie ");
    bw.write("\n");
    bw.write("auszeichnenden Eigenschaften erklären. So ist sie für jeden jederzeit einsehbar,");
    bw.write("\n");
    bw.write("kann weder zentral überwacht noch nachträglich verändert werden. ");
    bw.write("\n");
    bw.write("Diese Unveränderlichkeit will der US-Bundesstaat nun gesetzlich festhalten.");

   



    bw.close();
  }
}