import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class DuplicateCounter 
{
	private Map<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	public void count(String dataFile)
	{
		String currentWord;
		try (Scanner input = new Scanner(Paths.get(dataFile)))
		{
			while (input.hasNext())
			{
				currentWord = input.next().toLowerCase();
				if (!wordCounter.containsKey(currentWord))
				{
					wordCounter.put(currentWord, 1);
				}
				else
				{
					wordCounter.replace(currentWord, wordCounter.get(currentWord) + 1);
				}
			}
			input.close();
		}
		catch (IOException | IllegalStateException ex)
		{
			System.out.println("There was an exception thrown during the count function. Please try again. :)");
			System.exit(-1);
		}
	}
	
	public void write(String outputFile)
	{
		try (Formatter output = new Formatter(outputFile))
		{
			for (String key : wordCounter.keySet())
			{
				output.format("%s: %d\n", key, wordCounter.get(key));
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
