package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.BaseDict;

public interface BaseDictService {

	public List<BaseDict> findByDictType(String string);

}
