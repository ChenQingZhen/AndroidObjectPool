# AndroidObjectPool
best pratices of Android Object Pool
This project's Object Pool base on SynchronizedPool which come from android support v4; This is API and Demo https://developer.android.com/reference/android/support/v4/util/Pools.html <br />

The above API include one demo,but this project has more detail about using object pool.<br /> 
Usage 1：Create Object in advance,you can use it direct when you need it.This way improve the efficiency.<br/>  
Step 1:We could create some object and put that into object pool in Application. <br /> 
Step 2:We get object instance from object pool when we need it.The key method is obtain().<br /> 

Usage 2：This usage is about reusing objecvt instace.The key recycle() mean recycling object instance to put into object pool,and  then use obtain() to get object instace from object pool. <br /> 
Step 1:You should traverse list adapter data and put every object into object pool when you refresh list.This project has one similar way that MemberListAdapter's clear() include. <br /> 
Step 2:Using obtain() get object from object pool. <br /> 
