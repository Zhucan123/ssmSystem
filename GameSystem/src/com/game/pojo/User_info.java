package com.game.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuCan
 *
 * @DATE  2017年8月19日
 *
 * @TIME  下午3:11:55
 */
@SuppressWarnings("serial")
public class User_info implements Serializable{

	private Integer id;
	private String username;
	private Date borndate;
	private String sex;
	private Integer roleno;
	private String rolename;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User_info [id=" + id + ", username=" + username + ", borndate=" + borndate + ", sex=" + sex
				+ ", roleno=" + roleno + ", rolename=" + rolename + "]";
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the borndate
	 */
	public Date getBorndate() {
		return borndate;
	}
	/**
	 * @param borndate the borndate to set
	 */
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the roleno
	 */
	public Integer getRoleno() {
		return roleno;
	}
	/**
	 * @param roleno the roleno to set
	 */
	public void setRoleno(Integer roleno) {
		this.roleno = roleno;
	}
	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}
	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
