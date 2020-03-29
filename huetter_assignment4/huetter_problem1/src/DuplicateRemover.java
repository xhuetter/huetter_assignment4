import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.HashSet;

public class DuplicateRemover 
{
	private Set<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile)
	{
		String currentWord;
		try (Scanner input = new Scanner(Paths.get(dataFile)))
		{
			while (input.hasNext())
			{
				currentWord = input.next().toLowerCase();
				uniqueWords.add(currentWord);
			}
			input.close();
		}
		catch (IOException | IllegalStateException ex)
		{
			System.out.println("There was an exception thrown during the remove function. Please try again. :)");
			System.exit(-1);
		}
	}
	
	public void write(String outputFile)
	{
		try (Formatter output = new Formatter(outputFile))
		{
			for (String i : uniqueWords)
			{
				output.format("%s \n", i);
			}
			output.close();
		}
		catch (FileNotFoundException | FormatterClosedException ex)
		{
			System.out.println("There was an exception thrown during the write function. Please try again. :)");
			System.exit(-1);
		}
	}
}
