package com.example.tkc.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tkc.greendao.dbmanager.CommonUtils;
import com.student.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG="MainActivity";
    private CommonUtils commonUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         commonUtils=new CommonUtils(MainActivity.this);
    }
    //插入一条数据
    public void insertData(View view){
        Log.i(TAG, "insert Data");
        Student student=new Student();
        student.setId(1001l);
        student.setName("xs");
        student.setAddress("长春");
        student.setAge("22");
        commonUtils.insertStudent(student);
    }
    //插入多条数据
    public void insertMultData(View view){
        List<Student> list=new ArrayList<Student>();
        for(int i=0;i<10;i++){
            Student student=new Student();
            student.setName("张三" + i);
            student.setAddress("北京" + i);
            student.setAge("10" + i);
            list.add(student);
        }
        commonUtils.insertMultStudent(list);
    }
    //修改一条数据
    public void upData(View view){
        //update student set name='jack' where id = 1001;
        Student student=new Student();
        student.setId(1001L);
        student.setAge("100");
        student.setName("李四");
        student.setAddress("长春嘉诚");
        commonUtils.updataStudent(student);
    }
    //查询所有数据
    public void queryAll(View view){
        List<Student> list=commonUtils.queryAllData();
        Log.i("==>",list.toString());
    }
}
