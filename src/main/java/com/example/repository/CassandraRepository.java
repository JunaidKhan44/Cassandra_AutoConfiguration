/**
 * 
 */
package com.example.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.SimpleTable;

/**
 * junaid.khan
 *
 */
@Repository
public interface CassandraRepository extends CrudRepository<SimpleTable,Serializable>{

	Optional<SimpleTable> findByIdAndName(String id,String name);
}
