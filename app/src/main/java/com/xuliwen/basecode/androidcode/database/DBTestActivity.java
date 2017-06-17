package com.xuliwen.basecode.androidcode.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.xuliwen.basecode.R;
import com.xuliwen.basecode.utils.L;

import java.util.List;

public class DBTestActivity extends AppCompatActivity {

    private EditText stuentName;
    private EditText stuentHeight;
    private EditText foodName;
    private EditText foodPrice;
    private StudentDao studentDao=new StudentDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);

        initView();
    }

    private void initView(){
        stuentName= (EditText) findViewById(R.id.student_name_editText);
        stuentHeight= (EditText) findViewById(R.id.student_height_editText);
        foodName= (EditText) findViewById(R.id.food_name_editText);
        foodPrice= (EditText) findViewById(R.id.food_price_editText);
    }

    public void addStudent(View view) {
        Student student=new Student();
        student.setName(stuentName.getText().toString());
        student.setHeight(Float.valueOf(stuentHeight.getText().toString()));
        studentDao.addStuent(student);
        printStudentTable();
    }

    public void printStudentTable(){
        List<Student> students=studentDao.getStudents();
        int size=students.size();
        L.l("打印Student表如下：");
        for(int i=0;i<size;i++){
            L.l("第"+i+"条数据为： "+students.get(i));
        }
    }

    public void addFood(View view) {
    }

    public void deleteStudentByName(View view) {
        String name=stuentName.getText().toString();
        float height= Float.parseFloat(stuentHeight.getText().toString());
        studentDao.deleteStudent(name,height);
        printStudentTable();
    }

    public void updateStudentByName(View view) {
        Student student=new Student();
        student.setName(stuentName.getText().toString());
        student.setHeight(Float.parseFloat(stuentHeight.getText().toString()));
        studentDao.updateStudent(student);
        printStudentTable();
    }
}
