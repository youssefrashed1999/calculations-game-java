import java.util.Scanner;
import java.util.Arrays;
public class GameEnhancedFinal
{
	static public void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int noOfPlayers,noOfQuestions,num1,num2,answer,remainder,playerscore=0,playertime,questionType,questionType1,index=0;
		String playerTotalResult="";
		long endTime,startTime;
		//getting number of players from the user
		System.out.print("Enter no of players : ");
		noOfPlayers=scan.nextInt();
		//check for errors
		noOfPlayers=Methods.checkForError(noOfPlayers,1,"Enter no of players : ");
		//declairing arrays to store players' names and scores
		int[] totalscore=new int[noOfPlayers*2];
		String[] names=new String[noOfPlayers];
		//getting players' names
		String enter=scan.nextLine();
		System.out.println("Enter players' names");
		for(int i=0;i<noOfPlayers;i++)
		{
			System.out.print("Player no("+(i+1)+") : ");
			names[i]=scan.nextLine();
		}
		//getting number of questions from the user
		System.out.print("Enter no of questions : ");
		noOfQuestions=scan.nextInt();
		//checking for any wrong input
		noOfQuestions=Methods.checkForError(noOfQuestions,1,"Enter no of questions : ");
		//getting the type of questions from the user
		questionType=Methods.getQuestionType();
		questionType1=questionType;
		for(int i=1;i<=noOfPlayers;i++)
		{
			System.out.println("\n"+names[i-1]+" Questions :");
			Methods.delay();
			startTime=System.currentTimeMillis();
			for(int j=1;j<=noOfQuestions;j++)
			{
				//generating two random numbers
				num1=(int)(Math.random()*10);
				num2=(int)(Math.random()*10);
				//swaping if num1 < num2
				if(num1<num2)
				{
					num1=num1+num2;
					num2=num1-num2;
					num1=num1-num2;
				}
				//if the user want random questions
				if(questionType1==5)
				{
					questionType=(int)(1+Math.random()*4);
				}
				switch(questionType)
				{
					case 1:	//displaying question
						System.out.print(num1+" + "+num2+" = ");
						//getting answer from user
						answer=scan.nextInt();
						//checking user's answer
						if(answer==(num1+num2))
						{
							System.out.println("Correct!");
							playerscore++;
							playerTotalResult=(playerTotalResult+num1+" + "+num2+" = "+answer+" Correct$");
						}
						else
						{
							System.out.println("Wrong!");
							System.out.println(num1+" + "+num2+" should equal "+(num1+num2));
							playerTotalResult=(playerTotalResult+num1+" + "+num2+" = "+answer+" false$");
						}
						break;

					case 2:	//displaying question
						System.out.print(num1+" - "+num2+" = ");
						//getting answer from user
						answer=scan.nextInt();
						//checking user's answer
						if(answer==(num1-num2))
						{
							System.out.println("Correct!");
							playerscore++;
							playerTotalResult=(playerTotalResult+num1+" - "+num2+" = "+answer+" Correct$");
						}
						else
						{
							System.out.println("Wrong!");
							System.out.println(num1+" + "+num2+" should equal "+(num1-num2));
							playerTotalResult=(playerTotalResult+num1+" - "+num2+" = "+answer+" false$");
						}
						break;

					case 3:	//displaying question
						System.out.print(num1+" * "+num2+" = ");
						//getting answer from user
						answer=scan.nextInt();
						//checking user's answer
						if(answer==(num1*num2))
						{
							System.out.println("Correct!");
							playerscore++;
							playerTotalResult=(playerTotalResult+num1+" * "+num2+" = "+answer+" Correct$");
						}
						else
						{
							System.out.println("Wrong!");
							System.out.println(num1+" * "+num2+" should equal "+(num1*num2));
							playerTotalResult=(playerTotalResult+num1+" * "+num2+" = "+answer+" false$");
						}
						break;
					case 4:	//if the denominator equals zero then generate another number from one to (numerator-1)
						if(num2==0)
						{
							num2=(int)(1+Math.random()*(num1));
						}
						//displaying question
						System.out.print(num1+" / "+num2+" = ");
						//getting answer from user
						answer=scan.nextInt();
						remainder=scan.nextInt();
						//checking user's answer
						if(answer==(num1/num2) && remainder==(num1%num2))
						{
							System.out.println("Correct!");
							playerscore++;
							playerTotalResult=(playerTotalResult+num1+" * "+num2+" = "+answer+" R "+remainder+" Correct$");
						}
						else
						{
							System.out.println("Wrong!");
							System.out.println(num1+" * "+num2+" should equal "+(num1/num2)+" R "+(num1%num2));
							playerTotalResult=(playerTotalResult+num1+" * "+num2+" = "+answer+" R "+remainder+" false$");
						}
						break;
				}
			}
			//displaying player results
			endTime=System.currentTimeMillis();
			playertime=(int)((endTime-startTime)/1000);
			System.out.println("\n\nYou scored "+playerscore+" out of "+noOfQuestions);
			System.out.println("Your time is "+playertime+" sec");
			//displaying all player's questions and answers
			Methods.displayAnswers(noOfQuestions,playerTotalResult);
			//saving player results
			totalscore[index]=playerscore;
			totalscore[index+1]=playertime;
			//reset j and player score and playerTotalResult
			playerscore=0;
			playerTotalResult="";
			index+=2;
		}
	//sorting and ranking players
	Methods.rankArray(totalscore,names,noOfPlayers);
	}
}



