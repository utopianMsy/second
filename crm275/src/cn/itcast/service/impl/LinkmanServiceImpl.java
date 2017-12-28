package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.LinkmanDao;
import cn.itcast.domain.Linkman;
import cn.itcast.service.LinkmanService;
import cn.itcast.utils.PageBean;
@Service
@Transactional
public class LinkmanServiceImpl implements LinkmanService {

	@Autowired
	private LinkmanDao linkmanDao;

	@Override
	public void save(Linkman linkman) {
		linkmanDao.save(linkman);
	}

	@Override
	public PageBean findAll(DetachedCriteria dc, int page, int rowsNum) {
		//查询总记录数
		int total = linkmanDao.findTotal(dc);
		//new分页对象
		PageBean pageBean = new PageBean(page, rowsNum, total);
		//查询出指定页的数据集合
		int firstResult = (page-1)*rowsNum;
		int maxResults = rowsNum;
		List<Linkman> list = linkmanDao.findAll(dc, firstResult, maxResults);
		pageBean.setRowsData(list);
		return pageBean;
	}

	@Override
	public void delete(Linkman linkman) {
		linkmanDao.delete(linkman);
	}

	@Override
	public Linkman findById(Long lkmId) {
		return linkmanDao.findById(lkmId);
	}

	@Override
	public void update(Linkman linkman) {
		linkmanDao.update(linkman);
	}
}
