class Queue {
    Node head;
    int length = 0;
    int max = 6;

    public void addClient(Node client){

        if (this.isFull())
            return;

        if (client.type == Node.VIP_TYPE){
            this.addVIP(client);
        }else{
            this.addORD(client);
        }
    }
    private void addVIP(Node vip) {

        if (this.isEmpty()) {
            this.head = vip;
            this.length++;
            Node.LAST_VIP_INDEX++;
            return;
        }
        Node currentPerson = this.head;
        while (currentPerson != null){

            if (currentPerson.next != null && currentPerson.next.type==Node.ORD_TYPE){
                vip.next = currentPerson.next;
                 currentPerson.next = vip;
               break;
            }
            else if(currentPerson.next == null){
                currentPerson.next = vip;
                break;
            }

            currentPerson = currentPerson.next;
        }
        Node.LAST_VIP_INDEX++;
        length++;

    }

    private void addORD(Node ordClient) {

        if (isEmpty()) {
            this.head = ordClient;
            Node.LAST_ORD_INDEX++;
            this.length++;
            return;
        }
        Node currentPerson = this.head;
        while (currentPerson != null){
            if (currentPerson.next == null){
                currentPerson.next = ordClient;
                break;
            }
            currentPerson = currentPerson.next;
        }
        Node.LAST_ORD_INDEX++;
        this.length++;
    }

    public Node removeHead() {
        Node temp = this.head;

        if (this.head != null){
            this.head = this.head.next;
            this.length--;
        }
        return temp;
    }

    public Boolean isFull() {
        return this.length >= max;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void print() {
       Node current = this.head;
       String emptyName = ": ----";
        new StringBuilder("| ");
        StringBuilder status;
       status = new StringBuilder((current == null) ? " ----" : current.name + " ");
        for (int i = 1 ; i < this.max ; i++) {
            if (current != null) {
                current = current.next;
            }
            status.append((current == null) ? emptyName : ": " + current.name + " ");
        }
        System.out.println("["+status+" ]");
    }


}
