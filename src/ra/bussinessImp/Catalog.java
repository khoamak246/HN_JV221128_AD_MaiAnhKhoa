package ra.bussinessImp;

import ra.bussiness.IShop;

import static ra.run.ProductManagement.*;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }


    @Override
    public void inputData() {
        // Input catalogID:
        this.catalogId = (catalogs.isEmpty()) ? 0 : catalogs.getLast().getCatalogId() + 1;

        // Input catalogName:
        System.out.print("Input catalog name: ");
        this.catalogName = sc.nextLine();

        // Input priority
        while (true) {
            System.out.print("Input catalog priority: ");
            int priority = Integer.parseInt(sc.nextLine());
            if (priority < 0) {
                System.out.println("Your priority not lower than 0!");
                System.out.println("Please input again!\n");
            } else {
                this.priority = priority;
                break;
            }
        }

        // Input descriptions
        System.out.print("Input catalog descriptions: ");
        this.descriptions = sc.nextLine();

        // Input catalogStatus:
        while (true) {
            System.out.println("Catalog status option:\n" + "1. Sale\n" + "2. Sold out\n");
            System.out.print("Select catalog option: ");
            int selectedOption = Integer.parseInt(sc.nextLine());
            if (selectedOption == 1) {
                this.catalogStatus = true;
                break;
            } else if (selectedOption == 2) {
                this.catalogStatus = false;
                break;
            } else {
                System.out.println("Not match any option!");
                System.out.println("Please try again!\n");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Catalog ID: " + catalogId + " | " + "Catalog Name: " + catalogName);
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
