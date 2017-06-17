//--------------------Activity的启动模式------------------------//

1. standard  每次intent，都会创建一个新的Activity在原来的任务栈上，注意：如果使用的是非Activity类型（即Service或者Application）的Context，那么需要在 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)，这样创建的Activity是放在一个新的任务栈中的。

2. singleTop  如果任务栈的栈顶恰好有这个Activity，那么将重用这个Activity，生命周期的体现是：上一个Activity执行onPause，下一个Activity的onCreate，onStart将不会被执行，onNewIntent，onResume 将被执行， 如果栈顶没有这个Activity的话，创建过程就跟Standard一样了。


3. singleTask  如果任务栈中有这个Activity，那么将复用这个Activity，生命周期的体现是：上一个Activity执行onPause，下一个Activity的onCreate，onStart将不会被执行，onNewIntent，onResume                   将被执行（注意singleTask 具有clearTop的效果）；如果任务栈中没有这个Activity，就会在栈顶创建这个Activity；如果任务栈不存在，需要先创建这个任务栈

4. singleInstance  A只能单独的位于一个新的任务栈中，如果再一次创建A，将会复用A，生命周期
的体现是：上一个Activity执行onPause，下一个Activity的onCreate，onStart将不会被执行，onNewIntent，onResume 将被执行








1. 查看Activity任务栈的情况的命令：
adb shell dumpsys activity


2. 区分两个任务栈是否相通是依据taskid的( 如下面的#15623 )，并不是通过任务栈的名字
 TaskRecord{9b65d5a #15623 A=com.xuliwen.basecode.b U=0 sz=1}
        Run #14: ActivityRecord{4800bc7 u0 com.xuliwen.basecode/.androidcode.startmode.SingleTaskActivity t15623}
      TaskRecord{6744081 #15622 A=com.xuliwen.basecode.b U=0 sz=1}
        Run #13: ActivityRecord{cb3a339 u0 com.xuliwen.basecode/.androidcode.startmode.SingleInstanceActivity t15622}

以上虽然两个任务栈的名字相同，但是id不同，所以SingleTaskActivity 和 SingleInstanceActivity 位于不同的任务栈
