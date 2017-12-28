package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.BaseDictDao;
import cn.itcast.domain.BaseDict;
@Repository
public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public List<BaseDict> findByDictType(String string) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dictTypeCode=?", string);
	}
}
