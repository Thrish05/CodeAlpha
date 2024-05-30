import java.util.*;
public class student_tracker {
    
    static List<List<Students>> studList = new ArrayList<List<Students>>();

    public static class Students
    {
        public String name;
        public int roll_no;
        public int[] marks;

        public Students(String name, int roll_no, int[] marks)
        {
            this.name = name;
            this.roll_no = roll_no;
            this.marks = marks;
        }

        public void display()
        {
            System.out.print("Name: " + name + " | " + "Roll No: " +  roll_no + " | " + "Marks: ");
            for(int i = 0; i<marks.length; i++)
            {
                System.out.print(marks[i] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void computeAVG(List<List<Students>> myList)
    {
        int count = 1;
        for(List<Students> l : myList)
        {
            for(Students stud : l)
            {
                double totalSum = 0;
                for(int mark : stud.marks)
                {
                    totalSum += mark;
                }
                double avg = totalSum / 4;
                System.out.println("Average of Student " + count + " is " + avg);
                count++;
            }
            
        }
    }
    public static void getHighest(List<List<Students>> myList)
    {
        int[] result = new int[myList.size()];
        Arrays.fill(result, 0);
        int index = 0;
        for(List<Students> l : myList)
        {
            for(Students stud : l)
            {
                for(int i = 0; i<stud.marks.length; i++)
                {
                    if(stud.marks[i] > result[index])
                    {
                        result[index] = stud.marks[i];
                    }
                }
            }
            index++;
        }
        System.out.println("Highest Scores: ");
        for(int i = 0; i<result.length; i++)
        {
            System.out.println("Student " + (i + 1) + "'s highest score: " + result[i] );
        }
    }

    public static void getLowest(List<List<Students>> myList)
    {
        int[] result = new int[myList.size()];
        Arrays.fill(result, 100);
        int index = 0;
        for(List<Students> l : myList)
        {
            for(Students stud : l)
            {
                for(int i = 0; i<stud.marks.length; i++)
                {
                    if(stud.marks[i] < result[index])
                    {
                        result[index] = stud.marks[i];
                    }
                }
            }
            index++;
        }
        System.out.println("Lowest Scores: ");
        for(int i = 0; i<result.length; i++)
        {
            System.out.println("Student " + (i + 1) +"'s lowest score: " + result[i]);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do
        {
            System.out.println("");
            System.out.println("-----------------------STUDENT TRACKER-----------------------");
            System.out.println("Choose one of the following actions: ");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Compute Average");
            System.out.println("4. Get Highest Mark");
            System.out.println("5. Get Lowest Mark");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
    
            switch(choice)
            {
                case 1:
                String c;
                sc.nextLine();
                do {
                    System.out.println("Enter student details or type 'exit' to finish:");
                    System.out.print("Name: ");
                    
                    String name = sc.nextLine();
                    //sc.nextLine();
                    if (name.equals("exit")) {
                        break;
                    }
                    System.out.print("Roll No: ");
                    int rollNo = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter the marks obtained for subjects in order of Math, English, Java and DBMS: ");
                    int[] marks = new int[4];
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Enter mark for subject " + (i + 1) + ": ");
                        marks[i] = sc.nextInt();
                    }
                    sc.nextLine();

                    Students student = new Students(name, rollNo, marks);
                    List<Students> innerList = new ArrayList<>();
                    innerList.add(student);
                    studList.add(innerList);

                    System.out.println("Do you want to add more students? (Y/N)");
                    c = sc.nextLine();
                }
                while(c.equalsIgnoreCase("YES") || c.equalsIgnoreCase("Y"));
                break;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 2:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Student Details: ");
                for(int i = 0; i < studList.size(); i++)
                {
                    for(int j = 0; j < studList.get(i).size(); j++)
                    {
                        System.out.print("Student " + (i + 1) + ": ");
                        studList.get(i).get(j).display();
                    }
                }
                System.out.println("----------------------------------------------------------------");
                System.out.println("");
                break;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 3:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Average Scores:");

                computeAVG(studList);

                System.out.println("----------------------------------------------------------------");
                System.out.println("");
                break;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 4:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Average Scores:");

                getHighest(studList);

                System.out.println("----------------------------------------------------------------");
                System.out.println("");
                break;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 5:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Average Scores:");

                getLowest(studList);

                System.out.println("----------------------------------------------------------------");
                System.out.println("");
                break;
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            }
        }
        while(choice != 0);

        sc.close();
        System.out.println("Student Tracker Successfully Closed");
    }
};
