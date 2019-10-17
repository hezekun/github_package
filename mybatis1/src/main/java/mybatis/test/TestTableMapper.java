package mybatis.test;

import java.util.List;

public interface TestTableMapper {
	
	List<TestTable> selectTestTable();
	
	List<TestTable> findActiveTestTableWithTitleLike(TestTable table);
	
	List<TestTable> findTestTableById(TestTable table);
	int updateTestTable(TestTable table);
}
