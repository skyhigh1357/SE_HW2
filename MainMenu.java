package library;
import java.io.*;
import java.sql.*;


class MainMenu{	
	public void mainmenu() throws IOException, SQLException{
		
		InputStreamReader sr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(sr);
		
		while(true){
		System.out.println("---------------------------");
		System.out.println("���� ���� ���α׷�");
		System.out.println("---------------------------");
		System.out.println("1. ȸ�� ����");
		System.out.println("2. �α���");
		System.out.println("0. ���α׷� ����");
		System.out.print(">");
		
		int n=Integer.parseInt(br.readLine());
		System.out.println("n="+n);
	
		if(n==1){
			System.out.println("1�̸� ȸ������");
			MainMenu1 mn1=new MainMenu1();
			mn1.mainmenu1();
		}
		else if(n==2){
			System.out.println("2�̸� �α���");
			MainMenu2 mn2=new MainMenu2();
			mn2.mainmenu2();
		}
		else if(n==0){
			System.out.println("0�̸� ���α׷�����");
			System.out.println("�̿��� �ּż� �����մϴ�.");
			System.exit(0);
		}
		else{
			System.out.println("�ٽ� �Է��ϼ���");
		}
	}}
}
	