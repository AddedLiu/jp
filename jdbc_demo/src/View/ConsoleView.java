package View;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import action.GoddessControler;
import modle.Goddess;

public class ConsoleView {
	private static String CONTEXT = "Welcome to goddess hotel\n" +
			"Please choose a function\n" +
			"[MAIN/M]: Show main menu\n" +
			"[QUERY/Q]: Show all goddess infomation\n" +
			"[GET/G]: Get a goddess detail infomation by id\n" + 
			"[ADD/A]: Add a goddess\n" + 
			"[UPDATE/U]: Update goddess\n" + 
			"[DELETE/D]: Delete a goddess\n" + 
			"[SEARCH/S]: Search goddess information by user_name or mobile\n" + 
			"[EXIT/E]: Exit goddess hotel\n";
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	
	private static Goddess g = null;
	private static GoddessControler gc = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println(CONTEXT);
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String in = scan.next().toString();
			// Exit goddess hotel
			if (OPERATION_EXIT.equals(in.toUpperCase())
					|| OPERATION_EXIT.subSequence(0, 1).equals(in.toUpperCase())){
				System.out.println("Exit goddess hotel!");
				break;
			}else if (OPERATION_ADD.equals(in.toUpperCase())
					|| OPERATION_ADD.subSequence(0, 1).equals(in.toUpperCase())){
				addGoddess();
				System.out.println("\n" + CONTEXT);
			}else if (OPERATION_MAIN.equals(in.toUpperCase())
					|| OPERATION_MAIN.subSequence(0, 1).equals(in.toUpperCase())){
				System.out.println(CONTEXT);
			}else if (OPERATION_QUERY.equals(in.toUpperCase())
					|| OPERATION_QUERY.subSequence(0, 1).equals(in.toUpperCase())){
				query();
				System.out.println("\n" + CONTEXT);
			}else if (OPERATION_GET.equals(in.toUpperCase())
					|| OPERATION_GET.subSequence(0, 1).equals(in.toUpperCase())){
				getGoddess();
				System.out.println("\n" + CONTEXT);
			}else if (OPERATION_UPDATE.equals(in.toUpperCase())
					|| OPERATION_UPDATE.subSequence(0, 1).equals(in.toUpperCase())){
				updateGoddess();
				System.out.println("\n" + CONTEXT);
			}else if (OPERATION_DELETE.equals(in.toUpperCase())
					|| OPERATION_DELETE.subSequence(0, 1).equals(in.toUpperCase())){
				deleteGoddess();
				System.out.println("\n" + CONTEXT);
			}else if (OPERATION_SEARCH.equals(in.toUpperCase())
					|| OPERATION_SEARCH.subSequence(0, 1).equals(in.toUpperCase())){
				searchGoddess();
				System.out.println("\n" + CONTEXT);
			}
			else{			
				System.out.println("You input string is:" + in);
			}
		}
		scan.close();
	}
	
	// Search goddess by goddess [name] or [mobile]
	private static void searchGoddess() throws SQLException {
		gc = new GoddessControler();
		Scanner s = new Scanner(System.in);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("Please enter goddess [user_name](null while don't know):");
		String user_name = s.next();
		if(!user_name.equals("null")){
			map.put("name", "user_name");
			map.put("rela", "=");
			map.put("value", "'"+user_name+"'");
			list.add(map);
		}
		System.out.println("Please enter goddess [moblie]:");
		String moblie = s.next();
		if(!moblie.equals("null")){
			map.put("name", "moblie");
			map.put("rela", "=");
			map.put("value", "'"+moblie+"'");
			list.add(map);
		}
		List<Goddess> ls = gc.query(list);
		for(Goddess go : ls){
			System.out.println(go.toString());
		}
		s.close();
	}

	// Delete a goddess
	private static void deleteGoddess() throws NumberFormatException, SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter goddess [id]:");
		Integer id = Integer.valueOf(s.next());
		g = gc.query(id);
		if(null != g){
			gc.delete(id);
			System.out.println("Delete success!");
		}else
			System.out.println("No such goddess, please enter ture [id]!");
		s.close();
	}

	// Update Goddess
	private static void updateGoddess() throws NumberFormatException, SQLException, ParseException {
		gc = new GoddessControler();
		System.out.println("Please enter goddess [id]:");
		Scanner s = new Scanner(System.in);
		g = gc.query(Integer.valueOf(s.next()));
		if (null != g){
			System.out.println("Please enter goddess [user_name](null if don't change):");
			if (s.next().toString() != "null")
				g.setUser_name(s.next());
			System.out.println("Please enter goddess [age]:");
			if (s.next().toString() != "null")
				g.setAge(Integer.valueOf(s.next()));
			System.out.println("Please enter goddess [birthday](yyyy-mm-dd):");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
			Date birthday = sf.parse(s.next());
			if (s.next().toString() != "null")
				g.setBirthday(birthday);
			System.out.println("Please enter goddess [moblie]:");
			if (s.next().toString() != "null")
				g.setmobile(s.next());
			System.out.println("Please enter goddess [email]:");
			if (s.next().toString() != "null")
				g.setEmail(s.next());
			g.setUpdate_date(new Date());
			gc.update(g);
			System.out.println("Update success!");
		}
		s.close();
	}

	// Get goddess detail information
	private static void getGoddess() throws NumberFormatException, SQLException {
		gc = new GoddessControler();
		System.out.println("Please enter goddess [id]:");
		Scanner s = new Scanner(System.in);
		g = gc.query(Integer.valueOf(s.next()));
		if(g == null) {
			System.out.println("No such goddess, please enter true [id]!\n");
			System.out.println(CONTEXT);
		}
		else
			System.out.println(g.toString());
		s.close();
	}

	// Get all goddess id, name and age
	private static void query() throws SQLException {
		gc = new GoddessControler();
		List<Goddess> result = gc.query();
		for(Goddess go: result){
			System.out.println("id: " + go.getId() + ", user_name: " + 
		go.getUser_name() + ", age: " + go.getAge());
		}
	}

	// Add goddess
	private static void addGoddess() throws Exception {
		g = new Goddess();
		gc = new GoddessControler();
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter goddess [user_name]:");
		g.setUser_name(s.next());
		System.out.println("Please enter goddess [age]:");
		g.setAge(Integer.valueOf(s.next()));
		System.out.println("Please enter goddess [birthday](yyyy-mm-dd):");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		Date birthday = sf.parse(s.next());
		g.setBirthday(birthday);
		System.out.println("Please enter goddess [moblie]:");
		g.setmobile(s.next());
		System.out.println("Please enter goddess [email]:");
		g.setEmail(s.next());
		gc.add(g);
		System.out.println("Add success!");
		s.close();
	}
}
