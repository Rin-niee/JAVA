/*С помощью многопоточного приложения смоделируйте следующую задачу.
Пусть имеется конвейер для производства некоторого вида продукции (в
системе представляет собой класс Product). Для сборки единицы продукции
требуется 2 сек. Каждая единица продукции состоит из деталей A и B. Для
сборки детали A требуется 1 сек. Деталь B в свою очередь состоит из деталей
C и D. Для сборки детали B нужно 3 сек, для сборки детали С нужно 2 сек, для
сборки детали D –нужно 1 сек.
Процесс сборки деталей каждого вида представляет собой отдельный поток.
Собранные детали помещаются в очередь (каждая – в свою), причём размер
очереди не превышает 5 штук (если в очереди есть 5 деталей – поток их
производства останавливается, например, на некоторое время). При
добавлении данных в очередь и извлечении из очереди она должна
блокироваться.
На консоль должна выводиться информация о каждой очередной единице
произведённой продукции и число имеющихся в этот момент деталей
каждого вида. */
/*С помощью многопоточного приложения смоделируйте следующую задачу.
Пусть имеется конвейер для производства некоторого вида продукции (в
системе представляет собой класс Product). Для сборки единицы продукции
требуется 2 сек. Каждая единица продукции состоит из деталей A и B. Для
сборки детали A требуется 1 сек. Деталь B в свою очередь состоит из деталей
C и D. Для сборки детали B нужно 3 сек, для сборки детали С нужно 2 сек, для
сборки детали D –нужно 1 сек.
Процесс сборки деталей каждого вида представляет собой отдельный поток.
Собранные детали помещаются в очередь (каждая – в свою), причём размер
очереди не превышает 5 штук (если в очереди есть 5 деталей – поток их
производства останавливается, например, на некоторое время). При
добавлении данных в очередь и извлечении из очереди она должна
блокироваться.
На консоль должна выводиться информация о каждой очередной единице
произведённой продукции и число имеющихся в этот момент деталей
каждого вида. */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProductionLine{

    private static final int PRODUCTION_TIME = 2000;
    private static final int DETAIL_A_PRODUCTION_TIME = 1000;
    private static final int DETAIL_B_PRODUCTION_TIME = 3000;
    private static final int DETAIL_C_PRODUCTION_TIME = 2000;
    private static final int DETAIL_D_PRODUCTION_TIME = 1000;

    private static final int QUEUE_CAPACITY = 5;

    private static BlockingQueue<Product> productQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    private static BlockingQueue<DetailA> detailAQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    private static BlockingQueue<DetailB> detailBQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    private static BlockingQueue<DetailC> detailCQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    private static BlockingQueue<DetailD> detailDQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Поток сборки продукции
        executorService.submit(() -> {
            while (true) {
                try {
                    DetailA detailA = detailAQueue.take();
                    DetailB detailB = detailBQueue.take();
                    Product product = new Product(detailA, detailB);
                    productQueue.put(product);
                    System.out.println("Produced product: " + product);
                    System.out.println("Current details count: A=" + detailAQueue.size() + ", B=" + detailBQueue.size() + ", C=" + detailCQueue.size() + ", D=" + detailDQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Поток сборки детали A
        executorService.submit(() -> {
            while (true) {
                try {
                    detailAQueue.put(new DetailA());
                    TimeUnit.MILLISECONDS.sleep(DETAIL_A_PRODUCTION_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Поток сборки детали B
        executorService.submit(() -> {
            while (true) {
                try {
                    DetailC detailC = detailCQueue.take();
                    DetailD detailD = detailDQueue.take();
                    DetailB detailB = new DetailB(detailC, detailD);
                    detailBQueue.put(detailB);
                    TimeUnit.MILLISECONDS.sleep(DETAIL_B_PRODUCTION_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Поток сборки детали C
        executorService.submit(() -> {
            while (true) {
                try {
                    detailCQueue.put(new DetailC());
                    TimeUnit.MILLISECONDS.sleep(DETAIL_C_PRODUCTION_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Поток сборки детали D
        executorService.submit(() -> {
            while (true) {
                try {
                    detailDQueue.put(new DetailD());
                    TimeUnit.MILLISECONDS.sleep(DETAIL_D_PRODUCTION_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    private static class Product
    {
        private final DetailA detailA;
        private final DetailB detailB;

        public Product(DetailA detailA, DetailB detailB)
        {
            this.detailA = detailA;
            this.detailB = detailB;
        }

        @Override
        public String toString()
        {
            return "Product {" +
                    "detail A= " + detailA +
                    ", detail B= " + detailB +
                    '}';
        }
    }

    private static class DetailA { }

    private static class DetailB
    {
        private final DetailC detailC;
        private final DetailD detailD;

        public DetailB(DetailC detailC, DetailD detailD)
        {
            this.detailC = detailC;
            this.detailD = detailD;
        }

        @Override
        public String toString()
        {
            return "DetailB {" +
                    "detail C= " + detailC +
                    ", detail D= " + detailD +
                    '}';
        }
    }

    private static class DetailC {}

    private static class DetailD { }
}
