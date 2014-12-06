package library;

public class staticvar {
	static String jdbcUrl="jdbc:mysql://127.0.0.1:3306/library";
	static String userID = "root";
	static String userPass="1234";
	
	public static String nowid="null";
	
	public static void login(String id){
		nowid=id;	
	}
	
	public static void logout(){
		nowid="null";
	}
}
