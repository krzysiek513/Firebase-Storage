package pl.studia.firebasestoregedb;

public class Item {
    private String imageUrl;
    private String itemName;

    public Item(String imageUrl, String itemName) {
        this.imageUrl = imageUrl;
        this.itemName = itemName;
    }

    public Item() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
