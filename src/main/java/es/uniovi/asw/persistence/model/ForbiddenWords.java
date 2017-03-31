package es.uniovi.asw.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="ForbiddenWords")
public class ForbiddenWords {

	@Id
	@GeneratedValue
	private Long id;
	private String word;
	@ManyToOne
	private Configuration conf;
	
	public ForbiddenWords(){}

	public ForbiddenWords(String word, Configuration conf) {
		this.word = word;
		setConf(conf);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Configuration getConf() {
		return conf;
	}

	public void setConf(Configuration conf) {
		Association.ConfigureForbiddenWords.link(conf, this);
	}
	
	void _setConf(Configuration conf){
		this.conf = conf;
	}
	
	
}
