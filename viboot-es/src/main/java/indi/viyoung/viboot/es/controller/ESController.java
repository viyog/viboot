package indi.viyoung.viboot.es.controller;

import indi.viyoung.viboot.es.entity.Article;
import indi.viyoung.viboot.es.service.ESService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author vi
 * @description
 * @since 2019-05-19 12:26
 */
@RestController
@RequestMapping("es")
@Slf4j
public class ESController {


	@Autowired
	private ESService esService;

	@GetMapping("addSome")
	public void addSome() {
		List<Article> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Article article = new Article();
			article.setId((long) i);
			article.setTitle("测试"+i);
			article.setContent("测试1文字啊啊"+i);
			list.add(article);
		}
		esService.addSome(list);
	}


	@GetMapping("get")
	public Iterable<Article> getAll() {
		Iterable<Article> all = esService.findAll();
		all.forEach(one ->{
			log.info(one.toString());
		});

		return all;

	}

	@GetMapping("add")
	public void add() {
		Article article = new Article();
		article.setId(1L);
		article.setTitle("测试1");
		article.setContent("测试1文字啊啊");
		esService.add(article);
	}

	@GetMapping("put")
	public void put() {
		Article article = new Article();
		article.setId(1L);
		article.setTitle("测试1");
		article.setContent("测试1修改啊啊");
		esService.add(article);
	}

	@GetMapping("delete")
	public void delete() {
		esService.delete(1L);
	}


	@GetMapping("getOne/{id}")
	public Optional<Article> getOne(@PathVariable("id") Long id) {
		return esService.findOne(id);
	}
}
