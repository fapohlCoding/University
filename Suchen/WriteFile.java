package Suchen;

import java.io.*;

class WriteFile
{
  public static void main(String[] args) throws IOException
  {
    FileWriter fw = new FileWriter("ausgabe.txt");
    BufferedWriter bw = new BufferedWriter(fw);

    bw.write("Die Blockchain erfreut sich immer gr��erer Beliebtheit. So konnte man bei Banken und Finanzinstituten eine ");
    bw.write("\n");
    bw.write("Budget-Erh�hung von 1,7 Milliarden US-Dollar f�r ebenjene Technologie warnte. Die Tochtergesellschaft");
    bw.write("\n");
    bw.write("des s�dkoreanischen Messenger-Marktf�hrers Kakao, Ground X, will die Blockchain f�r die ");
    bw.write("\n");
    bw.write("L�sung humanit�rer Probleme nutzen. In Abu Dhabi plant die erste B�rse den Einsatz der Blockchain, ");
    bw.write("\n");
    bw.write("um Transaktionen zu optimieren und die Sicherheit zu erh�hen. Das weltweite ");
    bw.write("\n");
    bw.write("Interesse unterschiedlichster Sektoren an der Blockchain l�sst sich mit den sie ");
    bw.write("\n");
    bw.write("auszeichnenden Eigenschaften erkl�ren. So ist sie f�r jeden jederzeit einsehbar,");
    bw.write("\n");
    bw.write("kann weder zentral �berwacht noch nachtr�glich ver�ndert werden. ");
    bw.write("\n");
    bw.write("Diese Unver�nderlichkeit will der US-Bundesstaat nun gesetzlich festhalten.");

   



    bw.close();
  }
}