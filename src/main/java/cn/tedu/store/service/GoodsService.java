package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
@Service
public class GoodsService implements IGoodsService{
    @Resource
	private GoodsMapper goodsMapper;

	public List<Goods> getGoodsByCategoryId(
			Integer categoryId, Integer offset, Integer count) {
		List<Goods> list = goodsMapper.select(categoryId, offset, count);
		return list;
	}

	public Integer getCount(Integer categoryId) {
		
		return goodsMapper.selectCount(categoryId);
	}

	public Goods getGoodsById(String id) {
		
		return goodsMapper.selectGoodsById(id);
	}
	

}
