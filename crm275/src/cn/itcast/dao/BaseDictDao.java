package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findByDictType(String string);

}
