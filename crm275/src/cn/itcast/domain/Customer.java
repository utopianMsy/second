package cn.itcast.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.engine.spi.CascadeStyle;

/**
 * 客户实体类
 * @author hasee
 *
 */
@Entity
@Table(name="cst_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cust_id")
	private Integer custId;  //客户编号(主键)//,
	@Column(name="cust_name")
	private String custName;  //客户名称(公司名称)//,
	@Column(name="cust_address")
	private String custAddress;  //客户联系地址//,
	@Column(name="cust_phone")
	private String custPhone;  //客户联系电话//,
	
	//@Column(name="cust_source")
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_source", referencedColumnName="dict_id")
	private BaseDict custSource; //客户信息来源//,
	//@Column(name="cust_industry")
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_industry", referencedColumnName="dict_id")
	private BaseDict custIndustry; //客户所属行业//,
	//@Column(name="cust_level")
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_level", referencedColumnName="dict_id")
	private BaseDict custLevel;  //客户级别//,
	
	@OneToMany(targetEntity=Linkman.class, mappedBy="customer", cascade=CascadeType.ALL)
	private Set<Linkman> linkmans = new HashSet<>();
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public BaseDict getCustSource() {
		return custSource;
	}
	public void setCustSource(BaseDict custSource) {
		this.custSource = custSource;
	}
	public BaseDict getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(BaseDict custIndustry) {
		this.custIndustry = custIndustry;
	}
	public BaseDict getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(BaseDict custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public Set<Linkman> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(Set<Linkman> linkmans) {
		this.linkmans = linkmans;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress + ", custPhone="
				+ custPhone + "]";
	}
	
	
}
