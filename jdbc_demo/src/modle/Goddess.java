package modle;

import java.util.Date;

public class Goddess {
	private Integer id;
	private String user_name;
	// 0 as male, 1 as female
	private Integer sex;
	private Integer age;
	private Date birthday;
	private String email;
	private String mobile;
	private String create_user;
	private String update_user;
	private Date create_date;
	private Date update_date;
	// 0 as false, 1 as true
	private Integer isdel;

	public Goddess() {
		this.sex = 1;
		this.create_user = "ADMIN";
		this.update_date = new Date();
		this.update_user = "ADMIN";
		this.create_date = new Date();
		this.isdel = 0;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getmobile() {
		return mobile;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	@Override
	public String toString() {
		return "Godness [id=" + id + ", user_name=" + user_name + ", sex=" + sex + ", age=" + age + ", birthday="
				+ birthday + ", email=" + email + ", mobile=" + mobile + ", create_user=" + create_user
				+ ", update_user=" + update_user + ", create_date=" + create_date + ", update_date=" + update_date
				+ ", isdel=" + isdel + "]";
	}

}
