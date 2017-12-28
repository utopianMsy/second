package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<Customer> findAll(DetachedCriteria dc) {
		return customerDao.findAll(dc);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	public Customer findById(Integer custId) {
		return customerDao.findById(custId);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	
}
