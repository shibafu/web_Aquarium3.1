package com.TsugaruInfo.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the picture_master database table.
 * 
 */
@Data
@Entity
@Table(name="picture_master")
@NamedQuery(name="PictureMaster.findAll", query="SELECT p FROM PictureMaster p")
public class PictureMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="picture_id")
	private Long pictureId;

	private String name;

	@Column(name="picture_data")
	private byte[] pictureData;

	public PictureMaster() {
	}
}