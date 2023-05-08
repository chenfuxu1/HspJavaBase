package chapter14.list;

import java.util.ArrayList;
import java.util.List;

public class List05 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList();
        list.add(new Book("红楼梦", 100, "曹雪芹"));
        list.add(new Book("西游记", 10, "吴承恩"));
        list.add(new Book("水浒传", 19, "施耐庵"));
        list.add(new Book("三国志", 80, "罗贯中"));
        list.add(new Book("西游记", 10, "吴承恩"));
        for (Object o : list) {
            System.out.println(o);
        }

        // 排序
        sort(list);
        System.out.println("============================================");
        // 排序后
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void sort(List<Book> list) {
        int length = list.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                Book b1 = list.get(j);
                Book b2 = list.get(j + 1);
                if (b1.getPrice() > b2.getPrice()) {
                    list.set(j, b2);
                    list.set(j + 1, b1);
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t\t\t" +
                "价格：" + price + "\t\t\t" +
                "作者：" + author;
    }
}
