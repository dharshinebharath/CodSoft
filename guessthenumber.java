package dharshine;
import java.util.*;
public class guessthenumber {
	
public static void main(String []args)
{
	guessthenumber gtn=new guessthenumber();
	gtn.guess();
	
	
}
static void guess()

{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter your name:");
	String name=sc.next().toUpperCase();
	int min=1;
	
	int max=100;
	int score=0;
	Random r=new Random();
	
	int gen_num=r.nextInt(max-min+1)+min;
	
	boolean stop=true;
	while(stop)
	{
		
		int maxatmpt=10;
		
		System.out.println("HELLO "+name);
		System.out.println("I've generated a random number between "+min+" and "+max +" Try to guess it");
		int atmpt=0;
		while(maxatmpt>atmpt)
			
		{
			
			System.out.println("enter your guess:");

			int guess_num=sc.nextInt(); 
			if(guess_num==gen_num)
			{
				
				System.out.println("Wow!! You guessed the generated number is "+gen_num+" in "+atmpt+" attempts");
				score=score+(atmpt*10);
				System.out.println("Score : "+ score);
				
				
				break;
			}
			else if(guess_num<gen_num)
			{
				System.out.println("Your guess is low. Try again!");
				
				int attempt=maxatmpt-atmpt-1;
				System.out.println("Attempts left : "+attempt);
			}
			else if(guess_num>gen_num)
			{
				System.out.println("Your guess is high. Try again!");
				int attempt=maxatmpt-atmpt-1;
				System.out.println("Attempts left : "+attempt);
			}
			atmpt++;
		}
		if(atmpt==maxatmpt)
		{
			System.out.println("Sorry no more attempts.Try again!");
			
			
		}
		System.out.println("Would you like to play again!(yes/no)");
		Scanner in=new Scanner(System.in);
		String ans=in.nextLine().toLowerCase();
		if(ans.equals("yes"))
		{
			stop=true;
		}
		else
		{
			stop=false;
		}
		
		
	}
	
	
}
}
