package cn.itcast.utils;

import java.util.List;

/**
 * 分页工具类
 * @author hasee
 *
 */
public class PageBean {

	private int page;//当前页*
	private int rowsNum;//每页显示的记录数*
	private int total;//总记录数*
	
	private int prePage;//上一页
	private int nextPage;//下一页
	private int pageNum;//总页数
	
	private int beginPage;//要显示的起页
	private int endPage;//要显示的末页
	
	private List rowsData;//当前页数据集合*

	public PageBean(int page, int rowsNum, int total) {
		super();
		this.page = page;
		this.rowsNum = rowsNum;
		this.total = total;
		
		//算出总页数
		pageNum = total%rowsNum==0 ? total/rowsNum : total/rowsNum+1;
		//算出上一页
		prePage = page==1 ? 1 : page-1;
		//算出下一页
		nextPage = page==pageNum ? pageNum : page+1;
		
		//显示五页。12345  23456  56789
		if(pageNum>5){
			beginPage = page-2;
			endPage = page+2;
			if(beginPage<1){
				beginPage=1;
				endPage=5;
			}
			if(endPage>pageNum){
				endPage = pageNum;
				beginPage = pageNum-4;
			}
		}else{
			beginPage = 1;
			endPage = pageNum;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRowsNum() {
		return rowsNum;
	}

	public void setRowsNum(int rowsNum) {
		this.rowsNum = rowsNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List getRowsData() {
		return rowsData;
	}

	public void setRowsData(List rowsData) {
		this.rowsData = rowsData;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
