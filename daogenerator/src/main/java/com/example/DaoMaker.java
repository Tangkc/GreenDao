package com.example;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DaoMaker {
   public static void main(String []args){
       //生命数据库的实体类，XXentity，对应的数据的表
       Schema schema=new Schema(1,"com.student.entity");
       addStudent(schema);
       schema.setDefaultJavaPackageDao("com.student.dao");//设置数据访问层
       try {
           new DaoGenerator().generateAll(schema,"E:\\Studio Space\\GreenDao\\app\\src\\main\\java-gen");
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    private static void addStudent(Schema schema){
        Entity entity=schema.addEntity("Student");
        entity.addIdProperty();//主键 int类型；
        entity.addStringProperty("name");
        entity.addStringProperty("age");
        entity.addStringProperty("address");
        entity.addIntProperty("stuId");
    }
}
