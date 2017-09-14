package com.game.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.pojo.Role_info;
import com.game.pojo.User_info;
import com.game.service.GameService;
import com.game.serviceImpl.GameServieImpl;
import com.game.util.ConstantUtil;
import com.game.util.DateFormatUtil;
import com.game.util.PageBean;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private GameService service = new GameServieImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		String choice = request.getParameter("choice");
		switch (choice) {
		// 跳转到新增页面
		case ConstantUtil.TURN_TO_ADD_PAGE:
			turnAddPage(request, response);
			break;
		// 进行添加操作
		case ConstantUtil.ADD_INFO:
			addUserInfo(request, response);
			// 进行查询的操作
		case ConstantUtil.DO_QUERY:
			doQurey(request, response);
			break;
		// 跳转到修改页
		case ConstantUtil.TURN_TO_UPDATE_PAGE:
			turnUpdatePage(request, response);
			break;
		// 修改操作
		case ConstantUtil.UPDATE_INFO:
			doUpdate(request, response);
			break;
		// 删除
		case ConstantUtil.RAMOVE_INFO:
			doRamove(request, response);
			break;
		// 详情页面
		case ConstantUtil.TURN_TO_SHOW_PAGE:
			showInfo(request, response);
			break;
		
		default:
			break;
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void showInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		User_info info = service.queryById(idString);
		HttpSession session = request.getSession();
		session.setAttribute("infos", info);
		response.sendRedirect("Show_user_info.jsp");
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doRamove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		boolean isOk = service.delete(idString);
		PrintWriter writer = response.getWriter();
		if (isOk) {
			writer.println("<script>alert('删除成功');location.href='GameServlet?choice=0'</script>");
		} else {
			writer.println("<script>alert('删除失败');location.href='GameServlet?choice=0'</script>");
		}
		writer.flush();
		writer.close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		User_info info = getInfo(request);
		info.setId(Integer.parseInt(request.getParameter("id")));

		boolean isOk = service.doUpdate(info);
		PrintWriter writer = response.getWriter();
		if (isOk) {
			writer.println("<script>alert('修改成功');location.href='GameServlet?choice=0'</script>");
		} else {
			writer.println("<script>alert('修改失败');location.href='GameServlet?choice=0'</script>");
		}
		writer.flush();
		writer.close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void turnUpdatePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		User_info info = service.queryById(idString);
		List<Role_info> role_infos = service.getRole();
		HttpSession session = request.getSession();
		session.setAttribute("role_infos", role_infos);
		session.setAttribute("info", info);
		System.out.println(info);
		response.sendRedirect("Update_info.jsp");

	}

	protected void doQurey(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取条件
		String name = request.getParameter("username");
		String roleid = request.getParameter("roleid");
		String pageIndex = request.getParameter("pageIndex");
		// 创建分页对象
		PageBean<User_info> bean = new PageBean<>();
		// 分页设值
		bean.setTotalData(service.getCount(name, roleid));
		bean.setDataCount(3);
		if (pageIndex != null && !"".equals(pageIndex)) {
			bean.setPageIndex(Integer.parseInt(pageIndex));
		} else {
			bean.setPageIndex(0);
		}

		List<User_info> list = service.query(name, roleid, bean.getPageIndex() * bean.getDataCount(),
				bean.getDataCount());
		bean.setList(list);
		System.out.println(bean);
		HttpSession session = request.getSession();
		session.setAttribute("pageBean", bean);
		session.setAttribute("roles", service.getRole());
		session.setAttribute("username", name);
		session.setAttribute("roleid", roleid);
		response.sendRedirect("Game_show_info.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void turnAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Role_info> role_infos = service.getRole();

		HttpSession session = request.getSession();
		session.setAttribute("role_infos", role_infos);
		response.sendRedirect("Game_add.jsp");
	}

	protected void addUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User_info info = getInfo(request);
		boolean isOk = service.saveUser(info);
		PrintWriter writer = response.getWriter();
		if (isOk) {
			writer.println("<script>alert('新增成功');location.href='GameServlet?choice=0'</script>");
		} else {
			writer.println("<script>alert('新增失败');location.href='GameServlet?choice=0'</script>");
		}
		writer.flush();
		writer.close();
	}

	private User_info getInfo(HttpServletRequest request) {
		User_info info = new User_info();
		info.setUsername(request.getParameter("username"));
		info.setSex(request.getParameter("sex"));
		info.setBorndate(DateFormatUtil.format(request.getParameter("borndate")));
		info.setRoleno(Integer.parseInt(request.getParameter("roleid")));
		return info;
	}
}
