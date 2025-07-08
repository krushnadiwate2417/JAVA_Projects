import java.util.Scanner;

class QuestionService{
    Question[] questions = new Question[5];
     int score = 0;

    public QuestionService(){
        questions[0] = new Question(1, "Size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "Size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "Size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "Size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "Size of boolean", "1", "2", "4", "8", "1");
    }

    public void displayAllQuestions(){
        for(Question q : questions){
            System.out.println("\n===============\n" + q.toString() + "\n===============\n");
        }
    }

    public void playQuiz(){
        Scanner scanner = new Scanner(System.in);
        for(Question q : questions){
            System.out.println("\n===============\n" + q.displayQuestions() + "\n===============\n");
            System.out.println("Enter Your Answer : ");
            String ans = scanner.nextLine();

            if(q.getAns().equals(ans)){
                this.score = this.score + 1;
            }else{
                System.out.println("Wrong, The Right Answer is : " + q.getAns());
            }
            
        }
        System.out.println("Your Score is : "+this.score);
        scanner.close();
    }

}