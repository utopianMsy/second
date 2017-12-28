package cn.itcast.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerService {

	public void save(Customer customer);

	public List<Customer> findAll(DetachedCriteria dc);

	public void delete(Customer customer);

	public Customer findById(Integer custId);

	public void update(Customer customer);

}
