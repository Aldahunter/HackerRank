import java.util.*;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int cgpaCompare = Double.compare(s2.getCgpa(), s1.getCgpa());
        if (cgpaCompare != 0) return cgpaCompare;

        int fNameCompare = s1.getFname().compareTo(s2.getFname());
        if (fNameCompare != 0) return fNameCompare;

        return Integer.compare(s1.getId(), s2.getId());
    }
}

//Complete the code
public class Solution
{
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            int testCases = Integer.parseInt(in.nextLine());

            List<Student> studentList = new ArrayList<Student>();
            while(testCases>0){
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();

                Student st = new Student(id, fname, cgpa);
                studentList.add(st);

                StudentComparator comparator = new StudentComparator();
                studentList.sort(comparator);

                testCases--;
            }

            for(Student st: studentList){
                System.out.println(st.getFname());
            }
        }
    }
}
