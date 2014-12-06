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
		System.out.println("로그인");
		System.out.println("---------------------------");
		System.out.print("아이디:	");
		id=br.readLine();
		System.out.print("비밀번호:	");
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
				System.out.println("로그인되었습니다.");
				
				if(staticvar.nowid.equals("admin")){
					System.out.println("---------------------------");
					System.out.println("admin님 환영합니다.");
					System.out.println("---------------------------");
					AdminMainMenu amm=new AdminMainMenu();
					amm.adminmainmenu();
					break;
				}
				else{
					//학생계정처리
					break;
				}
			}
			else if(storedid==id){
				System.out.println("비밀번호를 확인해주세요.");
			}
			else{
				System.out.println("아이디와 비밀번호를 확인해주세요.");
			}
			
		}
		else{
			System.out.println("아이디가 존재하지 않습니다.");
		}
		}
		
	}
	
}
