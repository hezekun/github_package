package mybatis.mybatis1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.zhisen.service.Exception.ServiceException;
import com.zhisen.service.impl.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws  ServiceException {
//		String resource = "mybatis-config.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		System.out.println(sqlSessionFactory);
//
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//    		TestTableMapper mapper=session.getMapper(TestTableMapper.class);
//    		TestTable table=new TestTable();
//    		table.setId(17);
//    		
//        	List<TestTable> result = mapper.findActiveTestTableWithTitleLike(table);
//        	int result1 = mapper.updateTestTable(table);  //更新
//        	System.out.println(result1);
//        	List<TestTable> result2 = mapper.findTestTableById(table);
//        	System.out.println(result2.size());
//        	session.commit();
//        	
//        	
//			StudentDao mapper1 = session.getMapper(StudentDao.class);
//			
//			int result1 = mapper1.saveStudent();
//			System.out.println(result1);
//			for (Student s : result) {
//				System.out.println(s);
//			}
//		}
		
		StudentServiceImpl impl=new StudentServiceImpl();
		Map<String,Object> student =new HashMap<String,Object>();
		student.put("name", "胡涵辉");
		int result = impl.saveStudent(student);
		System.out.println(result);
	}
}
