
public class HW4 {

	public static void main(String[] args) throws InterruptedException {
		
		ConsumerProducer cp = new ConsumerProducer();
		
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cp.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cp.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
				
		System.out.println("Exiting!");
	}

}

