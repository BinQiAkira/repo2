package com.kaxi.repository;

import com.kaxi.entity.Student;
import com.kaxi.utils.JDBCTools;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> findAll(){
        List<Student> list= new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection= JDBCTools.getConnection();
            String sql="select * from student002";
            preparedStatement =connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student=null;
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(3);
                int age = resultSet.getInt(5);
                int room_id = resultSet.getInt(6);
                student=new Student(id,name,age,room_id);
                list.add(student);
                System.out.println(room_id);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return list;
    }

    public void add(String username,String password,String name, Integer age, Integer room_id){
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try {
            connection= JDBCTools.getConnection();
            String sql="insert into student002(username,name,password,age,room_id) values(?,?,?,?,?)";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,password);
            preparedStatement.setInt(4,age);
            preparedStatement.setInt(5,room_id);
            System.out.println(sql);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    public void deleteById(Integer id){
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "delete from student002 where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    public Student findById(Integer id){
        Connection connection=null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        Student student=null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select * from student002 where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id2 = resultSet.getInt(1);
                String name = resultSet.getString(3);
                Integer age = resultSet.getInt(5);
                Integer room_id = resultSet.getInt(6);
                student=new Student(id2,name,age,room_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return student;
    }

    public void update(Integer id,String name,Integer room_id){
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try {
            connection= JDBCTools.getConnection();
            String sql="update student002 set name =?,room_id=? where id = ?";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,room_id);
            preparedStatement.setInt(3,id);
            System.out.println(sql);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }
}
