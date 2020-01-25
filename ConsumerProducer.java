import java.util.Random;

public class ConsumerProducer {
	
	Random rnd = new Random();
	CircularBuffer buffer = new CircularBuffer();
	
	public void produce() throws InterruptedException {
		double bufferValueCounter = 0.0;
		synchronized(this) {
			for (int i = 1; i <= 1000000; ++i) {
				try {
					// Add number to buffer
					double bufferElement = rnd.nextDouble() * 100.0;
					buffer.add(bufferElement);
					bufferValueCounter += bufferElement;
					if (i % 100000 == 0)
						System.out.printf("Producer: Generated %,d items, cumulative value of generated items=%.3f\n",i,bufferValueCounter);
					notify();
				} catch (Exception e) { wait(); i--; }
			}
			notify();
			wait();
		}
		System.out.println("Producer: Finished generating 1,000,000 items");
	}
	
	public void consume() throws InterruptedException {
		double bufferValueCounter = 0.0;
		synchronized(this) {
			for (int i = 1; i <= 1000000; ++i) {
				try {
					double d = buffer.poll();
					bufferValueCounter += d;
					if (i % 100000 == 0)
						System.out.printf("Consumer: Consumed %,d items, cumulative value of consumed items=%.3f\n",i,bufferValueCounter);
					notify();
				} catch (Exception e) { wait(); i--; }
			}
			notify();
		}
		System.out.println("Consumer: Finished consuming 1,000,000 items");
	}
	
}
