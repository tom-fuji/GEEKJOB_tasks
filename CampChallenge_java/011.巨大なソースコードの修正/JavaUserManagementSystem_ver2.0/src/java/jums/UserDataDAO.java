package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            //検索する要素を記録するための配列を作成 ;neme = 0,BirthDay = 1,Type =2
            ArrayList<Integer> SQarr = new ArrayList<Integer>();
            
            String sql = "SELECT * FROM user_t";
          
            boolean flag = false;
            if (ud.getName() != null &&!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
                SQarr.add(0);
                
            }
            if (ud.getBirthday()!=null) {
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag = true;
                }else{
                    sql += " AND birthday like ?";
                }
                SQarr.add(1);
             
            }
            if (ud.getType()!=0) {
                if(!flag){
                    sql += " WHERE type like ?";
                }else{
                    sql += " AND type like ?";
                }
                SQarr.add(2);
         
            }
            st =  con.prepareStatement(sql);
     
           //SQL文の?にどの項目が入るか判定して格納する処理
            int i = 1;
            while(i <= SQarr.size()){
                switch(SQarr.get(i-1)){
                    case 0: st.setString(i, "%"+ud.getName()+"%");break;
                    case 1: st.setString(i, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");break;
                    case 2: st.setInt(i, ud.getType());break;
                 }           
                i +=1;
            }
             
            ResultSet rs = st.executeQuery();
            
            //配列化して要素にして格納したい -----------------
           
            ArrayList<UserDataDTO> resultListUd = new ArrayList(); 
             while(rs.next()){
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            resultListUd.add(resultUd);
            i +=1;
            }
            System.out.println("search completed");


            return resultListUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
     }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    
    //deleteUD データの削除の処理を行う 戻り値はなし
       public void deleteUD(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "delete from user_t where UserID =?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            int i  = st.executeUpdate();
            
            System.out.println("deleteUd completed");
           
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
        }
       
       
       //Updateするためのメソッド DTO型で変更する前と後のオブジェクトをそれぞれ引数に渡して使う　
       //戻り値は更新後のUserDTOオブジェクト
       public UserDataDTO updateUD(UserDataDTO preud, UserDataDTO upud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            //どの項目がどの順番でSQL文に組み込まれるか記録するための配列を作成
            //name=0,birthday=1,tell=2,type=3,comment=4
            ArrayList<Integer> SQarr = new ArrayList<Integer>();
            
            String sql = "update user_t set ";
            boolean flag = false;
            
            if (upud.getName() != null &&!upud.getName().equals("")) {
                sql += "name= ? ";
                SQarr.add(0);
                flag = true;               
            }
            if (upud.getBirthday() != null) {
                if(flag){
                    sql += ",";
                }
                sql += "birthday = ? ";
                SQarr.add(1);
                flag = true; 
            }
            if (upud.getTell() !=null && !upud.getTell().equals("")) { 
                if(flag){
                    sql += ",";
                }
                sql += " tell = ? ";
                SQarr.add(2);
                flag = true;
            }
            if (upud.getType() != 0) { 
                if(flag){
                    sql += ",";
                }
                sql += " type =  ? ";
                SQarr.add(3);
                flag = true;
            }
            if (upud.getComment() !=null && !upud.getComment().equals("")) { 
                if(flag){
                    sql += ",";
                }
                sql += " comment = ? ";
                SQarr.add(4);
            }
    
            sql += ", newDate = ?";
            
            sql += "where userID = " ;
            sql += String.valueOf(preud.getUserID());
            
            st =  con.prepareStatement(sql);
            
            //SQL文の?にどの項目が入るか判定して格納する処理
            int i = 1;
            while(i <= SQarr.size()){
                 switch(SQarr.get(i-1)){
                    
                    case 0: st.setString(i,upud.getName());break;
                    case 1: st.setDate(i,new java.sql.Date(upud.getBirthday().getTime()));break;
                    case 2: st.setString(i, upud.getTell());break;
                    case 3: st.setInt(i,upud.getType());break;
                    case 4: st.setString(i, upud.getComment());break;
                 }           
                i +=1;
            }
            
            st.setTimestamp(SQarr.size()+1,new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            
            UserDataDTO resultUd = new UserDataDTO();
            resultUd = searchByID(preud);
            
            System.out.println("updateUd completed");
            
            return resultUd;
            
            
           
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
        }

}


