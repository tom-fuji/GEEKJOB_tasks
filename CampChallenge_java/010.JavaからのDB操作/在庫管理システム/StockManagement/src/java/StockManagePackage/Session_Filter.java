
import java.io.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


//セッションの判定を行うサーブレットフィルタ
//Webwmlで指定したStockManageControll StockBookList StockRegistの
//3つのサーブレットが呼び出されるときに前もってこの処理が行われて
//セッション情報があるか判定する

public class Session_Filter implements Filter{
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        response.setContentType("text/html;charset=UTF-8");
        
    try{
     
      HttpSession session = ((HttpServletRequest)request).getSession(false);
  
      if (session == null){
         //セッション情報がない時にセッション切れページへリダイレクト
         ((HttpServletResponse)response).sendRedirect("session_out.html");
         //dofilter内でif文を使ってsendRedirectしているときはreturnを使わないと
         //「レスポンスがコミットされた後でsendRedirect()を呼び出すことはできません」とエラーが出てしまう
           return;
      }else{
        Object loginCheck = session.getAttribute("login");
        if (loginCheck == null){
            
          ((HttpServletResponse)response).sendRedirect("session_out.html");
           return;
        }
      }
   
      chain.doFilter(request, response);
    }catch (ServletException se){
    }catch (IOException e){
    }
  }

  public void init(FilterConfig filterConfig) throws ServletException{
  }

  public void destroy(){
  }
}