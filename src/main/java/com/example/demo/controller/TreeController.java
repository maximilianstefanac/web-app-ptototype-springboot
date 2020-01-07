package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tree;
import com.example.demo.repository.TreeRepository;

@RestController
public class TreeController {
	
	@Autowired
	private TreeRepository treeRepository;
	
	private class TreeResponse {
		private Long treeId;
		private double latitude; // geographische breite
		private double longitude; // geographische länge
		
		public TreeResponse(Long treeId, double latitude, double longitude) {
			this.treeId = treeId;
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
	}
	
	public List<TreeResponse> getAllTrees () {
		
		List<TreeResponse> treeList = new ArrayList<TreeResponse>();
		Iterator<Tree> treeResult = treeRepository.findAll().iterator();
		
		while(treeResult.hasNext()) {
			Tree currentTree = treeResult.next();
			TreeResponse currentTreeResponse = new TreeResponse(
					currentTree.getTreeId(), 
					currentTree.getPosition().getCoordinate().x, 
					currentTree.getPosition().getCoordinate().y );
			treeList.add(currentTreeResponse);
		}
		
		
		
		return treeList;
		
	}
}
