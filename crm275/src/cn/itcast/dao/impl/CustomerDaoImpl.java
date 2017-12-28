package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
@Repository
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

//	@Autowired(required=false)
//	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public List<Customer> findAll(DetachedCriteria dc) {
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	@Override
	public Customer findById(Integer custId) {
		return this.getHibernateTemplate().load(Customer.class, custId);
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}
	
	
	
}
