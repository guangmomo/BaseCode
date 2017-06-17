1. Activity，Service，BroadcastReceiver使用Intent的区别

1）Intent没有找到Activity会使应用崩溃，Service，BroadcastReceiver则不会

2）使用隐式intent的时候：
   如果Activity有<action/>属性，那么Activity就一定要有一个默认的属性：
  <category android:name="android.intent.category.DEFAULT"/>
  否则会崩溃
  而Service，BroadcastReceiver则可以只有<action/>属性


2. action，category需要注意的地方
1）java代码中intent只能指定一个action，可以指定多个category
2）AndroidManifest中， <intent-filter>可以指定多个action，多个category
3）java代码中，AndroidManifest中：action，category都可以单独存在
4）action，category的匹配规则： 只要AndroidManifest的组件的action，category包含java代码中的intent
的action，category，那么java代码的intent就能启动对应的组件
5）intent的getCategories()不会输出默认的category（android.intent.category.DEFAULT）

3. URi和mimeType要注意的地方
1）如果 <intent-filter>中声明了<data/>，那么java代码隐式启动Activity的时候，intent一定要通过setType(),
setData()，setDataAndType()来完全符合<data/>的要求，才能启动Activity，否则会因为找不到Activity而崩溃。
2）setType()，setData()会互相覆盖，谁写在后面谁有效，
    如果要data和type都有效，请使用setDataAndType(uri, type)
3）<data/>可以只指定 scheme、host、port、path中的其中几个属性
port、path可以省略其中的一个或者两个
如果存在port或者path，那么scheme、host是必须的
任何情况下scheme都是必须的
可以是以下组合：
scheme
scheme,host
scheme,host,port
scheme,host,path
scheme,host,port,path


4.  <intent-filter>可以有多个，只要匹配其中的一个就够了
