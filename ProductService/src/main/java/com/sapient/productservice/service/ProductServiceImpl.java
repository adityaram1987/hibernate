package com.sapient.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.productservice.dao.ProductDAO;
import com.sapient.productservice.model.Product;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	@Qualifier(value = "hibernateDAOImpl")
	private ProductDAO productDAO;

    public ProductServiceImpl(@Qualifier(value = "hibernateDAOImpl")ProductDAO productDAO){
        this.productDAO = productDAO;
    }
    
    @Transactional
	@Override
	public Product saveProduct(Product product) {
		System.out.println("Inside the save employee method of Product service class ....");
        return productDAO.saveProduct(product);
		
	}

	@Transactional
	@Override
	public List<Product> listAll() {
		return productDAO.listAll();
	}

	@Transactional
	@Override
	public Product findById(int id) {
		return productDAO.findById(id);
	}
	@Transactional
	@Override
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);		
	}
	@Transactional
	@Override
	public void updateProduct(int id, Product product) {
		productDAO.updateProduct(id, product);		
	}

}
