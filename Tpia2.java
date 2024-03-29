/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package l.tpia2;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author welcome
 */
public class Tpia2 {
    
    //######################_Variables_######################
	static int  Box[] = {1,2,3,4,5,6,7,8,0};
	static int  Width=3,i,Counter=0;
	static int Unmatch=0,Iteration=1,Void=-1,IterationDouble=1,j,Loop;
	static int MinUnmatch;
	
	static Integer NewBox[]= {1,2,3,5,6,7,8,4,0};
	static int SurvivedBox[] = new int[9] ;
	static int BeforeSurvivedBox[]= new int[9] ;
	//#######################################################
	
	

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        System.out.println("----------------------------Box----------------------------");
			System.out.print("\n________________________________________________\n");
			for (i =0;i<9;i++)
			{
				
				if(Counter==Width)
				{
				System.out.print("\n________________+_______________+_______________+\n");
				Counter=0;
				}
				if(Box[i]!=0)
				{
				System.out.print("	"+Box[i]+"	|");
				}
				else
				{
					System.out.print("	"+" "+"	|");	
				}
				
				Counter++;
			}
			System.out.print("\n________________+_______________+_______________+\n");
			System.out.println("\n-----------------------------------------------------------");
			
			System.out.println("----------------------------Random_Box---------------------");
//-----------------------------------------------------------------------Random Shuffle------------------------------------------------------------------
			
			/*for(int j=0;j<NewBox.length;j++)
			{
				NewBox[j]=j;
				
			}
			Collections.shuffle(Arrays.asList(NewBox));*/
		
			Counter =0;
			PrintBox();
			
			System.out.println("\n-----------------------------------------------------------");
			
//------------------------------------------------------------------Check/FindVoid--------------------------------------------------------------------
			Check();
			FindVoid();
//--------------------------------------------------------------------------------------------------------------------------------------------------
			System.out.println("Void: "+ Void);
			System.out.println("Unmatches: "+Unmatch);
						
			if(Unmatch==0)
			{
				System.out.println("Box Is Already Fixed");
				
			}
			else
			{
				while(Iteration!=100&&Unmatch!=0)
				{
					System.out.println("\n####################Iteration N°"+ (Iteration) +"####################");
					Swap();
					
				}
			}
}
		
		
		
		
		
		
		
//				     											   #### Functions ####
//--------------------------------------------------------------------Possibilities------------------------------------------------------------------
		public static void Swap()
{		
			if(Iteration>1)		// Refreshes the NewBox To The Survived Box So It Works With The Survived Box Iteration
			{
				FindVoid();
				int j=0;
				for (i=0;i<9;i++)
				{
					NewBox[i]=SurvivedBox[j];
					j++;
				}	
				
			}

			FindVoid();
			Integer SavedBox[]=Arrays.copyOf(NewBox, NewBox.length); 	// Initial Copy Of NewBox
			MinUnmatch=10;
			
			    //--------------Void In Top Left Corner----------
				if (Void==0)			
				{
					// Switch From Right
					SwitchFromRight();
					//Switch From Below
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromBelow();	
				}
				//---------------Void In Top Mid Corner-------------
				if (Void==1)			
				{
					// Switch From Right
					SwitchFromRight();
					//Switch From Below
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromLeft();	
					//Switch From Below
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromBelow();
				}
				//-----------Void In Top Right Corner-------------
				else if (Void==2) 
				{// Switch From Left					
					SwitchFromLeft();
					//Switch From Below
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromBelow();
				}
				// ---------------Void In Mid Left ----------------	
				else if (Void==3)		
				{
				    // Switch From Right					
					SwitchFromRight();
					//Switch From Top
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromAbove();		
					//Switch From Below
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromBelow();
				// ---------------Void In Mid ----------------		
				}
				else if (Void==4)		
				{
				    // Switch From Right					
					SwitchFromRight();
					//Switch From Left
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromLeft();	
					//Switch From Top
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromAbove();		
					//Switch From Below
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromBelow();
				// ---------------Void In Mid Right----------------	
				}
				else if (Void==5) 
				{
					// Switch From Left					
					SwitchFromLeft();
					//Switch From Top
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromAbove();	
					//Switch From Below
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromBelow();
				}
				// ---------------Void In Bottom left----------------
				else if (Void==6)	  
				{
				    // Switch From Right
					SwitchFromRight();
					//Switch From Top
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromAbove();		
					
				}
				// ---------------Void In Bottom Mid----------------
				else if (Void==7)	  
				{
				    // Switch From Right
					SwitchFromRight();
					//Switch From Left
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromLeft();	
					//Switch From Top
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromAbove();		
					
				}
				
				// ---------------Void In Bottom Right Corner----------------
				else if (Void==8)	
				{
					// Switch From Left					
					SwitchFromLeft();
					//Switch From Top
					NewBox = Arrays.copyOf(SavedBox, SavedBox.length); 	// Initial Copy Of NewBox
					SwitchFromAbove();	
				}
				
//________________________________________________________________________________________________________________________________________
				
				System.out.print("||||||||||||||||||||||||||||||Survived||||||||||||||||||||||||||");
				
				for(int j=0;j<SurvivedBox.length;j++)
				{
					if(Counter==Width)
					{
						System.out.print("\n________________+_______________+_______________+\n");
					Counter=0;
					}
					if(SurvivedBox[j]!=0)
					{
					System.out.print("	"+SurvivedBox[j]+"	|");
					}
					else
					{
						System.out.print("	"+" "+"	|");	
					}
					Counter++;
				}
				System.out.print("\n________________+_______________+_______________+\n");
				System.out.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				Iteration++; 			// Iteration Number
				IterationDouble++;
				System.out.println("\nIterationDouble:"+IterationDouble);
				System.out.println("\n_________________");
				
				for(int j=0;j<BeforeSurvivedBox.length;j++)
				{
					if(Counter==Width)
					{
					System.out.println();
					Counter=0;
					}
					System.out.print(BeforeSurvivedBox[j]+"|");
					Counter++;
				}
}
//--------------------------------------- Check -------------------------------------	
		public static void Check()
		{
			Unmatch=0;
		    
			for(i=0;i<9;i++)
			{
				if (Box[i]!=NewBox[i])
				{
					Unmatch++;			// Counts The Unmatches
				}	
				
			}
			System.out.println("-------------------------");
			System.out.println("Unmatch :"+Unmatch);
			
			j=0;
			if(IterationDouble==2)		// This Saves The Survived Box 2 steps Back So I Can Check If They Are The Same
			{
				for(i=0;i<9;i++)
				{
					BeforeSurvivedBox[i]=SurvivedBox[j];
					j++;
				}
				IterationDouble=0;
			}
			
			Loop=0;
			for (i=0;i<9;i++)
			{
				if (BeforeSurvivedBox[i]==NewBox[i])			// So It Doesnt Loop Back To The First State (Loop Breaker)
				{
					Loop++;			// Counts The Unmatches
				}
			}
			System.out.println("Loop :"+Loop);
			System.out.println("-------------------------");
			
			
			
if(MinUnmatch>Unmatch&&Loop!=9)			// Takes The Least Amount Of Unmatches 
				{
				
					MinUnmatch = Unmatch;		
					System.out.println("MinUnmatch :"+MinUnmatch);
					
					int j=0;
					for(i=0;i<9;i++)
					{
						SurvivedBox[i]=NewBox[j];			// Saves The Survived Box 
						j++;
					}
					
					
							
				}
				else if(MinUnmatch==Unmatch)
				{
					Random random = new Random();
					int RandomNum = random.nextInt(2)+1;
					if (RandomNum==1)
					{
						int j=0;
						for(i=0;i<9;i++)
						{
							SurvivedBox[i]=NewBox[j];
							j++;
						}
					}
				}	
		}
//--------------------------------------- FindVoid -------------------------------------			
		public static void FindVoid()
		{
			for(i=0;i<9;i++)
			{
				if(NewBox[i]==0)
				{
					Void = i;
				}
			}
		}
//--------------------------------------- PrintNewBox ----------------------------------
		public static void PrintBox()
		{
			
			for(int j=0;j<NewBox.length;j++)
			{
				if(Counter==Width)
				{
					System.out.print("\n________________+_______________+_______________+\n");
				Counter=0;
				}
				if(NewBox[j]!=0)
				{
				System.out.print("	"+NewBox[j]+"	|");
				}
				else
				{
					System.out.print("	"+" "+"	|");	
				}
				Counter++;
			}
			System.out.print("\n________________+_______________+_______________+\n");
		}
//--------------------------------------- SwitchFromRight ---------------------------
		public static void SwitchFromRight()
		{
			NewBox[Void] = 	NewBox[Void+1];
			NewBox[Void+1]=0;
			PrintBox();
			Check();
		}
//--------------------------------------- SwitchFromLeft ----------------------------
		public static void SwitchFromLeft()
		{
			NewBox[Void] = 	NewBox[Void-1];
			NewBox[Void-1]=0;					
			PrintBox();
			Check();
		}
//--------------------------------------- SwitchFromAbove ---------------------------
		public static void SwitchFromAbove()
		{
			NewBox[Void] = 	NewBox[Void-3];
			NewBox[Void-3]=0;	
			PrintBox();
			Check();
		}
//--------------------------------------- SwitchFromBelow ---------------------------
		public static void SwitchFromBelow()
		{
			NewBox[Void] = 	NewBox[Void+3];
			NewBox[Void+3]=0;
			PrintBox();
			Check();
    }
}
