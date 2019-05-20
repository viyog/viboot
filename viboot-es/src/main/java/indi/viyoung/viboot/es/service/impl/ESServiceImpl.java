package indi.viyoung.viboot.es.service.impl;

import indi.viyoung.viboot.es.dao.ESDao;
import indi.viyoung.viboot.es.entity.Article;
import indi.viyoung.viboot.es.service.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author vi
 * @description
 * @since 2019-05-19 12:31
 */
@Service
public class ESServiceImpl implements ESService {


	@Autowired
	private ESDao esDao;

	@Override
	public Iterable<Article> findAll() {
		return esDao.findAll();
	}

	@Override
	public void add(Article article) {
		esDao.save(article);
	}

	@Override
	public void delete(long l) {
		esDao.deleteById(l);
	}

	@Override
	public void addSome(List<Article> list) {
		esDao.saveAll(list);
	}

	@Override
	public Optional<Article> findOne(Long id) {
		return esDao.findById(id);
	}
}
