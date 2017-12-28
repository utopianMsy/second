package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Linkman;
import cn.itcast.utils.PageBean;

public interface LinkmanService {

	public void save(Linkman linkman);

	public PageBean findAll(DetachedCriteria dc, int page, int rowsNum);

	public void delete(Linkman linkman);

	public Linkman findById(Long lkmId);

	public void update(Linkman linkman);

}
