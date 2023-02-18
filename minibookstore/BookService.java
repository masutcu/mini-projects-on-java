package mini_projects.minibookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService implements ProductService{


    Scanner inp=new Scanner(System.in);

    //bookları saklamak için list gerekli
    List<Book> books=new ArrayList<>();
    //sistemde mevcut kitaplar olsun
    public BookService(){
        Book book1=new Book("Fareler ve İnsanlar","120 Lira",15,"J.Steinbeck","Penguin","A111");
        Book book2=new Book("Sefiller","150 Lira",5,"V.Hugo","Penguin","A222");
        Book book3=new Book("Suç ve Ceza","120 Lira",15,"Dostoyevski","Dream","A333");
        this.books.add(book1);
        this.books.add(book2);
        this.books.add(book3);
    }

    @Override
    public void processMenu() {
       int choice;
        do{
            System.out.println("----------------------");
            System.out.println("1-Kitapları Listele");
            System.out.println("2-Kitapları ekle");
            System.out.println("3-Kitapları sil");
            System.out.println("4-yayınevine göre filtrele");
            System.out.println("0-geri dön");
            System.out.println("Seçiminiz");
            choice=inp.nextInt();
            inp.nextLine();
            switch (choice){
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("yayınevi : ");
                    String publisher=inp.nextLine();
                    filterProduct(publisher);

                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("hatalı giriş");
                    break;
            }
        }while (choice!=0);

    }

    @Override
    public void listProduct() {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n","ID","Kitap Adı:","Yazar Adı:","Yayınevi:","ISBN","Fiyat","Stok");
        System.out.println("--------------------------");
        this.books.forEach(book-> System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                book.getId(),book.getName(),book.getAutherName(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock()));
        System.out.println("--------------------------------------------------------------");
        System.out.println();

    }
    @Override
    public void addProduct() {
        System.out.println("ISBN : ");
        String isbn=inp.nextLine();
        boolean isExists=false;
        for (Book book:this.books){

            if(book.getIsbn().equals(isbn)){
                System.out.println("bu kitap sistemde kayıtlı, güncelleme yapınız");
            }
        }if(!isExists){
            System.out.println("kitap adı: ");
            String name=inp.nextLine();
            System.out.println("Kitabın yazar adı : ");
            String author=inp.nextLine();
            System.out.println("Kitabın yayın evi : ");
            String publisher=inp.nextLine();
            System.out.println(" Birim fiyatı : ");
            String price=inp.nextLine();
            System.out.println("Stok sayısı: ");
            int stock=inp.nextInt();
            inp.nextLine();
            Book newBook=new Book(name, price, stock, author, publisher, isbn);
            this.books.add(newBook);
        }listProduct();

    }

    @Override
    public void deleteProduct() {
        boolean isExists=true;
        System.out.println("Kitap id: ");
        int id=inp.nextInt();
        for(Book book: this.books){
            if(book.getId()==id){
                this.books.remove(book);
                System.out.println("ürün silindi");
                break;
            }else {
                isExists=false;
            }
        }if(!isExists){
            System.out.println("ürün bulunamadı");
        }

    }

    @Override
    public void filterProduct(String filter) {
       //this.books.stream().filter(book -> book.getPublisher().equals(filter)).
       //        forEach(book -> System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
       //                book.getId(),book.getName(),book.getAutherName(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock()));

        int counter=0;

        for(Book book :this.books){
            if(book.getPublisher().equalsIgnoreCase(filter)){
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                        book.getId(),book.getName(),book.getAutherName(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock());
            counter++;
            }

        }if(counter==0){
            System.out.println(" ürün bulunamadı");
        }

    }
}
