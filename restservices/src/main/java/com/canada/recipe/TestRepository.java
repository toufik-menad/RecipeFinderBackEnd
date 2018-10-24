/**
 * 
 */
package com.canada.recipe;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MENAD
 *
 */
@Repository
public interface TestRepository extends JpaRepository<Test,UUID>{
}
