package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Linkman;

public interface LinkmanDao {

	public void save(Linkman linkman);

	public List<Linkman> findAll(DetachedCriteria dc, int firstResult, int maxResults);

	public void delete(Linkman linkman);

	public Linkman findById(Long lkmId);

	public void update(Linkman linkman);
	
	public int findTotal(DetachedCriteria dc);

}
