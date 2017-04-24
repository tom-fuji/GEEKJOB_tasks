<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
 public class BaseballPlayer{
     public String teamname ="";
     public String positions = "";
     public void setdata(String a,String b){
            teamname = a;
            positions = b ;
    }
     public void showteam(){
            System.out.print(teamname);
     }
     public void showpositions(){
            System.out.print(positions);
    }
}


%>

<%
    BaseballPlayer a = new BaseballPlayer();
    
    a.setdata("baystars","second");
    
    a.showteam();
    



%>