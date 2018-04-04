package test;
import  java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.io.*;
public class array {
	static int ko=0,x1=0;
	public static void main(String[] args)throws IOException, InterruptedException {
		
	    Scanner sc=new Scanner(System.in);
		
	    String s1,fr;
		char f;
	    System.out.println("!!!!!!!WELCOME TO PHONEBOOK!!!!!!");
	    System.out.println("\n");
	    System.out.println("DESCRIPTION:");
	    System.out.println("\n");
	    System.out.println("HERE YOU CAN ADD, SEARCH, SAVE, DELETE CONTACTS AND CAN USE IT ACCORDING TO YOUR WILL!!!!!!");
	    System.out.println("\n");
	    while(true)
	    {
		   
	    System.out.println("Press 'e' to continue");
	    char s=sc.next().charAt(0);
	    if(s=='e'||s=='E')
	    { 
	    	
	    	System.out.println("1.ADD    CONTACTS");
	    	System.out.println("2.SHOW   CONTACTS");
	    	System.out.println("3.DELETE CONTACTS");
	    	System.out.println("4.SEARCH CONTACTS");
	    	System.out.println("5.SEARCH CONTACTS BY FIRST ALPHABET");
	        System.out.println("6.EXIT           ");
	        System.out.println("Enter Your Choice\n");
	   
	        int ch=sc.nextInt();
	        
	    switch(ch)
	    {
	    
	     case 1:
	    	 x1=0;
	    	 insert_name();
	    	 while(true)
	    	 {
	         System.out.print("DO YOU WANT TO ENTER MORE CONTACTS Y/N\n");
	    	 char ch1=sc.next().charAt(0);
	    	 if(ch1=='Y'||ch1=='y')
	    	{        
	    		     insert_name();
	    	 }
	    	 else
	    	 {
	    		 
	    	break;
	    	 
	    	 
	    	   }
	    	 
	    	    }
	    	 System.out.println("\n");
	    	 break;
	    case 2:
	    	 print_name();
	    	 System.out.println("\n");
	    	 
	    	 break;
	    case 3:
	    	Delete_Contacts();
	    	System.out.println("\n");
	    	break;
	    case 4:
	    	x1=1;
	    	System.out.println("Enter NAME TO SEARCH\n");
	    	 sc.nextLine();
			 s1=sc.nextLine();
			 Search_Name(s1);
			 System.out.println("\n");
	    	break;
	    case 5:
	    	Search_by_first_alphabet();
	    	System.out.println("\n");
	    	break;
	    case 6:
	    	System.out.println("DO YOU LIKE THIS APPLICATION YES/NO");
	    	f=sc.next().charAt(0);
	    	if(f=='Y'||f=='y')
	    	{
	    	System.out.println("YOUR CONTACTS HAVE BEEN UPDATED AND SAVED SUCCESFULLY");
	    	System.out.println("VISIT AGAIN!!!!!! FOR  ENQUIRY OR UPDATE");
	    	System.out.println("THANK YOU FOR USING THIS APPLICATION");
	    	System.exit(0);
	    	}
	    	else if(f=='N'||f=='n')
	    	{
	    		System.out.println("PLEASE PROVIDE THE AREA TO IMPROVE");
	    		 sc.nextLine();
	    		 fr=sc.nextLine();
	    		 System.out.println("THANK YOU FOR USING THIS APPLICATION!!!!!!! WE WILL GO THROUGH THE IMPROVEMENTS NEEDED");
	    		 System.exit(0);
	    		
	    	}
	    	else
	    	{
	    		System.out.println("THANK YOU FOR USING THIS APPLICATION");
	    		System.exit(0);
	    	}
	    	break;
	    	
	    default:
	    	System.out.println("Sorry Invalid Choice");
	    	break;
	}
	    
	    }
	    else
	    {
	    	System.out.println("YOU HAVE ENTERED A WRONG KEY PLEASE ENTER CORRECT KEY");
	    	
	    }
	     
	   }
	  
	
	}
	public static void insert_name()throws IOException, InterruptedException
	{
		
	    BufferedWriter bf=new BufferedWriter(new FileWriter("NAME.txt",true));
	     BufferedWriter bf1=new BufferedWriter(new FileWriter("NUMBER.txt",true));
	     Scanner sc=new Scanner(System.in);
	     System.out.println("Enter the name");
	     String name=sc.nextLine();
	     int h=Search_Name(name);
	     if(h==1)
	     {
	    	 System.out.println("CONTACT ALREADY EXIST!!!!!!!!!");
	     }
	     else
	     {
	     System.out.println("Enter the number");
	     String num=sc.nextLine();
	     bf.write(name);
	     bf.newLine();
	     bf1.write(num);
	     bf1.newLine();
	     bf.close();
	     bf1.close();
	     }	     
	     
	     
	}
	public static void print_name()throws IOException
	  {  int l=1;
		 BufferedReader bf=new BufferedReader(new FileReader("NAME.txt"));
	     BufferedReader bf1=new BufferedReader(new FileReader("NUMBER.txt"));
	     String b=" ";
	     String b1=" ";
         System.out.println("NAME------->NUMBER");
	     while((b=bf.readLine())!=null&&(b1=bf1.readLine())!=null)
	     {   
	    	 System.out.println(l+".)"+b+"------->"+b1);
	         l++;
	         }
	     
	     
	     }
	public static int Search_Name(String s)throws IOException, InterruptedException
	{   int c=0,c1=0;
		Scanner sc=new Scanner(System.in);
		
		 String a[]=new String[1000];
		 String an[]=new String[1000];
		 BufferedReader bf=new BufferedReader(new FileReader("NAME.txt"));
	     BufferedReader bf1=new BufferedReader(new FileReader("NUMBER.txt"));
	     String b=" ";
	     String b1=" ";
	     int l=0;
	    s.replace(" ","_");
		 
         while((b=bf.readLine())!=null&&(b1=bf1.readLine())!=null)
	     {   
              a[l]=b;
              an[l]=b1;
              l++;
	     }
         if(x1==1)
         {
         System.out.println("SEARCHING FOR CONTACTS");
         for(int i=0;i<=155;i++)
         {
        	System.out.print("#");
        	TimeUnit.MICROSECONDS.sleep(10000);;
         }
         }
         System.out.println("\n");
        for(int i=0;i<l;i++)
        {   
        	a[i].replace(" ", "_");
        	if((a[i].toLowerCase()).compareTo(s.toLowerCase())==0)
        	{   c1=1;
        		break;
        	}
        	c++;
        }
        ko=c;
        if(c1==1)
        {   if(x1==1)
           {
        	System.out.println("FOUND!");
        	System.out.println("HERE ARE THE DETAILS!!!!!!!");
        	System.out.println(a[c].replace("_"," ")+"------------>"+an[c]);
        	
           }
        return 1;
        	
        }
        else
        {   if(x1==1)
            {
        	System.out.println("SORRY! CONTACT NOT FOUND");
            }
        	return 0;
        }
	}
	public static void Delete_Contacts()throws IOException, InterruptedException
	{   Scanner sc=new Scanner(System.in);
		print_name();
        System.out.println("ENTER THE INDEX NO. OF THE ELEMENT YOU WANT TO DELETE");
		int ch=sc.nextInt()-1;
		String a[]=new String[1000];
	    String an[]=new String[1000];
		BufferedReader bf=new BufferedReader(new FileReader("NAME.txt"));
	     BufferedReader bf1=new BufferedReader(new FileReader("NUMBER.txt"));
	     String b=" ";
	     String b1=" ";
	     int l=0;
        while((b=bf.readLine())!=null&&(b1=bf1.readLine())!=null)
	     {   
             a[l]=b;
             an[l]=b1;
             l++;
	     }
        System.out.println("Do You Really Want to delete "+a[ch]+"------->"+an[ch]);
        System.out.println("YES/NO");
        char ch2=sc.next().charAt(0);
        if(ch2=='y'||ch=='Y')
        {System.out.println("DELETING CONTACTS!!!!!");
        for(int i=0;i<=155;i++)
        {
       	System.out.print("*");
       	TimeUnit.MICROSECONDS.sleep(10000);;
        }
        System.out.println("\n");
        for(int i=ch; i<l-1; i++) { 
            a[i] = a[i+1] ;
            an[i]=an[i+1];
        } 
         a[l-1] =null; 
         an[l-1]=null;
         
         BufferedWriter bff=new BufferedWriter(new FileWriter("NAME.txt",false));
	     BufferedWriter bff1=new BufferedWriter(new FileWriter("NUMBER.txt",false));
         for(int i=0;i<l;i++)
         {   if(a[i]!=null&&an[i]!=null)
              {
        	 bff.write(a[i]);
        	 bff.newLine();
        	 bff1.write(an[i]);
        	 bff1.newLine();
                   }
             }
        
         bff.close();
         bff1.close();
         System.out.println("Your Contacts Deleted!!!  UPDATED CONTACTS ARE");
         print_name();
        }
        else
        {   
        	System.out.println("Selected Contact not Deleted!!!!   Your Contacts ARE");
        	print_name();
        
        }
        
    
	}
	public static void Search_by_first_alphabet() throws IOException
	{   Scanner sc=new Scanner(System.in); 
		String a[]=new String[1000];
	     String an[]=new String[1000];
		 BufferedReader bf=new BufferedReader(new FileReader("NAME.txt"));
	     BufferedReader bf1=new BufferedReader(new FileReader("NUMBER.txt"));
	     String b=" ";
	     String b1=" ";
	     int l=0;
         while((b=bf.readLine())!=null&&(b1=bf1.readLine())!=null)
	     {   
              a[l]=b;
              an[l]=b1;
              l++;
	     }
         System.out.println("ENTER THE CHARACTER BY WHICH YOU WANT TO SEARCH");
         
         char ch=sc.next().charAt(0);
         char ch1,ch2;
         int x=0;
         
         for(int i=0;i<l;i++)
         {  ch1=(a[i].toLowerCase().charAt(0));
            ch2=(a[i].toUpperCase().charAt(0));
        	 if((ch==ch1||ch==ch2))
        	 {
        		 System.out.println(a[i]+"---------->"+an[i]);
        		 x=1;
        	 }
        	
         }
         if(x==1)
         {
        	 System.out.println("WORDS STARTING BY LETTER '"+ch+"' IS LISTED ABOVE:");
         }
         if(x!=1)
     	{
     		System.out.println("NO CONTACTS OF LETTER '"+ch+"' WERE FOUND");
     	}
	}
        } 
		
	
	

