/**
 * 
 */
package com.game.util;

import java.util.List;

/**
 * @author MR zhu can
 * @date 2017��8��16��
 * @time ����1:46:32
 */
public class PageBean<T> {

	// ��ǰ��ʾҳ
	private int pageIndex;
	// ÿҳ��ʾ��������
	private int dataCount;
	// ��������
	private int totalData;
	// ��ҳ��
	private int totalPage;
	// ���ݶ���ļ���
	private List<T> list;

	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex
	 *            the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		// ���Ƶ�ǰҳ���ķ�Χ
		if (pageIndex <=0) {
			this.pageIndex = 0;
		} else if (pageIndex < totalPage) {
			this.pageIndex = pageIndex;
		} else {
			this.pageIndex = totalPage-1;
		}

	}

	/**
	 * @return the dataCount
	 */
	public int getDataCount() {
		return dataCount;
	}

	/**
	 * @param dataCount
	 *            the dataCount to set
	 */
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
		// ͨ����ȡ��ÿҳ��������������ҳ��
		this.totalPage = (this.totalData % this.dataCount == 0) ? (this.totalData / this.dataCount)
				: (this.totalData / this.dataCount + 1);
	}

	/**
	 * @return the totalData
	 */
	public int getTotalData() {
		return totalData;
	}

	/**
	 * @param totalData
	 *            the totalData to set
	 */
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage
	 *            the totalPage to set
	 */
	/*
	 * public void setTotalPage(int totalPage) { this.totalPage = totalPage; }
	 */
	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageBean [pageIndex=" + pageIndex + ", dataCount=" + dataCount + ", totalData=" + totalData
				+ ", totalPage=" + totalPage + "]";
	}

}
