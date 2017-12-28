package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.LinkmanDao;
import cn.itcast.domain.Linkman;
@Repository
public class LinkmanDaoImpl extends HibernateDaoSupport implements LinkmanDao {

	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void save(Linkman linkman) {
		this.getHibernateTemplate().save(linkman);
	}

	@Override
	public int findTotal(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		return list.size()>0 ? list.get(0).intValue() : 0;
	}
	
	@Override
	public List<Linkman> findAll(DetachedCriteria dc, int firstResult, int maxResults) {
		dc.setProjection(null);
		return (List<Linkman>) this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	@Override
	public void delete(Linkman linkman) {
		this.getHibernateTemplate().delete(linkman);
	}

	@Override
	public Linkman findById(Long lkmId) {
		return this.getHibernateTemplate().get(Linkman.class, lkmId);
	}

	@Override
	public void update(Linkman linkman) {
		this.getHibernateTemplate().update(linkman);
	}

}
