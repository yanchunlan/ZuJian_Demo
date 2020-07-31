# ZuJian_Demo

组件化的简单实践

- 1.动态切换application与lib模式，我们看上面的代码我们在gradle.properties里面配置
```
if (mineRunAlone.toBoolean()) {
    apply plugin: 'com.android.application'
} else {
    apply plugin: 'com.android.library'
}
```
- 2.组件与组件之间的资源命名冲突，解决方法很简单,添加以下代码就可以了，他代表在项目的名字前添加前缀名
```
 resourcePrefix "login_"
```
- 3.组件与组件之间跳转可以使用ARouter路由

#### 拓展

- 其实最真实的组件结构是这样的：

![](./pic/zujian.png)

#### 组件优化

- 组件之间的数据通信，跳转使用ARouter，数据交互使用RxLiveDatabus

- 模块管理，分别在moudle中加入maven_local.gradle通过maven仓库管理组件，在依赖的地方调用远程仓库依赖

-  生命周期管理，使用到主工程的application操作，在主工程做一个观察者模式，通过自定义gradle遍历模块，在观察者注入方法注入调用的模块，实现每个模块都观察到主工程app生命周期变动