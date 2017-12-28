package cn.itcast.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
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

import cn.itcast.domain.BaseDict;
import cn.itcast.domain.Customer;
import cn.itcast.service.BaseDictService;
import cn.itcast.service.CustomerService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("struts-default")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BaseDictService baseDictService;
	
	
	private List<BaseDict> custIndustrys;
	private List<BaseDict> custSources;
	private List<BaseDict> custLevels;
	/**
	 * 跳转到客户添加页面
	 * @return
	 */
	@Action(value="customer_toAddPage", results={@Result(name="success", location="/jsp/customer/add.jsp")})
	public String toAddPage(){
		custIndustrys = baseDictService.findByDictType("001");
		custSources = baseDictService.findByDictType("002");
		custLevels = baseDictService.findByDictType("006");
		return SUCCESS;
	}
	
	/**
	 * 客户保存
	 */
	@Action(value="customer_save", results={@Result(name="success", type="redirect", location="/customer_findAll.action")})
	public String save(){
		customerService.save(customer);
		return SUCCESS;
	}
	
	private List<Customer> customers;
	/**
	 * 客户列表查询
	 * @return
	 */
	@Action(value="customer_findAll", results={@Result(name="success", location="/jsp/customer/list.jsp")})
	public String findAll(){
		custIndustrys = baseDictService.findByDictType("001");
		//创建离线条件查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);//from Customer
		//封装条件//StringUtils.isNotBlank(customer.getCustName())相当于判断customer.getCustName()不等于null且不等于""
		if(StringUtils.isNotBlank(customer.getCustName())){
			dc.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}
		if(customer.getCustIndustry()!=null && StringUtils.isNotBlank(customer.getCustIndustry().getDictId())){
			dc.add(Restrictions.eq("custIndustry.dictId", customer.getCustIndustry().getDictId()));
		}
		customers = customerService.findAll(dc);
		return SUCCESS;
	}
	/**
	 * 删除客户
	 * @return
	 */
	@Action(value="customer_deleteCustomer", results={@Result(name="success", type="redirect", location="/customer_findAll.action")})
	public String deleteCustomer(){
		//先根据id查询客户
		customer = customerService.findById(customer.getCustId());
		customerService.delete(customer);
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@Action(value="customer_toEditPage", results={@Result(name="success", location="/jsp/customer/edit.jsp")})
	public String toEditPage(){
		//显示修改页面上三个数据字典表下拉菜单
		custIndustrys = baseDictService.findByDictType("001");
		custSources = baseDictService.findByDictType("002");
		custLevels = baseDictService.findByDictType("006");
		//查询客户数据
		customer = customerService.findById(customer.getCustId());
		//压栈的时候对象用push，集合用set
		ActionContext.getContext().getValueStack().push(customer);
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	@Action(value="customer_edit", results={@Result(name="success", type="redirect", location="/customer_findAll.action")})
	public String edit(){
		customerService.update(customer);
		return SUCCESS;
	}
	
	@Action("customer_findCustomers")
	public String findCustomers() throws IOException{
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = customerService.findAll(dc);
		//排除转json的时候不转的属性
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"linkmans"});
		//把客户集合转成json
		JSONArray json = JSONArray.fromObject(list, jsonConfig);
		System.out.println(json);
		//把json数据反给前端页面
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json.toString());
		return NONE;
	}

	public List<BaseDict> getCustIndustrys() {
		return custIndustrys;
	}
	public void setCustIndustrys(List<BaseDict> custIndustrys) {
		this.custIndustrys = custIndustrys;
	}
	public List<BaseDict> getCustSources() {
		return custSources;
	}
	public void setCustSources(List<BaseDict> custSources) {
		this.custSources = custSources;
	}
	public List<BaseDict> getCustLevels() {
		return custLevels;
	}
	public void setCustLevels(List<BaseDict> custLevels) {
		this.custLevels = custLevels;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
