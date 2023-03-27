package ra.run;

import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManagement {
    public static Scanner sc = new Scanner(System.in);
    public static LinkedList<Catalog> catalogs = new LinkedList<>();
    public static LinkedList<Product> products = new LinkedList<>();

    public static void main(String[] args) {
        while (true){
            showMenu();
            System.out.print("Input your select option: ");
            int selectedOption = Integer.parseInt(sc.nextLine());
            switch (selectedOption) {
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortByExportPrice();
                    break;
                case 4:
                    findProductByCatalogName();
                    break;
                case 5:
                    System.out.println("See you again!");
                    return;
                default:
                    System.out.println("Not match any option!");
                    System.out.println("Please input again!\n");
                    break;

            }
        }
    }

    private static void showMenu() {
        System.out.println(
                "-------------------------------| MENU |-------------------------------\n" +
                        "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục\n" +
                        "2. Nhập số sản phẩm và nhập thông tin các sản phẩm\n" +
                        "3. Sắp xếp sản phẩm theo giá bán sản phẩm tăng dần\n" +
                        "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n" +
                        "5. Thoát\n" +
                        "----------------------------------------------------------------------\n");
    }

    private static void addCatalog() {
        System.out.print("Input number of catalog: ");
        int numberCatalog = Integer.parseInt(sc.nextLine());
        if (numberCatalog <=0) {
            System.out.println("Your number catalog at least 1!");
            System.out.println("Please try again!");
        } else {
            for (int i = 1; i <= numberCatalog; i++) {
                System.out.println("\nInput catalog " + i + " data:");
                Catalog newCatalog = new Catalog();
                newCatalog.inputData();
                catalogs.add(newCatalog);
                System.out.println("Add new catalog successfully!\n");
            }
        }
    }

    private static void addProduct() {
        if (catalogs.isEmpty()) {
            System.out.println("Not have any catalog in list!");
            System.out.println("Please press 1 to add catalog and try again!\n");
        } else {
            System.out.print("Input number of product: ");
            int numberProduct = Integer.parseInt(sc.nextLine());
            if (numberProduct <= 0) {
                System.out.println("Your number product at least 1!");
                System.out.println("Please try again!");
            } else {
                for (int i = 1; i <= numberProduct; i++) {
                    System.out.println("\nInput product " + i + " data:");
                    Product newProduct = new Product();
                    newProduct.inputData();
                    products.add(newProduct);
                    System.out.println("Add new product successfully!\n");
                }
            }
        }
    }

    private static void sortByExportPrice() {
        if (products.isEmpty()) {
            System.out.println("Not have any product in list!");
            System.out.println("Please try again!\n");
        } else {
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Float.compare(o1.getExportPrice(), o2.getExportPrice());
                }
            });
            System.out.println("Sort successfully!\n");
            showProductList();
        }
    }


    private static void findProductByCatalogName() {
        if (products.isEmpty()) {
            System.out.println("Not have any product in list!");
            System.out.println("Please try again!\n");
        } else {
            // unlock comment to check:
            // showProductList();
            System.out.print("Input catalog name to search: ");
            String catalogName = sc.nextLine();
            boolean isContain = false;
            for (Product product : products) {
                if (product.getCatalog().getCatalogName().contains(catalogName)){
                    System.out.println("-----------------------");
                    product.displayData();
                    System.out.println("-----------------------");
                    isContain = true;
                }
            }

            if (!isContain){
                System.out.println("Not found any product you need!");
                System.out.println("Please try again!\n");
            }
        }
    }

    public static void showProductList(){
        for (Product product: products) {
            System.out.println("-----------------------");
            product.displayData();
            System.out.println("-----------------------\n");
        }
    }
}
