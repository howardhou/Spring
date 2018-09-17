# Spring - helloworld

- 创建项目： 选择 Spring， 并勾选 create spring-config.xml 文件

- 上传代码到 Git
	- helloworld.iml 和 .idea/modules.xml 要上传到 git 上
	- 其他 .idea 目录下的文件可以不上传

- [.idea文件夹中那些文件应该上传到 Git仓库里](https://zhuanlan.zhihu.com/p/38348372)

- clone 项目后的配置
	- 打开 project structure 界面
	- 选择 Project：配置 Project SDK 和 compiler output（编译输出的目录）
	- 选择 Module: 点击 Fix ，下载 Spring SDK
	- 关闭 project structure 界面
	- 打开 Run/Debug Configuration
	- 点击 Add New Configuration， 选择 Application 选项
	- 配置 Main Class
	- 关闭 Run/Debug Configuration， Run 项目