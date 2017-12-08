import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ForcedCards {

	private static int[] bestPlay(int[] deck) throws IOException {
		int [] answer = new int[3];

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
            if(readFile[j].equals(""))
            {
                readFileNum[j] = 0;
            }
            else
            {
                readFileNum[j] = Integer.parseInt(readFile[j]);
            }
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

        int test [] = {3, 6, 77, -31, 4, 2};
        ForcedCards act = new ForcedCards();
        act.bestPlay(test);

        int answer [] = new int[3];

        int startPoint = 0;
        int endPoint = 0;
        int totalValue = 0;

        int [] readFileNum = new int[test.length];
        String [] readFile = new String[test.length];

        for(int e = 0; e < test.length; e++)
        {
            readFile[e] = "" + (test[e]);
        }

        for(int j = 0; j < test.length; j++)
        {
            if(readFile[j].equals(""));
            {
                test[j] = 0;
            }
            if(!readFile[j].equals(""))
            {
                test[j] = Integer.parseInt(readFile[j]);
            }
        }

        for(int i = 0; i < test.length; i++)
        {
            if(test[i] >= 0)
            {
                totalValue += test[i];
            }
            else if(test[i] < 0)
            {
                if(test[i] + test[i + 1] > 0)
                {
                    totalValue += test[i];
                }
                else if(test[i] + test[i + 1] <= 0)
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

        System.out.println("Start/Stop/Value: " + answer[0] + "/" + answer[1] + "/" + answer[2]);



        /*
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
		*/
    }
}