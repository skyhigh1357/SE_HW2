package library;
import java.io.*;
import java.sql.*;


public class MainMenu2 {
	
	
	MainMenu2() throws IOException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			//System.exit(0);
		}
	}
	
	
	public void mainmenu2() throws IOException, SQLException{ 
		InputStreamReader sr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(sr);
		Connection conn = DriverManager.getConnection(staticvar.jdbcUrl, staticvar.userID, staticvar.userPass);
		PreparedStatement ps= null;
		String sql=null;
		ResultSet rs = null;
		
		String id;
		int pw;
		while(true){
		System.out.println("---------------------------");
		System.out.println("�α���");
		System.out.println("---------------------------");
		System.out.print("���̵�:	");
		id=br.readLine();
		System.out.print("��й�ȣ:	");
		pw=Integer.parseInt(br.readLine());
		
		sql="select * from user where sid=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1,  id);
		rs=ps.executeQuery();
		
		
		if(rs.next()){
			String storedid = rs.getString("sid");
			int storedpw = rs.getInt("pw");
			
			if(storedid.equals(id) && storedpw==pw){
				staticvar.login(id);
				System.out.println("�α��εǾ����ϴ�.");
				
				if(staticvar.nowid.equals("admin")){
					System.out.println("---------------------------");
					System.out.println("admin�� ȯ���մϴ�.");
					System.out.println("---------------------------");
					AdminMainMenu amm=new AdminMainMenu();
					amm.adminmainmenu();
					break;
				}
				else{
					//�л�����ó��
					break;
				}
			}
			else if(storedid==id){
				System.out.println("��й�ȣ�� Ȯ�����ּ���.");
			}
			else{
				System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���.");
			}
			
		}
		else{
			System.out.println("���̵� �������� �ʽ��ϴ�.");
		}
		}
		
	}
	
}
