
public class Application 
{

	public static void main(String[] args)
	{
		DuplicateCounter dc = new DuplicateCounter();
		dc.count("problem2.txt");
		dc.write("unique_word_counts.txt");
	}
	
}
