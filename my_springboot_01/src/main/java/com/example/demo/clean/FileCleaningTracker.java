package com.example.demo.clean;

/**
 * @program: 文件跟踪类(一个文件和 一个对象绑定，对象被垃圾回收进行相应操作)
 * @description: 2、FileCleaningTracker类，
 * @author: guoyiguang
 * @create: 2021-08-07 11:09
 **/

import java.io.File;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Vector;
public class FileCleaningTracker {

    // 引用队列
    ReferenceQueue q = new ReferenceQueue();

    // synchronized
    final Collection  trackers = new Vector();
    /**
     * Whether to terminate the thread when the tracking is complete.
     */
    volatile boolean exitWhenFinished = false;
    // 用于删除文件的线程
    Thread reaper;






    /** 
    * @Description:  synchronized 关键字 分布式的情况下 也是可以用的（如下的这种情况就可以用）
    * @Param:  
    * @return:  
    * @Author: guoyiguang
    * @Date:  
    */ 
    public synchronized void addTracker(String path, Object marker) {

        if (path == null) {
            throw new NullPointerException("The path must not be null");
        }
        // synchronized block protects reaper
        if (exitWhenFinished) {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
        if (reaper == null) {
            reaper = new Reaper();
            // 开启线程
            reaper.start();
        }
        // 将 marker 和  引用队列绑定，marker 被回收后 ，进行删除文件
        // 放到 trackers 集合里  是为了方便监控
        trackers.add(new Tracker(path, marker, q));
    }


    /** 
    * @Description:  清理临时文件的守护线程
    * @Param:  
    * @return:  
    * @Author: guoyiguang
    * @Date:  
    */ 
    private final class Reaper extends Thread {

            Reaper() {
                super("File Reaper");
                setPriority(Thread.MAX_PRIORITY);
                // 设置为守护线程
                setDaemon(true);
            }

            public void run() {
                // thread exits when exitWhenFinished is true and there are no more tracked objects
                while (exitWhenFinished == false || trackers.size() > 0) {
                    Tracker tracker = null;
                    try {
                        // 当 真实对象被删除 ，引用 队列 弹出  虚引用 对象（有 path 属性 知道 删除哪个 文件）
                        tracker = (Tracker) q.remove();
                    } catch (Exception e) {
                        continue;
                    }
                    if (tracker != null) {
                        // 删除文件
                        try {
                            FileDeleteStrategy.doDelete(new File(tracker.path));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        tracker.clear();
                        // 记录
                        trackers.remove(tracker);
                    }
                }
            }

    }



        //虚引用
    private static final class Tracker extends PhantomReference {
            // 要删除的文件路径
            private final String path;
            Tracker(String path, Object marker, ReferenceQueue queue) {
                // 将 Tracker  虚引用 对象 的 marker对象  和 引用队列绑定 ， 监控 marker 对象的生命周期
                super(marker, queue);
                this.path = path;
            }

        }


}
