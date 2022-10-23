import java.util.Scanner;

public class CoepoeWordPuzzle{

    //Deklarasi variabel Global
    private static Scanner sc = new Scanner(System.in); 

    public static void main(String[] args){
        String ulang="n";

        System.out.println("Coepoe Word Puzzle");
        System.out.println("===================\n");

        System.out.println("Rules :");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters.");
        System.out.println("2. Each level, You have 10 chances to answer correctly.");
        System.out.println("3. To get through to next level, you have to score 70 ponts each level.");
        
        do{
            int[] score = {0,0,0};
            int finalScore = 0;
            
            for(int idx = 0; idx<3; idx++){
                switch(idx+1){
                    case 1:
                        score[idx] = level1();
                        break;
                    case 2:
                        score[idx] = level2();
                        break;
                    case 3:
                        score[idx] = level3();
                        break;
                }

                if(score[idx]>=70){
                    finalScore = finalScore+score[idx];

                    if((idx+1) == 3){
                        System.out.println("\n\nOverall score : "+finalScore);
                        System.out.println("You Win!!");
                        System.out.print("Press ENTER to exit");
                        sc.nextLine();
                        ulang = "t";
                    }
                    
                }else{
                    System.out.println("\nYou Lose!! Try Again..");
                    System.out.println("Do you want to retry [y/t] : ");
                    ulang = sc.nextLine();
                    break;
                }
            }

        }while(ulang.equalsIgnoreCase("y"));

    }


    //METHOD LEVEL 1
    private static int level1(){
        String[] correctAnswer;
        int score = 0;

        correctAnswer = new String[]
        {"die", "led", "lei", "let", "lid", "lie", "lit", "tie", "deli", "diet",
        "edit", "idle", "lied", "tide", "tied", "tile", "tilt", "tilde", "tiled", "title",
        "tilted", "titled"};

        System.out.println("\nLevel 1");
        System.out.println("----------");
        System.out.println("\t\t d \t e \t t \t t \t l \t i");

        score = inputAnswer(correctAnswer);
    
        return score;
    }


    //METHOD LEVEL 2
    private static int level2(){
        String[] correctAnswer;
        int score = 0;

        correctAnswer = new String[]
        {"ace", "can", "ean", "eas", "sec", "see", "sea", "cane", "scan",
        "case", "seen", "ease", "cane", "cans", "scene", "scena", "canes", "acnes", "cease",
        "encase", "seance"
        };

        System.out.println("\n\nLevel 2");
        System.out.println("----------");
        System.out.println("\t\t s \t e \t c \t a \t e \t n");

        score = inputAnswer(correctAnswer);
    
        return score;
    }


    //METHOD LEVEL 3
    private static int level3(){
        String[] correctAnswer;
        int score = 0;

        correctAnswer = new String[]
        {"roe", "ore", "her", "hen", "one", "hoe", "eon", "hero", "horn", "kern",
        "honk", "hoke", "hone", "heron", "honker"
        };

        System.out.println("\n\nLevel 3");
        System.out.println("----------");
        System.out.println("\t\t h \t k \t r \t n \t e \t o");

        score = inputAnswer(correctAnswer);

        return score;
    }


    //METHOD INPUT JAWABAN
    private static int inputAnswer(String[] correctAnswer){
        String[] answer;
        String tempAnswer;
        int score=0;
        
        answer = new String[10];

        for(int chances=0; chances<10; chances++){

            do{
                do{
                    System.out.print((chances+1)+"> Your Answer : ");
                    tempAnswer = sc.nextLine();
                    if(tempAnswer.length()<3 || tempAnswer.length()>6){
                        System.out.println("--> Words must have 3 - 6 characters");
                    }
                }while(tempAnswer.length()<3 || tempAnswer.length()>6);
                
                if(isDuplicate(answer, tempAnswer)){
                    System.out.println("--> You had already type this word before..");
                }
            }while(isDuplicate(answer, tempAnswer));

            if(answerIsCorrect(correctAnswer, tempAnswer)){
                answer[chances]=tempAnswer;
                score = score+10;
                System.out.println("#Right. Score : "+score);
            }
        }

        //MENAMPILKAN JAWABAN BENAR
        if(score >= 70){
            
            System.out.println("\nYou had answered 10 times with "+ (score/10) +" right answers");
                    
            System.out.println("\nCorrect Answers :");
            for(int x = 0; x<correctAnswer.length;x++){
                System.out.print(correctAnswer[x]+"\t");
                if(x!=0 && (x+1)%10==0){
                    System.out.print("\n");
                }
            }
        }

        return score;
    }


    //METHOD CEK JAWABAN BERULANG
    private static boolean isDuplicate(String[] allAnswer, String answer){
        for(int x=0; x<allAnswer.length; x++){
            if(allAnswer[x] == null){
                continue;
            }else{
                if(allAnswer[x].equalsIgnoreCase(answer)){
                    return true;
                }
            }
        }
        return false;
    }


    //METHOD CEK JAWABAN BENAR/SALAH
    private static boolean answerIsCorrect(String[] correctAnswer, String answer){
        for(int x=0; x<correctAnswer.length; x++){
            if(correctAnswer[x].equalsIgnoreCase(answer)){
                return true;
            }
        }
        return false;
    }
}