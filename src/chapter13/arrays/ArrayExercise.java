package chapter13.arrays;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 案例：自定义 Book 类，里面包含 name 和 price，按 price 排序(从大到小)。
 * 要求使用两种方式排序, 有一个 Book[] books = 4 本书对象.
 * 使用前面学习过的传递 实现 Comparator 接口匿名内部类，也称为定制排序。
 * 可以按照 price 1.从大到小 2.从小到大 3.按照书名长度从大到小
 */
public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘 20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);

        // 1.price 从大到小
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double res = b2.getPrice() - b1.getPrice();
                return (int) res;
            }
        });
        System.out.println("1.price 从大到小");
        System.out.println(Arrays.toString(books));

        // 2.price 从小到大
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double res = b1.getPrice() - b2.getPrice();
                return (int) res;
            }
        });
        System.out.println("2.price 从小到大");
        System.out.println(Arrays.toString(books));

        // 3.按照书名长度从大到小
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b2.getName().length() - b1.getName().length();
            }
        });
        System.out.println("3.按照书名长度从大到小");
        System.out.println(Arrays.toString(books));
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}