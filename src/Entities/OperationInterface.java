package Entities;

public abstract class OperationInterface {
    private double amount;
    private String date;

    private String category;
    private String type;

    public OperationInterface() {
    }

    public OperationInterface(double amount, String date, String category,String type) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.type = type;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}