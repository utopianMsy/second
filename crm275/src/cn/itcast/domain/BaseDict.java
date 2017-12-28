package cn.itcast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="base_dict")
public class BaseDict {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dict_id")
	private String dictId;  //数据字典id(主键)//,
	@Column(name="dict_type_code")
	private String dictTypeCode;  //数据字典类别代码//,
	@Column(name="dict_type_name")
	private String dictTypeName;  //数据字典类别名称//,
	@Column(name="dict_item_name")
	private String dictItemName;  //数据字典项目名称//,
	@Column(name="dict_item_code")
	private String dictItemCode;  //数据字典项目(可为空)//,
	@Column(name="dict_sort")
	private Integer dictSort;  //排序字段//,
	@Column(name="dict_enable")
	private String dictEnable;  //1:使用 0:停用//,
	@Column(name="dict_memo")
	private String dictMemo;  //备注//,
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public String getDictTypeCode() {
		return dictTypeCode;
	}
	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}
	public String getDictTypeName() {
		return dictTypeName;
	}
	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}
	public String getDictItemName() {
		return dictItemName;
	}
	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}
	public String getDictItemCode() {
		return dictItemCode;
	}
	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}
	public Integer getDictSort() {
		return dictSort;
	}
	public void setDictSort(Integer dictSort) {
		this.dictSort = dictSort;
	}
	public String getDictEnable() {
		return dictEnable;
	}
	public void setDictEnable(String dictEnable) {
		this.dictEnable = dictEnable;
	}
	public String getDictMemo() {
		return dictMemo;
	}
	public void setDictMemo(String dictMemo) {
		this.dictMemo = dictMemo;
	}
	@Override
	public String toString() {
		return "BaseDict [dictId=" + dictId + ", dictTypeCode=" + dictTypeCode + ", dictTypeName=" + dictTypeName
				+ ", dictItemName=" + dictItemName + ", dictItemCode=" + dictItemCode + ", dictSort=" + dictSort
				+ ", dictEnable=" + dictEnable + ", dictMemo=" + dictMemo + "]";
	}
	
}
