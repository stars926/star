package learn.mode.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 在这个例子中，Singleton 类只有一个私有构造函数，
 * 这意味着它不能被外部实例化。同时，它有一个静态的 getInstance() 方法，
 * 该方法返回 Singleton 类的唯一实例。如果该实例不存在，则在第一次调用 getInstance() 方法时被创建。
 *
 * 这个例子使用了延迟初始化的方式创建 Singleton 实例，这意味着该实例只有在需要时才会被创建。这种方式可以提高性能，因为它避免了在应用程序启动时就创建实例的开销。但需要注意的是，如果多个线程同时调用 getInstance() 方法，可能会导致多个实例被创建。为了避免这种情况，可以使用 synchronized 关键字或者双重检查锁定等方式来确保只有一个实例被创建。
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 在这个例子中，getInstance() 方法会在创建实例之前休眠 1 秒钟，以模拟创建实例的耗时操作。如果多个线程同时调用 getInstance() 方法，可能会在同一时刻发现 instance 为 null，从而导致多个实例被创建。
     */
    public static Singleton getInstance2() {
        if (instance == null) {
            try {
                Random random = new Random();
                int randomNumber = random.nextInt(9000) + 1000;
                // 模拟创建实例的耗时操作
                Thread.sleep(randomNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 这种方式可以保证在同一时刻只有一个线程可以进入 getInstance() 方法，从而避免多个实例被创建。但需要注意的是，synchronized 关键字会导致性能下降，因为它会使得多个线程在竞争锁时被阻塞。如果 getInstance() 方法的开销很大，可能会导致整个应用程序的性能受到影响。因此，需要根据具体情况来选择合适的实现方式。
     */
    public static synchronized Singleton getInstance3() {
        if (instance == null) {
            try {
                Random random = new Random();
                int randomNumber = random.nextInt(9000) + 1000;
                Thread.sleep(randomNumber); // 模拟创建实例的耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton();
        }
        return instance;
    }

//     以下是一个简单的多例模式的 Java 代码示例：
//
//             ```java
//     public class DatabaseConnection {
//         private static final int MAX_CONNECTIONS = 10;
//         private static final List<DatabaseConnection> connections = new ArrayList<>(MAX_CONNECTIONS);
//
//         private DatabaseConnection() {
//             // private constructor to prevent instantiation
//         }
//
//         public static DatabaseConnection getInstance() {
//             if (connections.isEmpty()) {
//                 for (int i = 0; i < MAX_CONNECTIONS; i++) {
//                     connections.add(new DatabaseConnection());
//                 }
//             }
//             return connections.remove(0);
//         }
//
//         public void executeQuery(String sql) {
//             // code to execute the SQL query
//         }
//
//         public void close() {
//             connections.add(this);
//         }
//     }
// ```
//
//     在这个示例中，`DatabaseConnection` 类是一个多例模式的实现，它维护了一个最大连接数为 10 的连接池。`getInstance()` 方法返回连接池中的一个空闲连接，如果连接池为空，则会创建连接并返回。`executeQuery()` 方法用于执行 SQL 查询，`close()` 方法用于将连接放回连接池中。
//
//     可以使用以下代码来测试这个多例模式的实现：
//
//             ```java
//     public static void main(String[] args) {
//         DatabaseConnection connection1 = DatabaseConnection.getInstance();
//         DatabaseConnection connection2 = DatabaseConnection.getInstance();
//
//         connection1.executeQuery("SELECT * FROM users");
//         connection2.executeQuery("SELECT * FROM orders");
//
//         connection1.close();
//         connection2.close();
//     }
// ```
//
//     在这个示例中，我们获取了两个连接并分别执行了两个 SQL 查询，然后将连接放回连接池中。注意，当连接不再使用时，需要将其放回连接池中，否则连接池可能会被耗尽。
}