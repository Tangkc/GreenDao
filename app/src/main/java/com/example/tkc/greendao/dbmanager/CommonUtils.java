package com.example.tkc.greendao.dbmanager;

import android.content.Context;
import android.util.Log;

import com.student.entity.Student;

import java.util.List;

/**
 * 完成对某一个表的（对象）的具体操作，ORM对象映射，操作的是对象，Student
 * Created by tkc on 2016/4/17.
 */
public class CommonUtils {
    private DaoManager daoManager;
    public CommonUtils(Context context){
        daoManager=DaoManager.getInstance();
        daoManager.init(context);
    }

    /**
     * 完成对数据库中student表的插入操作，也可以检验数据库是否存在，如果不存在就建立一个
     * @param student
     * @return
     */
    public boolean insertStudent(Student student){
        boolean flag=false;
        flag = daoManager.getDaoSession().insert(student) != -1 ? true : false;
        Log.i("CommonUtils", "----insertStudent--result is -->>" + flag);
        return flag;
    }
    /**
     * 插入多条记录，需要开辟新的线程
     * @param students
     * @return
     */
    public boolean insertMultStudent(final List<Student> students) {
        boolean flag = false;
        try {
            daoManager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (Student student : students) {
                        daoManager.getDaoSession().insertOrReplace(student);
                    }
                }
            });
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改数据
     * @param student
     * @return
     */
    public boolean updataStudent(Student student){
        boolean flag=false;
        try{
            daoManager.getDaoSession().update(student);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return  flag;
    }

    /**
     * 查询所有数据
     * @return List
     */
    public List<Student> queryAllData(){

    return daoManager.getDaoSession().loadAll(Student.class);
    }
    /**
     *
     */
}
