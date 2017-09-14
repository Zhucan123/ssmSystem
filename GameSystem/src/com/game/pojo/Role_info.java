package com.game.pojo;

import java.io.Serializable;

/**
 * @author zhuCan
 *
 * @DATE  2017年8月19日
 *
 * @TIME  下午3:12:16
 */
@SuppressWarnings("serial")
public class Role_info implements Serializable{

	private Integer id;
	private String rolename;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role_info [id=" + id + ", rolename=" + rolename + "]";
	}
	
}
