package JUC.cyclicBarrierDemo;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author: Spaeurs
 * @date: 2021/8/19 15:46
 * @description: 银行流水处理服务类 ： CyclicBarrier的应用场景
 */
public class BankWaterService implements Runnable{

    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4,this);


    /**
     * 假设有4个需要处理的sheet，所以启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的结果
     */
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(()->{
                //计算当前的sheet的数据，并放入map
                sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                //计算完成，插入一个屏障
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        //汇总每个sheet计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result+=sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }


    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}