# Getting Started

## Requirements
This is the backend service of a simple order management system for a company.

### Support product  persistence
* The company maintains multiple products. Each product has id. product name and price. Fox instance, it can have product
    ```
    ID   PRODUCT_NAME     PRICE 
     1   Product1       10.00
     2   Product2       20.00
     3   Product3       15.00
    ```
### Maintain Orders
* The company maintains multiple orders. Each order has id, customer name and date signed (the date signed can use String to model).
For example, the system may have the following orders.
    ```
    ID   CUSTOMER_NAME     DATE_SIGNED 
    101   Customer1      2019-10-20
    102   Customer2      2020-08-01
    ```
* Each orders can contain multiple products with different quantities. For example, 
    ```
    Order 101  contains 
    ```
### Endpoints supported
It is expected to support the following endpoints, 

*  Get the information  of one prodcut
    ```
    GET /product/101
    ```

*  Retrieve  the information  of all prodcuts
    ```
    GET  /products
    ```

*  Create one product
    ```
    POST/product with payload of a product 
    ```
*  Retrieve the information of one order which include the order  ID, customer name,  data signed, and  total price of the order. It also includes information of all  products in this order (the product id, product name, product price and quantity of this product)
    ```
    GET /order/101
    ```
### Useful Annotations/syntax

*  Spring Web
    ```
    @RestController
    @GetMapping("/product/{productId}")
    @PathVariable Long productId
    @PostMapping("/product")
    @RequestBody ProductDTO productDTO
    ```
*  Lombok
    ```
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    ```
*  Spring Data/JPA
    ```
    @Entity
    @Id
    @ManyToOne
    @JoinColumn
    @OneToMany(mappedBy = "object name")
    @Repository
    public interface OrderRepository extends JpaRepository<OrderEntity,Long> 
    ```
 *  ModelMapper between DTO and Entity
     ```
    ModelMapper modelMapper = new ModelMapper();
    // user here is a prepopulated User instance
    UserDTO userDTO = modelMapper.map(user, UserDTO.class);
     ``` 
## Access H2 Database Console
*  Launch the following url:
    ```
    http://localhost:8080/h2
    ```
*  Provide the following information:
    ```
    JDBC URL:jdbc:h2:mem:testdb
    User Name:sa
    Password: sa
    ```
