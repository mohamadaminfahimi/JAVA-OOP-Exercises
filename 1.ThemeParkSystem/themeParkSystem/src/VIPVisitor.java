public class VIPVisitor extends Visitor {
    public VIPVisitor() {
        super();
    }
    public void getPriorityAccess() {
        System.out.println("💎 VIP Access Granted!");
        System.out.println("👑 " + getName() + " gets priority access to the ride: 🎢");
    }
}
