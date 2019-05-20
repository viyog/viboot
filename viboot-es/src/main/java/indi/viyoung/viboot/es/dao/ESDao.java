package indi.viyoung.viboot.es.dao;

import indi.viyoung.viboot.es.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESDao extends ElasticsearchRepository<Article,Long> {
}
