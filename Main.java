package homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("Maria", Arrays.asList(new Course("IT"),new Course("SMM"), new Course("Culture"))),
            new Student("Olga", Arrays.asList(new Course("Math"), new Course("IT"))),
            new Student("Kristina", Arrays.asList(new Course("English"), new Course("SMM"),new Course("IT"))),
            new Student("Kirill", Arrays.asList(new Course("English"))),
            new Student("Alex", Arrays.asList(new Course("Physics"), new Course("IT"),new Course("English"), new Course("Culture"))),
            new Student("Anna", Arrays.asList(new Course("Dancing"), new Course("IT")))

    ));

        System.out.println(students.stream()
                .map(student -> student.getCourses())
                .flatMap(courses -> courses.stream())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        Course course = new Course("IT");

        System.out.println(students.stream()
                .filter(student -> student.getCourses().contains(course))
                .collect(Collectors.toList()));

    }
}
