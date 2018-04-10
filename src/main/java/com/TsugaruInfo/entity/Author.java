package com.TsugaruInfo.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the "Author" database table.
 * 
 */
@Data
@Entity
@Table(name="\"Author\"")
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="author_id")
	private Integer authorId;

	@Column(name="author_name")
	private String authorName;

	private String authority;

	private String email;

	private Boolean enabled;

	private String password;

	public Author() {
	}
}