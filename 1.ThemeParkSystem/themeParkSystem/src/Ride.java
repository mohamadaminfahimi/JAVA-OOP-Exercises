import java.util.*;

public class Ride {
    public static Scanner  scan = new Scanner(System.in);
    private final String name;
    private final int capacity;
    private final double duration;
    public Queue<Visitor> visitorsQueue = new LinkedList<>();
    public static List<Ride> rideList = new ArrayList<>();

    public Ride () {
        System.out.print("🎡 Enter the name of the ride: ");
        this.name = scan.nextLine();

        System.out.print("👥 Enter the capacity of the ride: ");
        this.capacity = scan.nextInt();

        System.out.print("⏱️ Enter the duration of the ride (in minutes): ");
        this.duration = scan.nextDouble();

        System.out.println("\n🎢 Ride Created!");
        System.out.println("📝 Name: " + name);
        System.out.println("👥 Capacity: " + capacity);
        System.out.println("⏱️ Duration: " + duration + " minutes");
        rideList.add(this);
    }


    public void addVisitor(Visitor visitor) {
        if (visitorsQueue.size() < capacity) {
            visitorsQueue.add(visitor);
            System.out.println("✅ \"" + visitor.getName() + "\" has successfully joined the queue for \"" + name + "\"! 🎟️");
            System.out.println("🎢 Hang tight, your thrilling adventure is coming soon!\n");
        } else {
            System.out.println("🚫 The queue for \"" + name + "\" is full at the moment!");
        }
        System.out.println("🙏 Please try again later or check out another ride.\n");    }


    public void startRide() {

        System.out.println("🎢🎉═══════════════════════════════════════🎉🎢");
        System.out.println("🎡         🎠 Welcome to the Ride! 🎠         🎡");
        System.out.println("🎢            🚀 " + this.name.toUpperCase() + " 🚀");
        System.out.println("🎢🎉═══════════════════════════════════════🎉🎢\n");

        System.out.println("🔔 Riders are getting on board...\n");

        for (int i = 0; i < this.capacity && !visitorsQueue.isEmpty(); i++) {
            Visitor v = visitorsQueue.poll();
            System.out.println("🎉 " + v.getName() + " is now riding the amazing 🎢 " + name + "!");
            System.out.println("✨ Hold tight and enjoy the thrill! ✨\n");
        }
        System.out.println("✅ Ride started successfully!");
        System.out.println("🎠 Have fun, everyone! 🎠");
        System.out.println("🎢🎉═══════════════════════════════════════🎉🎢\n");
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getDuration() {
        return duration;
    }

}