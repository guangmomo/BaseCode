1. 使用Semaphore不能解决这个问题，因为不能保证A先获取到Semaphore
   看上去貌似实现了YY面试题的功能，实际上是依靠了Thread.sleep()来实现