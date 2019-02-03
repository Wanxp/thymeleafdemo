package com.wanxp.thymeleafdemo.model;

import java.math.BigDecimal;
import java.util.*;

public class ModelUtil {
    private static ModelUtil productRepository;
    private static Map<String, Object> cache = new HashMap<String, Object>() ;

    private ModelUtil() {
        init();
    }

    private void init() {
        cache.put("products", createProduct(10));
        cache.put("customers", createCustomer(10));
        cache.put("orders", createOrder(10));
    }

    public ModelUtil getIntance() {
        if (productRepository == null) {
            synchronized (productRepository) {
                if (productRepository == null)
                    productRepository = new ModelUtil();
            }
        }
        return productRepository;
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        Product product = new Product();
        return null;
    }

    private List<Comment> createComment() {
        List<Comment> comments = new ArrayList<Comment>();
        Comment comment = new Comment();
        comment.setId(0);
        comment.setText("first comment");
        Comment comment1 = new Comment();
        comment1.setId(0);
        comment1.setText("second comment");
        comments.add(comment);
        comments.add(comment1);
        cache.put("comments", comments);
        return null;
    }

    private List<Customer> createCustomer(Integer customerNum) {
        List<Customer> customers = new ArrayList<Customer>();
        for (int i = 0;i < customerNum;i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setName("Tom_" + i);
            customer.setCunstomerSince(Calendar.getInstance());
        }
        return customers;
    }

    private List<Order> createOrder(Integer orderNum) {
        List<Order> orders = new ArrayList<Order>();
        for (int i = 0;i < orderNum;i++) {

        }
        return null;
    }

    private Set<OrderLine> createOrderLine(int i) {
        Set<OrderLine> orderLines = new HashSet<OrderLine>();
        for (int j = 0;j < 4;j++) {
            OrderLine orderLine = new OrderLine();
            orderLine.setAmount(j*100);
//            orderLine.setProduct();
        }
        return null;
    }

    private List<Product> createProduct(int productNum) {
        List<Product> products = new ArrayList<Product>();
        for (int i = 0;i < productNum;i++) {
            Product product = new Product();
            product.setId(i);
            product.setName("Product_" + i);
            product.setPrice(BigDecimal.valueOf(i * 100));
            product.setInStock(i%2 == 0);
            product.setConments(createComment());
        }
        return products;
    }
}
