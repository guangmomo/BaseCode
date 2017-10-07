1. Exchanger用于两个线程之间交互数据，不能用于多个线程之间
2. 使用方法：以传递String为例，可以传递任何数据类型
A线程调用  String fromB=exchanger.exchange("A");//fromB是B传过来的数据，"A"是传递给B的数据
B线程调用  String fromB=exchanger.exchange("B");
A线程调用exchange后会阻塞，知道B调用exchange