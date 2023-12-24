/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chuimin
 */
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class saveXP {
    
    public saveXP() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username: ");
        String user=sc.next();
        int cPoint=getCurrentPoint(user);
        int newPoint=cPoint+20;//needmodify
        int xp=getCurrentXp(user);
        int newXp=xp+20;//need modify plus how much
        
        saveXpCPoint(user,newPoint,newXp);
        displayLeaderboard();
    }
    
    public static void saveXpCPoint(String username, int newPoint,int newXp){
        try(Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3308/user","root","")){
               String query= "UPDATE user SET xp = ?,current_point=?, xpLastUpdate =CURRENT_TIMESTAMP WHERE username=?";
               try(PreparedStatement preparedStatement = con.prepareStatement(query)){
                   preparedStatement.setInt(1,newXp);
                   preparedStatement.setInt(2,newPoint);
                   preparedStatement.setString(3,username);
                   preparedStatement.executeUpdate();
               }
           
           System.out.println("Point updated successfully");
           System.out.println("Your current point: "+getCurrentPoint(username));
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
        
    public static int getCurrentXp(String username){
       int currentPoints=0;
       try{
           Connection con =DriverManager.getConnection("jdbc:MySQL://localhost:3308/user","root","");
          String query="SELECT *FROM user WHERE username = ?";
            
                try(PreparedStatement preparedStatement = con.prepareStatement(query)){
                    preparedStatement.setString(1, username);
                    try(ResultSet resultSet = preparedStatement.executeQuery()){
                        if(resultSet.next()){
                            currentPoints = resultSet.getInt("xp");
                            
                        }
                    }
                }
           
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return currentPoints;
   }

    
    
    public static int getCurrentPoint(String username){
       int currentPoints=0;
       try{
           Connection con =DriverManager.getConnection("jdbc:MySQL://localhost:3308/user","root","");
          String query="SELECT *FROM user WHERE username = ?";
            
                try(PreparedStatement preparedStatement = con.prepareStatement(query)){
                    preparedStatement.setString(1, username);
                    try(ResultSet resultSet = preparedStatement.executeQuery()){
                        if(resultSet.next()){
                            currentPoints = resultSet.getInt("current_point");
                            
                        }
                    }
                }
           
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return currentPoints;
   }
    
    
    public static void displayLeaderboard(){
        String query ="SELECT username, current_point, xp FROM user ORDER BY xp DESC, xpLastUpdate ASC";
        try(Connection con =DriverManager.getConnection("jdbc:MySQL://localhost:3308/user","root","");
            java.sql.Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(query)){
                System.out.println();
            System.out.printf("Username%7sCurrent Point%5sXP","","");
            System.out.println();
            
            while(rs.next()){
                String username=rs.getString("username");
                int xp=rs.getInt("xp");
                int cPoint=rs.getInt("current_point");
                System.out.printf("%-15s%-18s%-9s",username,cPoint,xp);
                System.out.println();
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

