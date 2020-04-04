package file.practice.sort;

import java.io.File;
import java.util.Arrays;

public class StudentServiceImpl implements IStudentService {
    private static final File SAVE_FILE = new File("/Users/apple/Downloads/IOPractice/src/test/student.txt");
    private String content;//输入学生信息
    private Student[] students;//学生的排序

    public StudentServiceImpl() {
        this.content = FileUtil.load(SAVE_FILE);
        this.handle();
    }
    public void handle(){//字符串数组拆分
        if(this.content==null|"".equals(this.content)){
            return;
        }
        String result[] = this.content.split("\\|");
        this.students = new Student[result.length];
        for(int x = 0; x < result.length; x++){
            String temp [] = result[x].split("\\:");
            this.students[x] = new Student(temp[0],Double.parseDouble(temp[1]));
        }


    }

    @Override
    public Student[] getDate() {
        Arrays.sort(this.students);
        return this.students;
    }

    @Override
    public void append(String str) {
        if(str.startsWith("|")){
            str.substring(1);
        }
        if(!str.endsWith("|")){
            str =str+"|";
        }
        FileUtil.append(SAVE_FILE,str);
    }
}

