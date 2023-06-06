package chapter17.thread;


// 1.当一个类继承了 Thread 类，该类就可以当做线程使用
// 2.我们会重写 run 方法， 写上自己的业务代码
// 3.run Thread 类 实现了 Runnable 接口的 run 方法
public class Cat extends Thread {
	int times = 0;
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.start();
	}

	@Override
	public void run() { // 重写 run 方法， 写上自己的业务逻辑
		while(true){
			// 该线程每隔 1 秒。在控制台输出 “喵喵, 我是小猫咪”
			System.out.println("喵喵, 我是小猫咪" + (++times) );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(times == 8){ // 到 8, 退出 while, 这时线程也就退出
				break;
			}
		}
	}
}
