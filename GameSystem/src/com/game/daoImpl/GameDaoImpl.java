package com.game.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.game.dao.GameDao;
import com.game.pojo.Role_info;
import com.game.pojo.User_info;
import com.game.util.C3P0util;

/**
 * @author zhuCan
 *
 * @DATE 2017年8月19日
 *
 * @TIME 下午3:18:07
 */
public class GameDaoImpl implements GameDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.dao.GameDao#getRole()
	 */
	private QueryRunner runner = C3P0util.getQueryRunner();

	@Override
	public List<Role_info> getRole() {
		// TODO Auto-generated method stub
		String sql = "select * from role";
		List<Role_info> list = new ArrayList<>();

		try {
			list = runner.query(sql, new BeanListHandler<Role_info>(Role_info.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.dao.GameDao#saveUser()
	 */
	@Override
	public boolean saveUser(User_info info) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `user`(username,sex,borndate,roleno) VALUES(?,?,?,?) ";
		int num = 0;
		try {
			num = runner.update(sql, info.getUsername(), info.getSex(), info.getBorndate(), info.getRoleno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.dao.GameDao#getCount(java.lang.String, java.lang.String)
	 */
	@Override
	public int getCount(String name, String roleid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT count(*)FROM `user` WHERE 1=1 ");

		List<Object> list = new ArrayList<>();
		if (name != null && !"".equals(name)) {
			sql.append(" and username like ?");
			list.add("%" + name + "%");
		}
		if (roleid != null && !"0".equals(roleid)) {
			sql.append(" and roleno=?");
			list.add(roleid);
		}
		Long result = 0l;
		try {
			result = (Long) runner.query(sql.toString(), new ScalarHandler(), list.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.dao.GameDao#query(java.lang.String, java.lang.String, int,
	 * int)
	 */
	@Override
	public List<User_info> query(String name, String roleid, int i, int dataCount) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT `user`.id,`user`.username,`user`.borndate,`user`."
				+ "sex,`user`.roleno,role.rolename FROM `user` INNER JOIN role ON `user`.roleno = role.id"
				+ " where 1=1 ");

		List<Object> list = new ArrayList<>();
		if (name != null && !"".equals(name)) {
			sql.append(" and username like ?");
			list.add("%" + name + "%");
		}
		if (roleid != null && !"0".equals(roleid)) {
			sql.append(" and roleno=?");
			list.add(roleid);
		}
		sql.append(" order by id limit ?,?");
		list.add(i);
		list.add(dataCount);
		List<User_info> infos = new ArrayList<>();
		try {
			infos = runner.query(sql.toString(), new BeanListHandler<User_info>(User_info.class), list.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return infos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.dao.GameDao#queryById(java.lang.String)
	 */
	@Override
	public User_info queryById(String idString) {
		// TODO Auto-generated method stub
		String sql = "SELECT `user`.id,`user`.username,`user`.borndate,`user`."
				+ "sex,`user`.roleno,role.rolename FROM `user` INNER JOIN role ON `user`.roleno = role.id"
				+ " where `user`.id=? ";
		User_info info = null;
		try {
			info = runner.query(sql, new BeanHandler<>(User_info.class), idString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.dao.GameDao#update(com.game.pojo.User_info)
	 */
	@Override
	public boolean update(User_info info) {
		// TODO Auto-generated method stub
		String sql = "update user set username=? ,sex=?,borndate=?,roleno=? where id=?";
		int num = 0;
		try {
			num = runner.update(sql, info.getUsername(), info.getSex(), info.getBorndate(), info.getRoleno(),
					info.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.dao.GameDao#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String idString) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id=? ";
		int num = 0;
		try {
			num = runner.update(sql, idString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

}
