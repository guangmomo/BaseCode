YY的一道面试题
两条线程：A,B ，B执行到某个节点的时候，如果A没有完成，需要等A完成，如果A已经完成了，就不需要等待了。

1. CountDownLatch  最方便
   wait_notify     可以实现，但稍复杂
   semaphore       不能实现