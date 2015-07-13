package com.test;

import com.dao.TblEquipmentMapper;
import com.db.ConnectionFactory;
import com.kiki.entity.TblEquipment;
import com.kiki.entity.TblEquipmentExample;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*

No spring by page query

Example parameter:
     ShopExample example = new ShopExample();
     Criteria c1 = example.createCriteria(); 
     Criteria c2 = example.createCriteria(); 
     example.or(c2); 
     c1.andSidBetween(1, 100); 
     c1.andSnameLike("my%"); 
     c2.andSidIsNotNull(); 
     example.setOrderByClause("sprice desc"); //sort field		

Page query
     List list = mapper.selectByExampleAndPage(example, new RowBounds(0, 3));


*/
public class TestDAOWithoutSpring {

    public static void main(String[] args) throws Exception {
        SqlSession  session  = ConnectionFactory.getSession();
        //Get DAO
        TblEquipmentMapper mapper  = session.getMapper(TblEquipmentMapper.class);
        //Invoke DAO
        TblEquipmentExample example = new TblEquipmentExample();
        List  list = mapper.selectByExampleAndPage(example, new RowBounds(0,3));
    }
}