package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

@Entity(name = "tree")
public class Tree implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5259484810534205009L;

	@Id
	@Column(name = "tree_id")
	@GeneratedValue
	private Long treeId;
	
	@Column(name = "position")
	private Point position;
	
	public Tree () {
		
	}
	
	public Long getTreeId() {
		return treeId;
	}

	public void setTreeId(Long treeId) {
		this.treeId = treeId;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	
	
}
