<%-- 
    Document   : BlackJack
    Created on : 2017/04/24, 15:11:34
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*;"%>

<%!
    //抽象化クラスHumanの実装
    abstract class Human{
        public ArrayList<Integer> mycard = new ArrayList<Integer>();
        abstract int open();
        abstract void setcard(ArrayList<Integer>csets);
        abstract boolean checksum();
    }

    //Dealerクラスの実装
      class Dealer extends Human{
        public ArrayList<Integer> cards = new ArrayList<Integer>();
        //コンストラクタで変数cardsの初期値（トランプ52枚分の値）を配列に格納
        Dealer(){
          for(int i = 1 ; i < 14; i++){
               cards.add(i);
               cards.add(i);
               cards.add(i);
               cards.add(i);
               }
         }
        
        //dealメソッド
        public ArrayList deal(){
          Random rnd1 = new Random();
          Random rnd2 = new Random();
          int ran1 = rnd1.nextInt(52);
          int ran2 = rnd2.nextInt(52);
          
          ArrayList<Integer> dcards = new ArrayList<Integer>(); 
          
          dcards.add(cards.get(ran1));
          dcards.add(cards.get(ran2));
          cards.remove(ran1);
          cards.remove(ran2);
          
          return dcards;
          }
       
        //hitメソッド
        public ArrayList hit(){
          Random rnd1 = new Random();
          int ran1 = rnd1.nextInt(52);
          
          ArrayList<Integer> hcards = new ArrayList<Integer>(); 
          
          hcards.add(cards.get(ran1));
          cards.remove(ran1);
          
          return hcards;
          }
        //openメソッド
         public int open(){
            int sum = 0;     
            for(int i = 0 ; i < mycard.size(); i++){
                if((mycard.get(i) == 1)&(sum >= 11)){
                   sum += 1;
                }else if((mycard.get(i) == 1)&(sum < 11)){
                    sum += 11;
                }else if(mycard.get(i) >= 10){ 
                    sum += 10;
                }else{
                    sum += mycard.get(i);
                }
             }
            return sum;
         }
        
        //setcardメソッド
        public void setcard(ArrayList<Integer>csets){
            for(int i = 0 ; i < csets.size();i++){
            mycard.add(csets.get(i));
            }
        }
        
        //checksumメソッド
        public boolean checksum(){
            boolean type = true;
            if(open() >= 21){
               type = false;
            }
            return type;
        }
    }
     
     //Userクラスの実装 
     class User extends Human{
        
        //openメソッド
        public int open(){
            int sum = 0;     
            
            for(int i = 0 ; i < mycard.size(); i++){
                if((mycard.get(i) == 1)&(sum > 21)){
                   sum += 1;
                }else if((mycard.get(i) == 1)&(sum < 11)){
                    sum += 11;
                    
                }else if(mycard.get(i) >= 10){ 
                    sum += 10;
                }else{
                    sum += mycard.get(i);
                }
             }
            return sum;
             }
        //setcardメソッド
        public void setcard(ArrayList<Integer>csets){
            for(int i = 0 ; i < csets.size();i++){
            mycard.add(csets.get(i));
            }
        }
        //checksumメソッド
        public boolean checksum(){
            boolean type = true;
            if(open() > 21){
               type = false;
            }
            return type;
        }
    }

%>


<%
   Dealer Host = new Dealer();
   User you = new User();
   
   //ホストとユーザーにそれぞれカードを2枚配る
   Host.setcard(Host.deal());
   you.setcard(Host.deal());
   
   out.println("ブラックジャックを始めます。<br>");
   out.println("相手のカードの手札は" + Host.mycard + "です<br>");
   out.println("相手のカードの合計は" + Host.open() + "です<br>");
   out.println("こちらのカードの手札は" + you.mycard + "です<br>");
   out.println("こちらのカードの合計は" + you.open() + "です<br>");
   
   //ホストのカード合計が10以下ならばホストは一枚カードを引く
   if(Host.open() <= 10){
    Host.setcard(Host.hit());
    out.println("相手が一枚カードを引きました。");
    out.println("相手のカードの手札は" + Host.mycard + "です<br>");
    out.println("相手のカードの合計は" + Host.open() + "です<br>");
   }
   //ユーザーは合計がホストのカード合計以下であれば一枚カードを引く
   if(Host.open() >= you.open()){
       you.setcard(Host.hit());
       out.println("一枚カードを引きました。");
       out.println("こちらのカードの手札は" + you.mycard + "です<br>");
       out.println("こちらのカードの合計は" + you.open() + "です<br>");
   }

   //勝敗の記述。ユーザーは22以上であれば敗北
   if((Host.open() < you.open())&(you.checksum() != false)){
       out.print("あなたの勝ちです");
   }else{
       out.print("相手の勝ちです");
   }
   

%>