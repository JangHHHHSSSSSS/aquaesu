import java.sql.SQLException;
import java.util.List;

import com.aquaesu.webprj.dao.MemberDao;
import com.aquaesu.webprj.vo.Member;

public class TestProgram {

	public static void main(String[] args) throws SQLException {
		MemberDao dao = new MemberDao();
		List<Member> list = dao.getMembers();
		
		for(Member m : list){
			System.out.printf("mid:%s,name : %s\n",  m.getMid(),m.getName());
		}

	}

}
