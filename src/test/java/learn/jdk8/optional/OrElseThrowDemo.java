package learn.jdk8.optional;

import learn.jdk8.lambda.Student;

import java.util.Optional;

public class OrElseThrowDemo {

    public static void getStudentInfo(Student student){

        Optional<Student> optional = Optional.ofNullable(student);

        try {
            Student result = optional.orElseThrow(MyException::new);
            System.out.println(result);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //Student student = new Student(1,"zhangsan","M");
        Student student = null;
        getStudentInfo(student);
    }
}
