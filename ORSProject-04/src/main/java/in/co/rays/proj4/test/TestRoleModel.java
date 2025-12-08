package in.co.rays.proj4.test;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {
	
	public static RoleModel model = new RoleModel();
	
	
	public static void main(String[] args) throws ApplicationException, SQLException {
	
//		testAdd();
//		testupdate();
//		testDelete();
//		testFindByPk();
//		testFindByName();
		testSearch();
			
	}
	
	//-------------------TestAdd--------------------//
	
	public static void testAdd() throws ApplicationException {
		
//		RoleModel model = new RoleModel(); 
		
		RoleBean bean = new RoleBean();
		
		bean.setName("kiosk");
		bean.setDescription("kiosk");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		try {
			model.add(bean);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("data added successfully");
	}
	
	//-------------------------testupdate----------------------------//
	
	public static void testupdate() throws ApplicationException {
		
		
		RoleBean bean = new RoleBean();
	
		bean.setId(2);
		bean.setName("Student");
		bean.setDescription("Student");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		RoleModel model = new RoleModel();

		try {
			model.update(bean);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("data updated successfully");
		
		
	}
	
	//---------------------testDelete----------------------//
	
	public static void testDelete() {

		RoleBean bean = new RoleBean();
		bean.setId(5);
		
		RoleModel model = new RoleModel();
		try {
			model.delete(bean);
			System.out.println("data deleted successfully");
			
		} catch (ApplicationException e) {
			
						e.printStackTrace();
		}
	}
	
	//---------------------testfindbypk-------------------------------//
	
	public static void testFindByPk() {
		
		         RoleModel model = new RoleModel();
				RoleBean existsbean;
				
				try {
					existsbean = model.findByPk(1);
					if(existsbean != null) {
						System.out.println("ID exists");
					} else {
						System.out.println("no record found");
					}
				} catch (ApplicationException e) {
					
					e.printStackTrace();
				}
				
				
			}

	//-----------------------test findbyname--------------------------//
	
	public static void testFindByName() throws SQLException, ApplicationException {

		RoleModel model = new RoleModel();
		
		RoleBean existsbean = model.findByName("kiosk");
		
		if(existsbean != null) {
			
			System.out.println("name exists");
			
		} else {
			
			System.out.println("no record found");
		}

	}
	
	//-----------------testsearch-------------------------//
	
	public static void testSearch() {
		
		try {
			RoleModel model = new RoleModel();
			RoleBean bean = new RoleBean();
			
			List list = new ArrayList();
			bean.setName("Admin");
			list = model.search(bean, 0, 0);
			
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (RoleBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getDescription());
				System.out.println(bean.getCreatedBy());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
