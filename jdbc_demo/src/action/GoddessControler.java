package action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import modle.Goddess;
import modle.Goddess_DAO;

public class GoddessControler {
	
	public void add(Goddess g) throws SQLException{
		Goddess_DAO dao = new Goddess_DAO();
		dao.add(g);
	}
	
	public void delete(Integer id) throws SQLException{
		Goddess_DAO dao = new Goddess_DAO();
		dao.delete(id);
	}
	
	public void update(Goddess g) throws SQLException {
		Goddess_DAO dao = new Goddess_DAO();
		dao.update(g);
	}
	
	public Goddess query(Integer id) throws SQLException{
		Goddess_DAO dao = new Goddess_DAO();
		Goddess g = dao.query(id);
		return g;
	}
	
	public List<Goddess> query() throws SQLException {
		Goddess_DAO dao = new Goddess_DAO();
		List<Goddess> result = dao.query();
		return result;
	}
	
	public List<Goddess> query(List<Map<String, Object>> params) throws SQLException {
		Goddess_DAO dao = new Goddess_DAO();
		List<Goddess> result = dao.query(params);
		return result;
	}
}
