package library;
import java.io.*;
import java.sql.*;


class MainMenu{	
	public void mainmenu() throws IOException, SQLException{
		
		InputStreamReader sr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(sr);
		
		while(true){
		System.out.println("---------------------------");
		System.out.println("도서 관리 프로그램");
		System.out.println("---------------------------");
		System.out.println("1. 회원 가입");
		System.out.println("2. 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print(">");
		
		int n=Integer.parseInt(br.readLine());
		System.out.println("n="+n);
	
		if(n==1){
			System.out.println("1이면 회원가입");
			MainMenu1 mn1=new MainMenu1();
			mn1.mainmenu1();
		}
		else if(n==2){
			System.out.println("2이면 로그인");
			MainMenu2 mn2=new MainMenu2();
			mn2.mainmenu2();
		}
		else if(n==0){
			System.out.println("0이면 프로그램종료");
			System.out.println("이용해 주셔서 감사합니다.");
			System.exit(0);
		}
		else{
			System.out.println("다시 입력하세요");
		}
	}}
}
	