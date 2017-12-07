import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ForcedCards {

	private static int[] bestPlay(int[] deck) throws IOException {
		int[] answer = new int[3];

        int startPoint = 0;
        int endPoint = 0;
        int totalValue = 0;

        String [] readFile = new String[1000];
        int maxIndx = -1;

        /*
		 * Insert your code in here
		 *
		 * Your code should construct and return an array of length 3, where the 
		 * first number indicates the best starting point, the second number indicates
		 * the best end point, and the third number is the total value.
		 *
		 */

        Scanner bs666 = new Scanner(new File("01.in"));
        while(bs666.hasNext())
        {
            maxIndx++;
            readFile[maxIndx] = bs666.nextLine();
        }

        int [] readFileNum = new int[maxIndx];

        for(int j = 0; j < maxIndx; j++)
        {
            if(j == 9)
            {
                readFileNum[9] = 0;
                j++;
            }
            readFileNum[j] = Integer.parseInt(readFile[j]);
        }

        for(int i = 0; i < maxIndx; i++)
        {
            if(readFileNum[i] >= 0)
            {
                totalValue += readFileNum[i];
            }
            else if(readFileNum[i] < 0)
            {
                if(readFileNum[i] + readFileNum[i + 1] > 0)
                {
                    totalValue += readFileNum[i];
                }
                else if(readFileNum[i] + readFileNum[i + 1] <= 0)
                {
                    endPoint = i;
                    break;
                }
            }
        }

		/* End */

        answer[0] = startPoint;
        answer[1] = endPoint;
        answer[2] = totalValue;

        return answer;
	}


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();

		for (int testCase=0; testCase < numOfTestCases; testCase++)
		{
			int numOfCards = sc.nextInt();
			int[] cards = new int[numOfCards];
			for (int i=0; i<numOfCards; i++)
            {
				cards[i] = sc.nextInt();
			}

			int[] results = bestPlay(cards);        
			System.out.println(
					"Start/Stop/Value: " + 
					results[0]+"/"+results[1]+"/"+results[2]
					);
		}

		sc.close();
	}
}