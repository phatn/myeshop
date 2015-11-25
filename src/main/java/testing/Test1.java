package testing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.myeshop.dao.impl.ProductDaoImpl;
import com.myeshop.domain.Product;

public class Test1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("es-unit");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.setEntityManager(entityManager);
		List<Product> products = productDao.getAll();
		for(Product prod : products) {
			System.out.println("Id: " + prod.getId());
		}
		// ==============TRANSACTION BEGIN ============
		/*
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.setEntityManager(entityManager);
		
		ProductImageDaoImpl productImageDao = new ProductImageDaoImpl();
		productImageDao.setEntityManager(entityManager);
		
		ProductRelationshipDaoImpl prodRelDao = new ProductRelationshipDaoImpl();
		prodRelDao.setEntityManager(entityManager);
		
		RoleDaoImpl roleDao = new RoleDaoImpl();
		roleDao.setEntityManager(entityManager);
		
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		customerDao.setEntityManager(entityManager);
		
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setEntityManager(entityManager);*/
		
		/*Product product = productDao.get(600L);
		Product relProd1 = productDao.get(200L);
		Product relProd2 = productDao.get(250L);
		Product relProd3 = productDao.get(300L);
		Product relProd4 = productDao.get(350L);
		Product relProd5 = productDao.get(400L);
		Product relProd6 = productDao.get(450L);
		Product relProd7 = productDao.get(500L);
		Product relProd8 = productDao.get(550L);
		
		
		ProductRelationship prodRel1 = new ProductRelationship();
		prodRel1.setProduct(product);
		prodRel1.setRelatedProduct(relProd1);
		
		ProductRelationship prodRel2 = new ProductRelationship();
		prodRel2.setProduct(product);
		prodRel2.setRelatedProduct(relProd2);
		
		
		ProductRelationship prodRel3 = new ProductRelationship();
		prodRel3.setProduct(product);
		prodRel3.setRelatedProduct(relProd3);
		
		ProductRelationship prodRel4 = new ProductRelationship();
		prodRel4.setProduct(product);
		prodRel4.setRelatedProduct(relProd4);
		
		ProductRelationship prodRel5 = new ProductRelationship();
		prodRel5.setProduct(product);
		prodRel5.setRelatedProduct(relProd5);
		
		ProductRelationship prodRel6 = new ProductRelationship();
		prodRel6.setProduct(product);
		prodRel6.setRelatedProduct(relProd6);
		
		ProductRelationship prodRel7 = new ProductRelationship();
		prodRel7.setProduct(product);
		prodRel7.setRelatedProduct(relProd7);
		
		ProductRelationship prodRel8 = new ProductRelationship();
		prodRel8.setProduct(product);
		prodRel8.setRelatedProduct(relProd8);
		
		prodRelDao.create(prodRel1);
		prodRelDao.create(prodRel2);
		prodRelDao.create(prodRel3);
		prodRelDao.create(prodRel4);
		prodRelDao.create(prodRel5);
		prodRelDao.create(prodRel6);
		prodRelDao.create(prodRel7);
		prodRelDao.create(prodRel8);*/
		
		/*product.getRelationships().add(prodRel1);
		product.getRelationships().add(prodRel2);
		product.getRelationships().add(prodRel3);
		product.getRelationships().add(prodRel4);
		product.getRelationships().add(prodRel5);
		product.getRelationships().add(prodRel6);
		product.getRelationships().add(prodRel7);
		product.getRelationships().add(prodRel8);*/
		
		/*ProductImage tinyImage = new ProductImage();
		tinyImage.setImage("ab60177_2.jpg");
		tinyImage.setProduct(product);
		tinyImage.setImageSize(ImageSize.MEDIUM);
		
		ProductImage tinyImage1 = new ProductImage();
		tinyImage1.setImage("ab60177_3.jpg");
		tinyImage1.setProduct(product);
		tinyImage1.setImageSize(ImageSize.MEDIUM);
		
		ProductImage tinyImage2 = new ProductImage();
		tinyImage2.setImage("ab60177_4.jpg");
		tinyImage2.setProduct(product);
		tinyImage2.setImageSize(ImageSize.MEDIUM);
		
		ProductImage tinyImage3 = new ProductImage();
		tinyImage3.setImage("ab55105_5.jpg");
		tinyImage3.setProduct(product);
		tinyImage3.setImageSize(ImageSize.MEDIUM);
		
		ProductImage tinyImage4 = new ProductImage();
		tinyImage4.setImage("ab60177_6.jpg");
		tinyImage4.setProduct(product);
		tinyImage4.setImageSize(ImageSize.MEDIUM);
		
		ProductImage tinyImage5 = new ProductImage();
		tinyImage5.setImage("ab60177_7.jpg");
		tinyImage5.setProduct(product);
		tinyImage5.setImageSize(ImageSize.MEDIUM);
		
		productImageDao.create(tinyImage);
		productImageDao.create(tinyImage1);
		productImageDao.create(tinyImage2);
		productImageDao.create(tinyImage3);
		productImageDao.create(tinyImage4);
		productImageDao.create(tinyImage5);*/
		
		
		//PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		// ============== BEGIN COMMIT ================
		
		/*User customer = new User();
		customer.setAdminEmailAddress("admin@gmail.com");
		customer.setFirstName("Phat");
		customer.setLastName("Nguyen");
		customer.setAdminUserName("admin");
		customer.setEnable(true);
		customer.setAdminPassword(passwordEncoder.encode("admin123"));
		
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		
		customer.getRoles().add(role);
		
		role.getUsers().add(customer);
		
		userDao.create(customer);
		roleDao.create(role);*/
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		emf.close();
		
		System.out.println("DONE");
	}
}
