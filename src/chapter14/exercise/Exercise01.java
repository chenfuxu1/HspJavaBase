package chapter14.exercise;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 1.封装一个新闻类，包含标题和内容属性，提供 get，set 方法，重写 toString 方法，打印对象时
 * 只打印标题
 * 2.只提供一个带参数的构造器，实例化对象时，只初始化标题，并且实例化两个对象
 * 新闻一：新冠确诊病例超千万，数百万印度教徒徒赴横河“圣域”引民众担忧
 * 新闻二：男子突然想起 2 个月前钓的鱼还在往兜里，捞起一看赶紧放生
 * 3.将新闻对象添加到 ArrayList 集合中，并且进行倒序遍历
 * 4.在遍历集合的过程中，对新闻标题进行处理，超过 15 个字只保留前 15 个，然后在后边加 "............"
 * 5.在控制台打印遍历出经过处理的新闻标题
 */
public class Exercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        News n1 = new News("新闻一");
        News n2 = new News("新闻二");
        n1.setContent("新冠确诊病例超千万，数百万印度教徒徒赴横河“圣域”引民众担忧");
        n2.setContent("男子突然想放生");
        list.add(n1);
        list.add(n2);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

        // 4.在遍历集合的过程中，对新闻标题进行处理，
        // 超过 15 个字只保留前 15 个，然后在后边加 "............"
        for (int i = 0; i < list.size(); i++) {
            if (((News) list.get(i)).getContent().length() > 15) {
                String s = ((News) list.get(i)).getContent();
                ((News) list.get(i)).setContent(s.substring(0, 15) + "......");
            }
            System.out.println(((News) list.get(i)).getContent());
        }
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
