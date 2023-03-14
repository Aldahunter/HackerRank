import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCGPA() {
        return cgpa;
    }

    public int compareTo(Student anotherStudent) {
        int rtn = Double.compare(anotherStudent.getCGPA(), cgpa);
        if (rtn == 0) {
            rtn = name.compareTo(anotherStudent.getName());
        }
        if (rtn == 0) {
            rtn = Integer.compare(id, anotherStudent.getID());
        }
        return Integer.signum(rtn);
    }

    public boolean equals(Object anObject) {
        if (anObject == null || !(anObject instanceof Student)) {
            return false;
        }
        if (anObject == this) {
            return true;
        }
        Student aStudent = (Student) anObject;
        return (id == aStudent.getID()
                && name.equals(aStudent.getName())
                && cgpa == aStudent.getCGPA());
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.compareTo(s2);
    }
}

class Priorities {
    PriorityQueue<Student> queue;

    public Priorities() {
        queue = new PriorityQueue<>(11, new StudentComparator());
    }

    public List<Student> getStudents(List<String> events) {
        for (String event : events) {
            String[] eventParams = event.split(" ");

            if (eventParams.length == 4) {
                enterStudent(eventParams[1],
                        Double.valueOf(eventParams[2]),
                        Integer.valueOf(eventParams[3]));
            }
            else if (eventParams.length == 1) {
                serveStudent();
            }
        }

        return getRemainingStudents();
    }

    private void enterStudent(String name, double cgpa, int id) {
        queue.add(new Student(id, name, cgpa));
    }
    private Student serveStudent() {
        return queue.poll();
    }
    private List<Student> getRemainingStudents() {
        List<Student> students = new LinkedList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }
        return students;
    }
}
