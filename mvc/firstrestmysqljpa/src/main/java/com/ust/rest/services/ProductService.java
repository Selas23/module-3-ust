package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.repository.UserRepository;
import com.ust.rest.resource.Product;
import com.ust.rest.resource.User;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;

	public Product getProduct(long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

//	public Product getProduct(long productId) {
//		return repository.getProduct(productId);
//
//	}
//
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Transactional
	public Product add(Product product) { // boolean changed to Product
//	if(productCache.add(product))
//		if (validate(product)) {
//			return false;
//		} else {
//			productRepository.save(product);
//			return true;
//		}
		Product productT = productRepository.save(product);
		User user = new User();
		user.setUserId(5L);
//		User user = new User();
//		user.setUserId(5L);
		user.setDateTime(System.currentTimeMillis() + "7676767676767676767676767676767676767676767676");
		User userT = userRepository.save(user);
//		System.out.println(userT);
		//RunTimeException exception = null;
		
		return productT;
//		user userT = null;

//		if (userT != null && productT != null) {
//			return true;
//		} else {
//			throw new RuntimeException("record not inserted");
//		}
//		userRepository.save(user);
//		return true;
	}

	public boolean validate(Product product) {
		if (product.getName().equals("Camera")) {
			return true;
		} else {
			return false;
		}
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(long productId) {
		productRepository.deleteById(productId);
	}

}
