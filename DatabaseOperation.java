import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {
	static final String url = "jdbc:mysql://localhost:/sample";
	static final String user = "root";
	static final String pass = "root";

	public static void main(String args[]) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass);
				st = con.createStatement();
				Scanner scanner = new Scanner(System.in);
				System.out.println(
						" 1. Update table student \n 2. Save values into table \n 3. Select the student table \n 4. Delete student stable");
				int number = scanner.nextInt();
				switch (number) {
				case 1:
					System.out.println("Enter the id of the table to to update column");
					int num = scanner.nextInt();
					System.out.println("Enter the name");
					String name = scanner.next();
					System.out.println("Enter the phone number");
					int ph = scanner.nextInt();
					System.out.println("Enter the address");
					String add = scanner.next();
					System.out.println("enter the id for updating table");
					int num2 = scanner.nextInt();
					String sql3 = "UPDATE STUDENT SET NAME=" + name + ",PHONE=" + ph + ",ADDRESS=" + add + ",ID=" + num2
							+ " WHERE ID=" + num + "";
					st.executeUpdate(sql3);
					System.out.println("Student table updated successfully");
					break;
				case 2:
					System.out.println("Enter the name");
					String nameget = scanner.next();
					System.out.println("Enter the phone number");
					int phno = (int) scanner.nextLong();
					System.out.println("Enter the address");
					String add1 = scanner.next();
					int numb4;
					int numb5 = -1;
					while (rs.next()) {
						numb4 = rs.getInt(4);
						numb5 = numb4++;

						String sql4 = "INSERT INTO STUDENT(NAME,PHONE,ADDRESS,ID) VALUES(" + nameget + "," + phno + ","
								+ add1 + "," + numb5 + ")";
						st.executeUpdate(sql4);
					}
					System.out.println("Inserted values in student table");
					break;
				case 3:
					String sql5 = "SELECT *FROM STUDENT";
					rs = st.executeQuery(sql5);
					while (rs.next())
						System.out.println(rs.getString("Name") + " " + rs.getLong("Phone") + " "
								+ rs.getString("Address") + "   " + rs.getLong("id"));
					break;
				case 4:
					System.out.println("Enter the id of row to delete");
					int numb3 = scanner.nextInt();
					String sql6 = "DELETE FROM STUDENT WHERE ID=" + numb3 + "";
					st.executeUpdate(sql6);
					System.out.println("Student table is deleted successfully");
					break;
				default:
					System.out.println("Error performing operation");
					break;

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
