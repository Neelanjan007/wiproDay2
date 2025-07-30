package javassignment1;

class Student {
    private static int nextRollNo = 1;
    private int rollNo;
    private String name;
    private int marksEng;
    private int marksMaths;
    private int marksScience;
    private int totalMarks;
    private double percentage;
    private int rank;

    public Student(String name, int marksEng, int marksMaths, int marksScience) {
        this.rollNo = nextRollNo++;
        this.name = name;
        this.marksEng = marksEng;
        this.marksMaths = marksMaths;
        this.marksScience = marksScience;
        calculateTotalAndPercentage();
    }

    private void calculateTotalAndPercentage() {
        totalMarks = marksEng + marksMaths + marksScience;
        percentage = totalMarks / 3.0;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getMarksMaths() {
        return marksMaths;
    }

    public int getMarksScience() {
        return marksScience;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

public class Standard {
    Student[] students = new Student[8];

    public Standard() {
        students[0] = new Student("Ravi", 85, 92, 78);
        students[1] = new Student("Priya", 90, 95, 88);
        students[2] = new Student("Amit", 75, 70, 82);
        students[3] = new Student("Sneha", 65, 60, 58);
        students[4] = new Student("Satya", 82, 89, 91);
        students[5] = new Student("Akash", 55, 60, 65);
        students[6] = new Student("Raj", 88, 90, 85);
        students[7] = new Student("Sara", 93, 96, 97);

        assignRanks();
    }

    public void assignRanks() {
        for (int i = 0; i < students.length; i++) {
            int rank = 1;
            for (int j = 0; j < students.length; j++) {
                if (students[j].getTotalMarks() > students[i].getTotalMarks()) {
                    rank++;
                }
            }
            students[i].setRank(rank);
        }
    }

    public void displayByRollNo() {
        System.out.println("Students sorted by Roll No:");
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getRollNo() > students[j].getRollNo()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        for (Student s : students) {
            System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getName());
        }
    }

    public void displayTopperByPercentage() {
        Student topper = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getPercentage() > topper.getPercentage()) {
                topper = students[i];
            }
        }
        System.out.println("Topper by Percentage: Roll No: " + topper.getRollNo() + ", Name: " + topper.getName());
    }

    public void displayTopperInMaths() {
        Student topper = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getMarksMaths() > topper.getMarksMaths()) {
                topper = students[i];
            }
        }
        System.out.println("Topper in Maths: Roll No: " + topper.getRollNo() + ", Name: " + topper.getName());
    }

    public void displayByMathsAndScienceMarks() {
        System.out.println("Students sorted by Maths + Science Marks:");
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                int sum1 = students[i].getMarksMaths() + students[i].getMarksScience();
                int sum2 = students[j].getMarksMaths() + students[j].getMarksScience();
                if (sum1 > sum2) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        for (Student s : students) {
            int total = s.getMarksMaths() + s.getMarksScience();
            System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getName() + ", Maths+Science: " + total);
        }
    }

    public void displayByRank() {
        System.out.println("Students sorted by Rank:");
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getRank() > students[j].getRank()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        for (Student s : students) {
            System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getName() +
                    ", Total: " + s.getTotalMarks() + ", Percentage: " + s.getPercentage() +
                    ", Rank: " + s.getRank());
        }
    }

    public static void main(String[] args) {
        Standard standard = new Standard();
        System.out.println();
        standard.displayByRollNo();
        System.out.println();
        standard.displayTopperByPercentage();
        System.out.println();
        standard.displayTopperInMaths();
        System.out.println();
        standard.displayByMathsAndScienceMarks();
        System.out.println();
        standard.displayByRank();
    }
}
