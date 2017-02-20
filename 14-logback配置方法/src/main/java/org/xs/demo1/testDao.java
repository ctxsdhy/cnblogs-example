package org.xs.demo1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;

@Repository
public class testDao {

	@Autowired
	private SessionFactory sessionFactory;  
	
	@SuppressWarnings("unchecked")
	/*@Cacheable(value="testDao", key="'list'")*/
	public List<testInfo> getList() {
		
		String hql = "from testInfo";  
	    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
	    query.setCacheable(true);
	    return query.list();
	}
	
	/*@Cacheable(value="testDao", key="'view' + #id")*/
	public testInfo getInfo(String id) {
		
		return (testInfo) sessionFactory.getCurrentSession().get(testInfo.class, id);
	}
	
	/*@Caching(
			put={@CachePut(value="testDao", key="'view' + #testInfo.id")}, 
			evict={@CacheEvict(value="testDao", key="'list'")}
			)*/
	public testInfo update(testInfo testInfo) {
		testInfo.setName("789");
		//update
		return testInfo;
	}
	
	/*@Caching( 
			evict={
					@CacheEvict(value="testDao", key="'view' + #id"), 
					@CacheEvict(value="testDao", key="'list'")}
	)*/
	public void delete(String id) {
		//delete
	}
	
	/*@CacheEvict(value="testDao", allEntries=true)*/
	public void deleteAll() {
		//deleteAll
	}
}
