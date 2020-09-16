class Node {
    public String name;
    public int type;
    public Node next;

    public static int LAST_VIP_INDEX = 0;
    public static int LAST_ORD_INDEX = 0;
    public static int VIP_TYPE = 0;
    public static int ORD_TYPE = 1;

    public Node(int type) {
        this.type = type;
        this.name = (this.type == VIP_TYPE) ?"VIP"+(LAST_VIP_INDEX + 1):"ORD"+(LAST_ORD_INDEX + 1);
    }

    public boolean isOrdinary() {
        return this.type == ORD_TYPE;
    }

}
