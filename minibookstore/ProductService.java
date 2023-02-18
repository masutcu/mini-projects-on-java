package mini_projects.minibookstore;

public interface ProductService {
    //product işlemleri için standartlar
    void processMenu();//kitapda defterde override edecek
    void listProduct();
    void addProduct();
    void deleteProduct();
    void filterProduct(String filter);
}
