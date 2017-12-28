package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerDao {

	public void save(Customer customer);

	public List<Customer> findAll(DetachedCriteria dc);

	public void delete(Customer customer);

	public Customer findById(Integer custId);

	public void update(Customer customer);

}
