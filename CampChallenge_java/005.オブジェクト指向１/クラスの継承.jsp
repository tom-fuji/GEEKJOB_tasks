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

 public class Batter extends BaseballPlayer{
     public void clear(){
            teamname = "";
            positions = "";
     }

}

%>

<%
    Batter a = new Batter();
    
    a.setdata("baystars","second");
    a.showteam();
    a.clear();
    a.showteam();
    



%>