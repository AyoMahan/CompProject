package cmop249lastcensor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class censoring {

	static File source;
	static File destination;
	static File badlist;
	static String censoredString;
	
	
	static void censor(File source, File destination, File badlist) throws IOException {
		
		Scanner scan=new Scanner(source);
		scan=new Scanner(badlist);
		
		String censoredWord1="";//all the words in badlist
		while(scan.hasNextLine()) {
			censoredWord1=censoredWord1.concat(scan.nextLine()+" ");//words to be censored
		}
		
		
		//split the words into array
		System.out.println("the words found in the file badlist are: ");
		String seperateWords[] = censoredWord1.split(" ");
		for(int i=0;i<seperateWords.length;i++) {
			System.out.println(seperateWords[i]);
		}
	
		
		//file content will hold the text in the original file
		String censoredWord="";//wroks with censored word
		String fileContent="";
		scan=new Scanner(source);
		while(scan.hasNextLine()) {
			fileContent=fileContent.concat(scan.nextLine()+" ");
		}
		System.out.println("The sourcefile reads: ");
		System.out.println(fileContent);
		
		for(int i=0;i<seperateWords.length;i++) {
			censoredString=censors(fileContent,seperateWords[0]);
		}
		
		for(int i=0;i<seperateWords.length;i++) {
			censoredString=censors(censoredString,seperateWords[i]);
		}
		System.out.println("The new censored String is: ");
		System.out.println(censoredString);
		
	
		
		//write to new file
		FileWriter writer=new FileWriter(destination);
		writer.write(censoredString);
		
		
		writer.close();
		
	}
	static String censors(String text,String word){//censors method that takes a text and a word and loops through the string to replace the word
			String[] word_list = text.split("\\s+");
			String result = "";
			String stars = "";
			for (int i = 0; i < word.length(); i++)
				stars += '*';

			int index = 0;
			for (String i : word_list){
				if (i.compareTo(word) == 0)
						word_list[index] = stars;
						index++;
					}
			for (String i : word_list)
				result += i + ' ';

			return result;
	}
	
	public static void main(String[] args) throws IOException {
		source=new File("C:\\Users\\Aru Tarunamihardja\\Desktop\\censorText.txt");
		//source file 
		
		destination=new File("C:\\Users\\Aru Tarunamihardja\\Desktop\\censoredText.txt");
		//new text file after censoring
		
		badlist= new File("C:\\Users\\Aru Tarunamihardja\\Desktop\\badList.txt");
		//words to be censored in the source file.
		censor(source,destination,badlist);
		

		
	}
	
	
	
	
	
	
	
}
