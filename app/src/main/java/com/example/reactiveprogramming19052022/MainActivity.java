package com.example.reactiveprogramming19052022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MainActivity extends AppCompatActivity {
    //ten tag trong logd
    static final String TAG = "BBB";
    //so luong thread duoc tao ra trong thread pool
    static final int DEFAULT_THREAD_POOL_SIZE_SUBMIT = 2;
    static final int DEFAULT_THREAD_POOL_SIZE_EXECUTE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //submit
//        try {
//            Log.d(TAG,"1: "+ generateStringUseSubmit().get());
//            Log.d(TAG,"2: "+ generateStringUseSubmit1().get());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//            Log.d(TAG, "Loi: "+e.getMessage());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            Log.d(TAG, "Loi: "+e.getMessage());
//        }

        //submit
        generateStringUseSubmit();

        //execute
        //generateStringUseExecute();


    }

    private void generateStringUseSubmit() {
        ExecutorService executorService = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE_SUBMIT);

        Future<String> future1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.d(TAG, Thread.currentThread().getName());
                return "abc";
            }
        });

        Future<String> future2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.d(TAG, Thread.currentThread().getName());
                Thread.sleep(1000);
                return "abc";
            }
        });


        try {
            Log.d(TAG, "1: " + future1.get());
            Log.d(TAG, "2: " + future2.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    private Future<String> generateStringUseSubmit1() {
//        ExecutorService executorService = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE_SUBMIT);
//
//        Future<String> future = executorService.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Log.d(TAG, Thread.currentThread().getName());
//                Thread.sleep(1000);
//                return "xyz";
//            }
//        });
//        return future;
//    }

    private void generateStringUseExecute() {
        ExecutorService executorService = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE_EXECUTE);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "run 1: " + Thread.currentThread().getName());
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run 2: " + Thread.currentThread().getName());
            }
        });
    }
}