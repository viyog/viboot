package indi.viyoung.viboot.es.service;

import indi.viyoung.viboot.es.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ESService {

	Iterable<Article> findAll();

	void add(Article article);

	void delete(long l);

	void addSome(List<Article> list);

	Optional<Article> findOne(Long id);
}
