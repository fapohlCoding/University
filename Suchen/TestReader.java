package Suchen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestReader {

	/**
	 * @author FabiP
	 * @param args
	 * 
	 */
	public static void main(String []args){
		
		try (
				
				
				FileInputStream filein = new FileInputStream(new File("ausgabe.txt"));
				BufferedReader bufin = new BufferedReader(new InputStreamReader(filein));
				Reader1 read = new Reader1(bufin, args[0]);)
				
//				InputStreamReader ReaderIn = new InputStreamReader(System.in);
//		//	BufferedReader bufin = new BufferedReader(new InputStreamReader(System.in));
//			Reader1 read = new Reader1(ReaderIn, args[0]);
//				)
		{
			String s;
			
			/*
			 * Ausgabe meine Main
			 */
			
			while((s = read.readLine()) != null){
				if (read.getAmountofMatches() > 0){
					System.out.println(read.getAmountofMatches() + "x gefunden in Zeile: " 
							+ read.getLineNumber() + " Text:" + s);
				}
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
}
