package mem;

import java.util.ArrayList;



public class ServiceImpl implements Service {
	private Dao dao;
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public boolean addMember(Member m) {
		// TODO Auto-generated method stub
		boolean flag = false;

		Member check = getMember(m.getId());
		if(check == null) {
			dao.insert(m);
			flag = true;	
		}
		else {
			System.out.println("중복 아이디 입니다.");
		}
		return flag;	
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

	@Override
	public ArrayList<Member> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editMember(Member m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Member m = getMember(id);
		if (m != null && pwd.equals(m.getPwd())) {
			flag = true;
		}
		return flag;
	}

}
