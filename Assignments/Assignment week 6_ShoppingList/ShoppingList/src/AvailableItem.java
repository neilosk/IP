public class AvailableItem {
   

    private int ItemQty;
    private String ItemName;
    

        public AvailableItem(){
            ItemName = "";
            ItemQty = 0;
        }

        public AvailableItem(int ItemQty, String ItemName){
            this.ItemQty = ItemQty;
            this.ItemName = ItemName;
        }

        public String getItemName() {
            return ItemName;
        }

        public int getItemQty() {
            return ItemQty;
        }

        public void setItemName(String ItemName){
            this.ItemName = ItemName;
        }

        public void setItemQty(int ItemQty){
            this.ItemQty = ItemQty;
        }
    }

