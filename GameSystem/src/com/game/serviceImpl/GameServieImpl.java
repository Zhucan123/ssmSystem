package com.game.serviceImpl;

import java.util.List;

import com.game.dao.GameDao;
import com.game.daoImpl.GameDaoImpl;
import com.game.pojo.Role_info;
import com.game.pojo.User_info;
import com.game.service.GameService;

/**
 * @author zhuCan
 *
 * @DATE 2017年8月19日
 *
 * @TIME 下午3:17:02
 */
public class GameServieImpl implements GameService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.service.GameService#getRole()
	 */
	private GameDao dao = new GameDaoImpl();

	@Override
	public List<Role_info> getRole() {
		// TODO Auto-generated method stub
		return dao.getRole();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.service.GameService#saveUser(com.game.pojo.User_info)
	 */
	@Override
	public boolean saveUser(User_info info) {
		// TODO Auto-generated method stub
		return dao.saveUser(info);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.service.GameService#getCount(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int getCount(String name, String roleid) {
		// TODO Auto-generated method stub
		return dao.getCount(name, roleid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.service.GameService#query(java.lang.String,
	 * java.lang.String, int, int)
	 */
	@Override
	public List<User_info> query(String name, String roleid, int i, int dataCount) {
		// TODO Auto-generated method stub
		return dao.query(name, roleid, i, dataCount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.service.GameService#queryById(java.lang.String)
	 */
	@Override
	public User_info queryById(String idString) {
		// TODO Auto-generated method stub
		return dao.queryById(idString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.service.GameService#doUpdate(com.game.pojo.User_info)
	 */
	@Override
	public boolean doUpdate(User_info info) {
		// TODO Auto-generated method stub
		return dao.update(info);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.service.GameService#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String idString) {
		// TODO Auto-generated method stub
		return dao.delete(idString);
	}

}
