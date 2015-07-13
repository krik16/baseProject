package service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kiki.dao.BrandDao;

/**
 * @author kejun
 *
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
public class BrandDaoTest {
	@Autowired
	BrandDao brandDao;
	
	@Test
	public void testGetMGCategoriesTags(){
		System.err.println(brandDao.getMGCategoriesTags(new ObjectId("51f9d9e131d65584ab000a15")));
	} 
	
	@Test
	public void testGetList(){
		List<ObjectId> idList = new ArrayList<ObjectId>();
		idList.add(new ObjectId("51f9d9e131d65584ab000a15"));
		idList.add(new ObjectId("51f9d9e131d65584ab000a17"));
		
//		brandDao.getBrandList(idList)
	}

}
