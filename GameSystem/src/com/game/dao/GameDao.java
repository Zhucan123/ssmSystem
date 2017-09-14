package com.game.dao;

import java.util.List;

import com.game.pojo.Role_info;
import com.game.pojo.User_info;

/**
 * @author zhuCan
 *
 * @DATE  2017年8月19日
 *
 * @TIME  下午3:17:53
 */
public interface GameDao {

	/**
	 * @return
	 */
	List<Role_info> getRole();

	/**
	 * @param info 
	 * @return
	 */
	boolean saveUser(User_info info);

	/**
	 * @param name
	 * @param roleid
	 * @return
	 */
	int getCount(String name, String roleid);

	/**
	 * @param name
	 * @param roleid
	 * @param i
	 * @param dataCount
	 * @return
	 */
	List<User_info> query(String name, String roleid, int i, int dataCount);

	/**
	 * @param idString
	 * @return
	 */
	User_info queryById(String idString);

	/**
	 * @param info
	 * @return
	 */
	boolean update(User_info info);

	/**
	 * @param idString
	 * @return
	 */
	boolean delete(String idString);

}
