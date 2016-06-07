# AndroidObjectPool
best pratices of Android Object Pool
This project's Object Pool base on SynchronizedPool which come from android support v4; This is API and Demo https://developer.android.com/reference/android/support/v4/util/Pools.html <br />

以上的API地址有一个小Demo，不过本项目更加详细写了怎么使用对象池 <br /> 
usage 1：预先创建对象，然后要用的时候直接拿来用，提高效率<br /> 
具体步骤： <br /> 
1、我们可以在Application里先创建几个对象放在对象池 <br /> 
2、然后然后要使用的时候从对象池去取对象，具体是用obtain()方法实现。<br /> 
usage 2：重复使用对象，对象使用后用recycle()回收对象存到对象池，然后再用obtain()方法获取对象。<br /> 
具体步骤：<br /> 
1、刷新列表的时候，遍历列表数据源，将每个对象回收放到对象池。MemberListAdapter里面的clear()正式实现了这个逻辑。<br /> 
2、用obtain()方法从数据源获取数据<br /> 
