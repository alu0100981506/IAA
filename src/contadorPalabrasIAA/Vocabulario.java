package contadorPalabrasIAA;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vocabulario {

	public Vocabulario() {
		
	}
	
	public void vocab(String input) {
		
		List<String> voca = new ArrayList<String>();

		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader("CorpusTodo.txt"));
			String line[];
			while (in.ready()) {
				line = in.readLine().toLowerCase().split("(\\s+|[^\\x00-\\x7F])+");
				for (String palabra : line) {
					Pattern p = Pattern.compile("[^A-Za-z0-9.@_-~#:/]+");
					Matcher m = p.matcher(palabra);
					if (!m.find()) {
						palabra = palabra.replaceAll("^'|\\!|\\?|\"|[~|.,;:)(+-]|w/", "");
						if (!voca.contains(palabra))
							voca.add(palabra);
					}
				}
			}
			
			voca.remove("");
			voca.sort(null);
			in.close();
			out = new BufferedWriter(new FileWriter("Vocabulario.txt"));
			out.write("Numero de palabras: " + voca.size() + "\n");
			for (String palabra : voca) {
				out.write("Palabra: " + palabra + "\n");
			}

			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	public void aprendizaje(String input) {
		try {
			TreeMap<String, Integer> mapa = new TreeMap<String, Integer>();

			BufferedReader in = new BufferedReader(new FileReader(input));
			
			String line[];
			while (in.ready()) {
				line = in.readLine().toLowerCase().split("(\\s+|[^\\x00-\\x7F])+");
				for (String palabra : line) {
					Pattern p = Pattern.compile("[a-z0-9.@_-~#:/]+");
					Matcher m = p.matcher(palabra);
					if (!m.find()) {
						palabra = palabra.replaceAll("^'|\\!|\\?|\"|[~|.,;:)(+-]|w/", "");
						// if (!vocabulario.contains(palabra))
						// vocabulario.add(palabra);
					}
				}
			}

		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		Vocabulario vo = new Vocabulario();
		
		vo.vocab("CorpusTodo.txt");
		
		
		
	}

}
