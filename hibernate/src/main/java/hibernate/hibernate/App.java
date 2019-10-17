package hibernate.hibernate;


import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import hibernate.dao.entity.Category;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       //创建配置对象
    	Configuration fig = new Configuration();
    	//启动配置对象
    	fig.configure();
    	//创建session工厂
    	SessionFactory factory = fig.buildSessionFactory();
    	//开启session
    	Session session = factory.openSession();
    	session.getTransaction().begin();
//    	Role role = new Role();
//    	role.setCode("code");
//    	role.setCreateTime(new Date(System.currentTimeMillis()));
//    	role.setCreateUserCode("user001");
//    	role.setCreateUserName("he");
//    	role.setIsDel(0);
//    	role.setModifierCode("user001");
//    	role.setModifyTime(new Date(System.currentTimeMillis()));
//    	role.setModifierName("he");
//    	role.setVersion(0);
//    	session.save(role);
    	
    	//Role r=session.find(Role.class, 7);
    	
//    	EntityManagerFactory factory = Persitence.createEntityManagerFactory("myJpa");
//    	//2.通过实体管理器工厂获取实体管理器
//    	EntityManager em = factory.createEntityManager();
//    	//3.获取事务对象,开启事务
//    	EntityTransaction tx = em.getTransaction();
//    	tx.begin();
//    	Role r = new Role();
//    	r.setId(null);
//    	r.setCode("code");
//    	r.setCreateTime(new Date(System.currentTimeMillis()));
//    	r.setCreateUserCode("胡涵辉");
//    	r.setCreateUserName("胡涵辉");
//    	r.setIsDel(0);
//    	r.setModifierCode("王子恒");
//    	r.setModifyTime(new Date(System.currentTimeMillis()));
//    	r.setModifierName("王子恒");
//    	r.setVersion(0);
//    	System.out.println(r.getCreateUserName());
//    	r.setCreateUserName("胡涵辉");
//    	session.saveOrUpdate(r);
    	
    	
//    	Role r1=new Role(3, "code", "name", "createUserName", "createUserCode", new Date(System.currentTimeMillis()), 
//    			"modifierName", "modifierCode", new Date(System.currentTimeMillis()), 0, 0);
//    	Role r2=new Role(3, "code", "name", "createUserName", "createUserCode", new Date(System.currentTimeMillis()), 
//    			"modifierName", "modifierCode", new Date(System.currentTimeMillis()), 0, 0);
//    	Role r3=new Role(3, "code", "name", "createUserName", "createUserCode", new Date(System.currentTimeMillis()), 
//    			"modifierName", "modifierCode", new Date(System.currentTimeMillis()), 0, 0);
//    	
//    	//一对多映射
//    	Set<Test> tests =new HashSet<Test>();
//    	Test t1=new Test(null, 1,"testName1");
//    	Test t2=new Test(null, 2,"testName2");
//    	Test t3=new Test(null, 3,"testName3");
//    	Test t4=new Test(null, 4,"testName4");
//    	
//    	tests.add(t1);
//    	tests.add(t2);
//    	tests.add(t3);
//    	tests.add(t4);
//    	
//    	Role r1=new Role(25, "code", "name", "createUserName", "createUserCode", new Date(System.currentTimeMillis()), 
//   			"modifierName", "modifierCode", new Date(System.currentTimeMillis()), 0, 0,tests);
//    	
//    	session.save(r1);
    	

//    	//一对一映射
//    	Clerk c=session.find(Clerk.class, 1);
//    	System.out.println(c.getName());
//    	System.out.println(c.getJob().getJob_name());
    	
//    	//双向多对多
//    	 Category c1 = new Category();
//         c1.setCatregoryName("C-AA");
//
//         Category c2 = new Category();
//         c2.setCatregoryName("C-BB");
//
//         Item i1 = new Item();
//         i1.setItemName("I-AA");
//         Item i2 = new Item();
//         i2.setItemName("I-BB");
//
//         c1.getItems().add(i1);
//         c1.getItems().add(i2);//向c1对象的item集合里加入元素
//         c2.getItems().add(i1);
//         c2.getItems().add(i2);//向c2对象的item集合里加入元素
//         session.save(c1);
//         session.save(c2);
    	
    	
//    	//hql查询语法   
//    	String hql = "select new Category(c.categoryId,c.categoryName) from Category c";
//    	Query query=session.createQuery(hql);
//		List result = query.getResultList();
//    	System.out.println(result);
    	
    	
//    	for(Object[] to:result) {
//    		Object[] t=(Object[]) to;
//    		System.out.println(t[0]);
//    		System.out.println(t[1]);
//    	}
//    	
//    	//new Map
//    	String hql = "select new Map(c.categoryId as id,c.categoryName as name) from Category c";
//    	Query query=session.createQuery(hql);
//		List result = query.getResultList();
//    	System.out.println(result);
//    	//更新
//    	String hql = "UPDATE Category SET categoryName = '王子恒'  WHERE categoryName = 'C-AA'";
//        int result = session.createQuery(hql).executeUpdate();
//    	System.out.println(result);
    	
//    	String hql = "from Category c join Item i on c.categoryId=i.itemId where c.id=1";
//        Query query = session.createQuery(hql);
//        List result = query.getResultList();
//        Object[] column =(Object[] )result.get(0); 
//        //拿出来的是List存了2个Object对象
//    	System.out.println(column);
    	
//    	//迫切左外连接查询
//    	String hql="select distinct r from Role r left join fetch r.tests";
//    	Query query = session.createQuery(hql);
//    	List<Role> roles = query.getResultList();
//    	System.out.println(roles.size());
//    	for(Role r: roles) {
//    		System.out.println(r.getName()+"  "+"这个role对应的多的test个数有"+r.getTests().size());
//    	}
    	
    	CriteriaQuery<Category> criteriaQuery = session.getCriteriaBuilder().createQuery(Category.class);
    	//criteriaQuery 对象可以添加各种查询条件和关联条件等
    	
    	
    	session.getTransaction().commit();
    	session.close();
    }
}
