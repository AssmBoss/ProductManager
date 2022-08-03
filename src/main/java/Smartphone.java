public class Smartphone extends Product {

    private String phoneName;
    private String vendor;

    public Smartphone(int id, String name, int price, String phoneName, String vendor) {
        super(id, name, price);
        this.phoneName = phoneName;
        this.vendor = vendor;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (vendor.contains(search)) {
            return true;
        }
        return false;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
