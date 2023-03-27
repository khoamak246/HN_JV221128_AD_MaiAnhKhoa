package ra.bussinessImp;

import ra.bussiness.IShop;

import static ra.run.ProductManagement.*;

public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = importPrice * RATE;
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        this.productId = (products.isEmpty()) ? 0 : products.getLast().getProductId() + 1;

        // Input productName:
        System.out.print("Input product name: ");
        this.productName = sc.nextLine();

        // Input title:
        System.out.print("Input product title: ");
        this.title = sc.nextLine();

        // Input descriptions:
        System.out.print("Input product descriptions: ");
        this.descriptions = sc.nextLine();

        // Input catalog:
        while (true) {
            boolean isContainCatalog = false;
            for (Catalog catalog : catalogs) {
                System.out.println("-----------------------");
                catalog.displayData();
                System.out.println("-----------------------\n");
            }

            System.out.print("Input ID to select catalog: ");
            int catalogId = Integer.parseInt(sc.nextLine());

            for (Catalog catalog : catalogs) {
                if (catalog.getCatalogId() == catalogId) {
                    this.catalog = catalog;
                    isContainCatalog = true;
                    break;
                }
            }
            if (isContainCatalog) {
                break;
            } else {
                System.out.println("OOP! not match any Id!");
                System.out.println("Please input ID again!\n");
            }
        }

        // Input importPrice:
        while (true) {
            System.out.print("Input product importPrice: ");
            float importPrice = Float.parseFloat(sc.nextLine());
            if (importPrice < 0) {
                System.out.println("Your import price not lower than 0!");
                System.out.println("Please input again!\n");
            } else {
                this.importPrice = importPrice;
                break;
            }
        }

        // Input exportPrice
        this.exportPrice = this.importPrice * RATE;

        // Input productStatus:
        while (true) {
            System.out.println("Product status option:\n" + "1. Sale\n" + "2. Sold out\n");
            System.out.print("Select product option: ");
            int selectedOption = Integer.parseInt(sc.nextLine());
            if (selectedOption == 1) {
                this.productStatus = true;
                break;
            } else if (selectedOption == 2) {
                this.productStatus = false;
                break;
            } else {
                System.out.println("Not match any option!");
                System.out.println("Please try again!\n");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Product ID: " + productId + " | " + "Product Name: " + productName + " | " + "Catalog Name: " + catalog.getCatalogName());
        System.out.println("Product ExportPrice: " + exportPrice + " | " + "Product status: " + ((productStatus) ? "Sale" : "Sold out"));
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
