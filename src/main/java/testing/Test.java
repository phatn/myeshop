package testing;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.myeshop.dao.impl.AttributeDaoImpl;
import com.myeshop.dao.impl.CategoryDaoImpl;
import com.myeshop.dao.impl.ProductDaoImpl;
import com.myeshop.domain.Attribute;
import com.myeshop.domain.Category;
import com.myeshop.domain.Product;
import com.myeshop.domain.ProductAttributeValue;

public class Test {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("es-unit");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		// ==============TRANSACTION BEGIN ============
		
		/*ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.setEntityManager(entityManager);
		
		AttributeDaoImpl attributeDao = new AttributeDaoImpl();
		attributeDao.setEntityManager(entityManager);
		
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		categoryDao.setEntityManager(entityManager);*/
		
		
		// Name
		Attribute name = new Attribute();
		name.setName("Name");
		
		ProductAttributeValue valueName = new ProductAttributeValue();
		valueName.setAttribute(name);
		valueName.setValue("ACER Aspire V5-572P 15.6\" Notebook Intel Core i3 4GB 500GB Win 8 Touch");
		name.getAttributeValues().add(valueName);
		
		// OS
		Attribute os = new Attribute();
		os.setName("Operating System");
		
		ProductAttributeValue valueOS = new ProductAttributeValue();
		valueOS.setAttribute(os);
		valueOS.setValue("Windows 8");
		os.getAttributeValues().add(valueOS);
		
		
		// Processor
		Attribute processor = new Attribute();
		processor.setName("Processor");
		
		ProductAttributeValue valueProcessor = new ProductAttributeValue();
		valueProcessor.setAttribute(processor);
		valueProcessor.setValue("Intel Core i3-3227U");
		processor.getAttributeValues().add(valueProcessor);
		
		// Chipset
		Attribute chipset = new Attribute();
		chipset.setName("Chipset");
		
		ProductAttributeValue valueChipset = new ProductAttributeValue();
		valueChipset.setAttribute(chipset);
		valueChipset.setValue("Intel HM77 Express");
		chipset.getAttributeValues().add(valueChipset);
		
		// Memory
		Attribute memory = new Attribute();
		memory.setName("Memory");
		
		ProductAttributeValue valueMemory = new ProductAttributeValue();
		valueMemory.setAttribute(memory);
		valueMemory.setValue("4GB RAM");
		memory.getAttributeValues().add(valueMemory);
		
		// Storage
		Attribute storage = new Attribute();
		storage.setName("Storage");
		
		ProductAttributeValue valueStorage = new ProductAttributeValue();
		valueStorage.setAttribute(storage);
		valueStorage.setValue("4GB RAM");
		storage.getAttributeValues().add(valueStorage);
		
		// Screen Size
		Attribute screenSize = new Attribute();
		screenSize.setName("Screen Size");
		
		ProductAttributeValue valueScreenSize = new ProductAttributeValue();
		valueScreenSize.setAttribute(screenSize);
		valueScreenSize.setValue("15.6\" (1366 x 768) Resolution with Touchscreen");
		screenSize.getAttributeValues().add(valueScreenSize);
		
		// Graphics
		Attribute graphics = new Attribute();
		graphics.setName("Graphics");
		
		ProductAttributeValue valueGraphics = new ProductAttributeValue();
		valueGraphics.setAttribute(graphics);
		valueGraphics.setValue("Intel HD Graphics 4000");
		graphics.getAttributeValues().add(valueGraphics);
		
		// Network
		Attribute network = new Attribute();
		network.setName("Network");
		
		ProductAttributeValue valueNetwork = new ProductAttributeValue();
		valueNetwork.setAttribute(network);
		valueNetwork.setValue("Wireless: 802.11 a/g/n Ethernet: 1x 10/100/1000");
		network.getAttributeValues().add(valueNetwork);
		
		
		/*attributeDao.create(name);
		attributeDao.create(os);
		attributeDao.create(processor);
		attributeDao.create(chipset);
		attributeDao.create(memory);
		attributeDao.create(storage);
		attributeDao.create(screenSize);
		attributeDao.create(graphics);
		attributeDao.create(network);*/
		
		Product product = new Product();
		product.setProductPrice(new BigDecimal(20000000));
		product.getAttributes().add(name);
		product.getAttributes().add(os);
		product.getAttributes().add(processor);
		product.getAttributes().add(chipset);
		product.getAttributes().add(memory);
		product.getAttributes().add(storage);
		product.getAttributes().add(screenSize);
		product.getAttributes().add(graphics);
		product.getAttributes().add(network);
		
		/*productDao.create(product);
		
		Category cat = categoryDao.get(100L);
		
		cat.getProducts().add(product);
		product.getCategories().add(cat);
		
		categoryDao.update(cat);
		productDao.update(product);*/
		
		// ============== BEGIN COMMIT ================
		entityManager.getTransaction().commit();
		entityManager.close();
		emf.close();
		System.out.println("DONE " + i);
		}
	}
}
