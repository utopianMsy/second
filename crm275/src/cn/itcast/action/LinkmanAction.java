package cn.itcast.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Linkman;
import cn.itcast.service.LinkmanService;
import cn.itcast.utils.PageBean;
@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("struts-default")
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

	private Linkman linkman = new Linkman();
	@Override
	public Linkman getModel() {
		return linkman;
	}
	@Autowired
	private LinkmanService linkmanService;
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@Action(value="linkman_toAddPage", results={@Result(name="success", location="/jsp/linkman/add.jsp")})
	public String toAddPage(){
		return SUCCESS;
	}
	
	/**
	 * 保存联系人
	 */
	@Action(value="linkman_save", results={@Result(name="success", type="redirect", location="/linkman_findAll.action")})
	public String save(){
		linkmanService.save(linkman);
		return SUCCESS;
	}
	
	/**
	 * 修改联系人
	 */
	@Action(value="linkman_edit", results={@Result(name="success", type="redirect", location="/linkman_findAll.action")})
	public String edit(){
		linkmanService.update(linkman);
		return SUCCESS;
	}
	
	private List<Linkman> linkmans;
	private int page = 1;
	private int rowsNum = 3;
	/**
	 * 查询列表
	 */
	@Action(value="linkman_findAll", results={@Result(name="success", location="/jsp/linkman/list.jsp")})
	public String findAll(){
		DetachedCriteria dc = DetachedCriteria.forClass(Linkman.class);
		//添加条件
		if(linkman.getCustomer()!=null && linkman.getCustomer().getCustId()!=null){
			dc.add(Restrictions.eq("customer.custId", linkman.getCustomer().getCustId()));
		}
		if(StringUtils.isNotBlank(linkman.getLkmName())){
			dc.add(Restrictions.like("lkmName", "%"+linkman.getLkmName()+"%"));
		}
		PageBean pageBean = linkmanService.findAll(dc, page, rowsNum);
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	
	/**
	 * 联系人删除
	 * @return
	 */
	@Action(value="linkman_deleteLinkman", results={@Result(name="success", type="redirect", location="/linkman_findAll.action")})
	public String deleteLinkman(){
		linkmanService.delete(linkman);
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@Action(value="linkman_toEditPage", results={@Result(name="success", location="/jsp/linkman/edit.jsp")})
	public String toEditPage(){
		linkman = linkmanService.findById(linkman.getLkmId());
		ActionContext.getContext().getValueStack().push(linkman);
		return SUCCESS;
	}

	public List<Linkman> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(List<Linkman> linkmans) {
		this.linkmans = linkmans;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setRowsNum(int rowsNum) {
		this.rowsNum = rowsNum;
	}

}
