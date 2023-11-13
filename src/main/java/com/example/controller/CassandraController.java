/**
 * 
 */
package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SimpleTable;
import com.example.repository.CassandraRepository;

/**
 * junaid.khan
 *
 */
@RestController
@RequestMapping("/cassandra")
public class CassandraController {

	@Autowired
	private CassandraRepository cassandraRepository;
	
	@PostMapping
	public ResponseEntity<SimpleTable> saveIntoSimpleTable(@RequestBody SimpleTable simpleTable){
		SimpleTable saveData=cassandraRepository.save(simpleTable);
		return new ResponseEntity<>(saveData,HttpStatus.OK);
	}
	
	
	@GetMapping(path="{id}/{name}")
	public ResponseEntity<SimpleTable> fetchRecordFromSimpleTable(@PathVariable("id") String id,
			@PathVariable("name") String name){
		Optional<SimpleTable> fetchData= cassandraRepository.findByIdAndName(id, name);
		if(fetchData.isPresent()) {
			return new ResponseEntity<>(fetchData.get(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
}
