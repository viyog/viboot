package indi.viyoung.viboot.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author vi
 * @description
 * @since 2019-05-19 17:48
 */

@Document(indexName = "test",type = "article")
@Data
public class Article implements Serializable {

	private Long id;

	@Field(type= FieldType.Text,analyzer = "ik_max_word")
	private String title;

	private String content;
}
