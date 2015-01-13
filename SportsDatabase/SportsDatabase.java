//scanner
import java.util.Scanner;

//file reading and writing
import java.io.*;

/**
 * This program is a database that contains information about the MLB. There are 4 fields: Players, Teams, Salaries, Player Efficiency Ratings and Player Points Per Game.
 * The purpose of this program is to present a database to the user(s) that contains this information. Furthermore, the user is able to add records to the program. 
 * They may also delete records of their choice. Both changes can be viewed after re-opening the program. For convenience, records can be sorted by two fields.
 * Lastly,the user can also search for records according to any fields. This database is therefore constantly updating and growing and encourages user input.
 * @author (Krupen Patel) 
 * @version (01/22/13)
 */
public class SportsDatabase
{    
    static int records=0;
    static int totalRows=0;
    public static void main (String args [])throws IOException
    {   
	//scanners
	Scanner sc = new Scanner (System.in);
	Scanner sc1 = new Scanner (System.in);

	System.out.print ('\u000C');//clears screen

	//introduction
	System.out.println ("                                                  Sports Database");
	System.out.println ();
	System.out.println ("Hi, welcome to the Sports Database program.");
	System.out.println ("This database contains a list of sports players with statistics and information.");
	System.out.println ("The player name, team, salary, age, and an important statistic of the player is available in this database.");
	System.out.println ("Take a look at the brightest sports stars and obtain a more detailed insight on them.");
	System.out.println ("");
	System.out.println ("Also, modifying the database to ensure accurate information is strongly encouraged.");
	System.out.println ("This includes adding, deleting, searching, and sorting records.");
	System.out.println ("Follow the program instructions and proceed.");
	System.out.println ();
	System.out.println ("Press and enter any key to continue.");
	sc.nextLine().charAt(0);
	System.out.print ('\u000C');

	String data [][] = new String [30][5]; //2D array (30 rows, 5 columns)

	updateDatabase (data);

	while (true)
	{  
	    System.out.println ("                                                   Database");
	    System.out.println ();

	    //menu
	    System.out.println ("What would you like to do? Please choose the following options (a,b,c,d,e,f)"); //presents user options
	    System.out.println ("a. Add Records");
	    System.out.println ("b. Delete Records");
	    System.out.println ("c. Search Records");
	    System.out.println ("d. Sort Records");
	    System.out.println ("e. View Database");
	    System.out.println ("f. Exit Program");

	    String menuOption = sc.nextLine ();
	    if (menuOption.equalsIgnoreCase ("a"))
	    {   
		System.out.print ('\u000C');
		addData (sc); //procedure that adds records to database

		System.out.println ("Press and enter any key to continue.");
		sc.nextLine().charAt(0);
		System.out.print ('\u000C');

	    }
	    else if (menuOption.equalsIgnoreCase ("b"))
	    {
		System.out.print ('\u000C');
		removeData (sc,sc1,data,records, totalRows); //procedure that deletes records from database
		System.out.println ("Press and enter any key to continue.");
		sc.nextLine().charAt(0);
		System.out.print ('\u000C');

	    }
	    else if (menuOption.equalsIgnoreCase ("c"))
	    {

		System.out.print ('\u000C');
		searchData (sc,sc1,data); //procedure that searches database for records
		System.out.println ("Press and enter any key to continue.");
		sc.nextLine().charAt(0);
		System.out.print ('\u000C');

	    }
	    else if (menuOption.equalsIgnoreCase ("d"))
	    {
		System.out.print ('\u000C');
		sortData (sc,sc1,data); //procedure that sorts database 
		System.out.println ("Press and enter any key to continue.");
		sc.nextLine().charAt(0);
		System.out.print ('\u000C');
	    }
	    else if (menuOption.equalsIgnoreCase ("e"))
	    {
		System.out.println ();
		output (data);//procedure that outputs database
		System.out.println ("Press and enter any key to continue.");
		sc.nextLine().charAt(0);
		System.out.print ('\u000C');

	    }
	    else if (menuOption.equalsIgnoreCase ("f"))
	    {    
		System.out.println ("If you are leaving to view changes to the database, please proceed.");
		System.out.println ();
		System.out.println ("Otherwise,thank you for using my program.");//exiting program message
		System.out.println ("Please do visit the Sports Database at another time.");
		break;
	    }
	    else //validation
	    {
		//invalid entry
		System.out.println ("That is invalid. Please try again.");
		System.out.println ("");
		System.out.println ("Press and enter any key to continue.");
		sc.nextLine().charAt(0);
		System.out.print ('\u000C');
	    }
	}

    }

    public static void updateDatabase (String d [][]) throws IOException // resets static variables
    {
	BufferedReader input = new BufferedReader (new FileReader ("finalprojectdata.txt")); //opens file stream for reading
	int count =0;
	String line = input.readLine ();
	while (line != null) //reads file
	{    
	    for (int y=0; y<5; y++)
	    {
		d[count][y] = line;
		line = input.readLine ();
		records+=1;//counts records

	    }
	    count+=1;//new row

	}
	input.close(); 

	totalRows = records/5;//total number of records in database

    }

    public static void output (String d [][]) //outputs database
    {    
	System.out.println ("   Player Name" + "               " + "         Team Name" + "               " + "    Salary" + "              " + "             Age" + "                         " +      "  Important Stat");  
	System.out.println ("------------------------------------------------------------------------------------------------------------------------------------------------");
	for (int z=0; z<totalRows; z++) //rows
	{
	    for (int p=0; p<5; p++) //columns
	    {
		System.out.print (String.format("%1$-" + 32 + "s", d[z][p])); 
	    }
	    System.out.println ();
	    System.out.println ("------------------------------------------------------------------------------------------------------------------------------------------------");
	}

    }

    public static void addData (Scanner sc)throws IOException //adding records to database
    {   

	PrintWriter o = new PrintWriter (new FileWriter("finalprojectdata.txt",true)); //adds new records to file, opens output stream
	while (true)
	{    
	    System.out.println ("                                                  Sports Database");
	    System.out.println ();

	    System.out.println ("What is the name of the player? (Last name, First name)"); //field one 
	    String  playerName = sc.nextLine ();
	    o.println (playerName);

	    System.out.println ("What is the name of the player`s team?"); //field two
	    String teamName = sc.nextLine ();
	    o.println (teamName);

	    System.out.println ("What is the player's salary?");  //field three
	    String playerSalary = sc.nextLine ();
	    o.println (playerSalary);

	    System.out.println ("What is the player's age?");//field four
	    String playerEfficiency = sc.nextLine ();
	    o.println (playerEfficiency);

	    System.out.println ("List an important statistic for this player.");//field five
	    String pPG = sc.nextLine ();
	    o.println (pPG);

	    //resets variables
	    playerName = "";
	    teamName = "";
	    playerSalary = "";
	    playerEfficiency = "";
	    pPG = "";

	    System.out.println ("Would you like to add more? (y/n)"); 
	    String a = sc.nextLine ();

	    //validation
	    while (true)
	    {
		if (a.equalsIgnoreCase("yes") || a.equalsIgnoreCase ("no") || a.equalsIgnoreCase ("y") || a.equalsIgnoreCase ("n"))
		{  
		    break;                    
		}
		else 
		{
		    System.out.println ("That is invalid. Please enter again.");
		    a = sc.nextLine ();
		    if (a.equalsIgnoreCase("yes") || a.equalsIgnoreCase ("no") || a.equalsIgnoreCase ("y") || a.equalsIgnoreCase ("n"))
		    {
			break;
		    }
		}
	    }

	    if (a.equalsIgnoreCase ("no")|| a.equalsIgnoreCase ("n"))//proceeds to menu
	    {  
		System.out.println ();
		System.out.println ("Your records have successfully been added to the database. You must close the program and re-open it to view them.");
		break;
	    }
	    else 
	    {    
		System.out.print ('\u000C');//clears screen and allows more adding of records
	    }
	}
	o.close(); //closes output stream


    }

    public static void searchData (Scanner sc, Scanner sc1, String d[][])throws IOException //searches database
    {   

	while (true)
	{   
	    System.out.println ("                                                  MLB Database");
	    System.out.println ();
	    boolean flag = false; //boolean condition

	    //user options
	    System.out.println ("Enter the column number to search?");
	    System.out.println ();
	    System.out.println ("Column 0: Player");
	    System.out.println ("Column 1: Team");
	    System.out.println ("Column 2: Salary");
	    System.out.println ("Column 3: Player Age");
	    System.out.println ("Column 4: Player Statistic");
	    System.out.println ();
	    int cNumber = sc1.nextInt (); //field to search in

	    //validation
	    while (true)
	    {
		if (cNumber >=0 && cNumber <=4)
		{
		    break;
		}
		else
		{
		    System.out.println ("This is invalid. Please enter again.");
		    cNumber = sc1.nextInt ();
		    if (cNumber >=0 && cNumber <=4)
		    {
			break;
		    }
		}
	    }

	    System.out.println ();
	    System.out.println ("Enter what to search?"); 
	    String search = sc.nextLine (); //user search entry
	    System.out.println ();
	    System.out.println ("   Player Name" + "               " + "         Team Name" + "               " + "    Age" + "              " + "             Salary" + "                         " +      "     Statistic");  

	    for (int y=0; y<totalRows; y++) //rows
	    {
		for (int x=0; x<5; x++) //columns
		{ 
		    if(search.equals (d[y][cNumber])) //if search item is found
		    {   
			while (true)
			{    
			    flag=true; //boolean condition changed to true
			    int s=y; 
			    int q=0;

			    System.out.print (String.format("%1$-" + 32 + "s", d[s][q])); 
			    q+=1;

			    System.out.print (String.format("%1$-" + 32 + "s", d[s][q])); 
			    q+=1;

			    System.out.print (String.format("%1$-" + 32 + "s", d[s][q])); 
			    q+=1;

			    System.out.print (String.format("%1$-" + 32 + "s", d[s][q])); 
			    q+=1;

			    System.out.print (String.format("%1$-" + 32 + "s", d[s][q])); 
			    System.out.println ();
			    break;

			}
			break;

		    }

		}

	    }

	    if (flag == false ) //search yields no results
	    {
		System.out.println ("The search has found no results.");
	    }

	    System.out.println ();

	    System.out.println ("Would you like to search again? (y/n)");
	    String again = sc.nextLine ();
	    //validation
	    while (true)
	    {
		if (again.equalsIgnoreCase("yes") || again.equalsIgnoreCase ("no") || again.equalsIgnoreCase ("y") || again.equalsIgnoreCase ("n"))
		{
		    break;
		}
		else
		{
		    System.out.println ("That is invalid. Please enter again.");
		    again = sc.nextLine ();
		    if (again.equalsIgnoreCase("yes") || again.equalsIgnoreCase ("no") || again.equalsIgnoreCase ("y") || again.equalsIgnoreCase ("n"))
		    {
			break;
		    }
		}

	    }

	    if (again.equalsIgnoreCase ("no") || again.equalsIgnoreCase ("n"))//proceeds to menu
	    {
		break;
	    }
	    else 
	    {
		System.out.print ('\u000C');//clears screen and searches again
	    }

	}
    }

    public static void removeData (Scanner sc, Scanner sc1, String d[][],int records,int totalRows)throws IOException //removes records
    {   
	while (true)
	{       
	    System.out.println ("                                                  Sports Database");
	    System.out.println ();
	    totalRows=0; //resets static variables
	    records=0;

	    BufferedReader input = new BufferedReader (new FileReader ("finalprojectdata.txt")); //opens file stream for reading
	    int count =0;
	    String line = input.readLine ();
	    while (line != null) //reads file
	    {    
		for (int y=0; y<5; y++)
		{
		    d[count][y] = line;
		    //System.out.println (line + count + y);
		    line = input.readLine ();
		    records+=1;//counts records
		    //remainingRecords-=1;

		}
		count+=1;

	    }
	    input.close(); 

	    totalRows = (records/5);//determine total records

	    //prints out players at each record
	    System.out.println ("Here is a list of all the players at each record.");              
	    for (int x=0; x<totalRows; x++) // displays options (element names)
	    {
		System.out.println (x + "- " + d[x][0]);
	    }

	    int newTotalRows =  totalRows-1;

	    System.out.println ("Which record would you like to remove (enter no. from 0 to " + newTotalRows + ")?");//user removing records range

	    System.out.println ("Please provide the row number.");
	    int rowDel = sc1.nextInt ();

	    //validation
	    while (true)
	    {
		if (rowDel >=0 && rowDel <=newTotalRows)
		{
		    break;
		}
		else
		{
		    System.out.println ("This is invalid. Please enter again.");
		    rowDel = sc1.nextInt ();
		    if (rowDel >=0 && rowDel <=newTotalRows)
		    {
			break;
		    }
		}
	    }

	    PrintWriter o = new PrintWriter (new FileWriter("finalprojectdata.txt")); //output stream
	    //overwrites file data without deleted record of user choice
	    for (int y=0; y<totalRows; y++) //rows
	    {
		for (int x=0; x<5; x++) //columns
		{    
		    if (d[y][x] != (d[rowDel][x]))
		    {
			o.println ((d[y][x]));

		    }
		}

	    }
	    o.close(); //closes output stream

	    System.out.println ("Would you like to remove another record? (y/n)");
	    String yn = sc.nextLine ();

	    //validation
	    while (true)
	    {
		if (yn.equalsIgnoreCase("yes") || yn.equalsIgnoreCase ("no") || yn.equalsIgnoreCase ("y") || yn.equalsIgnoreCase ("n"))
		{
		    break;
		}
		else
		{
		    System.out.println ("That is invalid. Please enter again.");
		    yn = sc.nextLine ();
		    if (yn.equalsIgnoreCase("yes") || yn.equalsIgnoreCase ("no") || yn.equalsIgnoreCase ("y") || yn.equalsIgnoreCase ("n"))
		    {
			break;
		    }
		}

	    }

	    if (yn.equalsIgnoreCase ("no")|| yn.equalsIgnoreCase ("n"))//proceeds to menu
	    {   
		System.out.println ();
		System.out.println ("Your records have been successfully deleted from the database. You must close the program and re-open it to view your changes.");
		break;
	    }
	    else 
	    {
		System.out.print ('\u000C');//clears screen and proceeds back to removing records
	    }
	}

    }

    public static void sortData (Scanner sc,Scanner sc1, String d[][])throws IOException //sorts data by two fields
    {    
	System.out.println ("                                                  Sports Database");
	System.out.println ();

	System.out.println ("Would you like to sort by player name (0) or team name (1)? Please enter 0 or 1.");//user choices
	System.out.println ("The database will sort alphabetically from A-Z according to the field of your choice.");
	int fieldSort = sc1.nextInt();

	//validation
	while (true)
	{
	    if (fieldSort ==0 || fieldSort==1)
	    {
		break;
	    }
	    else
	    {
		System.out.println ("This is invalid. Please enter again.");
		fieldSort = sc1.nextInt ();
		if (fieldSort ==0 || fieldSort ==1)
		{
		    break;
		}
	    }
	}

	System.out.println();

	if(fieldSort == 0)  //player name 
	{   
	    //bubble sort
	    String temp;
	    String temp1;
	    String temp2;
	    String temp3;
	    String temp4;
	    for(int y=0; y<1000; y++)
	    {
		for(int x=0;x<totalRows-1; x++)
		{

		    if(d[x][0].compareTo(d[x+1][0])>0)//swaps values
		    {
			temp = d[x][0];
			temp1 = d[x][1];
			temp2 = d[x][2];
			temp3 = d[x][3];
			temp4 = d[x][4];

			d[x][0] = d[x+1][0];
			d[x][1] = d[x+1][1];
			d[x][2] = d[x+1][2];
			d[x][3] = d[x+1][3];
			d[x][4] = d[x+1][4];

			d[x+1][0] = temp;
			d[x+1][1] = temp1;
			d[x+1][2] = temp2;
			d[x+1][3] = temp3;
			d[x+1][4] = temp4;

		    }
		}
	    }

	    /*
	    PrintWriter o = new PrintWriter (new FileWriter("finalprojectdata.txt")); //opens output stream
	    //overwrites sorted data to file
	    for (int y=0; y<totalRows; y++) //rows
	    {
	    for (int x=0; x<5; x++) //columns
	    {    

	    o.println ((d[y][x]));

	    }

	    }
	    o.close();//closes output stream
	     */
	    System.out.println ("Your data has been sorted by player name alphabetically (A-Z).");
	    System.out.println ("You may proceed to the main menu to view it.");

	}
	else //team name
	{

	    String temps;
	    String temps1;
	    String temps2;
	    String temps3;
	    String temps4;
	    for(int y=0; y<1000; y++)
	    {
		for(int x=0;x<totalRows-1; x++)
		{
		    if(d[x][1].compareTo(d[x+1][1])>0)//swaps values
		    {
			//bubble sort
			temps = d[x][1];
			temps1 = d[x][0];
			temps2 = d[x][2];
			temps3 = d[x][3];
			temps4 = d[x][4];

			d[x][0] = d[x+1][0];
			d[x][1] = d[x+1][1];
			d[x][2] = d[x+1][2];
			d[x][3] = d[x+1][3];
			d[x][4] = d[x+1][4];

			d[x+1][0] = temps1;
			d[x+1][1] = temps;
			d[x+1][2] = temps2;
			d[x+1][3] = temps3;
			d[x+1][4] = temps4;

		    }
		}
	    }
	    /*
	    PrintWriter ot = new PrintWriter (new FileWriter("finalprojectdata.txt")); //opens output stream 
	    for (int y=0; y<totalRows; y++) //rows
	    {
	    for (int x=0; x<5; x++) //columns
	    {    

	    ot.println ((d[y][x]));

	    }

	    }
	    ot.close();//closes output stream
	     */
	    System.out.println ("Your data has been sorted by team name alphabetically (A-Z).");
	    System.out.println ("You may proceed to the main menu to view it.");

	}

    }
}

